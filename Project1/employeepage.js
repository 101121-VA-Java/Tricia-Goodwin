
window.onload = function(){
    document.getElementById("SeeUsers").addEventListener("click", getUsers);
}

let apiurl = 'http://localhost:8080';

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
      
