//setup
var findInsert = document.getElementById("testHere"); //get locator tag
var findStatsInsert = document.getElementById("statsHere"); //get locator tag
var typeMe = findInsert.innerText; //get text to type

var typeParent = document.createElement("pre"); //parent tag

var stats1 = document.createElement("p");//stats tags
stats1.id = "TimeText";
stats1.style = "text-align:center"
var stats2 = document.createElement("p");
stats2.id = "WpmText";
stats2.style = "text-align:center"
var stats3 = document.createElement("p");
stats3.id = "ErrorsText";
stats3.style = "text-align:center";

var newDone = document.createElement("span"); //child tags
newDone.id = "done";
newDone.style = "color: black;";

var newCurrentChar = document.createElement("span");
newCurrentChar.id = "nextID";
newCurrentChar.className= "next";

var newTodo = document.createElement("span");
newTodo.id = "todo";
newTodo.style = "color: grey;";

var newLast = document.createElement("span");
newLast.id="lastID";



typeParent.appendChild(newDone); //add child tags to parent tag
typeParent.appendChild(newLast);
typeParent.appendChild(newCurrentChar);
typeParent.appendChild(newTodo);

document.body.insertBefore(typeParent, findInsert); //insert tags
document.body.insertBefore(stats1, findStatsInsert)
document.body.insertBefore(stats2, findStatsInsert)
document.body.insertBefore(stats3, findStatsInsert)

findInsert.parentNode.removeChild(findInsert); //remove locatorTags
findStatsInsert.parentNode.removeChild(findStatsInsert);

//setup done
//-------------------------------------------------------

var countVar = 0; //keep track of where in string we are
var errors = 0; //errors

var typeThis = document.getElementById("nextID"); //get elements
var done = document.getElementById("done");
var todo = document.getElementById("todo");
var TimeText = document.getElementById("TimeText");
var WpmText = document.getElementById("WpmText");
var ErrorsText = document.getElementById("ErrorsText");

typeThis.style.color="green";

done.textContent = typeMe.substring(0, countVar); //setup strings
todo.textContent = typeMe.substring(countVar + 1, typeThis.length);
typeThis.textContent = typeMe.charAt(countVar);

var keyPressed = false; // setup start variable
let donetype = false; // setup finish variable

document.addEventListener("keydown", function (event) {
    if (event.key != "Shift") { //ignore shift key, can add other ignores here
        if (keyPressed == false) {// start timer
            date1 = new Date();
            keyPressed = true;
        }
        if (typeMe.charAt(countVar).toString() == event.key) { // if correct key

            countVar++;

            var last = document.getElementById("lastID");
            last.parentNode.removeChild(last);

			typeThis = document.getElementById("nextID");

			typeThis.className = "from"
			typeThis.id="lastID";
            typeThis.style.color="black";
			
            var next = document.createElement("span");//make next tag
			next.id = "nextID";
			next.className = "next";
            next.style.color="green";
			var y = document.createTextNode(typeMe.charAt(countVar));
			next.appendChild(y);
            typeParent.insertBefore(next, todo);

			next.style.color="green";
            
            done.textContent = typeMe.substring(0, countVar-1);
            todo.textContent = typeMe.substring(countVar + 1, typeThis.length);
            //typeThis.textContent = typeMe.charAt(countVar);

            if (countVar == typeMe.length) { //done
                var date2 = new Date();
                TimeText.textContent = "Time: " + (date2 - date1) / 1000 + " Seconds";
                WpmText.textContent = "WPM: " + Math.round(((typeMe.length / 5) / ((date2 - date1) / 1000)) * 60);
                ErrorsText.textContent = "Errors: " + errors;
                donetype = true;
            }
        }
        else { //wrong key
            var next = document.getElementById("nextID");
            next.style.color="red";
            errors++;
        }
        var intervalId = window.setInterval(function () { //live timer
            if (donetype != true) {
                var date2 = new Date();
                TimeText.textContent = "Time: " + (date2 - date1) / 1000
            }
        }, 100);
    }
});
