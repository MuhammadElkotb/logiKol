
package logikol;


import javax.sound.midi.Soundbank;

import Controllers.IOConnectionsController;
import Controllers.InputHandler;
import Controllers.LogicalGraph;
import Controllers.UIController;
import Gates.BasicGate;
import Providers.GateProvider;
import Providers.TextureProvider;
import Providers.UIGateProvider;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    int width = 1280;
    int height = 720;

    @Override
    public void start(Stage stage) {


        try
        {
            BorderPane borderPane = new BorderPane();

            Pane pane = new Pane();
           // pane.getChildren().add(root);

            borderPane.setCenter(pane);

            VBox vBox = new VBox(8);

            vBox.setPrefWidth(300);
           // pane.setPrefSize(300, 300);

            vBox.setBorder(Border.stroke(Color.BLACK));
            pane.setBorder(Border.stroke(Color.RED));

            Button andBtn = new Button("AND");
            Button orBtn = new Button("OR");
            Button notBtn = new Button("NOT");
            Button buffBtn = new Button("Buffer");
            Button inBtn = new Button("in");
            Button runBtn = new Button("RUN");
            
            vBox.getChildren().addAll(andBtn, orBtn, notBtn, buffBtn, inBtn, runBtn);
            borderPane.setLeft(vBox);


            TextureProvider textureProvider = TextureProvider.getInstnace();
            UIGateProvider uiGateProvider = UIGateProvider.getInstnace(textureProvider);
            GateProvider gateProvider = GateProvider.getInstnace();
            InputHandler inputHandler = InputHandler.getInstance();
            LogicalGraph logicalGraph = new LogicalGraph();
            IOConnectionsController ioConnectionsController = IOConnectionsController.getInstance(pane, logicalGraph);
            UIController uiController = UIController.getInstnace(inputHandler, ioConnectionsController, logicalGraph);


            andBtn.setOnMouseClicked(e -> {
                try 
                {
                    uiController.mountBasicMultiInGateUI(pane, uiGateProvider.buildGate("And"), gateProvider.buildGate("AND"), 150, 100);

                }
                catch(Exception exception)
                {   
                    System.out.println(exception.getMessage());
                }
            });

            orBtn.setOnMouseClicked(e -> {
                try 
                {
                    uiController.mountBasicMultiInGateUI(pane, uiGateProvider.buildGate("or"), gateProvider.buildGate("OR"), 200, 100);

                }
                catch(Exception exception)
                {   
                    System.out.println(exception.getMessage());
                }
            });

            notBtn.setOnMouseClicked(e -> {
                try 
                {
                    uiController.mountBasicSingleInGateUI(pane, uiGateProvider.buildGate("not"), gateProvider.buildGate("NOT"), 200, 300);

                }
                catch(Exception exception)
                {   
                    System.out.println(exception.getMessage());
                }
            });

            buffBtn.setOnMouseClicked(e -> {
                try 
                {
                    uiController.mountBufferNode(pane, uiGateProvider.buildGate("io"), gateProvider.buildGate("io"), 200, 520);

                }
                catch(Exception exception)
                {   
                    System.out.println(exception.getMessage());
                }
            });


            inBtn.setOnMouseClicked(e -> {
                try 
                {
                    uiController.mountInNode(pane, uiGateProvider.buildGate("in"), gateProvider.buildGate("in"), 200, 600);

                }
                catch(Exception exception)
                {   
                    System.out.println(exception.getMessage());
                }
            });

            runBtn.setOnMouseClicked(e -> {
                for(BasicGate gate : logicalGraph.getBufferNodes())
                {
                    boolean value = gate.process();

                    if(value)
                    {
                        logicalGraph.getGraph().getBackward(gate).getOutNode().node.setFill(Color.GREEN);
                    }
                    else
                    {
                        logicalGraph.getGraph().getBackward(gate).getOutNode().node.setFill(Color.RED);
                    }
                }
            });

            /*ImageView texture = textureProvider.getANDGateTexture();

           
            texture.setX(200);
            texture.setY(200);

            pane.getChildren().add(texture);

            texture.setOnMouseDragged(e -> {

                System.out.println(pane.getLayoutX());

                if(pane.contains(e.getX(), e.getY()))
                {
                    texture.setX(e.getX() - 30);
                    texture.setY(e.getY());
                }
                else
                {
                    System.out.println("false");

                }
            });*/

            Scene scene = new Scene(borderPane, width, height);
            scene.setFill(Color.WHITE);
            stage.setScene(scene);
            stage.show();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
      
        
    }

    public static void main(String[] args) {
        launch();
    }
}
