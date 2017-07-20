/**
 * Created by Shreya on 7/20/2017.
 */


$().ready(function () {
    $("#passwordUpdation").validate({
        rules:{
            password:{
                required:true,
                minlength:5
            },
            confirm_password:{
                required:true,
                minlength:5,
                equalTo:"#reg_password"
            }
        },
        messages:{

            password:{
                required:"Please enter a password",
                minlength:"Must consist of atleast 5 characters"
            }
        }

    })
});