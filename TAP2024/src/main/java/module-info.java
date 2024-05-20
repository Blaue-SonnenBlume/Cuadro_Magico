module com.example.tap2024 {



    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.tap2024 to javafx.fxml;
    // exports com.example.demo;
    exports com.example.tap2024.modelos;
    opens com.example.tap2024.modelos to javafx.fxml;



    requires java.sql;
    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.j;
   // requires mariadb.java.client;
    requires java.desktop;
    //  opens com.example.demo.modelos;




    // Agrega esta línea para exportar el paquete Vistas
    exports Vistas;

    opens Vistas to javafx.fxml;





}