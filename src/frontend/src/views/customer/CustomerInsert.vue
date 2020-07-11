<template>
    <div>
        <form style="width: 100%" @submit.prevent="submit">
        <CRow class="mb-3 ml-2">
            <h3>고객정보 등록</h3>
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
                        <CInput v-model="custName"/>
                    </td>
                 </tr>
                <tr>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>전화</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="phone"/>
                    </td>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>닉네임</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="custNick"/>
                    </td>
                </tr>
                <tr>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>주소</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="addr"/>
                    </td>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>이메일</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="email"/>
                    </td>
                </tr>
                <tr>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>ID</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="id"/>
                    </td>
                    <td class="col-title">
                        <span class="table-span-margin">
                            <strong>비밀번호</strong>
                        </span>
                    </td>
                    <td style="width: 30%">
                        <CInput v-model="pwd"/>
                    </td>
                </tr>
                </tbody>
            </table>
        </CRow>
        <CRow>
            <CCol>
                <div class="ml-4">
                    <input type="checkbox"
                           id="push"
                           v-model="checkedMessage"
                           true-value=
                                   "강남요양병원입니다. 이번달 결제일은 25일이며, 홍길동 님의 결제액은 200,000원 입니다. 등록하신 앱에서 편리하게 분할로 결제하실수 있습니다."
                           false-value=""
                    >
                </div>
                <label class="ml-4" style="font-size: medium; font-weight:bold;" for="push">
                    알림메시지 전송
                </label>
                <br>
                <span class="ml-4 mb-2"> {{ checkedMessage }} </span>
            </CCol>
        </CRow>
        <CRow style="margin-bottom: 3%;">
            <CCol class="btn-col-margin ml-4" sm="1">
                <button label=""
                        type="button"
                        class="btn btn-info btn-block"
                        @click="submit">
                    저 장</button>
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
        },
        methods: {
            submit () {
                axios.post('/main/insert', {
                    custName: this.custName,
                    custNick: this.custNick,
                    phone: this.phone,
                    addr: this.addr,
                    email: this.email,
                    id: this.id,
                    pwd: this.pwd
                })
                .then(data => {
                    console.log("customer insert 통신")
                    this.$router.push({name:"customerlist"})
                })
                .catch(function (error) {
                    console.log(error)
                });
            }
        }
    }
</script>
