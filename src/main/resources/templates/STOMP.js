const socket = new SockJS('/ws-chat');
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
  stompClient.subscribe('/topic/rooms/general', function (message) {
    const msg = JSON.parse(message.body);
    console.log(msg.sender + ': ' + msg.content);
  });

  stompClient.send("/app/chat.send", {}, JSON.stringify({
    sender: "TestUser",
    content: "Hello Room!",
    roomId: "general"
  }));


});