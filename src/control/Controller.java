package control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import sprites.Globo;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Scene scene;
    private Stage stage;
    private GraphicsContext gc;
    private Globo globo;
    private Globo globo2;

    @FXML
    Canvas mainCanvas;

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0017), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            globo.clear(gc);
            globo.move();
            globo.render(gc);

            globo2.clear(gc);
            globo2.move();
            globo2.render(gc);


        }
    })
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        globo = new Globo(new Image("css/images/globo_verde_grande.png"));
        globo2 = new Globo(new Image("css/images/globo_azul.png"));


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
}
