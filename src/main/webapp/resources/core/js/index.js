function checkPass()
{
    var pass1 = document.getElementById('reg_password');
    var pass2 = document.getElementById('confirm_password');
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    if(pass1.value === pass2.value){
       // document.getElementById("register").disabled=false;
        pass2.style.backgroundColor = goodColor;
    }else{
        pass2.style.backgroundColor = badColor;
    }
}