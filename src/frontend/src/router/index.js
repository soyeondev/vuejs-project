import Vue from 'vue'
import Router from 'vue-router'

// Containers
const TheContainer = () => import('@/containers/TheContainer')

// Views - Pages
const Page404 = () => import('@/views/pages/Page404')
const Page500 = () => import('@/views/pages/Page500')
const Login = () => import('@/views/pages/Login')
const Register = () => import('@/views/pages/Register')

// paymanage
const PayManagementList = () => import('@/views/paymanage/PayManagementList')
const PayManageInsert = () => import('@/views/paymanage/PayManageInsert')
const PayManageUpdate = () => import('@/views/paymanage/PayManageUpdate')
const PayManageUnpaid = () => import('@/views/paymanage/PayManageUnpaid')
const PayManageCharge = () => import('@/views/paymanage/PayManageCharge')
const PayManageExcelList = () => import('@/views/paymanage/PayManageExcelList')
const PayManageExcelUpload = () => import('@/views/paymanage/PayManageExcelUpload')

// charge
const ChargeList = () => import('@/views/studer/StuderList')

// customer
const CustomerList = () => import('@/views/customer/CustomerList')
const CustomerUpdate = () => import('@/views/customer/CustomerUpdate')
const CustomerInsert = () => import('@/views/customer/CustomerInsert')

Vue.use(Router)

export default new Router({
  mode: 'hash', // https://router.vuejs.org/api/#mode
  linkActiveClass: 'active',
  scrollBehavior: () => ({ y: 0 }),
  routes: configRoutes()
})

function configRoutes () {
  return [
      {
      path: '/',
       redirect: '/customer/list',
        name: 'Home',
      component: TheContainer,
      children: [
        {
          path: 'paymanage',
          redirect: 'paymanage/list',
          name: 'PayManage',
          component: {
            render (c) { return c('router-view') }
          },
          children: [
            {
              path: 'list',
              name: 'paymanagementlist',
              component: PayManagementList
            },
            {
              path: 'insert',
              name: 'paymanageinsert',
              component: PayManageInsert
            },
            {
              path: 'update/:custId',
              name: 'paymanageupdate',
              component: PayManageUpdate,
              props: true
            },
            {
              path: 'unpaid/:custId',
              name: 'paymanageunpaid',
              component: PayManageUnpaid,
              props: true
            },
            {
              path: 'charge/:custId',
              name: 'paymanagecharge',
              component: PayManageCharge
            },
            {
              path: 'excellist',
              name: 'excellist',
              component: PayManageExcelList
            },
            {
              path: 'excelupload',
              name: 'excelupload',
              component: PayManageExcelUpload
            }
          ]
        },
        {
          path: 'charge',
          redirect: 'charge/list',
          name: 'Charge',
          component: {
            render (c) { return c('router-view') }
          },
          children: [
            {
              path: 'list',
              name: 'chargelist',
              component: ChargeList
            }
          ]
        },
        {
          path: 'customer',
          redirect: 'customer/list',
          name: 'Customer',
          component: {
            render (c) { return c('router-view') }
          },
          children: [
            {
              path: 'list',
              name: 'customerlist',
              component: CustomerList
            },
            {
              path: 'update',
              name: 'customerupdate',
              component: CustomerUpdate
            },
            {
              path: 'insert',
              name: 'customerinsert',
              component: CustomerInsert
            }
          ]
         }
      ]
    },
    {
      path: '/pages',
      redirect: '/pages/404',
      name: 'Pages',
      component: {
        render (c) { return c('router-view') }
      },
      children: [
        {
          path: '404',
          name: 'Page404',
          component: Page404
        },
        {
          path: '500',
          name: 'Page500',
          component: Page500
        },
        {
          path: 'login',
          name: 'Login',
          component: Login
        },
        {
          path: 'register',
          name: 'Register',
          component: Register
        }
      ]
    }
  ]
}

