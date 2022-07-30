/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SeverAppInitilaizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setScene(new Scene(FXMLLoader.load((getClass().getResource("views/SeverManagemant.fxml")))));
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Sever");
        //  primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }
}