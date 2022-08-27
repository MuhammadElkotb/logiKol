package logikol;




import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

import javafx.scene.layout.Border;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ToolsPane {
    private Label label;
    private VBox toolsBox;
    
    public ToolsPane(String label)
    {
        this.label = new Label(label);
        this.label.setFont(new Font(30));
        this.toolsBox = new VBox(5);
        this.toolsBox.getChildren().add(this.label);
    }

    public void setWidth(double value)
    {
        this.toolsBox.setPrefWidth(value);
    }

    public void setBorderColor(Color color)
    {
        this.toolsBox.setBorder(Border.stroke(color));
    }

    public VBox getToolsBox()
    {
        return this.toolsBox;
    }
}
