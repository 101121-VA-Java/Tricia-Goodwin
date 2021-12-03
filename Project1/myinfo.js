let loggedIn = sessionStorage.getItem("LoggedIn");

if(!loggedIn){
    window.location.href = "../indez.html";
}

document.getElementById("logOutButton").addEventListener("click", LogOut);

function LogOut(){
    sessionStorage.clear();
    window.location.href = "views/login.html";
}
window.onload =  function(){

    document.getElementById("changepasswordButton").addEventListener("click",changePassword);
    loadUser();
}





//document.getElementById("searchEmp").addEventListener("click", searchUser);

async function loadUser(){
     
    let LIArr = loggedIn.split(":");
    
    let id = LIArr[0];
    console.log(id);
    apiURL = `http://localhost:8080/users/${id}/`;
    let response = await fetch(apiURL, {

});
    let employee = await response.json();
    var data = employee;
    console.log(employee);
    let Emp = document.getElementById("myinfodiv");
    let result = "<h4>My Information<h4>";

        const element = data;
        console.log(data);


        result += `<div>User ID: ${element.id}</div>`;
        result += `<div>Username:  ${element.username}</div>`;
        result += `<div>Name: ${element.fname} ${element.lname}</div>`;
        result += `<div>Email: ${element.email}</div>`;
        result += `<div>Role: ${element.role}</div>`;

        result += `<br>`
    
    Emp.innerHTML = result;
}
async function changePassword(){
    let LIArr = loggedIn.split(":");
    
    let id = LIArr[0];
    let pass = document.getElementById("newpassword").value;

    
    
    apiURL = `http://localhost:8080/users/${id}/`;
    let response = await fetch(apiURL, {

});
    let employee = await response.json();
    var data = employee;
    console.log(employee);
    const element = data;

        let username = element.username;
        let fname = element.fname;
        let lname = element.lname;
        let email = element.email;
       

    console.log(id);
    apiURL = `http://localhost:8080/users/${id}/`;
    let xhr = new XMLHttpRequest();
   let requestBody={id, fname, lname, username, pass, email};
    xhr.open("PUT", apiURL);
    xhr.send(JSON.stringify(requestBody));
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                xhr.send(JSON.stringify(requestBody)); 
            }
        }
    }
}