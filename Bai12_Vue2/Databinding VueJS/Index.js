var dtbd = new Vue({  
    el: '#dataBinding',  
    data: {  
       title : "Data Binding Simple Example",  
       hreflink : "http://www.javatpoint.com",
       activeColor: 'red',  
       fontSize: 30,
       styleobj : {  
        color: 'blue',  
        fontSize :'50px'  
     }     
    }  
 });
 var clbd = new Vue({
    el: '#classBinding',
    data:{
        title:"HTML class binding example",
        isactive:true,
        hasError : false,
        titles : "Multiple classes with array example",  
        infoclass : 'info',  
        errorclass : 'displayError'  

    }
 })