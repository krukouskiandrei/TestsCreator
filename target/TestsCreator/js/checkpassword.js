/**
 * Created by Krukouski Andrei on 04.03.2016.
 */
function checkPasswords(){
    var pass1 = document.getElementById("password");
    var pass2 = document.getElementById("password1");
    if(pass1.value != pass2.value)
        pass2.setCustomValidity("Пароли не совпадают");
    else
        pass2.setCustomValidity("");
}

function valid(){
    var v = new Array;
    v[0] = "../css/image/13.png";
    v[1] = "../css/image/15.png";
    v[2] = "../css/image/33.png";
    v[3] = "../css/image/41.png";
    v[4] = "../css/image/86.png";

    var now = new Date();
    var num = (now.getSeconds())%v.length;
    document.write('<img name="pic" id="pic" src="' + v[num] + '"></img>');
}

function check(){
    var sp = document.getElementById("pic").src.split('/');
    var sp2 = sp[sp.length-1].split('.');
    var sp3 = sp2[0]+"52";
    var valid = document.getElementById("valid");
    if(valid.value==sp3){
        valid.setCustomValidity("");
    }else {
        valid.setCustomValidity("Не правильно введены цифры")
    }
}