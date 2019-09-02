package database;

import entity.Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Home_DAO {
    private final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private final static String  GET_HOME_BY_ID_SQL  = "SELECT * FROM  HOME WHERE HOME_ID = ?";

    public Home getHomeByID(long homeID) throws SQLException {
        Home home = new Home();
        Connection connection = CONNECTION_POOL.retrieve();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_HOME_BY_ID_SQL)){
            preparedStatement.setLong(1, homeID);
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
