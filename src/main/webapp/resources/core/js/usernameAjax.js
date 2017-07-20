/**
 * Created by Shreya on 7/19/2017.
 */

function checkusername()
{

    var v=document.getElementById('username').value;

    if(v!=null){
        var url="uniqueusername?val="+v;

        if(window.XMLHttpRequest){
            request=new XMLHttpRequest();
        }
        else if(window.ActiveXObject){
            request=new ActiveXObject("Microsoft.XMLHTTP");
        }

        try{
            request.onreadystatechange=getInfo;
            request.open("POST",url,true);
            request.send();
        }catch(e){alert("Unable to connect to server");}
    }
    else
        document.getElementById('status').innerHTML="User name can't be null";


}

function getInfo(){
    if(request.readyState==4){
        var val=request.responseText;
        document.getElementById("status").innerHTML=val;
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

    }
}


