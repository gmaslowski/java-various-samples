var wsUri = "ws://localhost:9000/ws";
var communication;

function init() {
    communication = document.getElementById("communication");
    setupWebSocket();
}

function setupWebSocket() {
    websocket = new WebSocket(wsUri);
    websocket.onopen = function (event) {
        updateGui("Connected to " + wsUri);
        var message = "Doesn't matter. Handling Strings.";
        updateGui("Sent: " + message);
        websocket.send(message);
    };

    websocket.onmessage = function (event) {
        updateGui('<span style="color: darkred;">Received: ' + event.data + '</span>');
    };
}

function updateGui(message) {
    var p = document.createElement("p");
    p.style.wordWrap = "break-word";
    p.innerHTML = message;
    communication.appendChild(p);
}

window.addEventListener("load", init, false);
