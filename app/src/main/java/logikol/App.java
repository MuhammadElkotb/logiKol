package logikol;

import javax.tools.Tool;

import Controllers.GateCreator;
import Controllers.GateMounter;
import Controllers.IOConnectionsController;
import Controllers.InputHandler;
import Controllers.LogicalGraph;
import Controllers.Runner;
import Controllers.ToolsPaneController;
import Providers.GateProvider;
import Providers.TextureProvider;
import Providers.UIGateProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    int width = 1280;
    int height = 720;

    @Override
    public void start(Stage stage) {
        try
        {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/logiKol.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, width, height);

            scene.setFill(Color.WHITE);
            stage.setScene(scene);
            stage.setTitle("logiKol");
            stage.show();
            MainPane mainPane = new MainPane(scene, "MainPane");
            ToolsPane toolsPane = new ToolsPane(scene, "ToolsPane", "AnchorPane");
            LogicalGraph logicalGraph = new LogicalGraph();
            GateMounter gateMounter = GateMounter.getInstnace(InputHandler.getInstance(), IOConnectionsController.getInstance(mainPane.getLayout(), logicalGraph), logicalGraph);
            GateCreator gateCreator = new GateCreator(gateMounter, UIGateProvider.getInstnace(TextureProvider.getInstnace()), GateProvider.getInstnace());
            ToolsPaneController toolsPaneController = new ToolsPaneController(toolsPane, gateCreator, Runner.getInstance(logicalGraph));
            toolsPaneController.setupToolsPane(mainPane);
            


            

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
