package logikol;


import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MainPane {


    public Pane pane;
    public MainPane(Scene scene, String paneId) 
    {
        this.pane = (Pane)scene.lookup("#".concat(paneId));
    }
    public Pane getLayout()
    {
        return this.pane;
    }


}
