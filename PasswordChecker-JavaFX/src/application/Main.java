package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	private GridPane grid;
	
	private Text scenetitle;
	private Text actionBtnPressed;
	
	private Label pwLabel;
	
	private PasswordField pwField;
	
	private HBox hbPwBtn;
	private Button pwBtn;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Password Checker");
			
			//create and setup grid layout
			grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			
			//create and setup grid children
			scenetitle = new Text("Password Checker");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
			pwLabel = new Label("Password:");
		
			pwField = new PasswordField();
		
			pwBtn = new Button("check");
			
			hbPwBtn = new HBox(10);
			hbPwBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbPwBtn.getChildren().add(pwBtn);
			
			//Button actions
			actionBtnPressed = new Text();
			
			try {
				pwBtn.setOnAction(new EventHandler<ActionEvent>() {
		        	 
		            @Override
		            public void handle(ActionEvent e) {
		            	buttonPressed(pwField.getText());
		            }
		        });				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
        
	        //position grid children
	        grid.add(scenetitle, 0, 0, 2, 1);
	        grid.add(pwLabel, 0, 2);
			grid.add(pwField, 1, 2);
			grid.add(hbPwBtn, 1, 4);
			grid.add(actionBtnPressed, 1, 6);
	        
			//create new scene
			//grid pane as root node
			Scene scene = new Scene(grid,325,300);
			primaryStage.setScene(scene);
			
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void buttonPressed(String txt) {
		//create password checker
		PasswordChecker pwc = new PasswordChecker();

		if(pwc.checkPassword(txt)) {
			//pw valid
			actionBtnPressed.setFill(Color.GREEN);
			actionBtnPressed.setText("Your password is valid.");
		} else {
			//pw not valid
			actionBtnPressed.setFill(Color.FIREBRICK);
			actionBtnPressed.setText("Your password is not valid.");
		}
		
	}
}
