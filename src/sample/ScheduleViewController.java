package sample;

import com.jfoenix.controls.*;
import com.jfoenix.svg.SVGGlyph;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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
    private VBox calendarArea;
    @FXML
    private VBox appointmentControl;

    @FXML
    private JFXButton menuButton;

    @FXML
    private ImageView image;

    @FXML
    private ImageView arrowGlyph;


    // TABLE COLUMNS
    @FXML
    private Pane sundayColumn;
    @FXML
    private Pane mondayColumn;
    @FXML
    private Pane tuesdayColumn;
    @FXML
    private Pane wednesdayColumn;
    @FXML
    private Pane thursdayColumn;
    @FXML
    private Pane fridayColumn;
    @FXML
    private Pane saturdayColumn;

    //Controls
    @FXML
    private Pane classSession;
    @FXML
    private Pane masterySession;
    @FXML
    private Pane tutoringSession;
    @FXML
    private Pane unpaidEvent;
    @FXML
    private Pane planningTime;
    @FXML
    private Pane discretionaryTime;

    @FXML
    private JFXButton classSessionButton;
    @FXML
    private JFXButton masterySessionButton;
    @FXML
    private JFXButton tutoringSessionButton;
    @FXML
    private JFXButton unpaidEventButton;
    @FXML
    private JFXButton planningTimeButton;
    @FXML
    private JFXButton discretionaryTimeButton;



    // TABLE COLUMN LISTS
    @FXML
    private final ObservableList<Appointment> sundayList = FXCollections.observableArrayList();
    @FXML
    private final ObservableList<Appointment> mondayList = FXCollections.observableArrayList();
    @FXML
    private final ObservableList<Appointment> tuesdayList = FXCollections.observableArrayList();
    @FXML
    private final ObservableList<Appointment> wednesdayList = FXCollections.observableArrayList();
    @FXML
    private final ObservableList<Appointment> thursdayList = FXCollections.observableArrayList();
    @FXML
    private final ObservableList<Appointment> fridayList = FXCollections.observableArrayList();
    @FXML
    private final ObservableList<Appointment> saturdayList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawerAction();
        appointmentAction();
        appointmentAnimations();
        appointmentControl.setTranslateX(384);




        // TEST OBJECT
        String student = "Thomas Arrington";
        String courseTitle = "Music Elective 1";
        String teacher = "Joshua Pare";
        Integer currentSession = 7;
        Integer totalSession = 25;
        Integer DayOfWeek = 5;
        Integer duration = 60;

        // Get Time Zone and start time to minutes
        ZoneId z = ZoneId.systemDefault();
        long minutesIntoTheDay = ChronoUnit.MINUTES.between(
                ZonedDateTime.now().toLocalDate().atStartOfDay( z ) ,
                ZonedDateTime.now()
        );

        Pane a = new Pane();
        a.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        a.setPrefHeight(duration);
        a.getStyleClass().add("appointmentObject");
        a.setLayoutY(minutesIntoTheDay);

        // Text Flow
        TextFlow app = new TextFlow();
        app.setTextAlignment(TextAlignment.LEFT);
        DropShadow dropShadow = new DropShadow(10, Color.WHITE);

        Text mainline = new Text(student + "\n");
        Font main = new Font(15);
        main = Font.font("Roboto Thin", FontWeight.BOLD, 12);
        mainline.setFont(main);
        mainline.setEffect(dropShadow);


        Text undertext = new Text(courseTitle + "\n" + teacher + "\n" + currentSession + "/" + totalSession);
        Font under = new Font(11);
        under = Font.font("Roboto Thin", FontWeight.EXTRA_LIGHT, 9);
        undertext.setFont(under);
        undertext.setEffect(dropShadow);

        app.getChildren().addAll(mainline, undertext);
        app.setPadding(new Insets(5, 0, 0, 7));

        // ADD TO PANE
        a.getChildren().add(app);

        // ASSIGN TO COLUMN
        switch (DayOfWeek){
            case 1: sundayColumn.getChildren().add(a);
                    a.prefWidthProperty().bind(sundayColumn.widthProperty());
                    break;
            case 2: mondayColumn.getChildren().add(a);
                    a.prefWidthProperty().bind(mondayColumn.widthProperty());
                    break;
            case 3: tuesdayColumn.getChildren().add(a);
                    a.prefWidthProperty().bind(tuesdayColumn.widthProperty());
                    break;
            case 4: wednesdayColumn.getChildren().add(a);
                    a.prefWidthProperty().bind(wednesdayColumn.widthProperty());
                    break;
            case 5: thursdayColumn.getChildren().add(a);
                    a.prefWidthProperty().bind(thursdayColumn.widthProperty());
                    break;
            case 6: fridayColumn.getChildren().add(a);
                    a.prefWidthProperty().bind(fridayColumn.widthProperty());
                    break;
            case 7: saturdayColumn.getChildren().add(a);
                    a.prefWidthProperty().bind(saturdayColumn.widthProperty());
                    break;
        }

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

    private void appointmentAction(){

        TranslateTransition closeApp = new TranslateTransition(new Duration(100), appointmentControl);
        closeApp.setToX(0);
        TranslateTransition openApp = new TranslateTransition(new Duration(100), appointmentControl);
        addAppointment.setOnAction((ActionEvent evt) -> {
            if (appointmentControl.getTranslateX() != 0) {
                closeApp.play();

            } else {
                openApp.setToX(appointmentControl.getWidth());
                openApp.play();

                // Bring everything Back - DOESN'T CURRENTLY WORK
                classSession.setTranslateY(0);
                masterySession.setTranslateY(0);
                tutoringSession.setTranslateY(0);
                unpaidEvent.setTranslateY(0);
                planningTime.setTranslateY(0);
                discretionaryTime.setTranslateY(0);
            }
        });

    }

    private void appointmentAnimations(){
        TranslateTransition closeClassC = new TranslateTransition(new Duration(100), classSession);
        TranslateTransition closeClassM = new TranslateTransition(new Duration(100), masterySession);
        TranslateTransition closeClassT = new TranslateTransition(new Duration(100), tutoringSession);
        TranslateTransition closeClassU = new TranslateTransition(new Duration(100), unpaidEvent);
        TranslateTransition closeClassP = new TranslateTransition(new Duration(100), planningTime);
        TranslateTransition closeClassD = new TranslateTransition(new Duration(100), discretionaryTime);
        closeClassC.setToX(0);
        closeClassM.setToX(0);
        closeClassT.setToX(0);
        closeClassU.setToX(0);
        closeClassP.setToX(0);
        closeClassD.setToX(0);
        TranslateTransition openClassC = new TranslateTransition(new Duration(100), classSession);
        TranslateTransition openClassM = new TranslateTransition(new Duration(100), masterySession);
        TranslateTransition openClassT = new TranslateTransition(new Duration(100), tutoringSession);
        TranslateTransition openClassU = new TranslateTransition(new Duration(100), unpaidEvent);
        TranslateTransition openClassP = new TranslateTransition(new Duration(100), planningTime);
        TranslateTransition openClassD = new TranslateTransition(new Duration(100), discretionaryTime);


        classSessionButton.setOnAction((ActionEvent evt) -> {
            if (masterySession.getTranslateX() != 0) {
                closeClassM.play();
                closeClassT.play();
                closeClassU.play();
                closeClassP.play();
                closeClassD.play();
            } else {
                double width = masterySession.getWidth();
                openClassM.setToX(width);
                openClassT.setToX(width);
                openClassU.setToX(width);
                openClassP.setToX(width);
                openClassD.setToX(width);
                openClassM.play();
                openClassT.play();
                openClassU.play();
                openClassP.play();
                openClassD.play();

            }
        });

        masterySessionButton.setOnAction((ActionEvent evt) -> {
            if (classSession.getTranslateX() != 0) {
                closeClassC.play();
                closeClassT.play();
                closeClassU.play();
                closeClassP.play();
                closeClassD.play();
            } else {
                double width = classSession.getWidth();
                openClassC.setToX(width);
                openClassT.setToX(width);
                openClassU.setToX(width);
                openClassP.setToX(width);
                openClassD.setToX(width);
                openClassC.play();
                openClassT.play();
                openClassU.play();
                openClassP.play();
                openClassD.play();

            }
        });

    }



}
