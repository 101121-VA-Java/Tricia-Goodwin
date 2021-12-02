let loggedIn = sessionStorage.getItem("LoggedIn");

if(!loggedIn){
    window.location.href = "../indez.html";
}

window.onload = function(){
    document.getElementById("submitButton").addEventListener("click", NewReimbursement);
}
let apiurl = 'http://localhost:8080';

function NewReimbursement(){

    //document.getElementById("error-div").innerHTML = "";

    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let receipt = document.getElementById("receipt").value;
    let type = document.getElementById("type").value;

    console.log(amount);
    console.log(description);
    console.log(receipt);
    console.log(type);

    let xhr = new XMLHttpRequest();
   
    xhr.open("POST", "http://localhost:8080/Reimbursement");

    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){

            } else {
                document.getElementById("error-div").innerHTML = "Unable to submit Reimbursement.";
            }
        } 

    }
    let requestBody = `amount=${amount}&description=${type}&amount=${type}`;
    xhr.send(requestBody);
    
}

window.onload = function(){
document.getElementById("logOutButton").addEventListener('click', LogOut);
}    
function LogOut(){
    sessionStorage.clear();
    window.location.href = "views/login.html";
}