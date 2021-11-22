window.onload = function(){
    document.getElementById("logInButton").addEventListener("click", logIn);
}
let apiurl = 'http://localhost:8080';

function logIn(){

    document.getElementById("error-div").innerHTML = "";

    let email = document.getElementById("email").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    console.log(username);
    console.log(password);
    console.log(email);

    let xhr = new XMLHttpRequest();
   
    xhr.open("POST", "http://localhost:8080");

    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                let LoggedInToken = xhr.getResponseHeader("Auth");
                sessionStorage.setItem("LoggedIn", LoggedInToken);
                window.location.href = "../loggedInPage.html"
            } else {
                document.getElementById("error-div").innerHTML = "Unable to login.";
            }
        } 

    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = `username=${username}&password=${password}`;
    xhr.send(requestBody);
    
}