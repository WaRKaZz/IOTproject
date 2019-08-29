package database;

import entity.Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Home_DAO {
    private final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public Home getHomeByID(long userId) throws SQLException {
        Home home = new Home();
        Connection connection = CONNECTION_POOL.retrieve();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  HOME WHERE HOME_ID = ?")){
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                home = configureHome(home, resultSet);
            }

        } finally {
            CONNECTION_POOL.putBack(connection);
        }
        return home;
    }

    private Home configureHome(Home home, ResultSet resultSet) throws SQLException{
        home.setHome_id(resultSet.getLong("HOME_ID"));
        home.setHome_address("HOME_ADDRESS");
        home.setHome_name("HOME_NAME");
        return home;
    }
}
