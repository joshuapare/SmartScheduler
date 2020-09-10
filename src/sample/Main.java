package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage stage;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ScheduleView.fxml"));

        Scene scene = new Scene(root);
        this.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    static Stage getStage() {
        return stage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}