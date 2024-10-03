document.addEventListener("keydown", function (event) {
    var key = document.getElementById(event.code);
    key.className = "active";
});
document.addEventListener('keyup', function(event) {
    var key = document.getElementById(event.code);
    key.className = "";
});
  