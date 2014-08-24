$('.carousel').carousel({
    interval:10000
})

var i = 0; 
    var image = new Array();   
    // LIST OF IMAGES 
    image[0] = "/SodispolSoftware/resources/images/evento1.png"; 
    image[1] = "/SodispolSoftware/resources/images/evento2.jpg"; 
    var k = image.length-1;    
    var caption = new Array(); 
    // LIST OF CAPTİONS 
    caption[0] = "evento1"; 
    caption[1] = "evento2"; 
    function swapImage(){ 
    var el = document.getElementById("mydiv"); 
    el.innerHTML=caption[i]; 
    var img= document.getElementById("slide"); 
    img.src= image[i]; 
    if(i < k ) { i++;}  
    else  { i = 0; } 
    setTimeout("swapImage()",3000); 
    } 
    function addLoadEvent(func) { 
    var oldonload = window.onload; 
    if (typeof window.onload != 'function') { 
    window.onload = func; 
    } else  { 
    window.onload = function() { 
    if (oldonload) { 
    oldonload(); 
    } 
    func(); 
    } 
    } 
    } 
    
    addLoadEvent(function() { 
    swapImage(); 
    });  
