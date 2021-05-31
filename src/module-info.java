module TesteFX {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens gui;
}