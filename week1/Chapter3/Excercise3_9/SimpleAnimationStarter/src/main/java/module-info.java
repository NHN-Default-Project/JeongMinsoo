module com.nhnacademy.simpleanimationstarter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nhnacademy.simpleanimationstarter to javafx.fxml;
    exports com.nhnacademy.simpleanimationstarter;
}