package database;

public class ConnectionPool  {
    private static final ConnectionPool instance = new ConnectionPool();


    public static ConnectionPool getInstance() {
        return instance;
    }


}
