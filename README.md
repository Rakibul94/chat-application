This project was built using the concept of WebSocket which is implemented by Spring Boot using STOMP protocol and SockJS.

WebSocket is a protocol that sits on top of TCP.Websocket establishes a full duplex connnection between client and server whenever a client sends a handshake request and keeps the connection live for instant messaging.

STOMP is another protocol that sits on top of TCP.STOMP provides rules and structures to raw messages sent in by Websocket like send,subscribe and destination.

Message Broker is in charge of routing messages to rightful users or subscribers.'

SockJS is javascipt fall library that ensures a backup if browser fail to support STOMP.When old brower cannot support STOMP,SockJS comes in action.


