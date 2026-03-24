package org.rakibul.chatapplication.config;

import org.rakibul.chatapplication.security.JwtHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    private final JwtHandshakeInterceptor jwtHandshakeInterceptor;
//
//    @Autowired
//    public WebSocketConfig(JwtHandshakeInterceptor jwtHandshakeInterceptor){
//        this.jwtHandshakeInterceptor = jwtHandshakeInterceptor;
//    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                //.addInterceptors(jwtHandshakeInterceptor) // JWT Support
                .setAllowedOriginPatterns("*")
                .withSockJS(); // fallback for older browser that blocks STOMP
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // /topic for broadcast and /queue for private
        registry.enableSimpleBroker("/topic","/queue");
        registry.setApplicationDestinationPrefixes("/app"); // client -> server
        registry.setUserDestinationPrefix("/user"); // server specific user
    }

}
