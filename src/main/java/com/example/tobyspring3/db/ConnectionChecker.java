package com.example.tobyspring3.db;

import java.sql.*;
import java.util.Map;

import static java.lang.System.getenv;

public class ConnectionChecker {
    private String host;
    private String user;
    private String password;

    public ConnectionChecker(Map<String, String> env) {
        this.host = env.get("DB_HOST");
        this.user = env.get("DB_USER");
        this.password = env.get("DB_PASSWORD");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionChecker cc = new ConnectionChecker(getenv());
        cc.check();
//        cc.add();
//        cc.select();
    }

    private void check() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                host, user, password
        );

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("show databases");

        while (rs.next()) {
            String line = rs.getString(1);
            System.out.println("line = " + line);
        }
    }

    public void add() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                host, user, password
        );

        PreparedStatement ps = conn.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)"
        );
        ps.setInt(1, 2);
        ps.setString(2, "byungil2222");
        ps.setString(3, "12342222");
        ps.executeUpdate();

    }

    public void select() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                host, user, password
        );

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from users"); // 컬럼이 3개 (id, name, password)

        while (rs.next()) {
            String col1 = rs.getString(1);
            String col2 = rs.getString(2);
            String col3 = rs.getString(3);
            System.out.printf("%s %s %s\n", col1, col2, col3);
        }
    }
}
