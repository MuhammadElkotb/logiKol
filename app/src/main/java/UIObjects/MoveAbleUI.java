package UIObjects;


import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public abstract class MoveAbleUI implements UIObject{

    Pane root;
    public MoveAbleUI()
    {
    }
    public abstract void move(double x, double y);

    public Pane getRoot()
    {
        return this.root;
    }

    public abstract void setOnMouseDragged(EventHandler<MouseEvent> eventHandler);
    public abstract void setOnMouseReleased(EventHandler<MouseEvent> eventHandler);
    public abstract void setOnMouseClicked(EventHandler<MouseEvent> eventHandler);

   
}
