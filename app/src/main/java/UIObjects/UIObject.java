package UIObjects;

import javafx.scene.Group;

public interface UIObject {

    public Group getRoot();
    public void setRoot(Group root);

    public double getHeight();
    public double getWidth();

    
}
