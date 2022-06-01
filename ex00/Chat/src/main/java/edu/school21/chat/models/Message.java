package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private Long id;
    private User author;
    private Chatroom chatroom;
    private String text;
    private LocalDateTime messageDateTime;

    public Message(Long id, User author, Chatroom chatroom, String text, LocalDateTime messageDateTime) {
        this.id = id;
        this.author = author;
        this.chatroom = chatroom;
        this.text = text;
        this.messageDateTime = messageDateTime;
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getMessageDateTime() {
        return messageDateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Message message = (Message) o;
        if (id == message.id
                && author.equals(message.author)
                && chatroom.equals(message.chatroom)
                && text.equals(message.text)
                && messageDateTime.equals(message.messageDateTime)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, chatroom, text, messageDateTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", chatroom=" + chatroom +
                ", text='" + text + '\'' +
                ", messageDateTime=" + messageDateTime +
                '}';
    }

    public void setMessageDateTime(LocalDateTime messageDateTime) {
        this.messageDateTime = messageDateTime;
    }
}
