let loggedIn = sessionStorage.getItem("LoggedIn");

if(!loggedIn){
    window.location.href = "../indez.html";
}

document.getElementById("logOutButton").addEventListener("click", LogOut);

function LogOut(){
    sessionStorage.clear();
    window.location.href = "views/login.html";
}