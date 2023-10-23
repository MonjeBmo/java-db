package com.bmo.db.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class conn {

    public Connection connection() {
        try {
            config cfg = new config();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(cfg.url, cfg.usr, cfg.pass);
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
