package Providers;

import Gates.BasicGate;
import UIObjects.ANDGate;
import UIObjects.BasicGateUI;
import UIObjects.IONode;
import UIObjects.ORGate;
import UIObjects.UIObject;
import javafx.scene.image.ImageView;

public class UIGateProvider {


    public static BasicGateUI buildGate(String gate) throws Exception
    {
        switch(gate)
        {
            case "AND" : {
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();
                ImageView texture = TextureProvider.getANDGateTexture();

                if(texture == null)
                {
                    throw new Exception("Cannot find AND Texture File");
                }

                return new ANDGate(outNode, inNode1, inNode2, texture);
            } 
            case "OR" : {
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();
                ImageView texture = TextureProvider.getORGateTexture();

                if(texture == null)
                {
                    throw new Exception("Cannot find OR Texture File");
                }

                return new ORGate(outNode, inNode1, inNode2, texture);
            }
            default: break;

        }

        return null;
    } 

    
}
