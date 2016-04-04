function myTimer(t){
    var startTime = t*60;
    jTimer(startTime);
function jTimer(startTime) {

    var time = startTime;
    //определим сколько минут
    var min = parseInt(time / 60);
    if ( min < 1 ) min = 0;
    time = parseInt(time - min * 60);
    if ( min < 10 ) min = '0'+min;
    //определим сколько секунд
    var seconds = time;
    if ( seconds < 10 ) seconds = '0'+seconds;
    //отрисовываем время
    document.getElementById("time").innerHTML='<span>Осталось времени - '+min+' мин '+seconds+' секунд</span>';
    //уменьшаем общее время на одну секунду
    startTime--;
    //смотрим время не закончилось
    if ( startTime  >= 0 ) {
        //если нет то повторяем процедуру заново
        stopTimer  =  setTimeout(function(){jTimer(startTime); }, 1000);
    } else {
        var semilayer = document.getElementById("endtime");
        semilayer.style.display = 'block';
        var buttom = document.getElementById("bcheck");
        buttom.style.position = 'fixed';
        buttom.style.borderColor = '#000000';
        buttom.style.bottom = '100px';
        buttom.style.color = '#000000'
        clearTimeout(stopTimer);

    }
}
}