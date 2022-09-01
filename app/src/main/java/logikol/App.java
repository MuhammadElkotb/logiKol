
package logikol;


import Controllers.IOConnectionsController;
import Controllers.InputHandler;
import Controllers.UIController;
import Providers.TextureProvider;
import Providers.UIGateProvider;
import UIObjects.BasicGateUI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    int width = 1280;
    int height = 720;

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        TextureProvider textureProvider = TextureProvider.getInstnace();
        UIGateProvider uiGateProvider = UIGateProvider.getInstnace(textureProvider);
        InputHandler inputHandler = InputHandler.getInstance();
        IOConnectionsController ioConnectionsController = IOConnectionsController.getInstance(root);

        UIController uiController = UIController.getInstnace(inputHandler, ioConnectionsController);

        try
        {
            BasicGateUI andGate1 = uiGateProvider.buildGate("AND");
            BasicGateUI andGate2 = uiGateProvider.buildGate("AND");
            BasicGateUI orGate1 = uiGateProvider.buildGate("OR");
            BasicGateUI notGate = uiGateProvider.buildGate("NOT");
            BasicGateUI input1 = uiGateProvider.buildGate("io");
            BasicGateUI input2 = uiGateProvider.buildGate("io");
            BasicGateUI output = uiGateProvider.buildGate("io");


            System.out.println("after build");

            uiController.mountBasicMultiInGateUI(root, andGate1, 100, 100);
            uiController.mountBasicMultiInGateUI(root, andGate2, 300, 200);
            uiController.mountBasicMultiInGateUI(root, orGate1, 500, 500);
            uiController.mountBasicSingleInGateUI(root, notGate, 200, 200);
            uiController.mountBufferNode(root, input1, 60, 100);
            uiController.mountBufferNode(root, input2, 60, 160);
            uiController.mountBufferNode(root, output, 300, 50);


            // XOR connection 
            ioConnectionsController.connect(andGate1.getOutNode(), notGate.getInNodes()[0]);

            ioConnectionsController.connect(input1.getOutNode(), andGate1.getInNodes()[0]);
            ioConnectionsController.connect(input1.getOutNode(), orGate1.getInNodes()[0]);

            ioConnectionsController.connect(input2.getOutNode(), andGate1.getInNodes()[1]);
            ioConnectionsController.connect(input2.getOutNode(), orGate1.getInNodes()[1]);

            ioConnectionsController.connect(notGate.getOutNode(), andGate2.getInNodes()[0]);
            ioConnectionsController.connect(orGate1.getOutNode(), andGate2.getInNodes()[1]);

            ioConnectionsController.connect(andGate2.getOutNode(), output.getInNodes()[0]);



            System.out.println("after not");


        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       
      
        Scene scene = new Scene(root, width, height);
        scene.setFill(Color.WHITE);
        stage.setScene(scene);


        scene.setOnKeyPressed(e -> {


            if(e.getCode() == KeyCode.ESCAPE)
            {
                stage.close();
            }

        });        

        stage.setTitle("logiKol");

        scene.getStylesheets().add("style.css");
       
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
