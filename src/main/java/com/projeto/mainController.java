package com.projeto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


import java.sql.ResultSet;

import java.sql.*;

public class mainController {

    @FXML
    private ListView<String> list;

    /*public String getInfo() throws SQLException {

        // Establish a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://LAPTOP-5K0DBPI8:1433/projetoei;instance=EI26272;user=sa;password=123456");

        // Create a statement object
        Statement statement = conn.createStatement();

        // Execute a SQL query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CODPOSTAL");

        // Process the result set
        String cdPostal = null;
        String name = null;
        while (resultSet.next()) {
            cdPostal = resultSet.getString("CODPOSTAL");
            name = resultSet.getString("LOCALIDADE");
            System.out.println("ID: " + cdPostal + ", Name: " + name);
        }

        // Close the resources
        resultSet.close();
        statement.close();
        conn.close();

        return ("ID: " + cdPostal + ", Name: " + name);

    }*/


    public void initialize() throws SQLException {
        // Establish a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://DESKTOP-VDIJP2R:1433/projetoei;instance=EI24901;user=sa;password=123456");

        // Create a statement object
        Statement statement = conn.createStatement();

        // Execute a SQL query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CODPOSTAL");

        // Create an ObservableList to store the data
        ObservableList<String> items = FXCollections.observableArrayList();

        // Process the result set
        while (resultSet.next()) {
            String cdPostal = resultSet.getString("CODPOSTAL");
            String name = resultSet.getString("LOCALIDADE");
            String item = cdPostal + " - " + name;
            items.add(item);
        }

        // Set the items of the ListView to the ObservableList
        list.setItems(items);

        // Close the resources
        resultSet.close();
        statement.close();
        conn.close();
    }

}