package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;


import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Program {
    private static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PWD = "";
    private static final String DB_SCHEMA = "src/main/resources/schema.sql";
    private static final String DB_DATA = "src/main/resources/data.sql";

    public static void main (String[] argc) throws FileNotFoundException, SQLException{
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(DB_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PWD);

        runQueriesFromFile(ds, DB_SCHEMA);
        runQueriesFromFile(ds, DB_DATA);



        User creator = new User(10L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(1L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

        repository.save(message);
        System.out.println(message.getId());

        ds.close();

    }
    private static void runQueriesFromFile(DataSource ds, String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename)).useDelimiter(";");
        try {
            Connection connection = ds.getConnection();
            while (scanner.hasNext()) {
                connection.createStatement().execute(scanner.next().trim());
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();

    }
}