// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#users').DataTable();
});

async function loadUsers() {
    const request = await fetch('api/users', {
        method: 'GET',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        }
    });
    const users = await request.json();

    let listHTML = '';


    for(let user of users) {
      let deleteButton = '<a href="#" onclick="deleteUser(' + user.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
      let textPhone = user.phone == null ? '-' : user.phone;
      let usersHTML = '<tr><td>'+ user.id +'</td><td>'+ user.name +' '+ user.lastname +'</td><td>'+ user.email +'</td><td>'+ textPhone + '</td><td>'+ deleteButton +'</td></tr>';
      listHTML += usersHTML;
    }

    document.querySelector('#users tbody').outerHTML = listHTML;
}

async function deleteUser(id) {
    if(!confirm('Remove user?')) {
        return;
    }

    const request = await fetch('api/users/' + id , {
        method: 'DELETE',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        }
    });
    location.reload()

    console.log(id);
}