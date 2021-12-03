
window.onload = function(){
    
    myPending();
    myApproved();
    myDenied();
}


async function myPending(){
    let LIArr = loggedIn.split(":");
    
    let id = LIArr[0];
    
    apiURL = `http://localhost:8080/users/${id}/reimbursements/pending`;
    let response =  await fetch(apiURL, {

    });
    let myPending = await response.json();
    var data = myPending;
    //data = JSON.parse(data);
    console.table(data);
    
    // var table = "<table>";
    // for (let key in data){
    //     table += `<tr><td>${key}</td><td>${data[key]}</td></tr>`
    // }
    // table += "</table>";
    // document.getElementById("pendingtable").innerHTML = table;
    let pending = document.getElementById("pendingtable");
    let result = "";
    for (let i = 0; i < data.length; i++) {
        const element = data[i];
        var datesub = new Date(element.submitted);

        result += `<div>Reimbursement ID: ${element.id}</div>`;
        result += `<div>Amount:  $ ${element.amount}</div>`;
        //result += `<div>Creator: ${element.reCreatorUsername}</div>`;
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
        
    //var table = document.createElement("table"), row, cellA, cellB;
    // document.getElementById("pendingtable").appendChild(table);
    // for(let key in data){
    //     row = document.createElement("tr");
    //     cellA = document.createElement("td");
    //     cellB = document.createElement("td");

    //     cellA.innerHTML = "Amount";
    //     cellB.innerHTML = data["Amount"];

    //     table.append(row);
    //     row.appendChild(cellA);
    //     row.appendChild(cellB);
        
    // }

    if(Object.keys(myPending).length>0){
        
        document.getElementById("pending").innerHTML = `You have ${Object.keys(myPending).length} Pending Requests`;
    }
    console.log(myPending);
     
 }

 async function myApproved(){
    let LIArr = loggedIn.split(":");
    
    let id = LIArr[0];
    
    apiURL = `http://localhost:8080/users/${id}/reimbursements/approved`;
    let response =  await fetch(apiURL, {

    });
    let myApproved = await response.json();
    var data = myApproved;
    //data = JSON.parse(data);
    console.table(data);
    
    // var table = document.createElement("table"), row, cellA, cellB;
    // document.getElementById("approvedtable").appendChild(table);
    // for(let key in data){
    //     row = document.createElement("tr");
    //     cellA = document.createElement("td");
    //     cellB = document.createElement("td");

    //     cellA.innerHTML = key;
    //     cellB.innerHTML = data[key];

    //     table.append(row);
    //     row.appendChild(cellA);
    //     row.appendChild(cellB);
    // 
    let approved = document.getElementById("approvedtable");
    let result = "";
    for (let i = 0; i < data.length; i++) {
        const element = data[i];
        var timestamp = 1607110465663
    var datesub = new Date(element.submitted);
    var dateapp = new Date(element.resolved);
    console.log("Date: "+datesub.getDate()+
          "/"+(datesub.getMonth()+1)+
          "/"+datesub.getFullYear()+
          " "+datesub.getHours()+
          ":"+datesub.getMinutes()+
          ":"+datesub.getSeconds());
        result += `<div>Reimbursement ID: ${element.id}</div>`;
        result += `<div>Amount:  $ ${element.amount}</div>`;
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
        result += `<div>Approved By: ${element.reCreatorUsername}</div>`;
        result += `<div>Description of Request: ${element.description}</div>`;
        result += `<div>Status : ${element.status}</div>`;
        result += `<div>Type: ${element.type}</div>`;
        result += `<br>`
    }
    approved.innerHTML = result;
     console.log(myApproved);
     if(Object.keys(myApproved).length>0){
        
        document.getElementById("approved").innerHTML = `You have ${Object.keys(myApproved).length} Approved Requests`;
    }
 }
 async function myDenied(){
    let LIArr = loggedIn.split(":");
    
    let id = LIArr[0];
    
    apiURL = `http://localhost:8080/users/${id}/reimbursements/denied`;
    let response =  await fetch(apiURL, {

    });
    let myDenied = await response.json();
    var data = myDenied;
    // var data = myDenied;
    //  //data = JSON.parse(data);
    //  console.table(data);
     
    //  var table = document.createElement("table"), row, cellA, cellB;
    //  document.getElementById("deniedtable").appendChild(table);
    //  for(let key in data){
    //      row = document.createElement("tr");
    //      cellA = document.createElement("td");
    //      cellB = document.createElement("td");

    //      cellA.innerHTML = key;
    //      cellB.innerHTML = data[key];

    //      table.append(row);
    //      row.appendChild(cellA);
    //      row.appendChild(cellB);
     //}
     let denied = document.getElementById("deniedtable");
    let result = "";
    for (let i = 0; i < data.length; i++) {
        const element = data[i];
        var timestamp = 1607110465663
    var datesub = new Date(element.submitted);
    var dateapp = new Date(element.resolved);
    console.log("Date: "+datesub.getDate()+
          "/"+(datesub.getMonth()+1)+
          "/"+datesub.getFullYear()+
          " "+datesub.getHours()+
          ":"+datesub.getMinutes()+
          ":"+datesub.getSeconds());
        result += `<div>Reimbursement ID: ${element.id}</div>`;
        result += `<div>Amount:  $ ${element.amount}</div>`;
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
        result += `<div>Rejected By: ${element.reCreatorUsername}</div>`;
        result += `<div>Description of Request: ${element.description}</div>`;
        result += `<div>Status : ${element.status}</div>`;
        result += `<div>Type: ${element.type}</div>`;
        result += `<br>`
    }
    denied.innerHTML = result;
     console.log(myDenied);
     if(Object.keys(myDenied).length>0){
        
        document.getElementById("denied").innerHTML = `You have ${Object.keys(myDenied).length} Denied Requests`;
    }
 }
  
 //function maketable()

//  window.addEventListener("load", function(){
//      var data = myApproved;
//      //data = JSON.parse(data);
//      console.table(data);
     
//      var table = document.createElement("table"), row, cellA, cellB;
//      document.getElementById("pendingtable").appendChild(table);
//      for(let key in data){
//          row = document.createElement("tr");
//          cellA = document.createElement("td");
//          cellB = document.createElement("td");

//          cellA.innerHTML = key;
//          cellB.innerHTML = data[key];

//          table.append(row);
//          row.appendChild(cellA);
//          row.appendChild(cellB);
//      }
//  })


