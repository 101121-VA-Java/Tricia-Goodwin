if (loggedIn == null){
    let loggedIn = sessionStorage.getItem("LoggedIn");
}
if(!loggedIn){
    window.location.href = "../indez.html";
}

document.getElementById("logOutButton").addEventListener("click", LogOut);

function LogOut(){
    sessionStorage.clear();
    window.location.href = "views/login.html";
}

document.getElementById("SeePendingRequests").addEventListener("click", allPending);
document.getElementById("SeeApprovedRequests").addEventListener("click", allApproved);
document.getElementById("SeeDeniedRequests").addEventListener("click", allRejected);
document.getElementById("SeeRequests").addEventListener("click", getRequests);
document.getElementById("searchEmp").addEventListener("click", getEmpReq);
document.getElementById("approvereq").addEventListener("click", approveReq);
document.getElementById("denyreq").addEventListener("click", denyReq);

let apiurl = 'http://localhost:8080';


async function getRequests(){
    
        let LIArr = loggedIn.split(":");
        
        let id = LIArr[0];
        
        apiURL = `http://localhost:8080/reimbursements`;
        let response =  await fetch(apiURL, {
    
        });
        let allreq = await response.json();
        var data = allreq;
        //data = JSON.parse(data);
        console.table(data);
        
        // var table = "<table>";
        // for (let key in data){
        //     table += `<tr><td>${key}</td><td>${data[key]}</td></tr>`
        // }
        // table += "</table>";
        // document.getElementById("pendingtable").innerHTML = table;
        let all = document.getElementById("alltable");
        let result = "<h2>All Requests<h2><h5><h5>";
        for (let i = 0; i < data.length; i++) {
            const element = data[i];
            var datesub = new Date(element.submitted);
        var dateapp = new Date(element.resolved);
        result += `<div>Reimbursement ID: ${element.id}</div>`;
        result += `<div>Amount:  $ ${element.amount}</div>`;
        result += `<div>Creator: ${element.author}</div>`;
        result += `<div>Date Submitted: ${datesub.getDate()+
            "/"+(datesub.getMonth()+1)+
            "/"+datesub.getFullYear()+
            " "+datesub.getHours()+
            ":"+datesub.getMinutes()}</div>`;
        result += `<div>Date Approved or Rejected: ${dateapp.getDate()+
                "/"+(dateapp.getMonth()+1)+
                "/"+dateapp.getFullYear()+
                " "+dateapp.getHours()+
                ":"+dateapp.getMinutes()}</div>`;
        result += `<div>Reviewed By: ${element.reCreatorUsername}</div>`;
        result += `<div>Description of Request: ${element.description}</div>`;
        result += `<div>Status : ${element.status}</div>`;
        result += `<div>Type: ${element.type}</div>`;
        result += `<br>`
        }
        all.innerHTML = result;
    
    }

async function allPending(){
    let LIArr = loggedIn.split(":");
    
    let id = LIArr[0];
    
    apiURL = `http://localhost:8080/reimbursements/pending`;
    let response =  await fetch(apiURL, {

    });
    let allPending = await response.json();
    var data = allPending;
    //data = JSON.parse(data);
    console.table(data);
    
    // var table = "<table>";
    // for (let key in data){
    //     table += `<tr><td>${key}</td><td>${data[key]}</td></tr>`
    // }
    // table += "</table>";
    // document.getElementById("pendingtable").innerHTML = table;
    let pending = document.getElementById("pendingtable");
    let result = "<h2>All Pending Requests<h2><h5><h5>";
    for (let i = 0; i < data.length; i++) {
        const element = data[i];
        var datesub = new Date(element.submitted);

        result += `<div>Reimbursement ID: ${element.id}</div>`;
        result += `<div>Amount:  $ ${element.amount}</div>`;
        result += `<div>Creator: ${element.author.username}</div>`;
        result += `<div>Date Submitted: ${datesub.getDate()+
            "/"+(datesub.getMonth()+1)+
            "/"+datesub.getFullYear()+
            " "+datesub.getHours()+
            ":"+datesub.getMinutes()}</div>`;
        result += `<div>Description of Request: ${element.description}</div>`;
        result += `<div>Status : ${element.status}</div>`;
        result += `<div>Type: ${element.type}</div>`;
        result += `<br>`
    }
    pending.innerHTML = result;
        


     
 }
 async function allApproved(){
    let LIArr = loggedIn.split(":");
    
    let id = LIArr[0];
    
    apiURL = `http://localhost:8080/reimbursements/approved`;
    let response =  await fetch(apiURL, {

    });
    let allApproved = await response.json();
    var data = allApproved;
    //data = JSON.parse(data);
    console.table(data);
    
    // var table = "<table>";
    // for (let key in data){
    //     table += `<tr><td>${key}</td><td>${data[key]}</td></tr>`
    // }
    // table += "</table>";
    // document.getElementById("pendingtable").innerHTML = table;
    let approved = document.getElementById("approvedtable");
    let result = "<h2>All Approved Requests<h2>";
    for (let i = 0; i < data.length; i++) {
        const element = data[i];
        var datesub = new Date(element.submitted);
        var dateapp = new Date(element.resolved);
        result += `<div>Reimbursement ID: ${element.id}</div>`;
        result += `<div>Amount:  $ ${element.amount}</div>`;
        result += `<div>Creator: ${element.author.username}</div>`;
        result += `<div>Date Submitted: ${datesub.getDate()+
            "/"+(datesub.getMonth()+1)+
            "/"+datesub.getFullYear()+
            " "+datesub.getHours()+
            ":"+datesub.getMinutes()}</div>`;
        result += `<div>Date Approved: ${dateapp.getDate()+
                "/"+(dateapp.getMonth()+1)+
                "/"+dateapp.getFullYear()+
                " "+dateapp.getHours()+
                ":"+dateapp.getMinutes()}</div>`;
        result += `<div>Approved By: ${element.resolver.username}</div>`;
        result += `<div>Description of Request: ${element.description}</div>`;
        result += `<div>Status : ${element.status}</div>`;
        result += `<div>Type: ${element.type}</div>`;
        result += `<br>`
    }
    approved.innerHTML = result;
      
 }

 async function allRejected(){
    let LIArr = loggedIn.split(":");
    
    let id = LIArr[0];
    
    apiURL = `http://localhost:8080/reimbursements/denied`;
    let response =  await fetch(apiURL, {

    });
    let allRejected = await response.json();
    var data = allRejected;
    //data = JSON.parse(data);
    console.table(data);
    
    // var table = "<table>";
    // for (let key in data){
    //     table += `<tr><td>${key}</td><td>${data[key]}</td></tr>`
    // }
    // table += "</table>";
    // document.getElementById("pendingtable").innerHTML = table;
    let rejected = document.getElementById("deniedtable");
    let result = "<h2>All Rejected Requests<h2><h5><h5>";
    for (let i = 0; i < data.length; i++) {
        const element = data[i];
        var datesub = new Date(element.submitted);
        var dateapp = new Date(element.resolved)
        result += `<div>Reimbursement ID: ${element.id}</div>`;
        result += `<div>Amount:  $ ${element.amount}</div>`;
        result += `<div>Creator: ${element.author.username}</div>`;
        result += `<div>Date Submitted: ${datesub.getDate()+
            "/"+(datesub.getMonth()+1)+
            "/"+datesub.getFullYear()+
            " "+datesub.getHours()+
            ":"+datesub.getMinutes()}</div>`;
        result += `<div>Date Rejected: ${dateapp.getDate()+
                "/"+(dateapp.getMonth()+1)+
                "/"+dateapp.getFullYear()+
                " "+dateapp.getHours()+
                ":"+dateapp.getMinutes()}</div>`;
        result += `<div>Rejected By: ${element.resolver.username}</div>`;
        result += `<div>Description of Request: ${element.description}</div>`;
        result += `<div>Status : ${element.status}</div>`;
        result += `<div>Type: ${element.type}</div>`;
        result += `<br>`
    }
    rejected.innerHTML = result;
      
 }

 async function getEmpReq(){
    
    let id = document.getElementById("UserId").value;
    console.log(id);
    apiURL = `http://localhost:8080/users/${id}/reimbursements`;
    let response =  await fetch(apiURL, {

    });
    let allempreq = await response.json();
    var data = allempreq;
    //data = JSON.parse(data);
    console.table(data);
    
    // var table = "<table>";
    // for (let key in data){
    //     table += `<tr><td>${key}</td><td>${data[key]}</td></tr>`
    // }
    // table += "</table>";
    // document.getElementById("pendingtable").innerHTML = table;
    let allemp = document.getElementById("employeetable");
    let result = `<h2>All Requests from Employee #${id}<h2><h5><h5>`;
    for (let i = 0; i < data.length; i++) {
        const element = data[i];
        var datesub = new Date(element.submitted);
    var dateapp = new Date(element.resolved);
    result += `<div>Reimbursement ID: ${element.id}</div>`;
    result += `<div>Amount:  $ ${element.amount}</div>`;
    result += `<div>Creator: ${element.author.username}</div>`;
    result += `<div>Date Submitted: ${datesub.getDate()+
        "/"+(datesub.getMonth()+1)+
        "/"+datesub.getFullYear()+
        " "+datesub.getHours()+
        ":"+datesub.getMinutes()}</div>`;
        if(element.status!='PENDING'){
            result += `<div>Date Approved or Rejected: ${dateapp.getDate()+
                "/"+(dateapp.getMonth()+1)+
                "/"+dateapp.getFullYear()+
                " "+dateapp.getHours()+
                ":"+dateapp.getMinutes()}</div>`;
            result += `<div>Reviewed By: ${element.resolver.username}</div>`;
        }
    result += `<div>Description of Request: ${element.description}</div>`;
    result += `<div>Status : ${element.status}</div>`;
    result += `<div>Type: ${element.type}</div>`;
    result += `<br>`
    }
    allemp.innerHTML = result;

}

async function approveReq(){
    console.log("I am approving")
    let LIArr = loggedIn.split(":");
    let Myid = LIArr[0];
    let reqId = document.getElementById("reqId").value;
    let result = document.getElementById("approvediv")
    apiURL = `http://localhost:8080/reimbursements/${Myid}/${reqId}/approve`;
    //console.log(apiURL);
    let xhr = new XMLHttpRequest();
    xhr.open("PUT", apiURL);
    
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                console.log("Sent")
                result.innerHTML = `Reimbursement # ${reqId} has been Approved.`;
            } else {
                result.innerHTML = "Unable to alter Reimbursement.";
            }
        } 
       // window.location.reload();
}
xhr.send();
}

async function denyReq(){
    console.log("I am rejecting");
    let LIArr = loggedIn.split(":");
    let Myid = LIArr[0];
    let reqId = document.getElementById("reqId").value;
    apiURL = `http://localhost:8080/reimbursements/${Myid}/${reqId}/reject`;
    console.log(apiURL);
    let xhr = new XMLHttpRequest();
    xhr.open("PUT", apiURL);
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                console.log("Sent")
                document.getElementById("approvediv").innerHTML = `Reimbursement # ${reqId} has been Rejected.`;
            } else {
                document.getElementById("error-div").innerHTML = "Unable to alter Reimbursement.";
            }
        } 
        //window.location.reload();
    
}
xhr.send();
}
// async function makeReqTable(){
//     let response = await fetch(apiURL, {

//     });
//     let requests = await response.json();
//     console.log(requests);
