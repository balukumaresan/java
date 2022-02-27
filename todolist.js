function addTask() {
    var inputTask = document.getElementById('task').value;
    if (inputTask == "") {
        alert('No Task entered to add.');
    }
    else {
        var newtaskitem = document.createElement('li');

        var taskTxt = document.createTextNode(inputTask);
        newtaskitem.className = "tasklistelement";
        newtaskitem.setAttribute('id',inputTask);
        newtaskitem.appendChild(taskTxt);

        var editButton = document.createElement("button");
        var edittxt = document.createTextNode("Edit");
        editButton.className = "edit";
        editButton.appendChild(edittxt);
        editButton.addEventListener('click', editItems, false);
        newtaskitem.appendChild(editButton);

        var deleteButton = document.createElement("button");
        var deletetxt = document.createTextNode("Delete");
        deleteButton.className = "delete";
        deleteButton.appendChild(deletetxt);
        newtaskitem.appendChild(deleteButton);

        var taskList = document.getElementById('tasklist');
        taskList.appendChild(newtaskitem);

        document.getElementById('task').value= "";

        var deleteItems = document.getElementsByClassName("delete");

        for (i = 0; i < deleteItems.length; i++) {
            deleteItems[i].onclick = function() {
                alert(this.parentElement.innerText);
              var div = this.parentElement;
              div.style.display = "none";
            }
          }
            }
 


}

function editItems(){
    var inputTask = document.getElementById('task').value;
    alert(inputTask);
    if (inputTask == "") {
        var txt = this.parentElement.innerText;
        var txt1 = txt.split('Edit')[0]
        document.getElementById('task').value = txt1;

    }
    else {
        var div = this.parentElement;
              div.style.display = "none";
        this.parentElement.innerText= (inputTask);
        var newtaskitem = document.createElement('li');

        var taskTxt = document.createTextNode(inputTask);
        newtaskitem.className = "tasklistelement";
        newtaskitem.setAttribute('id',inputTask);
        newtaskitem.appendChild(taskTxt);

        var editButton = document.createElement("button");
        var edittxt = document.createTextNode("Edit");
        editButton.className = "edit";
        editButton.appendChild(edittxt);
        editButton.addEventListener('click', editItems, false);
        newtaskitem.appendChild(editButton);

        var deleteButton = document.createElement("button");
        var deletetxt = document.createTextNode("Delete");
        deleteButton.className = "delete";
        deleteButton.appendChild(deletetxt);
        newtaskitem.appendChild(deleteButton);

        var taskList = document.getElementById('tasklist');
        taskList.appendChild(newtaskitem);

        document.getElementById('task').value= "";
        var deleteItems = document.getElementsByClassName("delete");
        for (i = 0; i < deleteItems.length; i++) {
            deleteItems[i].onclick = function() {
                alert(this.parentElement.innerText);
              var div = this.parentElement;
              div.style.display = "none";
            }
          }

    }






}

