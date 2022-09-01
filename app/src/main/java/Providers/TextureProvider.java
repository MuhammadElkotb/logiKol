package Providers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TextureProvider {


    private static TextureProvider instance = null;

    private TextureProvider()
    {

    }
    public static TextureProvider getInstnace()
    {
        if(instance == null)
        {
            instance = new TextureProvider();
        }
        return instance;
    }

    private Image ANDGate = null;
    private Image ORGate = null;
    private Image NOTGate = null;


    public ImageView getANDGateTexture()
    {
        if(ANDGate == null)
        {
            ANDGate = new Image("andnew1.png");
        }
        return new ImageView(ANDGate);
    }
    
    public ImageView getORGateTexture()
    {
        if(ORGate == null)
        {
            ORGate = new Image("ornew1.png");
        }
        return new ImageView(ORGate);
    }

    public ImageView getNOTGateTexture()
    {
        if(NOTGate == null)
        {
            NOTGate = new Image("notnew1.png");
        }
        return new ImageView(NOTGate);
    }
}
