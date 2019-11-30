/**
 * @Author: Mohammed Bekhouche
 * @date: 11/14/2019
 * @Version: 1.0;
 *
 * Description: a GUI application that calculates a bill. developed by using
 * javaFX library.
 */
package labwork3;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.paint.Color;
import java.util.*;

/**
 *
 * @author Mo & Jenny
 */
public class LabWork3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Split Bill Calculator");
        // create the grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label lbl1 = new Label("Bill");
        grid.add(lbl1, 0, 1);
        TextField bill = new TextField();
        grid.add(bill, 1, 1);

        Label lbl2 = new Label("Sales Tax");
        grid.add(lbl2, 0, 2);
        TextField salesTax = new TextField();
        grid.add(salesTax, 1, 2);

        Label lbl3 = new Label("Tip percentage");
        grid.add(lbl3, 0, 3);
        ChoiceBox<String> tip = new ChoiceBox();
        tip.getItems().addAll("5%", "10%", "15%", "20%", "25%", "30%");
        grid.add(tip, 1, 3);

        Label lbl4 = new Label("Split");
        grid.add(lbl4, 0, 4);

        Spinner split = new Spinner(1, 10, 1, 1);
        grid.add(split, 1, 4);

        // create the buttons
        Button calculate = new Button("Calculate");
        Button clear = new Button("Clear");
        Button exit = new Button("Exit");
        HBox hbox = new HBox(8);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(calculate, clear, exit);
        grid.add(hbox, 1, 5);

        Label lbl5 = new Label("Total");
        grid.add(lbl5, 0, 6);
        TextField total = new TextField();
        grid.add(total, 1, 6);

        Label lbl6 = new Label("Ammount by person");
        grid.add(lbl6, 0, 7);
        TextField amountByPerson = new TextField();
        grid.add(amountByPerson, 1, 7);

        final Text exception = new Text();
        grid.add(exception, 1, 8);

        // create the event handlers
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double theBill, tax, splitAmount = 0, finalAmount,
                        tipChoice;
                try {
                    exception.setText("");
                    String str = tip.getValue();

                    theBill = Double.parseDouble(bill.getText());
                    tax = Double.parseDouble(salesTax.getText());

                    tipChoice = Double.parseDouble(str.substring(0, str.indexOf("%")));
                    tipChoice = (theBill + tax) * tipChoice / 100;

                    finalAmount = theBill + tax + tipChoice;
                    total.setText(Double.toString(finalAmount));
                    splitAmount
                            = finalAmount / Double.parseDouble(split.getValue().toString());
                    amountByPerson.setText(Double.toString(splitAmount));
                } catch (NumberFormatException ex) {
                    exception.setFill(Color.FIREBRICK);
                    exception.setText("Please enter numbers only");
                }

            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bill.setText("");
                salesTax.setText("");
                split.getValueFactory().setValue(1);
                total.setText("");
                amountByPerson.setText("");
                exception.setText("");
            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
