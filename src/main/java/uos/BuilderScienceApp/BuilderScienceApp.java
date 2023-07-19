package uos.BuilderScienceApp;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class BuilderScienceApp extends Application {
	GraphicsContext gc;
	FlowPane root;
	Scene scene;
	Pane ui, things;
	ComboBox myCombo;
	Label myLabel;
	CommandPattern commandPattern = new CommandPattern();
	Image img;
	
	
	
	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			//gc.strokeRect(event.getX(),event.getY(),3,3);
			GameObject d = new GameObject(gc,event.getX(),event.getY()); 
			commandPattern.addCommand(d);

			
		} };
		
	EventHandler<KeyEvent> keyboardHandler = new EventHandler<KeyEvent>() {

			@Override
		public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				
			if(event.getCode() == KeyCode.R) {
					commandPattern.redo();
				}
			if(event.getCode() == KeyCode.U) {
					commandPattern.undo();				
				}

				
			}};

	ChangeListener cbListener = new ChangeListener() {
		
	
		public void changed(ObservableValue observable, Object oldValue, Object newValue) {
			
			if(observable.getValue().equals("Wood")) {
				director.setBuilder(woodBuilder);
				director.constructProduct();
				wood=director.getProduct();
				myLabel.setText(wood.getInfo() + "\r\n" +  "\r\n" + "Heating up\r\n"
						+ "\r\n"
						
						+ "Melting - When a solid is heated, it absorbs energy and it melts, turning into a liquid.\r\n"
						+ "\r\n"
						+ "Cooling down\r\n"
						+ "\r\n"
						+ "Condensing - If a gas is cooled, it transfers energy to the surroundings, and turns into a liquid.\r\n"
						+ "Freezing - If the liquid is cooled, it transfers energy to the surroundings, and turns into a solid.\r\n"
						);
			}
				
			if(observable.getValue().equals("Water")) {
				director.setBuilder(waterBuilder);
				director.constructProduct();
				water=director.getProduct();
				myLabel.setText(water.getInfo()+ "\r\n" +  "\r\n" + "Heating up\r\n"
						+ "\r\n"
						+ "Boiling - If the liquid is heated, it absorbs more energy and it boils, turning into a gas.\r\n"
						+ "Evaporating is when a liquid turns into a gas slowly, at temperatures that are below its boiling point. Puddles dry up because they evaporate – they don’t boil.\r\n"
						+ "\r\n"
						+ "Cooling down\r\n"
						+ "\r\n"
						+ "Freezing - If the liquid is cooled, it transfers energy to the surroundings, and turns into a solid.\r\n"
						);;
			}
			
			if(observable.getValue().equals("Oxygen")) {
				director.setBuilder(oxygenBuilder);
				director.constructProduct();
				oxygen=director.getProduct();
				myLabel.setText(oxygen.getInfo()+ "\r\n" +  "\r\n" + "Heating up\r\n"
						+ "\r\n"
						
						+ "Melting - When a solid is heated, it absorbs energy and it melts, turning into a liquid.\r\n"
						+ "Boiling - If the liquid is heated, it absorbs more energy and it boils, turning into a gas.\r\n"
						+ "Evaporating is when a liquid turns into a gas slowly, at temperatures that are below its boiling point. Puddles dry up because they evaporate – they don’t boil.\r\n"
						+ "\r\n"
						+ "Cooling down\r\n"
						+ "\r\n"
						+ "Condensing - If a gas is cooled, it transfers energy to the surroundings, and turns into a liquid.\r\n"
						);;


			}
			
			if(observable.getValue().equals("Rock")) {
				director.setBuilder(rockBuilder);
				director.constructProduct();
				rock=director.getProduct();
				myLabel.setText(rock.getInfo() + "\r\n" +  "\r\n" + "Heating up\r\n"
						+ "\r\n"
						
						+ "Melting - When a solid is heated, it absorbs energy and it melts, turning into a liquid.\r\n"
						+ "\r\n"
						+ "Cooling down\r\n"
						+ "\r\n"
						+ "Condensing - If a gas is cooled, it transfers energy to the surroundings, and turns into a liquid.\r\n"
						+ "Freezing - If the liquid is cooled, it transfers energy to the surroundings, and turns into a solid.\r\n"
						);
			}
			if(observable.getValue().equals("Helium")) {
				director.setBuilder(heliumBuilder);
				director.constructProduct();
				helium=director.getProduct();
				myLabel.setText(helium.getInfo()+ "\r\n" +  "\r\n" + "Heating up\r\n"
						+ "\r\n"
						
						+ "Melting - When a solid is heated, it absorbs energy and it melts, turning into a liquid.\r\n"
						+ "Boiling - If the liquid is heated, it absorbs more energy and it boils, turning into a gas.\r\n"
						+ "Evaporating is when a liquid turns into a gas slowly, at temperatures that are below its boiling point. Puddles dry up because they evaporate – they don’t boil.\r\n"
						+ "\r\n"
						+ "Cooling down\r\n"
						+ "\r\n"
						+ "Condensing - If a gas is cooled, it transfers energy to the surroundings, and turns into a liquid.\r\n"
						);;


			}

			//myLabel.setText("You Chose: " + observable.getValue());
		}
		
	};
	Director director = new Director();
	Builder woodBuilder = new WoodBuilder();
	Builder waterBuilder = new WaterBuilder();
	Builder oxygenBuilder = new OxygenBuilder();
	Builder rockBuilder = new RockBuilder();
	Builder heliumBuilder = new HeliumBuilder();
	Product wood =  null;
	Product water =  null;
	Product oxygen =  null;
	Product rock = null;
	Product helium = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("Matter Game");
		root = new FlowPane();
		scene = new Scene(root,1000,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		


		Button button = new Button();
		button.setLayoutX(20);
		button.setLayoutY(660);
		
		
		button.setText("Draw Particle Diagram");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				

				StackPane secondaryLayout = new StackPane();
				Canvas canvas;
				Scene secondScene = new Scene(secondaryLayout, 800, 800);
				canvas = new Canvas(800,800);
				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Draw Here - U to Undo, R to Redo");
				newWindow.setScene(secondScene);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
				secondaryLayout.setFocusTraversable(true);
				secondaryLayout.getChildren().add(canvas);
				gc = canvas.getGraphicsContext2D();
				gc.setStroke(Color.BLACK);
				gc.setFill(Color.WHITE);
				gc.fillRect(0,0,800,800);
				gc.setLineWidth(5);
				gc.strokeRect(10, 10, 780, 780);
				secondaryLayout.requestFocus();
				
				
				secondaryLayout.setOnMouseDragged(mouseHandler);
				secondaryLayout.setOnKeyPressed(keyboardHandler);
			
					
			}
		});
		
			
		ui = new Pane();
		ui.setPrefSize(200, 800);
		ui.setStyle("-fx-background-color: #FF8B00");
		
		things = new Pane();
		things.setPrefSize(800, 800);
		things.setStyle("-fx-background-color: #CDCDCD");
		
		root.getChildren().addAll(ui,things);
		
		ObservableList<String> options = FXCollections.observableArrayList(
				"Wood",
				"Water",
				"Oxygen",
				"Rock",
				"Helium"
				);

		myCombo = new ComboBox(options);
		myCombo.setLayoutX(20);
		myCombo.setLayoutY(80);
		myCombo.setValue("Choose a Material");
		ui.getChildren().add(myCombo);
		
		myLabel = new Label("Material Will Be Shown Here");
		myLabel.setFont(Font.font("Cambria", 22));
		myLabel.setWrapText(true);
		myLabel.setTextAlignment(TextAlignment.JUSTIFY);
		myLabel.setMaxWidth(760);
		myLabel.setLayoutX(20);
		myLabel.setLayoutY(20);
		things.getChildren().add(myLabel);
		things.getChildren().add(button);
		
		Label myLabel2 = new Label("Click the button and try draw the particle diagram for this material!");
		myLabel2.setFont(Font.font("Cambria", 22));
		myLabel2.setLayoutX(20);
		myLabel2.setLayoutY(580);
		things.getChildren().add(myLabel2);
		
	
		

		
		

		
		myCombo.getSelectionModel().selectedItemProperty().addListener(cbListener);
		
		
		

	}

}
