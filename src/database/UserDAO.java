package database;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public User getUserByLogin(String userLogin) throws SQLException {
        User user = new User();
        Connection connection = CONNECTION_POOL.retrieve();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  USER WHERE USER_LOGIN = ?")){
            preparedStatement.setString(1,userLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = configureUser(user, resultSet);
            }

        } finally {
            CONNECTION_POOL.putBack(connection);
        }
        return user;
    }

    public User getUserByID(long userId) throws SQLException {
        User user = new User();
        Connection connection = CONNECTION_POOL.retrieve();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  USER WHERE USER_ID = ?")){
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = configureUser(user, resultSet);
            }

        } finally {
            CONNECTION_POOL.putBack(connection);
        }
        return user;
    }

    private User configureUser(User user, ResultSet resultSet) throws SQLException{
        user.setUserID(resultSet.getLong("USER_ID"));
        user.setUserLogin(resultSet.getString("USER_LOGIN"));
        user.setUserRole(resultSet.getInt("USER_ROLE"));
        user.setUserPassword(resultSet.getString("USER_PASSWORD"));
        user.setUserFirstName(resultSet.getString("USER_FIRST_NAME"));
        user.setUserLastName(resultSet.getString("USER_LAST_NAME"));
        user.setUserImageUrl(resultSet.getString("USER_IMAGE_URL"));
        return user;
    }

}