package com.example.tap2024;

import Vistas.Calculadora;
import Vistas.CuadroMagico;
import Vistas.EmpleadoTaqueria;
//import Vistas.Memorama;
import com.example.tap2024.Componentes.Hilo;
import com.example.tap2024.modelos.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private MenuBar mnbPrincipal;
    private Menu menParcial1, menParcial2, menSalir;

    private MenuItem mitCalculadora, mitMemorama, mitCuadroMagico, mitEmpleado, mitSalir,mitPista;
    private BorderPane bdpPanel;


    @Override
    public void start(Stage stage) throws IOException {
        CrearMenu();

        bdpPanel = new BorderPane();
        bdpPanel.setTop(mnbPrincipal);
        Scene scene = new Scene(bdpPanel);
        scene.getStylesheets().add(getClass().getResource("/estilos/main.css").toString());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);



        new Hilo("Juno").start();
        new Hilo("Joshua").start();
        new Hilo("Rafa").start();
        new Hilo("Sergio").start();
        new Hilo("Alma").start();
        Conexion.crearConexion();
        new Calculadora();
        //new Memorama();
        new CuadroMagico();


    }

    private void CrearMenu() {


        mitCalculadora = new MenuItem("Calculadora");
        mitCalculadora.setOnAction(actionEvent -> new Calculadora());
        mitCuadroMagico = new MenuItem("Cuadromagico");
        mitCuadroMagico.setOnAction(actionEvent -> new CuadroMagico());
        mitMemorama = new MenuItem("Memorama");
        //mitMemorama.setOnAction(actionEvent -> new Memorama());
        menParcial1 = new Menu("Primer parcial");
        mitEmpleado = new MenuItem("Empleado Taqueria");
        mitEmpleado.setOnAction(event -> new EmpleadoTaqueria());
        menParcial1.getItems().addAll(mitCalculadora);
        menParcial1.getItems().addAll(mitCuadroMagico);
        menParcial1.getItems().addAll(mitMemorama);
        menParcial1.getItems().addAll(mitEmpleado);


        menParcial1 = new Menu("Primer parcial");
        //menParcial1=new Menu();
        menParcial1.getItems().addAll(mitCalculadora, mitMemorama, mitCuadroMagico, mitEmpleado);


        //segundo parcialmenu
        menParcial2 = new Menu("segundo parcial");
        mitPista=new MenuItem("Manejo de hilos");
        menParcial2.getItems().add(mitPista);

        //menu salir
        mitSalir = new MenuItem("Salir");
        menSalir = new Menu("Salir");
        menSalir.getItems().add(mitSalir);
        menSalir.setOnAction(event -> System.exit(0));


        mnbPrincipal = new MenuBar();
        mnbPrincipal.getMenus().addAll(menParcial1, menParcial2, menSalir);


/*
        Calculadora = new MenuItem("Calculadora");
        Calculadora.setOnAction((event) -> new Calculadora());
        CuadroMagico = new MenuItem("Cuadro mágico");
        CuadroMagicoagico.setOnAction((event) -> new Cuadro_magico());
        //Loteria = new MenuItem("Loteria");
        //Loteria.setOnAction((event) -> new Loteria());
        //Restaurante = new MenuItem("Restaurante");
        //MI_Restaurante.setOnAction((event) -> new Restaurante());
        //MI_Pista_de_atletismo = new MenuItem("Pista Atletismo");
        //MI_Pista_de_atletismo.setOnAction((event) -> new Pista_de_atletismo());
        //MI_Simulador_de_impresion = new MenuItem("Simulador de impresión");
        //MI_Simulador_de_impresion.setOnAction((event) -> new Simulador_de_impresion());
        MI_Salir = new MenuItem("Salir");
        MI_Salir.setOnAction(event -> System.exit(0));
        //Opciones del menú principal del programa.
        M_Parcial_1 = new Menu("Parcial 1");
        M_Parcial_1.getItems().addAll(MI_Calculadora, MI_Loteria, MI_Cuadro_magico);
        M_Parcial_2 = new Menu("Parcial 2");
        M_Parcial_2.getItems().addAll(MI_Restaurante, MI_Pista_de_atletismo, MI_Simulador_de_impresion);
        M_salir = new Menu("Salir");
        M_salir.getItems().addAll(MI_Salir);
        //Menú principal del programa.
        MB_Barra_de_menu = new MenuBar(M_Parcial_1, M_Parcial_2, M_salir);
    }
 */





    }

    public static void main(String[] args) {
        launch();
    }
}