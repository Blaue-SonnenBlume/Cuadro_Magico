package Vistas;
/*
import javax.swing.*;
import java.awt.*;

public class CuadroMagico {
    public static void main(String[] args) {
        // Solicitar al usuario el tamaño del cuadro mágico
        String input = JOptionPane.showInputDialog("Ingrese el tamaño del cuadro mágico:");
        int n = Integer.parseInt(input);

        // Validar que el tamaño del cuadro mágico sea impar y mayor que 0
        if (n % 2 == 0 || n <= 0) {
            JOptionPane.showMessageDialog(null, "El tamaño del cuadro mágico debe ser impar y mayor que 0");
            return;
        }

        // Crear la ventana de diálogo para mostrar el cuadro mágico
        JFrame frame = new JFrame("Cuadro Mágico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        // Crear un panel personalizado con una imagen de fondo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar la imagen de fondo desde un archivo
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\GTO\\IdeaProjects\\TAP2024\\src\\main\\resources\\image\\gnomo.jpg");
                Image image = imageIcon.getImage();
                // Dibujar la imagen de fondo en el panel
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new GridLayout(n, n));

        // Generar el cuadro mágico
        int num = 1;
        int row = 0;
        int col = n / 2;

        for (int i = 0; i < n * n; i++) {
            JLabel label = new JLabel(Integer.toString(num), SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setFont(new Font("Arial", Font.BOLD, 24)); // Cambiar el tamaño de la fuente
            label.setOpaque(true); // Permitir que el fondo sea pintado
            label.setBackground(new Color(255, 255, 255, 100)); // Cambiar el color de fondo con transparencia
            label.setPreferredSize(new Dimension(50, 50)); // Cambiar el tamaño de la etiqueta
            panel.add(label);

            // Actualizar las coordenadas
            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;

            // Si la siguiente celda está vacía, moverse allí; de lo contrario, moverse abajo
            if ((i + 1) % n == 0) {
                row = (row + 1) % n;
            } else {
                row = nextRow;
                col = nextCol;
            }

            num++;
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}*/


/*
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

public class CuadroMagico {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de números para el cuadro mágico:");
        int n = Integer.parseInt(input);

        if (n % 2 == 0 || n <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de números para el cuadro mágico debe ser impar y mayor que 0");
            return;
        }

        int[][] cuadroMagico = generarCuadroMagico(n);
        escribirCuadroMagicoEnArchivo(cuadroMagico);
        leerYMostrarCuadrosMagicos(n);
    }

    // Generar el cuadro mágico
    public static int[][] generarCuadroMagico(int n) {
        int[][] cuadroMagico = new int[n][n];
        int num = 1;
        int row = 0;
        int col = n / 2;

        for (int i = 0; i < n * n; i++) {
            cuadroMagico[row][col] = num;
            num++;

            // Actualizar las coordenadas
            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;

            // Si la siguiente celda está vacía, moverse allí; de lo contrario, moverse abajo
            if (cuadroMagico[nextRow][nextCol] != 0) {
                row = (row + 1) % n;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }

        return cuadroMagico;
    }

    // Escribir el cuadro mágico en un archivo
    public static void escribirCuadroMagicoEnArchivo(int[][] cuadroMagico) {
        try (RandomAccessFile file = new RandomAccessFile("cuadro_magico.dat", "rw")) {
            for (int i = 0; i < cuadroMagico.length; i++) {
                for (int j = 0; j < cuadroMagico[i].length; j++) {
                    file.writeInt(cuadroMagico[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Leer el cuadro mágico desde el archivo y mostrarlo en una interfaz gráfica
    public static int[][] leerCuadroMagicoDesdeArchivo(int n) {
        int[][] cuadroMagico = new int[n][n];

        try (RandomAccessFile file = new RandomAccessFile("cuadro_magico.dat", "r")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cuadroMagico[i][j] = file.readInt();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cuadroMagico;
    }

    // Leer y mostrar ambos cuadros mágicos en la interfaz gráfica
    public static void leerYMostrarCuadrosMagicos(int n) {
        int[][] cuadroMagicoGenerado = generarCuadroMagico(n);
        int[][] cuadroMagicoDesdeArchivo = leerCuadroMagicoDesdeArchivo(n);

        JFrame frame = new JFrame("Cuadros Mágicos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2));

        JPanel panelGenerado = new JPanel(new BorderLayout());
        panelGenerado.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar un borde para la separación
        panelGenerado.add(new JLabel("Cuadro Mágico Original", SwingConstants.CENTER), BorderLayout.NORTH);
        JPanel panelGeneradoInterno = new JPanel(new GridLayout(n, n));
        mostrarCuadroMagicoEnPanel(cuadroMagicoGenerado, panelGeneradoInterno);
        panelGenerado.add(panelGeneradoInterno, BorderLayout.CENTER);

        JPanel panelDesdeArchivo = new JPanel(new BorderLayout());
        panelDesdeArchivo.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar un borde para la separación
        panelDesdeArchivo.add(new JLabel("Cuadro Mágico desde Archivo", SwingConstants.CENTER), BorderLayout.NORTH);
        JPanel panelDesdeArchivoInterno = new JPanel(new GridLayout(n, n));
        mostrarCuadroMagicoEnPanel(cuadroMagicoDesdeArchivo, panelDesdeArchivoInterno);
        panelDesdeArchivo.add(panelDesdeArchivoInterno, BorderLayout.CENTER);

        frame.add(panelGenerado);
        frame.add(panelDesdeArchivo);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Mostrar el cuadro mágico en un panel
    public static void mostrarCuadroMagicoEnPanel(int[][] cuadroMagico, JPanel panel) {
        for (int i = 0; i < cuadroMagico.length; i++) {
            for (int j = 0; j < cuadroMagico[i].length; j++) {
                JLabel label = new JLabel(Integer.toString(cuadroMagico[i][j]), SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setFont(new Font("Arial", Font.BOLD, 24));
                label.setOpaque(true);
                label.setBackground(new Color(255, 255, 255, 100));
                label.setPreferredSize(new Dimension(50, 50));
                panel.add(label);
            }
        }
    }
}*/

/*
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

public class CuadroMagico {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de números para el cuadro mágico:");
        int n = Integer.parseInt(input);

        if (n % 2 == 0 || n <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de números para el cuadro mágico debe ser impar y mayor que 0");
            return;
        }

        int[][] cuadroMagico = generarCuadroMagico(n);
        escribirCuadroMagicoEnArchivo(cuadroMagico);
        leerYMostrarCuadrosMagicos(n);
    }

    // Generar el cuadro mágico
    public static int[][] generarCuadroMagico(int n) {
        int[][] cuadroMagico = new int[n][n];
        int num = 1;
        int row = 0;
        int col = n / 2;

        for (int i = 0; i < n * n; i++) {
            cuadroMagico[row][col] = num;
            num++;

            // Actualizar las coordenadas
            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;

            // Si la siguiente celda está vacía, moverse allí; de lo contrario, moverse abajo
            if (cuadroMagico[nextRow][nextCol] != 0) {
                row = (row + 1) % n;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }

        return cuadroMagico;
    }

    // Escribir el cuadro mágico en un archivo
    public static void escribirCuadroMagicoEnArchivo(int[][] cuadroMagico) {
        try (RandomAccessFile file = new RandomAccessFile("cuadro_magico.dat", "rw")) {
            for (int i = 0; i < cuadroMagico.length; i++) {
                for (int j = 0; j < cuadroMagico[i].length; j++) {
                    file.writeInt(cuadroMagico[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Leer el cuadro mágico desde el archivo y mostrarlo en una interfaz gráfica
    public static int[][] leerCuadroMagicoDesdeArchivo(int n) {
        int[][] cuadroMagico = new int[n][n];

        try (RandomAccessFile file = new RandomAccessFile("cuadro_magico.dat", "r")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cuadroMagico[i][j] = file.readInt();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cuadroMagico;
    }

    // Leer y mostrar ambos cuadros mágicos en la interfaz gráfica
    public static void leerYMostrarCuadrosMagicos(int n) {
        int[][] cuadroMagicoGenerado = generarCuadroMagico(n);
        int[][] cuadroMagicoDesdeArchivo = leerCuadroMagicoDesdeArchivo(n);

        JFrame frame = new JFrame("Cuadros Mágicos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Agregar la imagen de fondo al centro del BorderLayout
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\GTO\\IdeaProjects\\TAP2024\\src\\main\\resources\\image\\gnomo.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        frame.add(backgroundLabel, BorderLayout.CENTER);

        // Crear paneles para los cuadros mágicos
        JPanel panelGenerado = new JPanel(new BorderLayout());
        panelGenerado.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar un borde para la separación
        panelGenerado.add(new JLabel("Cuadro Mágico Original", SwingConstants.CENTER), BorderLayout.NORTH);
        JPanel panelGeneradoInterno = new JPanel(new GridLayout(n, n));
        mostrarCuadroMagicoEnPanel(cuadroMagicoGenerado, panelGeneradoInterno);
        panelGenerado.add(panelGeneradoInterno, BorderLayout.CENTER);

        JPanel panelDesdeArchivo = new JPanel(new BorderLayout());
        panelDesdeArchivo.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar un borde para la separación
        panelDesdeArchivo.add(new JLabel("Cuadro Mágico desde Archivo", SwingConstants.CENTER), BorderLayout.NORTH);
        JPanel panelDesdeArchivoInterno = new JPanel(new GridLayout(n, n));
        mostrarCuadroMagicoEnPanel(cuadroMagicoDesdeArchivo, panelDesdeArchivoInterno);
        panelDesdeArchivo.add(panelDesdeArchivoInterno, BorderLayout.CENTER);

        // Agregar los paneles de los cuadros mágicos a la izquierda y derecha del BorderLayout
        frame.add(panelGenerado, BorderLayout.WEST);
        frame.add(panelDesdeArchivo, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Mostrar el cuadro mágico en un panel
    public static void mostrarCuadroMagicoEnPanel(int[][] cuadroMagico, JPanel panel) {
        for (int i = 0; i < cuadroMagico.length; i++) {
            for (int j = 0; j < cuadroMagico[i].length; j++) {
                JLabel label = new JLabel(Integer.toString(cuadroMagico[i][j]), SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setFont(new Font("Arial", Font.BOLD, 24));
                label.setOpaque(true);
                label.setBackground(new Color(255, 255, 255, 100));
                label.setPreferredSize(new Dimension(50, 50));
                panel.add(label);
            }
        }
    }
}*/


/*
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

public class  CuadroMagico {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de números para el cuadro mágico:");
        int n = Integer.parseInt(input);

        if (n % 2 == 0 || n <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de números para el cuadro mágico debe ser impar y mayor que 0");
            return;
        }

        int[][] cuadroMagico = generarCuadroMagico(n);
        escribirCuadroMagicoEnArchivo(cuadroMagico);
        leerYMostrarCuadrosMagicos(n);
    }

    // Generar el cuadro mágico
    public static int[][] generarCuadroMagico(int n) {
        int[][] cuadroMagico = new int[n][n];
        int num = 1;
        int row = 0;
        int col = n / 2;

        for (int i = 0; i < n * n; i++) {
            cuadroMagico[row][col] = num;
            num++;

            // Actualizar las coordenadas
            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;

            // Si la siguiente celda está vacía, moverse allí; de lo contrario, moverse abajo
            if (cuadroMagico[nextRow][nextCol] != 0) {
                row = (row + 1) % n;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }

        return cuadroMagico;
    }

    // Escribir el cuadro mágico en un archivo
    public static void escribirCuadroMagicoEnArchivo(int[][] cuadroMagico) {
        try (RandomAccessFile file = new RandomAccessFile("cuadro_magico.dat", "rw")) {
            for (int i = 0; i < cuadroMagico.length; i++) {
                for (int j = 0; j < cuadroMagico[i].length; j++) {
                    file.writeInt(cuadroMagico[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Leer el cuadro mágico desde el archivo y mostrarlo en una interfaz gráfica
    public static int[][] leerCuadroMagicoDesdeArchivo(int n) {
        int[][] cuadroMagico = new int[n][n];

        try (RandomAccessFile file = new RandomAccessFile("cuadro_magico.dat", "r")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cuadroMagico[i][j] = file.readInt();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cuadroMagico;
    }

    // Leer y mostrar ambos cuadros mágicos en la interfaz gráfica
    public static void leerYMostrarCuadrosMagicos(int n) {
        int[][] cuadroMagicoGenerado = generarCuadroMagico(n);
        int[][] cuadroMagicoDesdeArchivo = leerCuadroMagicoDesdeArchivo(n);

        JFrame frame = new JFrame("Cuadros Mágicos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Agregar la imagen de fondo al centro del BorderLayout
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\GTO\\IdeaProjects\\TAP2024\\src\\main\\resources\\image\\gnomo.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        frame.add(backgroundLabel, BorderLayout.CENTER);

        // Crear paneles para los cuadros mágicos
        JPanel panelGenerado = new JPanel(new BorderLayout());
        panelGenerado.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar un borde para la separación
        panelGenerado.add(new JLabel("Cuadro Mágico Original", SwingConstants.CENTER), BorderLayout.NORTH);
        JPanel panelGeneradoInterno = new JPanel(new GridLayout(n, n));
        mostrarCuadroMagicoEnPanel(cuadroMagicoGenerado, panelGeneradoInterno);
        panelGenerado.add(panelGeneradoInterno, BorderLayout.CENTER);

        JPanel panelDesdeArchivo = new JPanel(new BorderLayout());
        panelDesdeArchivo.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar un borde para la separación
        panelDesdeArchivo.add(new JLabel("Cuadro Mágico desde Archivo", SwingConstants.CENTER), BorderLayout.NORTH);
        JPanel panelDesdeArchivoInterno = new JPanel(new GridLayout(n, n));
        mostrarCuadroMagicoEnPanel(cuadroMagicoDesdeArchivo, panelDesdeArchivoInterno);
        panelDesdeArchivo.add(panelDesdeArchivoInterno, BorderLayout.CENTER);

        // Agregar los paneles de los cuadros mágicos a la izquierda y derecha del BorderLayout
        frame.add(panelGenerado, BorderLayout.WEST);
        frame.add(panelDesdeArchivo, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Mostrar el cuadro mágico en un panel


    public static void mostrarCuadroMagicoEnPanel(int[][] cuadroMagico, JPanel panel) {
        for (int i = 0; i < cuadroMagico.length; i++) {
            for (int j = 0; j < cuadroMagico[i].length; j++) {
                JLabel label = new JLabel(Integer.toString(cuadroMagico[i][j]), SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setFont(new Font("Arial", Font.BOLD, 24));
                label.setOpaque(true);
                label.setPreferredSize(new Dimension(50, 50));

                // Establecer color de fondo en función del número
                if (cuadroMagico[i][j] % 3 == 0) {
                    label.setBackground(Color.BLUE);
                    label.setForeground(Color.WHITE); // Establecer color de texto blanco para mayor contraste
                } else if (cuadroMagico[i][j] % 3 == 1) {
                    label.setBackground(Color.RED);
                    label.setForeground(Color.WHITE); // Establecer color de texto blanco para mayor contraste
                } else {
                    label.setBackground(Color.GREEN);
                    label.setForeground(Color.WHITE); // Establecer color de texto blanco para mayor contraste
                }

                panel.add(label);
            }
        }
    }

}
 */


//nuevo cuadro magico


/*
//ya corre
import java.io.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class CuadroMagico extends Application {
    private Scene escena;
    private Label lblMensaje;
    private TextField txtTamanioCuadro;
    private Button btnCalcular;
    private Button btnBorrar;
    private GridPane gdpCuadroMagico;
    private final String archivoCuadroMagico = "cuadro_magico.txt";

    @Override
    public void start(Stage primaryStage) {
        // Crear Label para el mensaje
       // lblMensaje = new Label("Los números impares mayores o iguales a 3 son 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, ...");

        // Crear TextField para el tamaño del cuadro
        txtTamanioCuadro = new TextField();
        txtTamanioCuadro.setPromptText("Introduce el tamaño del cuadro");

        // Crear botón para calcular el cuadro mágico
        btnCalcular = new Button("Calcular cuadro mágico");
        btnCalcular.setOnAction(this::calcularCuadroMagico);
        btnCalcular.setId("btnCalcular");

        // Crear botón para borrar el cuadro mágico
        btnBorrar = new Button("Borrar cuadro mágico");
        btnBorrar.setOnAction(this::borrarCuadroMagico);
        btnBorrar.setId("btnBorrar");

        // Crear GridPane para mostrar el cuadro mágico
        gdpCuadroMagico = new GridPane();
        gdpCuadroMagico.setAlignment(Pos.CENTER);
        gdpCuadroMagico.setHgap(10); // Espacio horizontal entre las celdas
        gdpCuadroMagico.setVgap(10); // Espacio vertical entre las celdas

        // Crear contenedor principal
        VBox vContenedorPrincipal = new VBox(lblMensaje, txtTamanioCuadro, btnCalcular, btnBorrar, gdpCuadroMagico);

        vContenedorPrincipal.setSpacing(10);
        vContenedorPrincipal.setAlignment(Pos.CENTER);

        // Crear escena y añadir estilos
        escena = new Scene(vContenedorPrincipal, 800, 600);

        // Comentar temporalmente la línea de estilos para asegurar que el problema sea solo la ruta del CSS
        // escena.getStylesheets().add(getClass().getResource("/Estilos/CuadroMagico.css").toString());

        // Verificar si el archivo CSS se carga correctamente
        try {
            String cssPath = getClass().getResource("/Estilos/CuadroMagico.css").toString();
            System.out.println("CSS Path: " + cssPath);
            escena.getStylesheets().add(cssPath);
        } catch (NullPointerException e) {
            System.out.println("El archivo CSS no se encontró en la ruta especificada.");
        }

        primaryStage.setTitle("Cuadro Mágico");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private void calcularCuadroMagico(ActionEvent event) {
        int tamanio = Integer.parseInt(txtTamanioCuadro.getText());

        // Verificar que el tamaño del cuadro sea válido
        if (tamanio < 3 || tamanio % 2 == 0) {
            System.out.println("El tamaño del cuadro debe ser un número impar mayor o igual a 3.");
            return;
        }

        // Limpiar el GridPane
        gdpCuadroMagico.getChildren().clear();

        // Calcular el cuadro mágico
        generarCuadroMagico(tamanio);
    }

    private void borrarCuadroMagico(ActionEvent event) {
        // Limpiar el GridPane y el TextField
        gdpCuadroMagico.getChildren().clear();
        txtTamanioCuadro.clear();
    }

    private void generarCuadroMagico(int tamanio) {
        int[][] cuadroMagico = new int[tamanio][tamanio];
        int numero = 1;
        int fila = 0;
        int columna = tamanio / 2;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCuadroMagico));

            while (numero <= tamanio * tamanio) {
                // Guardar el número en el cuadro mágico
                cuadroMagico[fila][columna] = numero;

                // Calcular la posición siguiente
                int nuevaFila = (fila - 1 + tamanio) % tamanio;
                int nuevaColumna = (columna + 1) % tamanio;

                // Verificar si la siguiente celda está ocupada
                if (cuadroMagico[nuevaFila][nuevaColumna] != 0) {
                    fila = (fila + 1) % tamanio;
                } else {
                    fila = nuevaFila;
                    columna = nuevaColumna;
                }
                numero++;
            }

            // Escribir el cuadro mágico en el archivo
            for (int i = 0; i < tamanio; i++) {
                StringBuilder filaCuadro = new StringBuilder();
                for (int j = 0; j < tamanio; j++) {
                    filaCuadro.append(cuadroMagico[i][j]);
                    if (j < tamanio - 1) {
                        filaCuadro.append(",");
                    }
                }
                writer.write("[" + filaCuadro.toString() + "]\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar el cuadro mágico en el GridPane
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Text textoNumero = new Text(String.valueOf(cuadroMagico[i][j]));
                StackPane celda = new StackPane();
                celda.setStyle("-fx-border-color: #2F4F4F; -fx-background-color: #76D7C4;");
                celda.getChildren().add(textoNumero);
                gdpCuadroMagico.add(celda, j, i);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/


/*
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class CuadroMagico extends Application {
    private Scene escena;
    private Stage primaryStage;
    private Label  lblMensaje;
    private TextField txtTamanioCuadro;
    private Button btnCalcular;
    private GridPane gdpCuadroMagico;
    private final String archivoCuadroMagico = "cuadro_magico.txt";

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Crear TextField para el tamaño del cuadro
        txtTamanioCuadro = new TextField();
        txtTamanioCuadro.setPromptText("Introduce el tamaño");
        txtTamanioCuadro.setMaxWidth(100); // Ajustar el ancho máximo del TextField
        txtTamanioCuadro.setStyle("-fx-border-radius: 10;"); // Establecer bordes redondeados

        // Crear botón para calcular el cuadro mágico
        btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(this::mostrarCuadroMagico);
        btnCalcular.setId("btnCalcular");

        // Crear ImageView para mostrar la imagen
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(getClass().getResource("/image/som2.jpg").toString());
            imageView.setImage(image);
            imageView.setFitWidth(200);  // Establecer el ancho deseado
            imageView.setFitHeight(200); // Establecer la altura deseada
            imageView.setPreserveRatio(true); // Mantener la relación de aspecto
        } catch (NullPointerException e) {
            System.out.println("La imagen no se encontró en la ruta especificada.");
        }

        // Crear contenedor principal
        VBox vContenedorPrincipal = new VBox(imageView, txtTamanioCuadro, btnCalcular);
        vContenedorPrincipal.setSpacing(10);
        vContenedorPrincipal.setAlignment(Pos.CENTER);

        // Crear escena
        escena = new Scene(vContenedorPrincipal, 300, 400); // Establecer un tamaño más pequeño
        escena.setFill(Color.DARKGRAY); // Establecer el color de fondo de la escena en gris oscuro

        primaryStage.setTitle("Cuadro Mágico");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private void mostrarCuadroMagico(ActionEvent event) {
        int tamanio = Integer.parseInt(txtTamanioCuadro.getText());

        // Crear una nueva ventana para mostrar el cuadro mágico
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Cuadro Mágico Generado");

        // Crear StackPane como contenedor principal
        StackPane stackPane = new StackPane();

        // Agregar imagen de fondo
        ImageView imageView = new ImageView();
        Image imageFondo = new Image(getClass().getResourceAsStream("/image/fonmag.jpg"));
        imageView.setImage(imageFondo);
        imageView.setFitWidth(800); // Ajusta el ancho de la imagen al tamaño de la ventana
        imageView.setFitHeight(600); // Ajusta la altura de la imagen al tamaño de la ventana
        stackPane.getChildren().add(imageView);

        // Crear GridPane para mostrar el cuadro mágico
        GridPane gdpCuadroMagicoVentana = new GridPane();
        gdpCuadroMagicoVentana.setAlignment(Pos.CENTER);
        gdpCuadroMagicoVentana.setHgap(10); // Espacio horizontal entre las celdas
        gdpCuadroMagicoVentana.setVgap(10); // Espacio vertical entre las celdas

        // Calcular el cuadro mágico
        generarCuadroMagico(gdpCuadroMagicoVentana, tamanio);

        stackPane.getChildren().add(gdpCuadroMagicoVentana);

        Scene escenaVentana = new Scene(stackPane, 800, 600);
        nuevaVentana.setScene(escenaVentana);
        nuevaVentana.show();

        // Ocultar la ventana principal
        primaryStage.hide();
    }

    private void generarCuadroMagico(GridPane gdpCuadroMagico, int tamanio) {
        int[][] cuadroMagico = new int[tamanio][tamanio];
        int numero = 1;
        int fila = 0;
        int columna = tamanio / 2;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCuadroMagico));

            while (numero <= tamanio * tamanio) {
                // Guardar el número en el cuadro mágico
                cuadroMagico[fila][columna] = numero;

                // Calcular la posición siguiente
                int nuevaFila = (fila - 1 + tamanio) % tamanio;
                int nuevaColumna = (columna + 1) % tamanio;

                // Verificar si la siguiente celda está ocupada
                if (cuadroMagico[nuevaFila][nuevaColumna] != 0) {
                    fila = (fila + 1) % tamanio;
                } else {
                    fila = nuevaFila;
                    columna = nuevaColumna;
                }
                numero++;
            }

            // Escribir el cuadro mágico en el archivo
            for (int i = 0; i < tamanio; i++) {
                StringBuilder filaCuadro = new StringBuilder();
                for (int j = 0; j < tamanio; j++) {
                    filaCuadro.append(cuadroMagico[i][j]);
                    if (j < tamanio - 1) {
                        filaCuadro.append(",");
                    }
                }
                writer.write("[" + filaCuadro.toString() + "]\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar el cuadro mágico en el GridPane
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Text textoNumero = new Text(String.valueOf(cuadroMagico[i][j]));
                textoNumero.setFont(Font.font(20)); // Ajustar el tamaño de la fuente
                StackPane celda = new StackPane();
                celda.setStyle("-fx-border-color: #2F4F4F; -fx-border-radius: 10;"); // Bordes redondeados
                celda.getChildren().add(textoNumero);
                gdpCuadroMagico.add(celda, j, i);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/






/*
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class CuadroMagico extends Application {
    private Scene escena;
    private Stage primaryStage;
    private Label  lblMensaje;
    private TextField txtTamanioCuadro;
    private Button btnCalcular;
    private GridPane gdpCuadroMagico;
    private final String archivoCuadroMagico = "CuadroMagico.txt";

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Crear TextField para el tamaño del cuadro
        txtTamanioCuadro = new TextField();
        txtTamanioCuadro.setPromptText("Introduce el tamaño");
        txtTamanioCuadro.setMaxWidth(100); // Ajustar el ancho máximo del TextField
        txtTamanioCuadro.setStyle("-fx-border-radius: 10;"); // Establecer bordes redondeados

        // Crear botón para calcular el cuadro mágico
        btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(this::mostrarCuadroMagico);
        btnCalcular.setId("btnCalcular");

        // Crear ImageView para mostrar la imagen
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(getClass().getResource("/image/som2.jpg").toString());
            imageView.setImage(image);
            imageView.setFitWidth(200);  // Establecer el ancho deseado
            imageView.setFitHeight(200); // Establecer la altura deseada
            imageView.setPreserveRatio(true); // Mantener la relación de aspecto
        } catch (NullPointerException e) {
            System.out.println("La imagen no se encontró en la ruta especificada.");
        }

        // Crear contenedor principal
        VBox vContenedorPrincipal = new VBox(imageView, txtTamanioCuadro, btnCalcular);
        vContenedorPrincipal.setSpacing(10);
        vContenedorPrincipal.setAlignment(Pos.CENTER);

        // Crear escena
        escena = new Scene(vContenedorPrincipal, 300, 400); // Establecer un tamaño más pequeño
        escena.setFill(Color.DARKGRAY); // Establecer el color de fondo de la escena en gris oscuro

        primaryStage.setTitle("Cuadro Mágico");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private void mostrarCuadroMagico(ActionEvent event) {
        int tamanio = Integer.parseInt(txtTamanioCuadro.getText());

        // Crear una nueva ventana para mostrar el cuadro mágico
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Cuadro Mágico Generado");

        // Crear StackPane como contenedor principal
        StackPane stackPane = new StackPane();

        // Agregar imagen de fondo
        ImageView imageView = new ImageView();
        Image imageFondo = new Image(getClass().getResourceAsStream("/image/fonmag.jpg"));
        imageView.setImage(imageFondo);
        imageView.setFitWidth(800); // Ajusta el ancho de la imagen al tamaño de la ventana
        imageView.setFitHeight(600); // Ajusta la altura de la imagen al tamaño de la ventana
        stackPane.getChildren().add(imageView);

        // Crear GridPane para mostrar el cuadro mágico
        GridPane gdpCuadroMagicoVentana = new GridPane();
        gdpCuadroMagicoVentana.setAlignment(Pos.CENTER);
        gdpCuadroMagicoVentana.setHgap(10); // Espacio horizontal entre las celdas
        gdpCuadroMagicoVentana.setVgap(10); // Espacio vertical entre las celdas

        // Calcular el cuadro mágico
        generarCuadroMagico(gdpCuadroMagicoVentana, tamanio);

        stackPane.getChildren().add(gdpCuadroMagicoVentana);

        Scene escenaVentana = new Scene(stackPane, 800, 600);
        nuevaVentana.setScene(escenaVentana);
        nuevaVentana.show();

        // Ocultar la ventana principal
        primaryStage.hide();
    }

    private void generarCuadroMagico(GridPane gdpCuadroMagico, int tamanio) {
        int[][] cuadroMagico = new int[tamanio][tamanio];
        int numero = 1;
        int fila = 0;
        int columna = tamanio / 2;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCuadroMagico));

            while (numero <= tamanio * tamanio) {
                // Guardar el número en el cuadro mágico
                cuadroMagico[fila][columna] = numero;

                // Calcular la posición siguiente
                int nuevaFila = (fila - 1 + tamanio) % tamanio;
                int nuevaColumna = (columna + 1) % tamanio;

                // Verificar si la siguiente celda está ocupada
                if (cuadroMagico[nuevaFila][nuevaColumna] != 0) {
                    fila = (fila + 1) % tamanio;
                } else {
                    fila = nuevaFila;
                    columna = nuevaColumna;
                }
                numero++;
            }

            // Escribir el cuadro mágico en el archivo
            for (int i = 0; i < tamanio; i++) {
                StringBuilder filaCuadro = new StringBuilder();
                for (int j = 0; j < tamanio; j++) {
                    filaCuadro.append(cuadroMagico[i][j]);
                    if (j < tamanio - 1) {
                        filaCuadro.append(",");
                    }
                }
                writer.write("[" + filaCuadro.toString() + "]\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar el cuadro mágico en el GridPane
        // Mostrar el cuadro mágico en el GridPane
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Text textoNumero = new Text(String.valueOf(cuadroMagico[i][j]));
                textoNumero.setFont(Font.font(20)); // Ajustar el tamaño de la fuente
                textoNumero.setFill(Color.WHITE); // Establecer el color del texto en blanco
                StackPane celda = new StackPane();
                celda.setStyle("-fx-border-color: white; -fx-border-radius: 10;"); // Bordes redondeados y color blanco
                celda.getChildren().add(textoNumero);
                gdpCuadroMagico.add(celda, j, i);
            }
        }





    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/


/*
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class CuadroMagico extends Application {
    private Scene escena;
    private Stage escenarioPrincipal;
    private Label lblMensaje;
    private TextField txtTamanioCuadro;
    private Button btnCalcular;
    private GridPane gdpCuadroMagico;
    private final String archivoCuadroMagico = "CuadroMagico.txt";

    @Override
    public void start(Stage primaryStage) {
        this.escenarioPrincipal = primaryStage;

        // Crear TextField para el tamaño del cuadro
        txtTamanioCuadro = new TextField();
        txtTamanioCuadro.setPromptText("Introduce el tamaño");
        txtTamanioCuadro.setMaxWidth(100); // Ajustar el ancho máximo del TextField
        txtTamanioCuadro.setStyle("-fx-border-radius: 10;"); // Establecer bordes redondeados

        // Crear botón para calcular el cuadro mágico
        btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(this::mostrarCuadroMagico);
        btnCalcular.setId("btnCalcular");

        // Crear ImageView para mostrar la imagen
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(getClass().getResource("/image/som2.jpg").toString());
            imageView.setImage(image);
            imageView.setFitWidth(200);  // Establecer el ancho deseado
            imageView.setFitHeight(200); // Establecer la altura deseada
            imageView.setPreserveRatio(true); // Mantener la relación de aspecto
        } catch (NullPointerException e) {
            System.out.println("La imagen no se encontró en la ruta especificada.");
        }

        // Crear contenedor principal
        VBox vContenedorPrincipal = new VBox(imageView, txtTamanioCuadro, btnCalcular);
        vContenedorPrincipal.setSpacing(10);
        vContenedorPrincipal.setAlignment(Pos.CENTER);

        // Crear escena
        escena = new Scene(vContenedorPrincipal, 300, 400); // Establecer un tamaño más pequeño
        escena.setFill(Color.DARKGRAY); // Establecer el color de fondo de la escena en gris oscuro

        primaryStage.setTitle("Cuadro Mágico");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private void mostrarCuadroMagico(ActionEvent event) {
        int tamanio = Integer.parseInt(txtTamanioCuadro.getText());

        // Crear una nueva ventana para mostrar el cuadro mágico
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Cuadro Mágico Generado");

        // Crear StackPane como contenedor principal
        StackPane stackPane = new StackPane();

        // Agregar imagen de fondo
        ImageView imageView = new ImageView();
        Image imageFondo = new Image(getClass().getResourceAsStream("/image/fonmag.jpg"));
        imageView.setImage(imageFondo);
        imageView.setFitWidth(800); // Ajusta el ancho de la imagen al tamaño de la ventana
        imageView.setFitHeight(600); // Ajusta la altura de la imagen al tamaño de la ventana
        stackPane.getChildren().add(imageView);

        // Crear GridPane para mostrar el cuadro mágico
        GridPane gdpCuadroMagicoVentana = new GridPane();
        gdpCuadroMagicoVentana.setAlignment(Pos.CENTER);
        gdpCuadroMagicoVentana.setHgap(10); // Espacio horizontal entre las celdas
        gdpCuadroMagicoVentana.setVgap(10); // Espacio vertical entre las celdas

        // Calcular el cuadro mágico
        generarCuadroMagico(gdpCuadroMagicoVentana, tamanio);

        stackPane.getChildren().add(gdpCuadroMagicoVentana);

        Scene escenaVentana = new Scene(stackPane, 800, 600);
        nuevaVentana.setScene(escenaVentana);
        nuevaVentana.show();

        // Ocultar la ventana principal
        escenarioPrincipal.hide();
    }

    private void generarCuadroMagico(GridPane gdpCuadroMagico, int tamanio) {
        int[][] cuadroMagico = new int[tamanio][tamanio];
        int numero = 1;
        int fila = 0;
        int columna = tamanio / 2;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCuadroMagico));

            while (numero <= tamanio * tamanio) {
                // Guardar el número en el cuadro mágico
                cuadroMagico[fila][columna] = numero;

                // Calcular la posición siguiente
                int nuevaFila = (fila - 1 + tamanio) % tamanio;
                int nuevaColumna = (columna + 1) % tamanio;

                // Verificar si la siguiente celda está ocupada
                if (cuadroMagico[nuevaFila][nuevaColumna] != 0) {
                    fila = (fila + 1) % tamanio;
                } else {
                    fila = nuevaFila;
                    columna = nuevaColumna;
                }
                numero++;
            }

            // Escribir el cuadro mágico en el archivo
            for (int i = 0; i < tamanio; i++) {
                StringBuilder filaCuadro = new StringBuilder();
                for (int j = 0; j < tamanio; j++) {
                    filaCuadro.append(cuadroMagico[i][j]);
                    if (j < tamanio - 1) {
                        filaCuadro.append(",");
                    }
                }
                writer.write("[" + filaCuadro.toString() + "]\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar el cuadro mágico en el GridPane
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Text textoNumero = new Text(String.valueOf(cuadroMagico[i][j]));
                textoNumero.setFont(Font.font(20)); // Ajustar el tamaño de la fuente
                textoNumero.setFill(Color.WHITE); // Establecer el color del texto en blanco
                StackPane celda = new StackPane();
                celda.setStyle("-fx-border-color: white; -fx-border-radius: 10;"); // Bordes redondeados y color blanco
                celda.getChildren().add(textoNumero);
                gdpCuadroMagico.add(celda, j, i);

            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CuadroMagico extends Application {
    private Scene escena;
    private Stage escenarioPrincipal;
    private TextField txtTamanioCuadro;
    private Button btnCalcular;
    private final String archivoCuadroMagico = "CuadroMagico.txt";

    @Override
    public void start(Stage primaryStage) {
        this.escenarioPrincipal = primaryStage;

        // Crear contenedor principal
        VBox vContenedorPrincipal = crearContenedorPrincipal();

        // Crear escena
        escena = new Scene(vContenedorPrincipal, 300, 400); // Establecer un tamaño más pequeño
        escena.setFill(Color.DARKGRAY); // Establecer el color de fondo de la escena en gris oscuro

        primaryStage.setTitle("Cuadro Mágico");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private VBox crearContenedorPrincipal() {
        // Crear TextField para el tamaño del cuadro
        txtTamanioCuadro = new TextField();
        txtTamanioCuadro.setPromptText("Introduce el tamaño");
        txtTamanioCuadro.setMaxWidth(100); // Ajustar el ancho máximo del TextField
        txtTamanioCuadro.setStyle("-fx-border-radius: 10;"); // Establecer bordes redondeados

        // Crear botón para calcular el cuadro mágico
        btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(this::mostrarCuadroMagico);
        btnCalcular.setId("btnCalcular");

        // Crear ImageView para mostrar la imagen
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(getClass().getResource("/image/som2.jpg").toString());
            imageView.setImage(image);
            imageView.setFitWidth(200);  // Establecer el ancho deseado
            imageView.setFitHeight(200); // Establecer la altura deseada
            imageView.setPreserveRatio(true); // Mantener la relación de aspecto
        } catch (NullPointerException e) {
            System.out.println("La imagen no se encontró en la ruta especificada.");
        }

        // Crear contenedor principal
        VBox vContenedorPrincipal = new VBox(imageView, txtTamanioCuadro, btnCalcular);
        vContenedorPrincipal.setSpacing(10);
        vContenedorPrincipal.setAlignment(Pos.CENTER);

        return vContenedorPrincipal;
    }

    private void mostrarCuadroMagico(ActionEvent event) {
        int tamanio = Integer.parseInt(txtTamanioCuadro.getText());

        // Crear una nueva ventana para mostrar el cuadro mágico
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Cuadro Mágico Generado");

        // Crear StackPane como contenedor principal
        StackPane stackPane = new StackPane();

        // Agregar imagen de fondo
        ImageView imageView = new ImageView();
        Image imageFondo = new Image(getClass().getResourceAsStream("/image/fonmag.jpg"));
        imageView.setImage(imageFondo);
        imageView.setFitWidth(800); // Ajusta el ancho de la imagen al tamaño de la ventana
        imageView.setFitHeight(600); // Ajusta la altura de la imagen al tamaño de la ventana
        stackPane.getChildren().add(imageView);

        // Crear GridPane para mostrar el cuadro mágico
        GridPane gdpCuadroMagicoVentana = new GridPane();
        gdpCuadroMagicoVentana.setAlignment(Pos.CENTER);
        gdpCuadroMagicoVentana.setHgap(10); // Espacio horizontal entre las celdas
        gdpCuadroMagicoVentana.setVgap(10); // Espacio vertical entre las celdas

        // Calcular el cuadro mágico
        generarCuadroMagico(gdpCuadroMagicoVentana, tamanio);

        stackPane.getChildren().add(gdpCuadroMagicoVentana);

        Scene escenaVentana = new Scene(stackPane, 800, 600);
        nuevaVentana.setScene(escenaVentana);
        nuevaVentana.show();

        // Ocultar la ventana principal
        escenarioPrincipal.hide();
    }

    private void generarCuadroMagico(GridPane gdpCuadroMagico, int tamanio) {
        int[][] cuadroMagico = new int[tamanio][tamanio];
        int numero = 1;
        int fila = 0;
        int columna = tamanio / 2;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCuadroMagico));

            while (numero <= tamanio * tamanio) {
                // Guardar el número en el cuadro mágico
                cuadroMagico[fila][columna] = numero;

                // Calcular la posición siguiente
                int nuevaFila = (fila - 1 + tamanio) % tamanio;
                int nuevaColumna = (columna + 1) % tamanio;

                // Verificar si la siguiente celda está ocupada
                if (cuadroMagico[nuevaFila][nuevaColumna] != 0) {
                    fila = (fila + 1) % tamanio;
                } else {
                    fila = nuevaFila;
                    columna = nuevaColumna;
                }
                numero++;
            }

            // Escribir el cuadro mágico en el archivo
            for (int i = 0; i < tamanio; i++) {
                StringBuilder filaCuadro = new StringBuilder();
                for (int j = 0; j < tamanio; j++) {
                    filaCuadro.append(cuadroMagico[i][j]);
                    if (j < tamanio - 1) {
                        filaCuadro.append(",");
                    }
                }
                writer.write("[" + filaCuadro.toString() + "]\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar el cuadro mágico en el GridPane
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Text textoNumero = new Text(String.valueOf(cuadroMagico[i][j]));
                textoNumero.setFont(Font.font(20)); // Ajustar el tamaño de la fuente
                textoNumero.setFill(Color.WHITE); // Establecer el color del texto en blanco
                StackPane celda = new StackPane();
                celda.setStyle("-fx-border-color: white; -fx-border-radius: 10; -fx-background-color: #2F4F4F;");
                celda.getChildren().add(textoNumero);
                gdpCuadroMagico.add(celda, j, i);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
