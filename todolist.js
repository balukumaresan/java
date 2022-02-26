function addTask() {
    var inputTask = document.getElementById('task').value;
    if (inputTask == "") {
        alert('No Task entered to add.');
    }
    else {
        var newtaskitem = document.createElement('li');

        var taskTxt = document.createTextNode(inputTask);
        newtaskitem.className = "task";
        newtaskitem.setAttribute('id',taskTxt.value);
        newtaskitem.appendChild(taskTxt);

        var editButton = document.createElement("button");
        var edittxt = document.createTextNode("Edit");
        editButton.className = "edit";
        editButton.appendChild(edittxt);
        newtaskitem.appendChild(editButton);

        var deleteButton = document.createElement("button");
        var deletetxt = document.createTextNode("Delete");
        deleteButton.className = "delete";
        deleteButton.appendChild(deletetxt);
        newtaskitem.appendChild(deleteButton);

        var taskList = document.getElementById('tasklist');
        taskList.appendChild(newtaskitem);

        document.getElementById('task').value= "";



    }

    let deleteBtn = document.getElementsByClassName("delete");
    Array.prototype.slice.call(deleteBtn).forEach(function (item) {
        item.addEventListener("click", function (e) {
            e.target.parentNode.remove()
        });

    })

    let editBtn = document.getElementsByClassName("edit");
    Array.prototype.slice.call(editBtn).forEach(function (item) {
        item.addEventListener("click", function (e) {
            alert('Hi');
            alert(this.document.getElementsByClassName('task'));
        });

    })
}

