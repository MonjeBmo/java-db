package com.bmo.db.controller;

import com.bmo.db.client.Client;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class Drive {

    public void saveInfo(Client client, Connection cc) {
        try {
            Statement stmt = cc.createStatement();
            String sql = new StringBuilder().append("INSERT INTO clientes (name, lastName, age, address, phone, email) ")
                    .append("VALUES ('").append(client.name)
                    .append("', '").append(client.lastName)
                    .append("', '").append(client.age)
                    .append("', '").append(client.address)
                    .append("', '").append(client.phone)
                    .append("', '").append(client.email)
                    .append("')").toString();
            if (stmt.executeUpdate(sql) == 1) {
                JOptionPane.showMessageDialog(null, "Cliente guardado con exito");
            }
            cc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
