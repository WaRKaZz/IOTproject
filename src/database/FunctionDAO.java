package database;

import entity.Function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionDAO {

    private final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();


    public Function getUserByID(long userId) throws SQLException {
        Function function = new Function();
        Connection connection = CONNECTION_POOL.retrieve();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FUNCTION WHERE FUNCTION_ID = ?")){
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                function = configureUserObject(function, resultSet);
            }

        } finally {
            CONNECTION_POOL.putBack(connection);
        }
        return user;
    }

    private configureFunctionObject
}
