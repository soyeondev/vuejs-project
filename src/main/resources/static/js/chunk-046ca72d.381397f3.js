(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-046ca72d"],{2014:function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",[e("form",{staticStyle:{width:"100%"},on:{submit:function(s){return s.preventDefault(),t.submit(s)}}},[e("CRow",{staticClass:"mb-3 ml-2"},[e("h3",[t._v("고객정보 수정")])]),e("CRow",{staticStyle:{width:"80%"}},[e("table",{staticClass:"table table-striped",staticStyle:{"margin-left":"3%","border-collapse":"collapse"}},[e("thead",[e("tr",[e("th"),e("th"),e("th"),e("th")])]),e("tbody",[e("tr",[e("td",{staticClass:"col-title"},[e("span",{staticClass:"table-span-margin"},[e("strong",[t._v("이름")])])]),e("td",{staticStyle:{width:"30%"}},[e("CInput",{model:{value:t.custItem.custName,callback:function(s){t.$set(t.custItem,"custName",s)},expression:"custItem.custName"}})],1)]),e("tr",[e("td",{staticClass:"col-title"},[e("span",{staticClass:"table-span-margin"},[e("strong",[t._v("전화")])])]),e("td",{staticStyle:{width:"30%"}},[e("CInput",{model:{value:t.custItem.phone,callback:function(s){t.$set(t.custItem,"phone",s)},expression:"custItem.phone"}})],1),e("td",{staticClass:"col-title"},[e("span",{staticClass:"table-span-margin"},[e("strong",[t._v("닉네임")])])]),e("td",{staticStyle:{width:"30%"}},[e("CInput",{model:{value:t.custItem.custNick,callback:function(s){t.$set(t.custItem,"custNick",s)},expression:"custItem.custNick"}})],1)]),e("tr",[e("td",{staticClass:"col-title"},[e("span",{staticClass:"table-span-margin"},[e("strong",[t._v("주소")])])]),e("td",{staticStyle:{width:"30%"}},[e("CInput",{model:{value:t.custItem.addr,callback:function(s){t.$set(t.custItem,"addr",s)},expression:"custItem.addr"}})],1),e("td",{staticClass:"col-title"},[e("span",{staticClass:"table-span-margin"},[e("strong",[t._v("이메일")])])]),e("td",{staticStyle:{width:"30%"}},[e("CInput",{model:{value:t.custItem.email,callback:function(s){t.$set(t.custItem,"email",s)},expression:"custItem.email"}})],1)]),e("tr",[e("td",{staticClass:"col-title"},[e("span",{staticClass:"table-span-margin"},[e("strong",[t._v("ID")])])]),e("td",{staticStyle:{width:"30%"}},[e("CInput",{model:{value:t.custItem.id,callback:function(s){t.$set(t.custItem,"id",s)},expression:"custItem.id"}})],1),e("td",{staticClass:"col-title"},[e("span",{staticClass:"table-span-margin"},[e("strong",[t._v("비밀번호")])])]),e("td",{staticStyle:{width:"30%"}},[e("CInput",{model:{value:t.custItem.pwd,callback:function(s){t.$set(t.custItem,"pwd",s)},expression:"custItem.pwd"}})],1)])])])]),e("CRow",{staticStyle:{"margin-bottom":"3%"}},[e("CCol",{staticClass:"btn-col-margin ml-4",attrs:{sm:"1"}},[e("button",{staticClass:"btn btn-info btn-block",attrs:{label:"",type:"button"},on:{click:t.submit}},[t._v(" 저 장")])]),e("CCol",{staticClass:"btn-col-margin ml-4",attrs:{sm:"1"}},[e("button",{staticClass:"btn btn-info btn-block",attrs:{label:"",type:"button"},on:{click:t.deleteCust}},[t._v(" 삭 제")])])],1),e("CRow",[e("CCol",[e("CCard",[e("CCardHeader",[e("div",{staticClass:"card-header-actions"},[e("a",{staticClass:"card-header-action",attrs:{href:"https://coreui.io/vue/docs/components/tabs",rel:"noreferrer noopener",target:"_blank"}})])]),e("CCardBody",[e("CTabs",[e("CTab",{attrs:{title:"청구내역",active:""}},[e("CRow",[e("table",{staticClass:"table table-striped",staticStyle:{"border-collapse":"collapse"}},[e("thead",{staticStyle:{"text-align":"center"}},[e("th",{attrs:{width:"40%"}},[t._v("청구일")]),e("th",{attrs:{width:"30%"}},[t._v("항목")]),e("th",{attrs:{width:"30%"}},[t._v("금액")])]),e("tbody",{staticClass:"position-relative"},t._l(this.custChargeItem,(function(s){return e("tr",[e("td",[t._v(" "+t._s(t.$moment(s.insertTime).format("YYYY-MM-DD")))]),e("td",[t._v(" "+t._s(s.item))]),e("td",[t._v(" "+t._s(s.amount))])])})),0)])]),e("CRow",{staticStyle:{"margin-top":"3%"}},[e("CCol",{staticClass:"btn-col-margin ml-4",attrs:{sm:"1"}},[e("button",{staticClass:"btn btn-info btn-block",attrs:{label:"",type:"button"},on:{click:function(s){return t.$router.push({name:"paymanagecharge"})}}},[t._v(" 금액청구")])])],1)],1),e("CTab",{attrs:{title:"납부내역"}},[e("CRow",[e("table",{staticClass:"table table-striped",staticStyle:{"border-collapse":"collapse"}},[e("thead",{staticStyle:{"text-align":"center"}},[e("th",{attrs:{width:"30%"}},[t._v("납부일")]),e("th",{attrs:{width:"30%"}},[t._v("납부구분")]),e("th",{attrs:{width:"20%"}},[t._v("금액")]),e("th",{attrs:{width:"20%"}},[t._v("비고(납부자)")])]),e("tbody",{staticClass:"position-relative"},t._l(this.custPayItem,(function(s){return e("tr",[e("td",[t._v(" "+t._s(t.$moment(s.insertTime).format("YYYY-MM-DD")))]),e("td",[t._v(" "+t._s(s.payType))]),e("td",[t._v(" "+t._s(s.amount))]),e("td",[t._v(" "+t._s(s.userInfo))])])})),0)])])],1)],1)],1)],1)],1)],1)],1)])},c=[],n=e("a026"),l=e("bc3a"),i=e.n(l),o=e("2ead"),u=e.n(o);n["default"].use(u.a);var r={name:"customerupdate",components:{},data:function(){return{custItem:null,custPayItem:null,custChargeItem:null,payItems:null,item:null}},mounted:function(){var t=this,s=this.$route.params.custId;i.a.get("main/goUpdate/"+s).then((function(s){t.custItem=s.data.customer,console.log("custItem"),console.log(t.custItem)})).catch((function(t){console.log(t)}))},methods:{submit:function(){var t=this;i.a.post("/main/update",{no:this.$route.params.custId,custName:this.custItem.custName,custNick:this.custItem.custNick,phone:this.custItem.phone,addr:this.custItem.addr,email:this.custItem.email,id:this.custItem.id,pwd:this.custItem.pwd}).then((function(s){console.log("customer update 통신"),t.$router.push({name:"customerlist"})})).catch((function(t){console.log(t)}))},deleteCust:function(){var t=this;i.a.post("/main/delete",{no:this.$route.params.custId}).then((function(s){console.log("customer delete 통신"),t.$router.push({name:"customerlist"})})).catch((function(t){console.log(t)}))}}},m=r,d=(e("c982"),e("2877")),p=Object(d["a"])(m,a,c,!1,null,null,null);s["default"]=p.exports},b4be:function(t,s,e){},c982:function(t,s,e){"use strict";var a=e("b4be"),c=e.n(a);c.a}}]);
//# sourceMappingURL=chunk-046ca72d.381397f3.js.map