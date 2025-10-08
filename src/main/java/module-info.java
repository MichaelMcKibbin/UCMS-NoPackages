module com.michaelmckibbin.ucms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.michaelmckibbin.ucms to javafx.fxml;
    exports com.michaelmckibbin.ucms;
}