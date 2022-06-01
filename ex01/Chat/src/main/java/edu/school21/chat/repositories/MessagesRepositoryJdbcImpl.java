package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{

    private final DataSource ds;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException{
        Optional <Message> optionalMessage;

        Connection connection = ds.getConnection();

        String quety = "SELECT * FROM chat.messages WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(quety);
        statement.setLong(1, id);
        ResultSet resultSet =  statement.executeQuery();

        resultSet.next();
        User user = new User(1L, "tttt", "123", null, null);
        Chatroom chatroom = new Chatroom(1L, "lol", null, null);
        optionalMessage = Optional.of(new Message(resultSet.getLong("id"), user,
                chatroom, resultSet.getString("text"), LocalDateTime.now()));
        resultSet.close();
        statement.close();
        connection.close();
        return optionalMessage;
    }
}
