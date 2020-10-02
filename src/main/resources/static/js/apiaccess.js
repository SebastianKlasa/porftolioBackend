var arr = [];
var arrID = [];
var projCount = 0;
//endpoint
var endpointConst = "http://localhost:8090/";
var request;

function getProjectTitles(){
  var x = 0;
  localStorage.setItem("projNumber", x);
  // Create a request variable and assign a new XMLHttpRequest object to it.
  request = new XMLHttpRequest();
  // Open a new connection, using the GET request on the URL endpoint
  request.open('GET', endpointConst+"projectData", true);
  request.onload = function () {
    // Begin accessing JSON data here
      var data = JSON.parse(this.response);
      data.forEach((proj) => {
      // Log each movie's title
        arr.push(proj.title);
        arrID.push(proj.id);
      })
      projCount = arr.length;
      document.getElementById("project-title").innerHTML = arr[x];
      localStorage.setItem("projID", arrID[0]);
  }
  // Send request
  request.send();
}

function getProjectDetails(){
  var projID = localStorage.getItem("projID");
  request = new XMLHttpRequest();
  request.open('GET', endpointConst+"projectData/id/"+projID, true);
  request.onload = function () {
      var data = JSON.parse(this.response);
      document.getElementById("description").innerHTML = data.description;
      document.getElementById("title").innerHTML = data.title;
      document.getElementById("tech-list").innerHTML = "<h2>Technologies</h2>";
      data.technologies.forEach((tech) =>{
        document.getElementById("tech-list").innerHTML += "<li>"+tech.name+"</li>";
      })
      document.getElementById("gitUrl").setAttribute("href", data.gitUrl);
      document.getElementById("action").innerHTML = data.action;
      document.getElementById("action").setAttribute("href", data.actionOnClick);
  }
  request.send();
}

function enableEmailConfirmation(){
    if(localStorage.getItem("emailConfirmation")=="Email was sent"){
        alert(localStorage.getItem("emailConfirmation"));
        localStorage.setItem("emailConfirmation", null);
    }
}

function setEmailConfirmation(){
  localStorage.setItem("emailConfirmation", "Email was sent");
}

function prevProj(){
  var x = parseInt(localStorage.getItem("projNumber"));
  if(x <= 0) x = projCount - 1;
  else x=x-1;
  localStorage.setItem("projNumber", x);
  localStorage.setItem("projID", arrID[x]);
  console.log(localStorage.getItem("projID"));
  document.getElementById("project-title").innerHTML = arr[x];
}

function nextProj(){
  var x = parseInt(localStorage.getItem("projNumber"));
  if(x >= projCount - 1) x = 0;
  else x=x+1;
  localStorage.setItem("projNumber", x);
  localStorage.setItem("projID", arrID[x]);
  console.log(localStorage.getItem("projID"));
  document.getElementById("project-title").innerHTML = arr[x];
}

function bodyOnloadFunctions(){
    getProjectTitles();
    enableEmailConfirmation();
}

function validateForm() {
  var email = document.getElementById("formPole1");
  var subject = document.getElementById("formPole2");
  var message = document.getElementById("formPole3");
  if (email.value == "") {
    email.setCustomValidity("Email is required!");
    return false;
  }
  else{
    email.setCustomValidity("");
  }
  if (subject.value == "") {
    subject.setCustomValidity("Subject is required!");
    return false;
  }
  else{
    subject.setCustomValidity("");
  }
  if (message.value == "") {
    message.setCustomValidity("Message is required!");
    return false;
  }
  else{
    message.setCustomValidity("");
  }
  return true;
}

function onSubmitForm(){
    var flag = validateForm();
    if(flag==true){
        setEmailConfirmation();
    }
    return flag;
}