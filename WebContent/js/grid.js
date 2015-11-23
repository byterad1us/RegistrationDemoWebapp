Ext.Loader.setConfig({
    enabled: true
});


Ext.require([
    'Ext.form.*',
    'Ext.layout.container.Column',
    'Ext.tab.Panel'
]);

Ext.define('User', {
    extend: 'Ext.data.Model',
    fields: [ 'firstName', 'lastName', 'address1','address2','city','state','zip','country' ]
});

var userStore = Ext.create('Ext.data.Store', {
    model: 'User',
    data: [
        { firstName: 'Lisa', lastName:'Simpson', address1:'325 Evergreen Terrace',address2:'',city:'Springfield',state: 'OH',country:'USA'},
        { firstName: 'Eric', lastName:'Louis', address1:'909 Jefferson',address2:'Suite 12',city:'Detroit',state: 'MI',country:'USA'},
        { firstName: 'Marge', lastName:'Simpson', address1:'325 Evergreen Terrace',address2:'',city:'Springfield',state: 'OH',country:'USA'}
        
    ]
});


Ext.onReady(function() {
    Ext.QuickTips.init();
    if(sessionUserJsobj != null && (!(Ext.isEmpty(sessionUserJsobj)))){
    userStore.add(sessionUserJsobj);
    }

    Ext.create('Ext.grid.Panel', {
    renderTo: 'results-grid',
    store: userStore,
    width: 800,
    height: 300,
    title: 'Registered Users',
    columns: [
        {
            text: 'First Name',
            width: 100,
            sortable: true,
            hideable: true,
            dataIndex: 'firstName'
        },
         {
            text: 'Last Name',
            width: 100,
            sortable: true,
            hideable: true,
            dataIndex: 'lastName'
        },
         {
            text: 'Address',
            width: 100,
            sortable: true,
            hideable: true,
            dataIndex: 'address1'
        },
         {
            text: 'City',
            width: 100,
            sortable: true,
            hideable: true,
            dataIndex: 'city'
        },
         {
            text: 'State',
            width: 28,
            sortable: true,
            hideable: true,
            dataIndex: 'state'
        },
         {
            text: 'Country',
            width: 100,
            sortable: true,
            hideable: true,
            dataIndex: 'country'
        }
    ]
});
                       
}); //end of OnReady
