Ext.Loader.setConfig({
    enabled: true
});


Ext.require([
    'Ext.panel.Panel'
]);


Ext.onReady(function() {
    Ext.QuickTips.init();


    Ext.create('Ext.panel.Panel',{  
                            comment: 'the  Panel',
                            renderTo: 'display-panel',
                            frame: true,
                            id: 'display',
                            width: 500,
                            height: 450,
                            contentEl: 'display-panel-content',
                            border: 3
                        });
                       /* end of Panel    */ 
                       
                       
     var contentEl = Ext.get("display-panel-content");
     contentEl.setStyle("display","block");
                       
}); //end of OnReady
