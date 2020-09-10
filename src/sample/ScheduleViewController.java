package sample;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleViewController  implements Initializable {

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXComboBox<?> studentChoice;

    @FXML
    private JFXComboBox<?> typeChoice;

    @FXML
    private JFXComboBox<?> teacherChoice;

    @FXML
    private JFXComboBox<?> optionsChoice;

    @FXML
    private JFXButton addAppointment;

    @FXML
    private JFXButton deleteAppointment;

    @FXML
    private VBox drawer;

    @FXML
    private JFXButton menuButton;

    @FXML
    private ImageView image;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawerAction();

//        //Image Load
//        Image fusionLogo = new Image("src/sample/FusionLogoFullReverse.png");
//        image.setImage(fusionLogo);
//        image.setCache(true);
    }
    private void drawerAction() {

        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        menuButton.setOnAction((ActionEvent evt) -> {
            if (drawer.getTranslateX() != 0) {
                openNav.play();
            } else {
                closeNav.setToX(-(drawer.getWidth()));
                closeNav.play();
            }
        });
    }


}
