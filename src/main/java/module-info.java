module com.netcracker.ballmovement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.netcracker.ballmovement to javafx.fxml;
    exports com.netcracker.ballmovement;
}