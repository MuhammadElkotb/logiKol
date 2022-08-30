package UIObjects;

import javafx.scene.Parent;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class IONode extends MoveAbleUIObject{
    public Rectangle node;

    public IONode(Group root)
    {
        super(root);

        this.node = new Rectangle(8, 8);
        this.node.setFill(Color.BLUE);
        this.node.setStroke(Color.BLACK);

        this.node.setOnMouseDragged(e -> {
            Line line = new Line();

            line.setStartX(node.getX());
            line.setStartY(node.getY());

            line.setEndX(e.getSceneX());
            line.setEndY(e.getSceneY());

        });

        root.getChildren().add(this.node);
    }
    public void move(double x, double y)
    {
        this.node.setX(x);
        this.node.setY(y);
    } 

    public void setRoot(Group root)
    {
        this.root = root;
        this.root.getChildren().add(this.node);
    }

}
