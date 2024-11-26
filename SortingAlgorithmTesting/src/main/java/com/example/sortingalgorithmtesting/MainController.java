package com.example.sortingalgorithmtesting;

import com.example.sortingalgorithmtesting.Utils.AlertMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainController {



    @FXML
    private ComboBox<String> AlgorithmComboBox;


    @FXML
    private TableView<String> DataTable;
    @FXML
    private TableColumn<String, String> UnsortedDataColumn;
    @FXML
    private TableColumn<String, String> SortedDataColumn;

    @FXML
    private TableView<String> AlgorithmTable;
    @FXML
    private TableColumn<String, String> AlgorithmColumn;
    @FXML
    private TableColumn<String, Double> TimeColumn;
    @FXML
    private TableColumn<String, Double> MemoryColumn;




    private final ObservableList<String> dataList = FXCollections.observableArrayList();
    @FXML
    private void initialize() {
        UnsortedDataColumn.setCellValueFactory();

    }
    @FXML
    protected void SelectFileHandler() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select data ");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text files", "*.csv"));
        File file = fileChooser.showOpenDialog(DataTable.getScene().getWindow());

        if(file!=null){
            dataList.clear();
            if(file.length() == 0){
                AlertMessage.showAlert(Alert.AlertType.WARNING, "Empty file", "WARNING", "Selected file is empty");
                return;
            }
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line;

                while((line = reader.readLine()) != null){
                    dataList.add(line);
                }

            }catch(Exception e){
                AlertMessage.showAlert(Alert.AlertType.ERROR, "Unable to read file", "ERROR", "Unable to read file");
                throw new RuntimeException(e);
            }
        }

        //Big string for UnsortedDataColumn to display, since it takes a String variable
        String megaString = "";
        for(int i = 0; i < dataList.size(); i++){
            megaString = megaString + " " + dataList.get(i);
        }
        UnsortedDataColumn.setCellValueFactory(megaString);
    }
    @FXML
    protected void ProgramHandler(){

    }
}