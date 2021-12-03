
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
    document.getElementById("GetEmps").addEventListener("click", getUsers);
    document.getElementById("searchEmp").addEventListener("click", searchUser);
}
let apiurl = 'http://localhost:8080';

async function getUsers(){
    
    apiURL = 'http://localhost:8080/users';

    let response =  await fetch(apiURL, {

    });
    let allEmp = await response.json();
    var data = allEmp;

    console.table(data);

    let Emps = document.getElementById("emps");
    let result = "<h2>All Employees<h2>";
    for (let i = 0; i < data.length; i++) {
        const element = data[i];

        result += `<div>User ID: ${element.id}</div>`;
        result += `<div>Username:  ${element.username}</div>`;
        result += `<div>Name: ${element.fname} ${element.lname}</div>`;
        result += `<div>Email: ${element.email}</div>`;
        result += `<div>Role: ${element.role}</div>`;

        result += `<br>`
    }
    Emps.innerHTML = result;
}


//document.getElementById("searchEmp").addEventListener("click", searchUser);

async function searchUser(){
    let ID = document.getElementById("UserId").value;

    apiURL = `http://localhost:8080/users/${ID}/`;
    let response = await fetch(apiURL, {

});
    let employee = await response.json();
    var data = employee;
    console.log(employee);
    let Emp = document.getElementById("employee");
    let result = "<h2>Employee<h2>";

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

async function makeUsertable(){
    console.log("I am being called")
    let response = await fetch(apiURL, {
       method: "GET",
    headers: {
      Auth: loggedIn,
    },
    });
    let employees = await response.json();

    let tableBody = document.getElementById('employee-tbody');
    console.log(employees);

    // tableBody.innerHTML = '';

    // for (employee of employees) {
    //     let row = document.createElement('tr');

    //     if (token.split(':')[1] === 'ADMIN') {
    //         row.setAttribute('data-toggle', 'modal');
    //         row.setAttribute('data-target', '#updateEmployeeModal');
    //         row.addEventListener('click', setupModal);
            
    //     }

    //     let idTd = document.createElement('td');
    //     idTd.innerHTML = employee.id;

    //     let nameTd = document.createElement('td');
    //     nameTd.innerHTML = employee.name;

    //     let usernameTd = document.createElement('td');
    //     usernameTd.innerHTML = employee.username;

    //     let roleTd = document.createElement('td');
    //     roleTd.innerHTML = employee.role;

    //     let manIdTd = document.createElement('td');
    //     manIdTd.innerHTML = employee.manager.id;

    //     row.appendChild(idTd);
    //     row.appendChild(nameTd);
    //     row.appendChild(usernameTd);
    //     row.appendChild(roleTd);
    //     row.appendChild(manIdTd);

    //     tableBody.appendChild(row);
    // }

    //document.getElementById('update-button').addEventListener('click', updateEmployee);
}

