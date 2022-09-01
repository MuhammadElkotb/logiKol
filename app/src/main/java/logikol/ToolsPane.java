package logikol;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;




public class ToolsPane {
    private Label label;
    private VBox toolsBox;
    
    public ToolsPane(String label)
    {
        this.label = new Label(label);
        this.label.setFont(new Font(30));
        this.toolsBox = new VBox(10);
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

    public void addButton(String label)
    {
        Button button = new Button(label);
        this.toolsBox.getChildren().addAll(button);
    }

    public VBox getToolsBox()
    {
        return this.toolsBox;
    }
}
