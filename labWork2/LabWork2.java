/**
 * @Author: Mohammed Bekhouche
 * @date: 11/14/2019
 * @Version: 1.0;
 * 
 * Description: a GUI application that calculates a bill. developed by using 
 * javaFX library.
 */
package labwork2;

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
public class LabWork2 extends Application {

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

        Label lbl3 = new Label("Split");
        grid.add(lbl3, 0, 3);

        TextField split = new TextField();
        grid.add(split, 1, 3);

        // create the buttons
        Button calculate = new Button("Calculate");
        Button clear = new Button("Clear");
        Button exit = new Button("Exit");
        HBox hbox = new HBox(8);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(calculate, clear, exit);
        grid.add(hbox, 1, 5);

        final Text exception = new Text();
        grid.add(exception, 1, 7);
        Text result = new Text();
        grid.add(result, 1, 7);
        // create the event handlers
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                double theBill, tax, sp, splitAmount = 0, finalAmount;
                exception.setText("");
                result.setText("");
                try{
                theBill = Double.parseDouble(bill.getText());
                tax = Double.parseDouble(salesTax.getText());
                sp = Double.parseDouble(split.getText());
                
                finalAmount = theBill + tax;
                if (sp != 0) {
                    splitAmount = finalAmount / sp;
                    result.setText("Your final amount " + finalAmount + " "
                            + "and split " + sp + " ways is: "
                            + splitAmount);
                } else {
                    exception.setFill(Color.FIREBRICK);
                    exception.setText("division by zero is undefined. "
                            + "try again with diffrent value");
                }
                }catch(NumberFormatException ex){
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
                split.setText("");
                result.setText("");
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
