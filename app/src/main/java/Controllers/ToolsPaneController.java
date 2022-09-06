package Controllers;
import Providers.TextureProvider;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import logikol.MainPane;
import logikol.ToolsPane;

public class ToolsPaneController {

    private ToolsPane toolsPane;
    private GateCreator gateCreator;
    private ImageView tempTexture = null;
    private Runner runner = null;

    public ToolsPaneController(ToolsPane toolsPane, GateCreator gateCreator, Runner runner)
    {
        this.toolsPane = toolsPane;
        this.gateCreator = gateCreator;
        this.runner = runner;
    }

    public void setupToolsPane(MainPane mainPane)
    {

        Pane root = mainPane.getLayout();


        EventHandler<MouseEvent> dragEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                if(tempTexture == null)
                {
                    try 
                    {
                        tempTexture = new ImageView(((ImageView)e.getSource()).getImage());
                    }
                    catch(Exception error)
                    {
                        System.out.println(error.getMessage());
                    }
                    root.getChildren().add(tempTexture);
                }

                tempTexture.setX(e.getSceneX() - toolsPane.getLayoutWidth());
                tempTexture.setY(e.getSceneY());
            }

        };

        EventHandler<MouseEvent> releaseEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e)
            {
                final ImageView tempView = (ImageView)e.getSource();
                final String id = tempView.getId();
                root.getChildren().remove(tempTexture);
                tempTexture = null;
                final double x = e.getX() - toolsPane.getLayoutWidth();
                if(x > 0)
                {
                    gateCreator.createGate(id, root, x, e.getSceneY());
                }
               
            }
        };

    

        for(Node node : toolsPane.getToolsNodes().values())
        {
            if(node.getId().startsWith("g-"))
            {
                node.setOnMouseDragged(dragEventHandler);
                node.setOnMouseReleased(releaseEventHandler);
            }
            if(node.getId().equals("RUN"))
            {
                System.out.println("runrunrunrunrun");
                node.setOnMouseClicked(e -> {
                    this.runner.run();
                });
            }
            
        }

    }

    
}
