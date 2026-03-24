package org.rakibul.chatapplication.security;

import org.jspecify.annotations.NonNull;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import java.net.URI;
import java.util.Map;

import org.rakibul.chatapplication.service.ChatService;

@Component
public class JwtHandshakeInterceptor implements HandshakeInterceptor {

    private final ChatService chatService;

    public JwtHandshakeInterceptor(ChatService chatService) {
        this.chatService = chatService;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request,
                                   @NonNull ServerHttpResponse response,
                                   @NonNull WebSocketHandler wsHandler,
                                   @NonNull Map<String, Object> attributes) throws Exception {
        URI uri = request.getURI();
        String token = chatService.extractTokenFromUri(uri); // implement this method

        if (chatService.isTokenValid(token)) {
            String username = chatService.extractUsername(token);
            attributes.put("username", username);
            return true;
        }
        return false;
    }

    @Override
    public void afterHandshake(@NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response,
                               @NonNull WebSocketHandler wsHandler, Exception exception) {
    }
}
