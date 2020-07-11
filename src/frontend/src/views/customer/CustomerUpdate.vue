<template>
    <div>
        <form style="width: 100%" @submit.prevent="submit">
        <CRow class="mb-3 ml-2">
            <h3>고객정보 수정</h3>
        </CRow>
        <CRow style="width: 80%">
            <table class="table table-striped" style="margin-left: 3%; border-collapse: collapse">
                <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>이름</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="custItem.custName"/>
                    </td>
                 </tr>
                <tr>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>전화</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="custItem.phone"/>
                    </td>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>닉네임</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="custItem.custNick"/>
                    </td>
                </tr>
                <tr>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>주소</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="custItem.addr"/>
                    </td>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>이메일</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="custItem.email"/>
                    </td>
                </tr>
                <tr>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>ID</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="custItem.id"/>
                    </td>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>비밀번호</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="custItem.pwd"/>
                    </td>
                </tr>
                </tbody>
            </table>
        </CRow>
        <CRow style="margin-bottom: 3%;">
            <CCol class="btn-col-margin ml-4" sm="1">
                <button label=""
                        type="button"
                        class="btn btn-info btn-block"
                        @click="submit">
                    저 장</button>
            </CCol>
            <CCol class="btn-col-margin ml-4" sm="1">
                <button label=""
                        type="button"
                        class="btn btn-info btn-block"
                        @click="deleteCust">
                    삭 제</button>
            </CCol>
        </CRow>
        <CRow>
            <CCol>
                <CCard>
                    <CCardHeader>
                        <div class="card-header-actions">
                            <a
                                    href="https://coreui.io/vue/docs/components/tabs"
                                    class="card-header-action"
                                    rel="noreferrer noopener"
                                    target="_blank"
                            >
                            </a>
                        </div>
                    </CCardHeader>
                    <CCardBody>
                        <CTabs>
                            <CTab title="청구내역" active>
                                <CRow>
                                    <table class="table table-striped" style="border-collapse: collapse">
                                        <thead style="text-align: center">
                                            <th width="40%">청구일</th>
                                            <th width="30%">항목</th>
                                            <th width="30%">금액</th>
                                        </thead>
                                        <tbody class="position-relative">
                                            <tr v-for="i in this.custChargeItem">
                                                <td> {{$moment(i.insertTime).format('YYYY-MM-DD')}}</td>
                                                <td> {{i.item}}</td>
                                                <td> {{i.amount}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </CRow>
                                <CRow style="margin-top: 3%;">
                                    <CCol class="btn-col-margin ml-4" sm="1">
                                        <button label=""
                                                type="button"
                                                class="btn btn-info btn-block"
                                                @click="$router.push({name: 'paymanagecharge'})"
                                        >
                                            금액청구</button>
                                    </CCol>
                                </CRow>
                            </CTab>

                            <CTab title="납부내역" >
                                <CRow>
                                    <table class="table table-striped" style="border-collapse: collapse">
                                        <thead style="text-align: center">
                                            <th width="30%">납부일</th>
                                            <th width="30%">납부구분</th>
                                            <th width="20%">금액</th>
                                            <th width="20%">비고(납부자)</th>
                                        </thead>
                                        <tbody class="position-relative">
                                            <tr v-for="p in this.custPayItem">
                                                <td> {{$moment(p.insertTime).format('YYYY-MM-DD')}}</td>
                                                <td> {{p.payType}}</td>
                                                <td> {{p.amount}}</td>
                                                <td> {{p.userInfo}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </CRow>
                            </CTab>
                        </CTabs>
                    </CCardBody>
                </CCard>
            </CCol>
        </CRow>
        </form>
    </div>
</template>
<style>
    .btn-col-margin{
        margin-top: 5px;
        margin-left: 15px;
        margin-right: 10px;
    }
    .col-title{
        width: 20%;
    }
    .table-span-margin{
        margin-left: 10%;
    }
</style>
<script>
    import Vue from 'vue'
    import axios from "axios";
    import VueMoment from 'vue-moment'

    Vue.use(VueMoment)

    export default {
        name: 'customerupdate',
        components: {},
        data() {
            return{
                custItem: null,
                custPayItem: null,
                custChargeItem: null,
                payItems: null,
                item: null
            }
        },
        mounted() {
            const custNo = this.$route.params.custId;

            axios.get('main/goUpdate/'+custNo)
                .then(res => {
                    this.custItem = res.data.customer;
                    console.log("custItem")
                    console.log(this.custItem)
                })
                .catch(function(error) {
                    console.log(error);
                });
        },
        methods: {
            submit () {
                axios.post('/main/update', {
                    no: this.$route.params.custId,
                    custName: this.custItem.custName,
                    custNick: this.custItem.custNick,
                    phone: this.custItem.phone,
                    addr: this.custItem.addr,
                    email: this.custItem.email,
                    id: this.custItem.id,
                    pwd: this.custItem.pwd
                })
                .then(data => {
                    console.log("customer update 통신")
                    this.$router.push({name:"customerlist"})
                })
                .catch(function (error) {
                    console.log(error)
                });
            },
            deleteCust(){
                axios.post('/main/delete', {
                    no: this.$route.params.custId,
                })
                    .then(data => {
                        console.log("customer delete 통신")
                        this.$router.push({name:"customerlist"})
                    })
                    .catch(function (error) {
                        console.log(error)
                    });
            }
        }
    }
</script>
