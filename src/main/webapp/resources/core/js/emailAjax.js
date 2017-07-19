/**
 * Created by Shreya on 7/19/2017.
 */


function checkemail()
{

    var v=document.getElementById('mail').value;

    if(v!=null){
        var url="uniqueEmail?val="+v;

        if(window.XMLHttpRequest){
            request=new XMLHttpRequest();
        }
        else if(window.ActiveXObject){
            request=new ActiveXObject("Microsoft.XMLHTTP");
        }

        try{
            request.onreadystatechange=getEmailInfo;
            request.open("POST",url,true);
            request.send();
        }catch(e){alert("Unable to connect to server");}
    }
    else
        document.getElementById('emailstatus').innerHTML="Email can't be null";


}

function getEmailInfo(){
    if(request.readyState==4){
        var val=request.responseText;
        document.getElementById("emailstatus").innerHTML=val;
        if(val==="not available")
        {
            userflag=1;
            document.getElementById("register").disabled=true;
        }
        else
        {
            userflag=0;
            document.getElementById("register").disabled=false;

        }
        /*    if(userflag==0)
         {

         document.getElementById("register").disabled=false;
         }*/


    }
}

