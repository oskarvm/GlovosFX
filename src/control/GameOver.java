package control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;


public class GameOver implements Initializable{

    public StackPane fondogo;
    @FXML
    Text puntuacio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        puntuacio.setText("Has rebentat "+Controller.contador + " globus!");
        puntuacio.setFont(Font.font ("Anson", FontWeight.BOLD, 15));
        puntuacio.setFill(Color.WHITESMOKE);
    }
}
