package Providers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TextureProvider {


    private static TextureProvider instance = null;

    private Image ANDGate = null;
    private Image ORGate = null;
    private Image NOTGate = null;
    private Image XORGate = null;
    private Image NANDGate = null;
    private Image NORGate = null;

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
            case "g-xor" : return this.getXORGateTexture();
            case "g-nand" : return this.getNANDGateTexture();
            case "g-nor" : return this.getNORGateTexture();

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

    private ImageView getXORGateTexture()
    {
        if(XORGate == null)
        {
            XORGate = new Image("xor.png");
        }
        return new ImageView(XORGate);
    }

    private ImageView getNANDGateTexture()
    {
        if(NANDGate == null)
        {
            NANDGate = new Image("nand.png");
        }
        return new ImageView(NANDGate);
    }

    private ImageView getNORGateTexture()
    {
        if(NORGate == null)
        {
            NORGate = new Image("nor.png");
        }
        return new ImageView(NORGate);
    }



}
