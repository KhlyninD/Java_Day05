package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> roomMessages;

    public Chatroom(Long id, String name, User owner, List<Message> roomMessages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.roomMessages = roomMessages;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Chatroom chatroom = (Chatroom) o;
        if (id == chatroom.id
                && name.equals(chatroom.name)
                && owner.equals(chatroom.owner)
                && roomMessages.equals(chatroom.roomMessages)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, roomMessages);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", roomMessages=" + roomMessages +
                '}';
    }
}
