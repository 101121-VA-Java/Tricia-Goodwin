let loggedIn = sessionStorage.getItem("LoggedIn");

if(!loggedIn){
    window.location.href = "../indez.html";
}

window.onload = function(){
    document.getElementById("SeeUsers").addEventListener("click", getUsers);
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
  


LIArr = loggedIn.split(':');
let role = LIArr[1];
let id = LIArr[0];

function getUsers(){
    console.log("I am being called")
    apiURL = 'http://localhost:8080/users';
    maketable();
}

async function maketable(){
    let response = await fetch(apiURL, {
        // headers: {
        //     'Auth': LoggedInToken
        // }
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

    document.getElementById('update-button').addEventListener('click', updateEmployee);
}
      

async function updateUser(){
    let uname = document.getElementById('user-name').value;
    let fname = document.getElementById('first-name').value;
    let lname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let pass = document.getElementById('password').value;
    
    LIArr = LoggedInToken.split(':');
    let role = LIArr[1];


    let updatedUser = {
        username : uname,
        password : pass,
        fname : fname,
        lname : lname,
        email : email,
        Role : role
    }

    let response = await fetch(`http://localhost:8080/users/${id}/`, {
        method: 'PUT',
        headers: {
            'Auth': LoggedInToken
        },
        body: JSON.stringify(updatedUser)
    });

    if(response.status == 200){
        window.location.reload();
    } else {
        document.getElementById('error-div').innerHTML='Unable to update employee.'
    }

}
