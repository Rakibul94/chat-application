package org.rakibul.chatapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {
    private String id;
    private String name;
    private Set<String> members;
}
