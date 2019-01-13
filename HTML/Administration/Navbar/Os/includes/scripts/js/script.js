setInterval(function(){
    var heure    = new Date();
    var uminute = heure.getMinutes();
    var uheure = heure.getHours();
    document.getElementById('clock').innerHTML=uheure + ":" + uminute;}, 1);
