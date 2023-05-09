package Data;

public class DbConfig {
    private String dbname = "personalNotes";
    private String password = "rollerrocker88";
    private String user = "postgres";

    private String host = "localhost";
    private int port = 5432;

    public String getDbname() {
        return dbname;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
