package Providers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TextureProvider {

    private static Image ANDGate = null;
    private static Image ORGate = null;
    private static Image NOTGate = null;


    public static ImageView getANDGateTexture()
    {
        if(ANDGate == null)
        {
            ANDGate = new Image("andnew1.png");
        }
        return new ImageView(ANDGate);
    }
    
    public static ImageView getORGateTexture()
    {
        if(ORGate == null)
        {
            ORGate = new Image("ornew1.png");
        }
        return new ImageView(ORGate);
    }

    public static ImageView getNOTGateTexture()
    {
        if(NOTGate == null)
        {
            NOTGate = new Image("notnew1.png");
        }
        return new ImageView(NOTGate);
    }
}
