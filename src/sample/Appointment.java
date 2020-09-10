package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Appointment {

    private String title;
    private LocalDateTime startTime;
    private ObservableList<Attendee> attendeesList = FXCollections.observableArrayList();
    


}
