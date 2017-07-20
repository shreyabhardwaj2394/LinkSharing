/**
 * Created by Shreya on 7/20/2017.
 */

$().ready(function () {
    $("#loginform").validate({
        rules:{

            username:{
                required:true,
                minlength:5
            },
            password:{
                required:true,
                minlength:5
            }

        },
        messages:{
            username:{
                required:"Please enter a username or an email",
                minlength:"Must consist of atleast 5 characters"
            },
            password:{
                required:"Please enter a password",
                minlength:"Must consist of atleast 5 characters"
            }
        }

    })
});