package Vistas;

/*
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static javafx.application.Application.launch;

public class Memorama {


    private void RevolverCartas() {

        String[] arImagenes ={"ima1.jpg","ima2.jpg","ima3.jpg","ima4.jpg","ima5.jpg","ima6.jpg",
                "ima7.jpg","ima8.jpg","ima9.jpg","ima10.jpg","ima11.jpg","ima12.jpg","ima13.jpg",
                "ima14.jpg","ima15.jpg","ima16.jpg","ima17.jpg","ima18.jpg","ima19.jpg","ima20.jpg",
                "ima21.jpg","ima22.jpg","ima23.jpg","ima24.jpg","ima25.jpg","ima26.jpg","ima27.jpg",
                "ima28.jpg","ima29.jpg","ima30.jpg","ima31.jpg","ima32.jpg","ima33.jpg","ima34.jpg",
                "ima35.jpg","ima36.jpg","ima37.jpg","ima38.png","ima39.jpg","ima40.png","ima41.png",
                "ima42.jpg","ima43.jpg","ima44.jpg","ima45.jpg","ima46.jpg","ima47.jpg","ima48.jpg",
                "ima49.jpg","ima50.jpg","ima51.jpg","ima52.jpg","ima53.jpg","ima54.jpg"};
        Button[][] arBnCartas =new Button[2][4];
        ImageView imvCarta;
        int posx=0;
        int posy=0;
        int cont=0;
        for (int i = 0; i < arImagenes.length;) {
            posx =(int)(Math.random()*2);
            posx =(int)(Math.random()*4);

            if (arBnCartas[posx][posy]==null) {
                arBnCartas[posx][posy] =new Button();
                imvCarta =new ImageView(getClass().getResource("/estilos/main.css"+arImagenes[i]).toString());


                imvCarta.setFitHeight(150);
                imvCarta.setFitWidth(100);
               arBnCartas[posx][posy].setGraphic(imvCarta);

               arBnCartas[posx][posy].setPrefSize(100,150);

                cont++;
                if (cont == 2) i++ ;

                cont=0;
                {

                }

            }

        }
    }
    public static void main(String[] args) {
        launch(args);
    }


}*/



/*
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Memorama extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear la ventana principal
        primaryStage.setTitle("Memorama Game");

        // Crear la escena principal
        Scene scene = new Scene(new Group(), 800, 600);

        // Crear y configurar los elementos de la interfaz de usuario (botones, etiquetas, etc.)
        // Aquí agregarías tus elementos de la interfaz de usuario y los añadirías al "Group" de la escena

        // Mostrar la escena en la ventana principal
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/





/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Memorama extends Application {

    private void RevolverCartas(GridPane gridPane) {
        String[] arImagenes = {"ima1.jpg", "ima2.jpg", "ima3.jpg", "ima4.jpg", "ima5.jpg", "ima6.jpg",
                "ima7.jpg", "ima8.jpg", "ima9.jpg", "ima10.jpg", "ima11.jpg", "ima12.jpg", "ima13.jpg",
                "ima14.jpg", "ima15.jpg", "ima16.jpg", "ima17.jpg", "ima18.jpg", "ima19.jpg", "ima20.jpg",
                "ima21.jpg", "ima22.jpg", "ima23.jpg", "ima24.jpg", "ima25.jpg", "ima26.jpg", "ima27.jpg",
                "ima28.jpg", "ima29.jpg", "ima30.jpg", "ima31.jpg", "ima32.jpg", "ima33.jpg", "ima34.jpg",
                "ima35.jpg", "ima36.jpg", "ima37.jpg", "ima38.png", "ima39.jpg", "ima40.png", "ima41.png",
                "ima42.jpg", "ima43.jpg", "ima44.jpg", "ima45.jpg", "ima46.jpg", "ima47.jpg", "ima48.jpg",
                "ima49.jpg", "ima50.jpg", "ima51.jpg", "ima52.jpg", "ima53.jpg", "ima54.jpg"};

        // Shuffle the array of images
        for (int i = 0; i < arImagenes.length; i++) {
            int randomIndex = (int) (Math.random() * arImagenes.length);
            String temp = arImagenes[i];
            arImagenes[i] = arImagenes[randomIndex];
            arImagenes[randomIndex] = temp;
        }

        int rowIndex = 0;
        int colIndex = 0;

        for (String imageName : arImagenes) {
            Image image = new Image("file:///C:/Users/GTO/IdeaProjects/TAP2024/src/main/resources/image/" + imageName);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(150);

            Button button = new Button();
            button.setGraphic(imageView);
            button.setPrefSize(100, 150);

            gridPane.add(button, colIndex, rowIndex);

            colIndex++;
            if (colIndex == 4) {
                colIndex = 0;
                rowIndex++;
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Memorama Game");

        GridPane gridPane = new GridPane();
        RevolverCartas(gridPane);

        Scene scene = new Scene(gridPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/
/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Memorama extends Application {

    private void RevolverCartas(GridPane gridPane) {
        String[] arImagenes = {"ima1.jpg", "ima2.jpg", "ima3.jpg", "ima4.jpg", "ima5.jpg", "ima6.jpg",
                "ima7.jpg", "ima8.jpg", "ima9.jpg", "ima10.jpg", "ima11.jpg", "ima12.jpg", "ima13.jpg",
                "ima14.jpg", "ima15.jpg", "ima16.jpg"};

        int numColumns = 4; // Número de columnas
        int numRows = 4;    // Número de filas

        // Shuffle the array of images
        for (int i = 0; i < arImagenes.length; i++) {
            int randomIndex = (int) (Math.random() * arImagenes.length);
            String temp = arImagenes[i];
            arImagenes[i] = arImagenes[randomIndex];
            arImagenes[randomIndex] = temp;
        }

        int index = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                if (index < arImagenes.length) {
                    // Load the image
                    Image image = new Image(getClass().getResourceAsStream("/image/" + arImagenes[index]));
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(150);

                    // Create button with image
                    Button button = new Button();
                    button.setGraphic(imageView);
                    button.setPrefSize(100, 150);

                    // Add button to GridPane
                    gridPane.add(button, col, row);

                    index++;
                }
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Memorama Game");

        GridPane gridPane = new GridPane();
        RevolverCartas(gridPane);

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}




/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Memorama extends Application {

    private String firstImageName = null;
    private Button firstButton = null;

    private void RevolverCartas(GridPane gridPane) {
        String[] arImagenes = {"ima1.jpg", "ima2.jpg", "ima3.jpg", "ima4.jpg", "ima5.jpg", "ima6.jpg",
                "ima7.jpg", "ima8.jpg", "ima9.jpg", "ima10.jpg", "ima11.jpg", "ima12.jpg", "ima13.jpg",
                "ima14.jpg", "ima15.jpg", "ima16.jpg"};

        int numColumns = 4; // Número de columnas
        int numRows = 4;    // Número de filas

        // Duplicar la lista de imágenes para crear pares
        List<String> listaImagenes = new ArrayList<>(Arrays.asList(arImagenes));
        listaImagenes.addAll(Arrays.asList(arImagenes));

        // Revolver la lista de imágenes
        Collections.shuffle(listaImagenes);

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                // Obtener la siguiente imagen de la lista
                String imageName = listaImagenes.get(row * numColumns + col);

                // Load the image
                Image image = new Image(getClass().getResourceAsStream("/image/" + imageName));
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(150);

                // Create button with image
                Button button = new Button();
                button.setGraphic(imageView);
                button.setPrefSize(100, 150);

                // Add button to GridPane
                gridPane.add(button, col, row);

                // Agregar evento de clic al botón
                button.setOnAction(event -> {
                    handleButtonClick(button, imageName);
                });
            }
        }
    }

    private void handleButtonClick(Button button, String imageName) {
        if (firstImageName == null) {
            // No hay una imagen seleccionada previamente
            firstImageName = imageName;
            firstButton = button;
        } else {
            // Ya hay una imagen seleccionada previamente, compararlas
            if (firstImageName.equals(imageName)) {
                // Las imágenes son iguales, mantenerlas visibles
                button.setDisable(true);
                firstButton.setDisable(true);
            } else {
                // Las imágenes son diferentes, ocultarlas nuevamente
                // Puedes implementar aquí alguna animación o un pequeño retraso para que el jugador pueda ver las imágenes antes de ocultarlas nuevamente
                button.setGraphic(null);
                firstButton.setGraphic(null);
            }
            // Reiniciar la selección de imágenes
            firstImageName = null;
            firstButton = null;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Memorama Game");

        GridPane gridPane = new GridPane();
        RevolverCartas(gridPane);

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/

/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Memorama extends Application {

    private String firstImageName = null;
    private Button firstButton = null;

    private void RevolverCartas(GridPane gridPane) {
        String[] arImagenes = {"ima1.jpg", "ima2.jpg", "ima3.jpg", "ima4.jpg", "ima5.jpg", "ima6.jpg",
                "ima7.jpg", "ima8.jpg", "ima9.jpg", "ima10.jpg", "ima11.jpg", "ima12.jpg", "ima13.jpg",
                "ima14.jpg", "ima15.jpg", "ima16.jpg"};

        int numColumns = 4; // Número de columnas
        int numRows = 4;    // Número de filas

        // Duplicar la lista de imágenes para crear pares
        List<String> listaImagenes = new ArrayList<>(Arrays.asList(arImagenes));
        listaImagenes.addAll(Arrays.asList(arImagenes));

        // Revolver la lista de imágenes
        Collections.shuffle(listaImagenes);

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                // Obtener la siguiente imagen de la lista
                String imageName = listaImagenes.get(row * numColumns + col);

                // Load the image
                Image image = new Image(getClass().getResourceAsStream("/image/" + imageName));
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(150);

                // Create button with image
                Button button = new Button();
                button.setGraphic(imageView);
                button.setPrefSize(100, 150);

                // Add button to GridPane
                gridPane.add(button, col, row);

                // Agregar evento de clic al botón
                button.setOnAction(event -> {
                    handleButtonClick(button, imageName);
                });
            }
        }
    }

    private void handleButtonClick(Button button, String imageName) {
        if (firstImageName == null) {
            // No hay una imagen seleccionada previamente
            firstImageName = imageName;
            firstButton = button;
        } else {
            // Ya hay una imagen seleccionada previamente, compararlas
            if (firstImageName.equals(imageName)) {
                // Las imágenes son iguales, mantenerlas visibles
                button.setDisable(true);
                firstButton.setDisable(true);
            }
            // Reiniciar la selección de imágenes
            firstImageName = null;
            firstButton = null;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Memorama Game");

        GridPane gridPane = new GridPane();
        RevolverCartas(gridPane);

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/

/*
//este codigo ya pone todos los pares en orden
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Memorama extends Application {

    private void cargarCartas(GridPane gridPane) {
        String[] nombresImagenes = {"ima1.jpg", "ima2.jpg", "ima3.jpg", "ima4.jpg", "ima5.jpg", "ima6.jpg",
                "ima7.jpg", "ima8.jpg"};

        List<String> listaPares = new ArrayList<>();
        for (String nombre : nombresImagenes) {
            listaPares.add(nombre);
            listaPares.add(nombre);
        }

        // Mezclar la lista de pares
        Collections.shuffle(listaPares);

        // Mezclar la lista completa con pares para posicionarlas aleatoriamente
        Collections.shuffle(listaPares);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                String imageName = listaPares.remove(0);

                // Cargar la imagen
                Image image = new Image(getClass().getResourceAsStream("/image/" + imageName));
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(150);

                // Crear un botón con la imagen
                Button button = new Button();
                button.setGraphic(imageView);
                button.setPrefSize(100, 150);

                // Agregar el botón a la cuadrícula
                gridPane.add(button, col, row);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Memorama Game");

        GridPane gridPane = new GridPane();
        cargarCartas(gridPane);

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/

/*
estan volteadas con las tapas

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Memorama extends Application {

    private Image tapa;

    private void cargarCartas(GridPane gridPane) {
        // Imagen para la tapa de las cartas
        tapa = new Image(getClass().getResourceAsStream("/image/carta_atras.jpg"));

        String[] nombresImagenes = {"ima1.jpg", "ima2.jpg", "ima3.jpg", "ima4.jpg", "ima5.jpg", "ima6.jpg",
                "ima7.jpg", "ima8.jpg"};

        List<String> listaPares = new ArrayList<>();
        for (String nombre : nombresImagenes) {
            listaPares.add(nombre);
            listaPares.add(nombre);
        }

        // Mezclar la lista de pares
        Collections.shuffle(listaPares);

        // Mezclar la lista completa con pares para posicionarlas aleatoriamente
        Collections.shuffle(listaPares);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                // Cargar la imagen trasera (tapa)
                ImageView tapaView = new ImageView(tapa);
                tapaView.setFitWidth(100);
                tapaView.setFitHeight(150);

                // Crear botón con la tapa mostrada
                Button button = new Button();
                button.setGraphic(tapaView); // Mostrar la tapa
                button.setPrefSize(100, 150);

                // Agregar evento para girar la carta
                button.setOnAction(event -> {
                    // Aquí puedes agregar la lógica para cambiar entre la tapa y la imagen frontal al girar la carta
                });

                // Agregar el botón a la cuadrícula
                gridPane.add(button, col, row);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Memorama Game");

        GridPane gridPane = new GridPane();
        cargarCartas(gridPane);

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/


/*
//ya estan volteadas y giran al darles clik
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Memorama extends Application {

    private Image tapa;

    private void cargarCartas(GridPane gridPane) {
        // Imagen para la tapa de las cartas
        tapa = new Image(getClass().getResourceAsStream("/image/carta_atras.jpg"));

        String[] nombresImagenes = {"ima1.jpg", "ima2.jpg", "ima3.jpg", "ima4.jpg", "ima5.jpg", "ima6.jpg",
                "ima7.jpg", "ima8.jpg"};

        List<String> listaPares = new ArrayList<>();
        for (String nombre : nombresImagenes) {
            listaPares.add(nombre);
            listaPares.add(nombre);
        }

        // Mezclar la lista de pares
        Collections.shuffle(listaPares);

        // Mezclar la lista completa con pares para posicionarlas aleatoriamente
        Collections.shuffle(listaPares);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                String imageName = listaPares.remove(0);

                // Cargar la imagen frontal
                Image image = new Image(getClass().getResourceAsStream("/image/" + imageName));
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(150);

                // Cargar la imagen trasera (tapa)
                ImageView tapaView = new ImageView(tapa);
                tapaView.setFitWidth(100);
                tapaView.setFitHeight(150);

                // Crear botón con la tapa mostrada
                Button button = new Button();
                button.setGraphic(tapaView); // Mostrar la tapa
                button.setPrefSize(100, 150);

                // Agregar evento para girar la carta
                button.setOnAction(event -> {
                    if (button.getGraphic() == tapaView) {
                        // Si la tapa está mostrada, cambiar a la imagen frontal
                        button.setGraphic(imageView);
                    } else {
                        // Si la imagen frontal está mostrada, cambiar a la tapa
                        button.setGraphic(tapaView);
                    }
                });

                // Agregar el botón a la cuadrícula
                gridPane.add(button, col, row);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Memorama Game");

        GridPane gridPane = new GridPane();
        cargarCartas(gridPane);

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/


