function addTask() {
    var inputTask = document.getElementById('task').value;
    if (inputTask == "") {
        alert('No Task entered to add.');
    }
    else {
        addListElement(inputTask);
        addDeleteEvents();
    }
}

function updateItems() {
    var inputTask = document.getElementById('task').value;
    if (inputTask == "") {
        alert('Please Press Edit button before pressing Update Button')

    }
    else {
        var div = this.parentElement;
        div.style.display = "none";
        addListElement(inputTask);
        addDeleteEvents();
        document.getElementById('task').value = "";
    }
}

function addListElement(inputTask) {
    var taskList = document.getElementById('tasklist');
    var newtaskitem = document.createElement('li');

    taskList.appendChild(newtaskitem);

    var taskTxt = document.createTextNode(inputTask);
    newtaskitem.className = "tasklistelement";
    newtaskitem.setAttribute('id', inputTask);
    newtaskitem.appendChild(taskTxt);

    var editButton = document.createElement("button");
    var edittxt = document.createTextNode("Edit");
    editButton.className = "edit";
    editButton.appendChild(edittxt);
    editButton.addEventListener('click', editItems, false);
    newtaskitem.appendChild(editButton);

    var updateButton = document.createElement("button");
    var updatetxt = document.createTextNode("Update");
    updateButton.className = "update";
    updateButton.appendChild(updatetxt);
    updateButton.addEventListener('click', updateItems, false);
    newtaskitem.appendChild(updateButton);

    var deleteButton = document.createElement("button");
    var deletetxt = document.createTextNode("Delete");
    deleteButton.className = "delete";
    deleteButton.appendChild(deletetxt);
    newtaskitem.appendChild(deleteButton);

}

function editItems() {
    var edittx = this.parentElement.innerText;    
    var txt = edittx.split('Edit')[0];
    document.getElementById('task').value= txt;
}

function addDeleteEvents() {
    var deleteItems = document.getElementsByClassName("delete");
    for (i = 0; i < deleteItems.length; i++) {
        deleteItems[i].onclick = function () {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }
    document.getElementById('task').value = "";
}

