package control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sprites.Globo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private GraphicsContext gc;
    private int globosperdidos=30;
    private int contadornivel = 1;
    private String stringcontadornivel = String.valueOf(contadornivel);

    List<Globo> arrayGlobos = new ArrayList<>();

    private float segundos = 0;
    private float creador_globo = 5;
    public static int contador = 0;
    @FXML
    Canvas mainCanvas;
    @FXML
    Text puntuacio;
    @FXML
    Text vides;
    @FXML
    Text nivell;

    Image image;
    Image image0 = new Image("css/images/globo_blanco_grande.png");
    Image image1 = new Image("css/images/globo_verde.png");
    Image image2 = new Image("css/images/globo_azul.png");
    Image image3 = new Image("css/images/globo_rojo.png");
    Image image4 = new Image("css/images/globo_negro_grande.png");
    Image image5 = new Image("css/images/globo_blanco.png");
    Image image6 = new Image("css/images/globo_verde_grande.png");
    Image image7 = new Image("css/images/globo_azul_grande.png");
    Image image8 = new Image("css/images/globo_rojo_grande.png");
    Image image9 = new Image("css/images/globo_negro_grande.png");

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0037), new EventHandler<>(){
        @Override
        public void handle(ActionEvent event) {
            segundos += 0.0037;
            printamientos();
            //CREAR NUEVO GLOBO
            if (segundos>creador_globo){
                establecer_globo();

                arrayGlobos.add(new Globo(image));
                creador_globo+=0.5F;
            }

            comprovarSiGloboEsClickado();

            //MOVER GLOBOS HACIA ARRIBA
            for (Globo globo: arrayGlobos ){
                globo.clear(gc);
                globo.move(contadornivel);
                globo.render(gc);
                if (globo.getPosY()-1 <= 0){
                    globo.eliminarAltura = true;
                }
            }

            //DEJAR DE PRINTAR GLOBOS ALTURA (TRUE)
            for (Globo globo: arrayGlobos ){
                if (globo.eliminarAltura){
                    globo.clear(gc);
                    globosperdidos--;
                }
                if (globo.eliminarConClick){
                    globo.clear(gc);
                }
            }

            //DEJAR DE PRINTAR GLOBOS CON CLICK (TRUE)
            for (Globo globo: arrayGlobos ){
                if (globo.eliminarConClick){
                    globo.clear(gc);
                }
                if (globo.eliminarConClick){
                    globo.clear(gc);
                }
            }

            arrayGlobos.removeIf(globo -> globo.eliminarAltura);
            arrayGlobos.removeIf(globo -> globo.eliminarConClick);

            //GAME OVER
            if (globosperdidos == 0){
                //TODO:navegar al game over
                try {
                    root = FXMLLoader.load(getClass().getResource("../sample/gameover.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                scene.getStylesheets().add("css/gameovercss.css");
                stage.setTitle("Game Over");
                stage.setScene(scene);
                stage.show();
            }
        }
    }));

    private void printamientos() {
        //Punts
        puntuacio.setText("Punts: "+contador);
        puntuacio.setFont(Font.font ("Anson", FontWeight.BOLD, 15));
        puntuacio.setFill(Color.MEDIUMVIOLETRED);
        //Vides
        vides.setText("Vides: "+globosperdidos);
        vides.setFont(Font.font ("Anson", FontWeight.BOLD, 15));
        vides.setFill(Color.ORANGERED);
        //Nivell
        nivell.setText("Nivell: "+stringcontadornivel);
        nivell.setFont(Font.font ("Anson", FontWeight.BOLD, 15));
        nivell.setFill(Color.INDIANRED);
    }

    private void comprovarSiGloboEsClickado() {
        scene.setOnMouseClicked(
                e -> {

                    for (Globo globo:arrayGlobos){
                        if ( globo.isClicked(new Point2D(e.getX(), e.getY()))){
                            globo.eliminarConClick = true;
                            contador++;
                            if (contador % 10 == 0) {
                                contadornivel++;
                                stringcontadornivel = String.valueOf(contadornivel);
                                if(contadornivel >= 11){
                                    stringcontadornivel = "MAX";
                                }
                            }
                        }
                    }
                });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        establecer_globo();
        arrayGlobos.add(new Globo(image));

        gc = mainCanvas.getGraphicsContext2D();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    private void establecer_globo() {
        Random random = new Random();
        int color = random.nextInt(10);

        if (color == 0) {
            image = image0;
        } else if (color == 1) {
            image = image1;
        } else if (color == 2) {
            image = image2;
        } else if (color == 3) {
            image = image3;
        } else if (color == 4) {
            image = image4;
        } else if (color == 5) {
            image = image5;
        } else if (color == 6) {
            image = image6;
        } else if (color == 7) {
            image = image7;
        } else if (color == 8) {
            image = image8;
        } else {
            image = image9;
        }

    }
}