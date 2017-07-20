/**
 * Created by Shreya on 7/20/2017.
 */

$().ready(function () {
    $("#registrationform").validate({
        rules:{
            firstName:{
                required:true,
                minlength:3
            },
            lastName:{
                required:true,
                minlength:3
            },

            email:{
                required:true,
                email:true
            },

            username:{
                required:true,
                minlength:5
            },
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
            firstName:{
                required:"Please enter your First Name",
                minlength:"Must consist of 3 characters"
            },
            lastName:{
                required:"Please enter your Last Name",
                minlength:"Must consist of atleast 3 characters"
            },
            email:{
                required:"Please enter an email",
                email:"Must be a valid email"
            },
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
$("#username").focus(function () {
        var firstName=$("#fname").val();
        var lastName=$("#lname").val();

        if(firstName && lastName && !this.value){
            this.value=firstName+"."+lastName;
        }
    }

);
