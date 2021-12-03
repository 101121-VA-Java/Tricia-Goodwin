let loggedIn = sessionStorage.getItem("LoggedIn");

if(!loggedIn){
    window.location.href = "../indez.html";
}


LIArr = loggedIn.split(':');
let role = LIArr[1];
let id = LIArr[0];


    document.getElementById("submitButton").addEventListener("click", NewReimbursement);

let apiurl = 'http://localhost:8080';

function NewReimbursement(){

    //document.getElementById("error-div").innerHTML = "";

    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let receipt = document.getElementById("receipt").value;
    let type = document.getElementById("type").value;
    let LIArr = loggedIn.split(':');
    let id = LIArr[0];

    console.log(amount);
    console.log(description);
    console.log(receipt);
    console.log(type);
    console.log(id);

    let xhr = new XMLHttpRequest();
   
    xhr.open("POST", `http://localhost:8080/users/${id}/reimbursements`);
    //let requestBody = `amount=${amount}&description=${description}&type=${type}`;
    let requestBody = { amount, description, type, id};
    xhr.send(JSON.stringify(requestBody));
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                console.log("Sent")
            } else {
               // document.getElementById("error-div").innerHTML = "Unable to submit Reimbursement.";
            }
        } 

    }

    
}

window.onload = function(){
document.getElementById("logOutButton").addEventListener('click', LogOut);
}    
function LogOut(){
    sessionStorage.clear();
    window.location.href = "views/login.html";
}