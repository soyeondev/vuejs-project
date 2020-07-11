<template>
    <div>
        <form style="width: 100%" @submit.prevent="submit">
            <CRow>
                <CCol sm="2">
                    <CInput
                            placeholder="이름 또는 닉네임 검색"
                            v-model="searchVal"
                    />
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
                                        :fields="fields"
                                        :per-page="perPage"
                                        :current-page="currentPage"
                                        striped hover
                                        @row-clicked="goUpdatePage"
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
        <CRow>
            <CCol class="btn-col-margin" sm="0.7">
                <div class="m-2 d-inline-block dropdown">
                    <CCol>
                        <CDropdown
                                toggler-text="고객 등록"
                                color="primary"
                                class="m-2 d-inline-block"
                        >
                            <CDropdownItem @click="goCustInsert">1인 등록</CDropdownItem>
                            <CDropdownItem @click="goExcelUpload">대량 등록</CDropdownItem>
                        </CDropdown>
                    </CCol>
                </div>
            </CCol>

            <CCol sm="9"></CCol>
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
    import axios from 'axios'

    export default {
        name: 'app',
        components: {},
        data: function () {
            return {
                perPage: 10,
                currentPage: 1,
                fields: [
                    {
                        key: 'no',
                        label: 'No'
                    },
                    {
                        key: 'custName',
                        label: '이름'
                    },
                    {
                        key: 'custNick',
                        label: '닉네임'
                    },
                    {
                        key: 'phone',
                        label: '전화번호'
                    },
                    {
                        key: 'addr',
                        label: '주소'
                    },
                    {
                        key: 'email',
                        label: '이메일'
                    },
                    {
                        key: 'id',
                        label: '아이디'
                    }
                ],
                items: [],
                searchVal: null
            }
        },
        computed: {
            rows() {
                return this.items.length;
            }
        },
        mounted() {
            axios.get('main/getCustomer')
                .then(res => {
                    this.items = res.data;
                    console.log(this.items)

                })
                .catch(function(error) {
                    console.log(error);
                });
        },
        methods: {
            searchList(){
                const qs = require('qs');
                const formData = qs.stringify({'searchVal': this.searchVal
                })

                axios.post('main/getCustomer', formData)
                    .then(res => {
                        this.items = res.data;
                        console.log(this.items)
                        console.log('검색통신완료')

                    })
                    .catch(function(error) {
                        console.log(error);
                    });
            },

            goCustInsert() {
                this.$router.push({name: 'customerinsert'})
            },

            goExcelUpload(){
                this.$router.push({name: 'excelupload'})
            },

            linkGen(pageNum) {
                return pageNum === 1 ? '?' : `?page=${pageNum}`

            },

            goUpdatePage(record, index) {
                this.$router.push({name: 'customerupdate', params: {custId: record.no}})
            }
        }
    }
</script>