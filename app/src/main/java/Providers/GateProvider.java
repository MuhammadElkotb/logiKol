package Providers;

import Gates.AND;
import Gates.BasicGate;
import Gates.Input;
import Gates.NOR;
import Gates.NOT;
import Gates.Node;
import Gates.OR;
import UIObjects.BufferNode;

public class GateProvider {
    

    private static GateProvider instance = null;

    private GateProvider()
    {
    }
    public static GateProvider getInstnace()
    {
        if(instance == null)
        {
            instance = new GateProvider();
        }
        return instance;
    }


    public BasicGate buildGate(String gate) throws Exception
    {
        if(gate != null)
        {
            gate = gate.toLowerCase();
        }
        switch(gate)
        {
            case "and" : {

                return new AND();
            } 
            case "or" : {
                return new OR();
            }
            case "not" : {
                return new NOT();
            }
            case "io" : { 
                return new Node();
            }
            case "in" : {
                return new Input();
            }
            default: break;
        }

        return null;
    } 

}
