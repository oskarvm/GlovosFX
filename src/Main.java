import control.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample/sample.fxml"));
        StackPane root = loader.load();

        //SCENE TO WORK
        Scene scene = new Scene(root);

        //Injectar Scene i Stage
        Controller controller = loader.getController();
        controller.setScene(scene);
        controller.setStage(primaryStage);

        //CSS
        // http://fxexperience.com/2011/12/styling-fx-buttons-with-css/
        scene.getStylesheets().add("css/samplecss.css");

        primaryStage.setTitle("Rebenta globus");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
