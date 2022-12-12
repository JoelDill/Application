package tests;



//Comprovem el correcte funcionament de la caché, obrim i tanquem 6 connexions al mateix servidor. 
//Un cop s'han tancat, repetim el procés. Si funciona correctament només s'haurien d'haver aprofitat 5/6 connexions.

//Executar app abans

import es.bsc.comm.Connection;
import es.bsc.comm.MessageHandler;
import es.bsc.comm.TransferManager;
import es.bsc.comm.exceptions.CommException;
import es.bsc.comm.nio.NIOEventManager;
import es.bsc.comm.nio.NIONode;
import es.bsc.comm.stage.Transfer;
//import es.bsc.compss.agent.comm.messages.AddResourcesCommand;


import java.io.IOException;

public class Test3 {

	protected static final TransferManager TM = new TransferManager();
	
	public static void main(String[] args) throws CommException, InterruptedException {
    	
     	Handler h = new Handler();
        TM.init(NIOEventManager.class.getCanonicalName(), null, h);
        
        NIONode nodeServer = new NIONode("127.0.0.40", 46300);
        TM.startServer(nodeServer);
        
        NIONode RemoteNode = new NIONode("127.0.0.1", 46100);
        Connection c1_1 = TM.startConnection(RemoteNode);
        Connection c1_2 = TM.startConnection(RemoteNode);
        Connection c1_3 = TM.startConnection(RemoteNode);
        Connection c1_4 = TM.startConnection(RemoteNode);
        Connection c1_5 = TM.startConnection(RemoteNode);
        Connection c1_6 = TM.startConnection(RemoteNode);
        
        Integer[] S1 = {
        		c1_1.getSocket().hashCode(),
        		c1_2.getSocket().hashCode(),
        		c1_3.getSocket().hashCode(),
        		c1_4.getSocket().hashCode(),
        		c1_5.getSocket().hashCode(),
        		c1_6.getSocket().hashCode(),
        };
        
        c1_1.sendCommand("First connection first round...");
        c1_2.sendCommand("Second connection first round...");
        c1_3.sendCommand("Third connection first round...");
        c1_4.sendCommand("Fourth connection first round...");
        c1_5.sendCommand("Fifth connection first round...");
        c1_6.sendCommand("Sixth connection first round...");
        
        
        c1_1.finishConnection();
        c1_2.finishConnection();
        c1_3.finishConnection();
        c1_4.finishConnection();
        c1_5.finishConnection();
        c1_6.finishConnection();
          
        Thread.sleep(2000);
        
        Connection c2_1 = TM.startConnection(RemoteNode);
        Connection c2_2 = TM.startConnection(RemoteNode);
        Connection c2_3 = TM.startConnection(RemoteNode);
        Connection c2_4 = TM.startConnection(RemoteNode);
        Connection c2_5 = TM.startConnection(RemoteNode);
        Connection c2_6 = TM.startConnection(RemoteNode);
        
        Integer[] S2 = {
        		c2_1.getSocket().hashCode(),
        		c2_2.getSocket().hashCode(),
        		c2_3.getSocket().hashCode(),
        		c2_4.getSocket().hashCode(),
        		c2_5.getSocket().hashCode(),
        		c2_6.getSocket().hashCode(),
        };
        
        c2_1.sendCommand("First connection second round...");
        c2_2.sendCommand("Second connection second round...");
        c2_3.sendCommand("Third connection second round...");
        c2_4.sendCommand("Fourth connection second round...");
        c2_5.sendCommand("Fifth connection second round...");
        c2_6.sendCommand("Sixth connection second round...");
        
        c2_1.finishConnection();
        c2_2.finishConnection();
        c2_3.finishConnection();
        c2_4.finishConnection();
        c2_5.finishConnection();
        c2_6.finishConnection();
        
        System.out.println(S1[0]+"  "+S1[1]+"  "+S1[2]+"  "+S1[3]+"  "+S1[4]+"  "+S1[5]);
        System.out.println(S2[0]+"  "+S2[1]+"  "+S2[2]+"  "+S2[3]+"  "+S2[4]+"  "+S2[5]);
        
        TM.shutdown(true, null);
      
    }


    private static class Handler implements MessageHandler {

        @Override
        public void init() throws CommException {
            System.out.println("Handler init...");
        }

        @Override
        public void errorHandler(Connection cnctn, Transfer trnsfr, CommException ce) {
            ce.printStackTrace();
        }

        @Override
        public void dataReceived(Connection cnctn, Transfer trnsfr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void commandReceived(Connection cnctn, Transfer trnsfr) {
            Object cmd = trnsfr.getObject();
            System.out.println("Received cmd " + cmd.toString());
            cnctn.finishConnection();
            TM.shutdown(true,null);
        }

        @Override
        public void writeFinished(Connection cnctn, Transfer trnsfr) {

            System.out.println("Command sent " + trnsfr.getArray().length);
        }

        @Override
        public void connectionFinished(Connection cnctn) {
            System.out.println("Connection Finished " + cnctn);
            //System.exit(0);
        }

        @Override
        public void shutdown() {
            System.out.println("Powering off Handler");
        }

    }

}


