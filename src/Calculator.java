import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.border.EmptyBorder;

public class Calculator  extends Application {
    private TextField textField;
    Button[] numbers = new Button[10];
    Button[] functions = new Button[8];
    Button add, sub, mul, div;
    Button dec, eq, del, clr;
    Pane pane;

    Font myFont = new Font("Arial", 30);
    double total = 0, current = 0;
    char operator;

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TextField is initialised and the size is set
        textField = new TextField();
        textField.setLayoutX(30);
        textField.setLayoutY(25);
        textField.setMaxWidth(360);
        textField.setMinSize(360, 50);
        textField.setMaxHeight(50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //Pane is instantiated
        pane = new Pane();
        pane.setMinSize(420, 600);
        pane.setMaxSize(420, 600);
        pane.getChildren().add(textField);
        pane.setVisible(true);


        //Scene is instantiated
        Scene scene = new Scene(pane);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");
        clr = new Button("A/C");
        del = new Button("DEL");
        dec = new Button(".");
        eq = new Button("=");

        functions[0] = add;
        functions[0].setOnAction(e -> {
            total = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        });
        functions[1] = sub;
        functions[1].setOnAction(e -> {
            total = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        });
        functions[2] = mul;
        functions[2].setOnAction(e -> {
            total = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        });
        functions[3] = div;
        functions[3].setOnAction(e -> {
            total = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        });
        functions[4] = dec;
        functions[4].setOnAction(e -> {
            textField.setText(textField.getText().concat("."));
        });
        functions[5] = eq;
        functions[5].setOnAction(e -> {
            current = Double.parseDouble(textField.getText());
            switch(operator) {
                case '+' :
                    total += current;
                    break;
                case '-':
                    total -= current;
                    break;
                case '*':
                    total *= current;
                    break;
                case '/':
                    total /= current;
                    break;
            }
            textField.setText(String.valueOf(total));
        });
        functions[6] = del;
        functions[6].setOnAction(e -> {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
            current = current - (current % 10);
        });
        functions[7] = clr;
        functions[7].setOnAction(e -> {
            textField.setText("");
            total = 0;
            current = 0;
        });

        for(Button b : functions) {
            b.setFont(myFont);
            b.setFocusTraversable(false);
            b.setMaxSize(100, 50);
            b.setMinSize(100, 50);
            pane.getChildren().add(b);
        }

        for (int i = 0; i < 10; i++) {
            numbers[i] = new Button(String.valueOf(i));
            numbers[i].setFont(myFont);
            numbers[i].setFocusTraversable(false);
            numbers[i].setMaxSize(100, 50);
            numbers[i].setMinSize(100, 50);
            int index = i;
            numbers[i].setOnAction(e -> {
                textField.setText(textField.getText().concat(String.valueOf(index)));
            });
            pane.getChildren().add(numbers[i]);
        }

        //Setting the layout of all the buttons
        numbers[0].setLayoutX(30);
        numbers[0].setLayoutY(100);
        numbers[1].setLayoutX(160);
        numbers[1].setLayoutY(100);
        numbers[2].setLayoutX(290);
        numbers[2].setLayoutY(100);
        numbers[3].setLayoutX(30);
        numbers[3].setLayoutY(175);
        numbers[4].setLayoutX(160);
        numbers[4].setLayoutY(175);
        numbers[5].setLayoutX(290);
        numbers[5].setLayoutY(175);
        numbers[6].setLayoutX(30);
        numbers[6].setLayoutY(250);
        numbers[7].setLayoutX(160);
        numbers[7].setLayoutY(250);
        numbers[8].setLayoutX(290);
        numbers[8].setLayoutY(250);
        numbers[9].setLayoutX(30);
        numbers[9].setLayoutY(325);
        functions[0].setLayoutX(160);
        functions[0].setLayoutY(325);
        functions[1].setLayoutX(290);
        functions[1].setLayoutY(325);
        functions[2].setLayoutX(30);
        functions[2].setLayoutY(400);
        functions[3].setLayoutX(160);
        functions[3].setLayoutY(400);
        functions[4].setLayoutX(290);
        functions[4].setLayoutY(400);
        functions[5].setLayoutX(30);
        functions[5].setLayoutY(475);
        functions[6].setLayoutX(160);
        functions[6].setLayoutY(475);
        functions[7].setLayoutX(290);
        functions[7].setLayoutY(475);

        // The stage is updated and set
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(pane.getMaxHeight());
        primaryStage.setMaxWidth(pane.getMaxWidth());
        primaryStage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
