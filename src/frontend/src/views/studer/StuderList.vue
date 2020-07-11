<template>
    <div>
        <form style="width: 100%" @submit.prevent="submit">
            <CRow class="mb-3">
                <CCol sm="2">
                    <div class="block">
                        <el-date-picker
                                v-model="monthVal"
                                type="month"
                                placeholder="Pick a month">
                        </el-date-picker>
                    </div>
                </CCol>
                <CCol sm="0.5">
                    <button
                            label=""
                            type="button"
                            class="btn btn-info btn-block"
                            @click="searchList">검색</button>
                </CCol>
            </CRow>
        </form>
        <CRow>
            <CCol sm="12">
                <div class="card">
                    <div class="card-body">
                        <div bordered="true" small="true">
                            <div class="position-relative table-responsive">
                                <b-table
                                        id = "list-table"
                                        :items="items"
                                        :per-page="perPage"
                                        :current-page="currentPage"
                                        striped hover
                                />
                            </div>
                            <b-pagination
                                    :link-gen="linkGen"
                                    :number-of-pages="10"
                                    use-router
                                    v-model="currentPage"
                                    :total-rows="rows"
                                    :per-page="perPage"
                                    aria-controls="list-table"
                            />
                        </div>
                    </div>
                </div>
            </CCol>
        </CRow>
    </div>
</template>
<style>
    .btn-col-margin{
        margin-top: 5px;
        margin-left: 15px;
        margin-right: 10px;
    }
</style>
<script>
    import axios from "axios"
    import Vue from 'vue';
    import DatePicker from 'element-ui';
    import 'element-ui/lib/theme-chalk/index.css';
    import lang from 'element-ui/lib/locale/lang/ko'
    import locale from 'element-ui/lib/locale'

    // configure language
    locale.use(lang)

    Vue.use(DatePicker);

    export default {
        name: 'Tables',
        data () {
            return {
                items: [],
                monthVal: '',
                perPage: 10,
                currentPage: 1
            }
        },
        computed: {
            rows() {
                return this.items.length;
            }
        },
        created () {
            axios.get('main/getChargeList') // controller x
                .then(res => {
                    this.items = res.data;
                    console.log(res);

                    this.items.forEach(function(obj){
                        obj.insertTime = obj.insertTime.toString().slice(0, 10);
                    })
                })
                .catch(err => {
                    console.log(err);
                });
        },
        methods: {
            searchList(value){
                const qs = require('qs');
                const formData = qs.stringify({'monthVal': this.monthVal})

                axios.post('main/studer/getStdList', formData)
                    .then(res => {
                        this.items = res.data;
                        console.log(this.items)

                        this.items.forEach(function(obj){
                            obj.insertTime = obj.insertTime.toString().slice(0, 10);
                        })

                    })
                    .catch(function(error) {
                        console.log(error);
                    });
            },
            linkGen(pageNum) {
                return pageNum === 1 ? '?' : `?page=${pageNum}`
            },
        }

    }
</script>
