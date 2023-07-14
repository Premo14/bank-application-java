import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private BankApplication bankApplication; // Declare a BankApplication instance
    private Account loggedInAccount; // Keep track of the logged-in account

    @Override
    public void start(Stage primaryStage) {
        bankApplication = new BankApplication(); // Create a BankApplication instance

        // Create a label to display messages
        Label messageLabel = new Label("Welcome to the Bank Application!");

        primaryStage.setTitle("Bank Application");

        // Create buttons for different actions
        Button createAccountButton = new Button("Create Account");
        Button loginButton = new Button("Login");
        Button displayBalancesButton = new Button("Display Balances");
        Button displayAccountInfoButton = new Button("Display Account Info");

        // Create a vertical box layout
        VBox layout = new VBox(10); // spacing between elements
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(loginButton, createAccountButton);

        // Create the scene
        Scene scene = new Scene(layout, 990, 540);

        // Set the scene on the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void handleLoginButton() {
        System.out.println("Login button clicked!");
        // Handle login logic here
    }

    private void handleCreateAccountButton() {
        System.out.println("Create Account button clicked!");
        // Handle create account logic here
    }
}