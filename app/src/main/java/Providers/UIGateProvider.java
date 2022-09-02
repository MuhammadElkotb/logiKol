package Providers;


import UIObjects.BasicGateMultiInUI;
import UIObjects.BasicGateSingleInUI;
import UIObjects.BasicGateUI;
import UIObjects.BufferNode;
import UIObjects.IONode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class UIGateProvider {



    private static UIGateProvider instance = null;
    private TextureProvider textureProvider = null;

    private UIGateProvider(TextureProvider textureProvider)
    {
        this.textureProvider = textureProvider;
    }
    public static UIGateProvider getInstnace(TextureProvider textureProvider)
    {
        if(instance == null)
        {
            instance = new UIGateProvider(textureProvider);
        }
        return instance;
    }

    public BasicGateUI buildGate(String gate) throws Exception
    {
        if(gate != null)
        {
            gate = gate.toLowerCase();
        }
        switch(gate)
        {
            case "and" : {
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();
                outNode.setClassName("ionode-out");
                inNode1.setClassName("ionode-in");
                inNode2.setClassName("ionode-in");

                ImageView texture = this.textureProvider.getANDGateTexture();

                if(texture == null)
                {
                    throw new Exception("Cannot find AND Texture File");
                }

                return new BasicGateMultiInUI(outNode, inNode1, inNode2, texture);
            } 
            case "or" : {
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();
                outNode.setClassName("ionode-out");
                inNode1.setClassName("ionode-in");
                inNode2.setClassName("ionode-in");
                ImageView texture = this.textureProvider.getORGateTexture();

                if(texture == null)
                {
                    throw new Exception("Cannot find OR Texture File");
                }

                return new BasicGateMultiInUI(outNode, inNode1, inNode2, texture);
            }
            case "not" : {
                IONode outNode = new IONode();
                IONode inNode = new IONode();
                outNode.setClassName("ionode-out");
                inNode.setClassName("ionode-in");
                ImageView texture = this.textureProvider.getNOTGateTexture();

                if(texture == null)
                {
                    throw new Exception("Cannot find NOT Texture file");
                }
                return new BasicGateSingleInUI(outNode, inNode, texture);
            }
            case "io" : { 
                IONode outNode = new IONode();
                outNode.node.setFill(Color.RED);
                return new BufferNode(outNode);
            }
            default: break;

        }

        return null;
    } 

    
}
