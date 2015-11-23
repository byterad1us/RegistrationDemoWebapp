Ext.Loader.setConfig({
    enabled: true
});


Ext.require([
    'Ext.form.*',
    'Ext.layout.container.Column',
    'Ext.tab.Panel'
]);


Ext.onReady(function() {
    Ext.QuickTips.init();


    Ext.create('Ext.form.Panel',{  
                            comment: 'the  Form Panel: layout auto',
                            renderTo: Ext.getBody(),
                            title: 'Your Information',
                            id: 'reg-form',
                            defaultType: 'textfield',
                            minHeight: 340,  
                            url: 'http://localhost:8080/RegistrationDemoWebapp/register',
                            padding: '12 30 40 30',
                            fieldDefaults: {
                                labelWidth: 60
                            },
                            layout: {
                                type: 'vbox',
                                align: 'stretch'
                            },
                            items: [   
                            
                            
                                /*  1st row  (fieldset)   */
                                {
                                    xtype: 'fieldset',
                                    fieldDefaults: {
                                       	xtype: 'textfield',
                                        labelAlign: 'top',
                                        labelPad: 12,
                                        labelStyle: 'text-align: center;',
                                        margin: 10
                                    },
                                    border: 0,
                                    layout: 'column',
                                    items: [
                                       {
                                            xtype: 'textfield',
                                            width: 280, 
                                            fieldLabel: 'First Name',
                                            name: 'first_name'
                                        },
                                        {
                                            xtype: 'textfield',
                                            width: 290,
                                            fieldLabel: 'Last Name',
                                            name: 'last_name'
                                        }
                                    ]
                                },
                                
                                
                                /* 2nd row  (fieldset)   */
                                
                                {
                                    xtype: 'fieldset',
                                    border: 1,
                                    fieldDefaults: {
                                    	xtype: 'textfield',
                                        labelAlign: 'top',
                                        labelPad: 12,
                                        labelStyle: 'text-align: center;',
                                        margin: 10
                                    },
                                    
                                    layout: 'column',
                                    items: [
                                         {
                                            xtype: 'textfield',
                                            width: 110,
                                            style: {
                                            	marginLeft: '20px'
                                            },
                                            fieldLabel: 'Address 1',
                                            name: 'address1'
                                        },
                                        {
                                            xtype: 'textfield',
                                            width: 110,
                                            style: {
                                            	marginLeft: '20px'
                                            },
                                            fieldLabel: 'Address 2',
                                            name: 'address2'
                                        }
                                        
                                    ]
                                },
                                /* end 2nd row  */
                                
                               
                               
                              /* 3rd row fieldset  */
                               {
                                    xtype: 'fieldset',
                                    border: 0,
                                    id: 'fifth-row-fieldset', 
                                    padding: '5 40 10 5',
                                    style: {
                                    			marginTop:  '10px',
                                    			marginBottom: '10px',
                                    			marginLeft: '400px',
                                    			overflowY: 'visible',
                                    			textAlign: 'center'
                                    	
                                    },
                                    fieldDefaults: {
                                        labelAlign: 'top',
                                        labelPad: 12,
                                        labelStyle: 'text-align: center;',
                                        margin: 10
                                    },
                                    
                                    layout: 'column',
                                    items: [
                                         {
                                            xtype: 'textfield',
                                            width: 230,
                                            style: 'text-align: right;',
                                            fieldLabel: 'City',
                                            name: 'city'
                                        },
                                        {
                                            xtype: 'textfield',
                                            width: 30,
                                            style: 'text-align: right;margin-left: 30px;',
                                            colspan: 2,
                                            fieldLabel: 'State',
                                            name: 'state'
                                        },
                                        {
                                            xtype: 'textfield',
                                            width: 90,
                                            style: 'text-align: right;margin-left: 30px;',
                                            fieldLabel: 'zip',
                                            name: 'zip'
                                        }
                                    ]
                                }],
                                buttons: [{
                                            text: 'Submit',
                                            handler: function() {
                                                 var form = this.up('form').getForm(); // get the basic form
                if (form.isValid()) { // make sure the form contains valid data before submitting
                    form.submit({
                        success: function(form, action) {
                           Ext.Msg.alert('Success', action.result.msg);
                        },
                        failure: function(form, action) {
                            Ext.Msg.alert('Failed', action.result.msg);
                        }
                    });
                } else { // display error alert if the data is invalid
                    Ext.Msg.alert('Invalid Data', 'Please correct form errors.')
                }
                                             }
                                           },
                                           {
                                                text: 'Cancel',
                                                handler: function(){
                                                this.up('form').getForm().reset();
                                                }
                                           }]
                              
                        });
                       /* end of FormPanel    */ 
                       
}); //end of OnReady
