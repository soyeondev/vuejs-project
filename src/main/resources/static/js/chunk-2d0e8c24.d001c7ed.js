(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0e8c24"],{"8b48":function(t,o,e){"use strict";e.r(o);var n=function(){var t=this,o=t.$createElement,e=t._self._c||o;return e("div",{staticClass:"c-app flex-row align-items-center"},[e("CContainer",[e("CRow",{staticClass:"justify-content-center"},[e("CCol",{attrs:{md:"8"}},[e("CCardGroup",[e("CCard",{staticClass:"p-4"},[e("CCardBody",[e("CForm",[e("h1",[t._v("Login")]),e("p",{staticClass:"text-muted"},[t._v("Sign In to your account")]),e("CInput",{attrs:{placeholder:"Username",autocomplete:"username email"},scopedSlots:t._u([{key:"prepend-content",fn:function(){return[e("CIcon",{attrs:{name:"cil-user"}})]},proxy:!0}])}),e("CInput",{attrs:{placeholder:"Password",type:"password",autocomplete:"curent-password"},scopedSlots:t._u([{key:"prepend-content",fn:function(){return[e("CIcon",{attrs:{name:"cil-lock-locked"}})]},proxy:!0}])}),e("CRow",[e("CCol",{staticClass:"text-left",attrs:{col:"6"}},[e("CButton",{staticClass:"px-4",attrs:{color:"primary"},on:{click:function(o){return t.login({email:t.email,password:t.password})}}},[t._v("Login")]),e("CButton",{on:{click:t.test}},[t._v("테스트")]),e("CButton",{on:{click:t.postTest}},[t._v("post테스트")])],1),e("CCol",{staticClass:"text-right",attrs:{col:"6"}},[e("CButton",{staticClass:"px-0",attrs:{color:"link"}},[t._v("Forgot password?")]),e("CButton",{staticClass:"d-lg-none",attrs:{color:"link"}},[t._v("Register now!")])],1)],1)],1)],1)],1),e("CCard",{staticClass:"text-center py-5 d-md-down-none",attrs:{color:"primary","text-color":"white","body-wrapper":""}},[e("CCardBody",[e("h2",[t._v("Sign up")]),e("p",[t._v("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")]),e("CButton",{attrs:{color:"light",variant:"outline",size:"lg"}},[t._v(" Register Now! ")])],1)],1)],1)],1)],1)],1)],1)},s=[],a=e("bc3a"),r=e.n(a),c={name:"Login",methods:{test:function(){r.a.get("https://reqres.in/api/users?page=2").then((function(t){console.log(t)})).catch((function(t){console.log(t)})).then((function(){console.log("test")}))},postTest:function(){r.a.post("https://reqres.in/api/register",{email:"eve.holt@reqres.in"}).then((function(t){console.log(t)})).catch((function(t){console.log(t)}))}}},i=c,l=e("2877"),p=Object(l["a"])(i,n,s,!1,null,null,null);o["default"]=p.exports}}]);
//# sourceMappingURL=chunk-2d0e8c24.d001c7ed.js.map