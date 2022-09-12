package logikol;

import Controllers.GateCreator;
import Controllers.GateDeleter;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    int width = 1600;
    int height = 900;

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

            Runner runner = new Runner(logicalGraph);

            logicalGraph.setRunner(runner);


            IOConnectionsController ioConnectionsController = new IOConnectionsController(mainPane.getLayout(), logicalGraph, runner);

            GateDeleter gateDeleter = new GateDeleter(logicalGraph, ioConnectionsController, runner);

            InputHandler inputHandler = new InputHandler(mainPane.getLayout(), gateDeleter);

            ioConnectionsController.setInputHandler(inputHandler);

            GateMounter gateMounter = new GateMounter(inputHandler, ioConnectionsController, logicalGraph);
           
            GateCreator gateCreator = new GateCreator(gateMounter, UIGateProvider.getInstnace(TextureProvider.getInstnace()), GateProvider.getInstnace());
           
            ToolsPaneController toolsPaneController = new ToolsPaneController(toolsPane, gateCreator, runner);
            toolsPaneController.setupToolsPane(mainPane);
            

            MenuBar menu = (MenuBar)scene.lookup("#MENU");
            menu.getMenus().clear();
            Menu file = new Menu("File");
            MenuItem save = new MenuItem("Save");
            file.getItems().add(save);
            menu.getMenus().add(file);
            

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
