module com.nhnacademy.excercise3_8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nhnacademy.excercise3_8 to javafx.fxml;
    exports com.nhnacademy.excercise3_8;
}