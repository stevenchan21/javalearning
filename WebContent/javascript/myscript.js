$(function() {
    setTimeout(function test1(){
      $('#001').css("background","#F2635F");
    }, 1000);
    setTimeout(function test2(){
      $('#001').css("background","DodgerBlue");
      $('#002').css("background","#F2635F");
    }, 2000);
    setTimeout(function test3(){
      $('#002').css("background","DodgerBlue");
      $('#003').css("background","#F2635F");
    }, 3000);
});
