package tests;



//Funciona correctament en un cas bàsic, creem una connexió a un servidor i la tanquem, 2 segons després creem un
//altra connexió al mateix servidor i comprovem si s'ha reaprofitat el canal

//Executar app i app2 abans

import es.bsc.comm.Connection;
import es.bsc.comm.MessageHandler;
import es.bsc.comm.TransferManager;
import es.bsc.comm.exceptions.CommException;
import es.bsc.comm.nio.NIOEventManager;
import es.bsc.comm.nio.NIONode;
import es.bsc.comm.stage.Transfer;
//import es.bsc.compss.agent.comm.messages.AddResourcesCommand;


import java.io.IOException;

public class Test4 {

	protected static final TransferManager TM = new TransferManager();
	
	public static void main(String[] args) throws CommException, InterruptedException {
    	
     	Handler h = new Handler();
        TM.init(NIOEventManager.class.getCanonicalName(), null, h);
        
        NIONode nodeServer = new NIONode("127.0.0.40", 46300);
        TM.startServer(nodeServer);
        
        NIONode RemoteNode = new NIONode("127.0.0.1", 46100);
        NIONode RemoteNode2 = new NIONode("127.0.0.10", 46200);
        
        Connection c1_1 = TM.startConnection(RemoteNode);
        Connection c1_2 = TM.startConnection(RemoteNode2);
        
        Integer sn1_1 = c1_1.getSocket().hashCode();
        Integer sn1_2 = c1_2.getSocket().hashCode();
        
        c1_1.sendCommand("Connection server 1...");
        c1_1.finishConnection();
        c1_2.sendCommand("Connection server 2...");
        c1_2.finishConnection();
        
        Thread.sleep(2000);
        
        Connection c2_1 = TM.startConnection(RemoteNode);
        Connection c2_2 = TM.startConnection(RemoteNode2);
        
        Integer sn2_1 = c2_1.getSocket().hashCode();
        Integer sn2_2 = c2_2.getSocket().hashCode();
        
        c2_1.sendCommand("Connection server 1...");
        c2_1.finishConnection();
        c2_2.sendCommand("Connection server 2...");
        c2_2.finishConnection();
        
        System.out.println(sn1_1.equals(sn2_1));
        System.out.println(sn1_2.equals(sn2_2));
        
        
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


