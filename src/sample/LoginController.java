package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private void handleChangeScene() {

        Parent main = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScheduleView.fxml"));
            main = loader.load();
            Scene scene = new Scene(main);

            Stage stage = Main.getStage();
            stage.setScene(scene);

//            // Pass User Object to Controller
//            CalendarController controller = loader.getController();
//            controller.initUser(currentUser);

            // Show scene
            stage.show();

        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
