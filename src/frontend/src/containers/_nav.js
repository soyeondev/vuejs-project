export default [
    {
        _name: 'CSidebarNav',
        _children: [
            {
                _name: 'CSidebarNavTitle',
                name: 'Silverpay Admin',
                _children: ['Silverpay Admin']
            },
            {
                _name: 'CSidebarNavItem',
                name: '고객관리',
                icon: 'cil-dollar',
                to: '/customer/list'
            },
            {
                _name: 'CSidebarNavDivider',
                _class: 'm-2'
            },
        ]
    }
]