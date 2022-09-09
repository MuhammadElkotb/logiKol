package Providers;


import UIObjects.BasicGateMultiInUI;
import UIObjects.BasicGateSingleInUI;
import UIObjects.BasicGateUI;
import UIObjects.BufferNode;
import UIObjects.IONode;
import UIObjects.InNode;
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
        switch(gate.toLowerCase())
        {
            case "g-and" : {
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();
                outNode.setClassName("ionode-out");
                inNode1.setClassName("ionode-in");
                inNode2.setClassName("ionode-in");

                ImageView texture = this.textureProvider.getTexture("g-and");

                if(texture == null)
                {
                    throw new Exception("Cannot find AND Texture File");
                }

                return new BasicGateMultiInUI(outNode, inNode1, inNode2, texture);
            } 
            case "g-or" : {
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();
                outNode.setClassName("ionode-out");
                inNode1.setClassName("ionode-in");
                inNode2.setClassName("ionode-in");
                ImageView texture = this.textureProvider.getTexture("g-or");

                if(texture == null)
                {
                    throw new Exception("Cannot find OR Texture File");
                }

                return new BasicGateMultiInUI(outNode, inNode1, inNode2, texture);
            }
            case "g-not" : {
                IONode outNode = new IONode();
                IONode inNode = new IONode();
                outNode.setClassName("ionode-out");
                inNode.setClassName("ionode-in");
                ImageView texture = this.textureProvider.getTexture("g-not");

                if(texture == null)
                {
                    throw new Exception("Cannot find NOT Texture file");
                }
                return new BasicGateSingleInUI(outNode, inNode, texture);
            }
            case "g-xor" : {
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();

                outNode.setClassName("ionode-out");
                inNode1.setClassName("ionode-in");
                inNode2.setClassName("ionode-in");
                
                ImageView texture = this.textureProvider.getTexture("g-xor");

                if(texture == null)
                {
                    throw new Exception("Cannot find XOR Texture file");
                }
                return new BasicGateMultiInUI(outNode, inNode1, inNode2, texture);
            }
            case "g-nand" : {
                
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();

                outNode.setClassName("ionode-out");
                inNode1.setClassName("ionode-in");
                inNode2.setClassName("ionode-in");
                
                ImageView texture = this.textureProvider.getTexture("g-nand");

                if(texture == null)
                {
                    throw new Exception("Cannot find NAND Texture file");
                }
                return new BasicGateMultiInUI(outNode, inNode1, inNode2, texture);
            }
            case "g-nor" : {
                
                IONode outNode = new IONode();
                IONode inNode1 = new IONode();
                IONode inNode2 = new IONode();

                outNode.setClassName("ionode-out");
                inNode1.setClassName("ionode-in");
                inNode2.setClassName("ionode-in");
                
                ImageView texture = this.textureProvider.getTexture("g-nor");

                if(texture == null)
                {
                    throw new Exception("Cannot find NAND Texture file");
                }
                return new BasicGateMultiInUI(outNode, inNode1, inNode2, texture);
            }
            case "g-out" : { 
                IONode outNode = new IONode();
                outNode.node.setFill(Color.RED);
                return new BufferNode(outNode);
            }
            case "g-in" : {
                IONode outNode = new IONode();
                outNode.node.setFill(Color.RED);
                outNode.node.setStroke(Color.BLUE);
                return new InNode(outNode);
            }
            default: break;

        }

        return null;
    } 

    
}
