// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function registerUser() {
    let data = {};
    data.name = document.getElementById('txtFirstName').value;
    data.lastname = document.getElementById('txtLastName').value;
    data.email = document.getElementById('txtInputEmail').value;
    data.password = document.getElementById('txtInputPassword').value;

    let repeatPassword = document.getElementById('txtRepeatPassword').value;

    if(repeatPassword != data.password) {
        alert('Password is not same')
        return;
    }

   const request = await fetch('api/users', {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
   });
   alert('register successfully')
   window.location.href = 'login.html'
}