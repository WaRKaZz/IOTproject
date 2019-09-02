package database;

import entity.Device;
import entity.Function;
import entity.FunctionDefinition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionDAO {

    private final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private final static String GET_FUNCTION_BY_ID_SQL = "SELECT * FROM FUNCTION WHERE FUNCTION_ID = ? " +
                                                                        "LEFT JOIN  FUNCTION_DEFINITIONS";
    private final static String ADD_NEW_USER_SQL = "INSERT INTO FUNCTIONS" +
            " (F_BOOL, F_INT, F_STRING, FUNCTION_DEFINITION_ID, FUNCTION_DEVICE_ID)" +
            " VALUES (?, ?, ?, ?, ?)";

    public Function getFunctionByID(long functionID) throws SQLException {
        Function function = new Function();
        Connection connection = CONNECTION_POOL.retrieve();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_FUNCTION_BY_ID_SQL)){
            preparedStatement.setLong(1, functionID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                function = configureFunctionObject(function, resultSet);
            }

        } finally {
            CONNECTION_POOL.putBack(connection);
        }
        return function;
    }

    public void addNewFunction (Function function, FunctionDefinition functionDefinition, Device device) throws SQLException{
        Connection connection = CONNECTION_POOL.retrieve();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER_SQL)){
            configureFunctionStatement(function, functionDefinition.getFunctionDefinitionID(), device.getDeviceID(), preparedStatement);
            preparedStatement.executeUpdate();
        } finally {
            CONNECTION_POOL.putBack(connection);
        }
    }

    private Function configureFunctionObject(Function function, ResultSet resultSet) throws SQLException{
        function.setFunctionId(resultSet.getLong("FUNCTION_ID"));
        function.setFunctionName(resultSet.getString("FUNCTION_NAME"));
        function.setFunctionInput(resultSet.getBoolean("FUNCTION_TYPE"));
        function.setFunctionTrue(resultSet.getBoolean("F_BOOL"));
        function.setFunctionInteger(resultSet.getInt("F_INT"));
        function.setFunctionText(resultSet.getString("F_TEXT"));

        return function;
    }

    private void configureFunctionStatement(Function function, Long dfID, Long deviceID,  PreparedStatement preparedStatement) throws SQLException{
        preparedStatement.setBoolean(1, function.isFunctionInput());
        preparedStatement.setInt(2, function.getFunctionInteger());
        preparedStatement.setString(3, function.getFunctionText());
    }
}
