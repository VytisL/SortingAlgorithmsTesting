module com.example.sortingalgorithmtesting {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sortingalgorithmtesting to javafx.fxml;
    exports com.example.sortingalgorithmtesting;
}