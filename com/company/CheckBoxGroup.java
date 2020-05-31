package com.company;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CheckBoxGroup implements ComponentLinker{

    private HBox hBox;

    private void showAlertNotExist() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("This option does not exist!");

        alert.showAndWait();
    }

    @Override
    public void link() {
        hBox = new HBox();

        TextField nameField = new TextField();
        nameField.setPrefColumnCount(11);

        ArrayList<String> optionList = new ArrayList<>();
        CheckBox option1 = new CheckBox("Option 1");
        optionList.add(option1.getText());

        CheckBox option2 = new CheckBox("Option 2");
        optionList.add(option2.getText());

        CheckBox option3 = new CheckBox("Option 3");
        optionList.add(option3.getText());

        Button chooseButton = new Button("Choose");
        chooseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String tmp = nameField.getText();
                if(!optionList.contains(tmp)){
                    showAlertNotExist();
                    return;
                }
                if(optionList.indexOf(tmp) == 0){
                    option1.fire();
                }
                if(optionList.indexOf(tmp) == 1){
                    option2.fire();
                }
                if(optionList.indexOf(tmp) == 2){
                    option3.fire();
                }
            }
        });

        hBox.setPadding(new Insets(15, 20, 20, 12));
        hBox.getChildren().addAll(nameField, option1, option2, option3, chooseButton);
        hBox.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.setSpacing(10);
    }

    @Override
    public HBox component() {
        return this.hBox;
    }
}
