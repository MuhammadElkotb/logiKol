package UIObjects;

import javafx.scene.Group;

public abstract class MoveAbleUI implements UIObject{

    Group root;
    public MoveAbleUI(Group root)
    {
        this.root = root;
    }
    public abstract void move(double x, double y);

    public Group getRoot()
    {
        return this.root;
    }
   
}
