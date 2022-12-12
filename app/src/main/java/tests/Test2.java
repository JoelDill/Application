package tests;



//Funciona correctament en un cas bàsic, creem una connexió a un servidor i no la tanquem, 2 segons després creem un
//altra connexió al mateix servidor i comprovem que no s'ha reaprofitat el canal

//Executar abans app

import es.bsc.comm.Connection;
import es.bsc.comm.MessageHandler;
import es.bsc.comm.TransferManager;
import es.bsc.comm.exceptions.CommException;
import es.bsc.comm.nio.NIOEventManager;
import es.bsc.comm.nio.NIONode;
import es.bsc.comm.stage.Transfer;
//import es.bsc.compss.agent.comm.messages.AddResourcesCommand;


import java.io.IOException;

public class Test2 {

	protected static final TransferManager TM = new TransferManager();
	
	public static void main(String[] args) throws CommException, InterruptedException {
    	
     	Handler h = new Handler();
        TM.init(NIOEventManager.class.getCanonicalName(), null, h);
        
        NIONode nodeServer = new NIONode("127.0.0.40", 46300);
        TM.startServer(nodeServer);
        
        NIONode RemoteNode = new NIONode("127.0.0.1", 46100);
        Connection c1 = TM.startConnection(RemoteNode);
        Integer sn1 = c1.getSocket().hashCode();
        c1.sendCommand("Single connection...");
        
        Thread.sleep(2000);
        
        Connection c2 = TM.startConnection(RemoteNode);
        Integer sn2 = c2.getSocket().hashCode();
        c2.sendCommand("Single connection...");
        c1.finishConnection();
        c2.finishConnection();
        
        System.out.println(sn1.equals(sn2));
        
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


