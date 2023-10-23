package com.bmo.db.controller;

import com.bmo.db.client.Client;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.Statement;

public class Drive {

    public void saveInfo(Client client, Connection cc) {
        try {
            Statement stmt = cc.createStatement();
            String sql = new StringBuilder().append("INSERT INTO clientes (name, lastName, age, address, phone, email, dpi) ")
                    .append("VALUES ('").append(client.name)
                    .append("', '").append(client.lastName)
                    .append("', '").append(client.age)
                    .append("', '").append(client.address)
                    .append("', '").append(client.phone)
                    .append("', '").append(client.email)
                    .append("', '").append(client.DPI)
                    .append("')").toString();
            if (stmt.executeUpdate(sql) == 1) {
                JOptionPane.showMessageDialog(null, "Cliente guardado con exito");
            }
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Client FindClient(String id, Connection cc) {
        Client client = new Client();
        try {
            Statement stmt = cc.createStatement();
            String sql = new StringBuilder().append("SELECT * FROM clientes WHERE id = '").append(id).append("'").toString();
            var rs = stmt.executeQuery(sql);
            if (rs.next()) {
                client.name = rs.getString("name");
                client.lastName = rs.getString("lastName");
                client.age = rs.getInt("age");
                client.address = rs.getString("address");
                client.phone = rs.getString("phone");
                client.email = rs.getString("email");
                client.DPI = rs.getString("dpi");
            } else {
                return null;
            }
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    public boolean DeleteClient(String id, Connection cc) {
        try {
            Statement stmt = cc.createStatement();
            String sql = new StringBuilder().append("DELETE FROM clientes WHERE id = '").append(id).append("'").toString();
            if (stmt.executeUpdate(sql) == 1) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
                return true;
            }
            stmt.close();
            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
