/**
 * @author : Mohammed Bekhouche
 * @since :12/1/2019
 * @version :1.0
 *
 * Description: Tax calculator asks the user to provide income and status in order 
 * to calculate the total tax amount. The application does that through four steps
 * first one is to collect tax rates from two files and store them in arrays. then
 * the application call the method findRange to locate the category of the income
 * provided by the user. After finding the category the application call the method 
 * calcTax which does the calculations finally the result is displayed. 
 */
package assignment4;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.scene.Scene;
import javafx.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;

public class Assignment4 extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        final int elements = 15;
        DecimalFormat decimal = new DecimalFormat("#.##");

        // initialize arrays that will handle federal tax data
        double[] rates = new double[elements];
        double[] individIncomes = new double[elements];
        double[] marriedIncomes = new double[elements];
        double[] householdHeads = new double[elements];
        // initialize arrays that will handle state tax data
        double[] stateRates = new double[elements];
        double[] stateIndividual = new double[elements];
        double[] stateMarried = new double[elements];
        double[] stateHouseH = new double[elements];

        //create the grid layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //create the components of the application 
        Text title = new Text();
        title.setText("Income Tax Calculator");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        grid.add(title, 0, 0);
        
        Label label1 = new Label("Income");
        grid.add(label1, 0, 1);
        TextField income = new TextField();
        grid.add(income, 1, 1);
        
        Label label2 = new Label("Filling as");
        grid.add(label2, 2, 1);
        ChoiceBox<String> status = new ChoiceBox();
        status.getItems().addAll("Unmarried", "Married", "Head of household");
        grid.add(status, 3, 1);
        
        Button calculate = new Button("calculate");
        grid.add(calculate, 4, 1);
        
        Label label3 = new Label("Federal Tax Rate");
        grid.add(label3, 0, 2);
        Text fTaxRate = new Text();
        grid.add(fTaxRate, 1, 2);
        
        Label label4 = new Label("Federal Tax Amount");
        grid.add(label4, 2, 2);
        Text fTaxAmount = new Text();
        grid.add(fTaxAmount, 3, 2);
        
        Label label5 = new Label("State Tax Rate");
        grid.add(label5, 0, 3);
        Text sTaxRate = new Text();
        grid.add(sTaxRate, 1, 3);
        
        Label label6 = new Label("Satet Tax Amount");
        grid.add(label6, 2, 3);
        Text sTaxAmount = new Text();
        grid.add(sTaxAmount, 3, 3);
        
        Label label7 = new Label("Total Income Tax");
        grid.add(label7, 2, 4);
        Text totalIncomeTax = new Text();
        grid.add(totalIncomeTax, 3, 4);
        
        Text exception = new Text();
        grid.add(exception, 1, 5);
        
        try { // handle the exception of a missing file
            int size1, size2;
            Scanner federalSc = new Scanner(new File("Tax Brackets and Rates.txt"));
            Scanner stateSc = new Scanner(new File("NYS Tax.txt"));
            
            size1 = getData(rates, individIncomes, marriedIncomes, householdHeads,
                    federalSc);
            size2 = getData(stateRates, stateIndividual, stateMarried, stateHouseH,
                    stateSc);
            calculate.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    double salary, stateTax, federalTax;
                    int federalRange, stateRange;
                    try { // handle the exception of not selecting type of status 
                        String str = status.getValue();
                        
                        try { // handle the exception of wrong inputs
                            salary = Double.parseDouble(income.getText());
                            if (salary >= 0) { // process positive data only
                                
                                if (str.equalsIgnoreCase("unmarried")) {
                                    federalRange = findRange(salary, individIncomes, size1);
                                    fTaxRate.setText(Double.toString(rates[federalRange]));
                                    federalTax = calcTax(salary, individIncomes, rates, federalRange);
                                    fTaxAmount.setText(decimal.format(federalTax));
                                    
                                    stateRange = findRange(salary, stateIndividual, size2);
                                    sTaxRate.setText(Double.toString(stateRates[stateRange]));
                                    stateTax = calcTax(salary, stateIndividual, stateRates, stateRange);
                                    sTaxAmount.setText(decimal.format(stateTax));
                                    totalIncomeTax.setText(decimal.format(stateTax + federalTax));
                                    
                                } else if (str.equalsIgnoreCase("married")) {
                                    federalRange = findRange(salary, marriedIncomes, size1);
                                    fTaxRate.setText(Double.toString(rates[federalRange]));
                                    federalTax = calcTax(salary, marriedIncomes, rates, federalRange);
                                    fTaxAmount.setText(decimal.format(federalTax));
                                    stateRange = findRange(salary, stateMarried, size2);
                                    sTaxRate.setText(Double.toString(stateRates[stateRange]));
                                    stateTax = calcTax(salary, stateMarried, stateRates, stateRange);
                                    sTaxAmount.setText(decimal.format(stateTax));
                                    totalIncomeTax.setText(decimal.format(stateTax + federalTax));
                                } else {
                                    federalRange = findRange(salary, householdHeads, size1);
                                    fTaxRate.setText(Double.toString(rates[federalRange]));
                                    federalTax = calcTax(salary, householdHeads, rates, federalRange);
                                    fTaxAmount.setText(decimal.format(federalTax));
                                    stateRange = findRange(salary, stateHouseH, size2);
                                    sTaxRate.setText(Double.toString(stateRates[stateRange]));
                                    stateTax = calcTax(salary, stateHouseH, stateRates, stateRange);
                                    sTaxAmount.setText(decimal.format(stateTax));
                                    totalIncomeTax.setText(decimal.format(stateTax + federalTax));
                                }
                            } else {
                                exception.setFill(Color.FIREBRICK);
                                exception.setText("Please enter a positive number");
                            }
                        } catch (NumberFormatException ex) {
                            exception.setFill(Color.FIREBRICK);
                            exception.setText("Please enter your correct income");
                        }
                    } catch (NullPointerException ex) {
                        exception.setFill(Color.FIREBRICK);
                        exception.setText("Please provide your status");
                    }
                }
            });
        } catch (FileNotFoundException ex) {
            exception.setFill(Color.FIREBRICK);
            exception.setText("I have no reference data to do calculations");
        }
        
        primaryStage.setTitle("Income Tax Calculator");
        primaryStage.setScene(new Scene(grid, 750, 200));
        primaryStage.show();
    }

    // populate data to the arrays
    public int getData(double[] r, double[] individuals, double[] married,
            double[] householdHeads, Scanner sc) {
        
        int count = 0;
        while (sc.hasNext()) {
            r[count] = sc.nextDouble();
            individuals[count] = sc.nextDouble();
            married[count] = sc.nextDouble();
            householdHeads[count] = sc.nextDouble();
            count++;
        }
        return count;
    }

    /* The method tax calculates tax*/
    public double calcTax(double salary, double[] salaries, double[] rates, int index) {
        double tax = 0;
        while (index >= 0) {
            tax = tax + ((salary - salaries[index]) * rates[index]);
            salary = salaries[index];
            index = index - 1;
        }
        return tax;
    }

    /* the method findRange locate the category of the provided income*/
    public int findRange(double income, double[] incomes, int size) {
        int i = 0;
        while (i < size) {
            if (income <= incomes[i]) {
                return i - 1;
            } else {
                i = i + 1;
            }
        }
        return size - 1;
    }
}
