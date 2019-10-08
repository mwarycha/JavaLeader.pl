var client = null;

function showMessage(value, user) {

    var today    = new Date();
    var date     = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    var time     = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var dateTime = date+' '+time;

    var newResponse = document.createElement('p');
    newResponse.appendChild(document.createTextNode("[" + dateTime + "] "));
    newResponse.appendChild(document.createTextNode(user));
    newResponse.appendChild(document.createTextNode(" : "));
    newResponse.appendChild(document.createTextNode(value));
    var respone = document.getElementById('reponse');
    respone.appendChild(newResponse);
}

function connect() {
    client = Stomp.client('ws://localhost:8080/chat');
    client.connect({}, function (frame) {
        client.subscribe("/topic/messages", function(message){
            showMessage(JSON.parse(message.body).message, JSON.parse(message.body).user)
        });
    })
}

function sendMessage() {
    var messageToSend = document.getElementById('messageToSend').value;
    var user          = document.getElementById('user').value;
    client.send("/app/chat", {}, JSON.stringify({'message': messageToSend, 'user': user}));
}
