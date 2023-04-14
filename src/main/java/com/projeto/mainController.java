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

    public void initialize() throws SQLException {
        // Establish a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://DESKTOP-VDIJP2R:1433/projetoei;instance=EI24901;user=sa;password=123456");

        // Create a statement object
        Statement statement = conn.createStatement();

        // Execute a SQL query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CONSULTA");

        // Create an ObservableList to store the data
        ObservableList<String> items = FXCollections.observableArrayList();

        // Process the result set
        while (resultSet.next()) {
            int cdPostal = resultSet.getInt("ID_CONSULTA");
            String name = resultSet.getString("DESCRICAO");
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