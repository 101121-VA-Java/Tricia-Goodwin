// if (loggedIn == null){
//     let loggedIn = sessionStorage.getItem("LoggedIn");
// }
if(!loggedIn){
    window.location.href = "../indez.html";
}


document.getElementById("logOutButton").addEventListener("click", LogOut);

function LogOut(){
    sessionStorage.clear();
    window.location.href = "views/login.html";
}
let apiurl = 'http://localhost:8080';

window.onload = function(){
    
    getMe();
}


async function getMe(){
    let LIArr = loggedIn.split(":");
    console.log(LIArr);
    let id = LIArr[0];
    
    apiURL = `http://localhost:8080/users/${id}/`;
    let response =  await fetch(apiURL, {

    });
    let me = await response.json();

     let fname = me.fname;
     console.log(fname);
     document.getElementById("welcome").innerHTML = `Welcome ${fname}!`;
 }
     
