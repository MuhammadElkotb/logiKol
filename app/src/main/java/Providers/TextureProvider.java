package Providers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TextureProvider {


    private static TextureProvider instance = null;

    private Image ANDGate = null;
    private Image ORGate = null;
    private Image NOTGate = null;


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


    public ImageView getTexture(String gate) throws Exception
    {
        switch(gate.toLowerCase())
        {
            case "g-and" : return this.getANDGateTexture();
            case "g-or" : return this.getORGateTexture();
            case "g-not" : return this.getNOTGateTexture();
            default : return null;
        }
    }

    

    private ImageView getANDGateTexture()
    {
        if(ANDGate == null)
        {
            ANDGate = new Image("andnew1.png");
        }
        return new ImageView(ANDGate);
    }
    
    private ImageView getORGateTexture()
    {
        if(ORGate == null)
        {
            ORGate = new Image("ornew1.png");
        }
        return new ImageView(ORGate);
    }


    private ImageView getNOTGateTexture()
    {
        if(NOTGate == null)
        {
            NOTGate = new Image("notnew1.png");
        }
        return new ImageView(NOTGate);
    }



}
