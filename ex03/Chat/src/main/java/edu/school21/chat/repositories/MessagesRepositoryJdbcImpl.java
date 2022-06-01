package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
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

        Statement statement = connection.createStatement();


        String quety = "SELECT * FROM chat.messages WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(quety);
        resultSet.next();

        User user = new User(1L, "tttt", "123", null, null);
        Chatroom chatroom = new Chatroom(1L, "lol", null, null);
        optionalMessage = Optional.of(new Message(resultSet.getLong("id"), user,
                chatroom, resultSet.getString("text"), LocalDateTime.of(2022, 2, 22, 00, 00, 00)));


        resultSet.close();
        statement.close();
        connection.close();
        return optionalMessage;
    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException {
        String sqlQuery = "INSERT INTO chat.messages (author, room, text, timestamp)" +
                " VALUES (" +
                message.getAuthor().getId() + ", " +
                message.getChatroom().getId() + ", " +
                "'" + message.getText() + "'" + ", " +
                "'" + message.getMessageDateTime() + "'" +
                ");";

        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS) ) {

            statement.execute();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setId(key.getLong(1));

        } catch (SQLException e) {
            throw  new NotSavedSubEntityException();
        }
    }

    @Override
    public void update(Message message) throws SQLException {

        String sqlQuery = "UPDATE chat.messages " +
                "SET room = " + message.getChatroom().getId() + ", " +
                "author = " + message.getAuthor().getId() + ", " +
                "text = " +  "'" + message.getText() + "'" + ", " +
                "timestamp = " + "'" + message.getMessageDateTime() + "'" +
                "WHERE id = " + message.getId() + ";";

        try (Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery))  {
            statement.execute();
        }
    }
}
