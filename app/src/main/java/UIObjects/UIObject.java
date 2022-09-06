package UIObjects;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public interface UIObject {

    public Pane getRoot();
    public void setRoot(Pane root);

    public double getHeight();
    public double getWidth();

    public double getX();
    public double getY();

    public Point2D getPosition();

    
}
