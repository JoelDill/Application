package Performance;



//Funciona correctament a l'hora d'haver d'aprofitar canals
//Al tancar la connexió, consultem el socket que tenen assignat i veurem que és el mateix

//Executar app, app2, app3, app4 i app5

import es.bsc.comm.Connection;
import es.bsc.comm.MessageHandler;
import es.bsc.comm.TransferManager;
import es.bsc.comm.exceptions.CommException;
import es.bsc.comm.nio.NIOEventManager;
import es.bsc.comm.nio.NIONode;
import es.bsc.comm.stage.Transfer;
//import es.bsc.compss.agent.comm.messages.AddResourcesCommand;


import java.io.IOException;

public class AvaluacioRendiment1 {

	protected static final TransferManager TM = new TransferManager();
	
	public static void main(String[] args) throws CommException, InterruptedException {
    	
    	Handler h = new Handler();
        TM.init(NIOEventManager.class.getCanonicalName(), null, h);
        
        NIONode nodeServer = new NIONode("127.0.0.40", 46300);
        TM.startServer(nodeServer);
        
        long start = System.currentTimeMillis();
        
        NIONode RemoteNode = new NIONode("127.0.0.1", 46100);
        NIONode RemoteNode2 = new NIONode("127.0.0.2", 46101);
        NIONode RemoteNode3 = new NIONode("127.0.0.3", 46102);
        NIONode RemoteNode4 = new NIONode("127.0.0.4", 46103);
        NIONode RemoteNode5 = new NIONode("127.0.0.5", 46104);

        //Primera ronda
        
        Connection c1_1_1 = TM.startConnection(RemoteNode);
        Connection c1_1_2 = TM.startConnection(RemoteNode);
        Connection c1_1_3 = TM.startConnection(RemoteNode);
        Connection c1_1_4 = TM.startConnection(RemoteNode);
        Connection c1_1_5 = TM.startConnection(RemoteNode);
        
        Connection c2_1_1 = TM.startConnection(RemoteNode2);
        Connection c2_1_2 = TM.startConnection(RemoteNode2);
        Connection c2_1_3 = TM.startConnection(RemoteNode2);
        Connection c2_1_4 = TM.startConnection(RemoteNode2);
        Connection c2_1_5 = TM.startConnection(RemoteNode2);
        
        Connection c3_1_1 = TM.startConnection(RemoteNode3);
        Connection c3_1_2 = TM.startConnection(RemoteNode3);
        Connection c3_1_3 = TM.startConnection(RemoteNode3);
        Connection c3_1_4 = TM.startConnection(RemoteNode3);
        Connection c3_1_5 = TM.startConnection(RemoteNode3);
        
        Connection c4_1_1 = TM.startConnection(RemoteNode4);
        Connection c4_1_2 = TM.startConnection(RemoteNode4);
        Connection c4_1_3 = TM.startConnection(RemoteNode4);
        Connection c4_1_4 = TM.startConnection(RemoteNode4);
        Connection c4_1_5 = TM.startConnection(RemoteNode4);
        
        Connection c5_1_1 = TM.startConnection(RemoteNode5);
        Connection c5_1_2 = TM.startConnection(RemoteNode5);
        Connection c5_1_3 = TM.startConnection(RemoteNode5);
        Connection c5_1_4 = TM.startConnection(RemoteNode5);
        Connection c5_1_5 = TM.startConnection(RemoteNode5);
        
        c1_1_1.sendCommand("First connection first round first message...");
        c1_1_2.sendCommand("First connection first round second message...");
        c1_1_3.sendCommand("First connection first round third message...");
        c1_1_4.sendCommand("First connection first round fourth message...");
        c1_1_5.sendCommand("First connection first round fifth message...");
        
        c2_1_1.sendCommand("Second connection first round first message...");
        c2_1_2.sendCommand("Second connection first round second message...");
        c2_1_3.sendCommand("Second connection first round third message...");
        c2_1_4.sendCommand("Second connection first round fourth message...");
        c2_1_5.sendCommand("Second connection first round fifth message...");
        
        c3_1_1.sendCommand("Third connection first round first message...");
        c3_1_2.sendCommand("Third connection first round second message...");
        c3_1_3.sendCommand("Third connection first round third message...");
        c3_1_4.sendCommand("Third connection first round fourth message...");
        c3_1_5.sendCommand("Third connection first round fifth message...");
        
        c4_1_1.sendCommand("Fourth connection first round first message...");
        c4_1_2.sendCommand("Fourth connection first round second message...");
        c4_1_3.sendCommand("Fourth connection first round third message...");
        c4_1_4.sendCommand("Fourth connection first round fourth message...");
        c4_1_5.sendCommand("Fourth connection first round fifth message...");
        
        c5_1_1.sendCommand("Fifth connection first round first message...");
        c5_1_2.sendCommand("Fifth connection first round second message...");
        c5_1_3.sendCommand("Fifth connection first round third message...");
        c5_1_4.sendCommand("Fifth connection first round fourth message...");
        c5_1_5.sendCommand("Fifth connection first round fifth message...");
        
        
        c1_1_1.finishConnection();
        c1_1_2.finishConnection();
        c1_1_3.finishConnection();
        c1_1_4.finishConnection();
        c1_1_5.finishConnection();
        
        c2_1_1.finishConnection();
        c2_1_2.finishConnection();
        c2_1_3.finishConnection();
        c2_1_4.finishConnection();
        c2_1_5.finishConnection();
        
        c3_1_1.finishConnection();
        c3_1_2.finishConnection();
        c3_1_3.finishConnection();
        c3_1_4.finishConnection();
        c3_1_5.finishConnection();
        
        c4_1_1.finishConnection();
        c4_1_2.finishConnection();
        c4_1_3.finishConnection();
        c4_1_4.finishConnection();
        c4_1_5.finishConnection();
        
        c5_1_1.finishConnection();
        c5_1_2.finishConnection();
        c5_1_3.finishConnection();
        c5_1_4.finishConnection();
        c5_1_5.finishConnection();
        
        Thread.sleep(1000);
        
        //Segona ronda
        
        Connection c1_2_1 = TM.startConnection(RemoteNode);
        Connection c1_2_2 = TM.startConnection(RemoteNode);
        Connection c1_2_3 = TM.startConnection(RemoteNode);
        Connection c1_2_4 = TM.startConnection(RemoteNode);
        Connection c1_2_5 = TM.startConnection(RemoteNode);
        
        Connection c2_2_1 = TM.startConnection(RemoteNode2);
        Connection c2_2_2 = TM.startConnection(RemoteNode2);
        Connection c2_2_3 = TM.startConnection(RemoteNode2);
        Connection c2_2_4 = TM.startConnection(RemoteNode2);
        Connection c2_2_5 = TM.startConnection(RemoteNode2);
        
        Connection c3_2_1 = TM.startConnection(RemoteNode3);
        Connection c3_2_2 = TM.startConnection(RemoteNode3);
        Connection c3_2_3 = TM.startConnection(RemoteNode3);
        Connection c3_2_4 = TM.startConnection(RemoteNode3);
        Connection c3_2_5 = TM.startConnection(RemoteNode3);
        
        Connection c4_2_1 = TM.startConnection(RemoteNode4);
        Connection c4_2_2 = TM.startConnection(RemoteNode4);
        Connection c4_2_3 = TM.startConnection(RemoteNode4);
        Connection c4_2_4 = TM.startConnection(RemoteNode4);
        Connection c4_2_5 = TM.startConnection(RemoteNode4);
        
        Connection c5_2_1 = TM.startConnection(RemoteNode5);
        Connection c5_2_2 = TM.startConnection(RemoteNode5);
        Connection c5_2_3 = TM.startConnection(RemoteNode5);
        Connection c5_2_4 = TM.startConnection(RemoteNode5);
        Connection c5_2_5 = TM.startConnection(RemoteNode5);
        
        c1_2_1.sendCommand("First connection second round first message...");
        c1_2_2.sendCommand("First connection second round second message...");
        c1_2_3.sendCommand("First connection second round third message...");
        c1_2_4.sendCommand("First connection second round fourth message...");
        c1_2_5.sendCommand("First connection second round fifth message...");
        
        c2_2_1.sendCommand("Second connection second round first message...");
        c2_2_2.sendCommand("Second connection second round second message...");
        c2_2_3.sendCommand("Second connection second round third message...");
        c2_2_4.sendCommand("Second connection second round fourth message...");
        c2_2_5.sendCommand("Second connection second round fifth message...");
        
        c3_2_1.sendCommand("Third connection second round first message...");
        c3_2_2.sendCommand("Third connection second round second message...");
        c3_2_3.sendCommand("Third connection second round third message...");
        c3_2_4.sendCommand("Third connection second round fourth message...");
        c3_2_5.sendCommand("Third connection second round fifth message...");
        
        c4_2_1.sendCommand("Fourth connection second round first message...");
        c4_2_2.sendCommand("Fourth connection second round second message...");
        c4_2_3.sendCommand("Fourth connection second round third message...");
        c4_2_4.sendCommand("Fourth connection second round fourth message...");
        c4_2_5.sendCommand("Fourth connection second round fifth message...");
        
        c5_2_1.sendCommand("Fifth connection second round first message...");
        c5_2_2.sendCommand("Fifth connection second round second message...");
        c5_2_3.sendCommand("Fifth connection second round third message...");
        c5_2_4.sendCommand("Fifth connection second round fourth message...");
        c5_2_5.sendCommand("Fifth connection second round fifth message...");
        
        
        c1_2_1.finishConnection();
        c1_2_2.finishConnection();
        c1_2_3.finishConnection();
        c1_2_4.finishConnection();
        c1_2_5.finishConnection();
        
        c2_2_1.finishConnection();
        c2_2_2.finishConnection();
        c2_2_3.finishConnection();
        c2_2_4.finishConnection();
        c2_2_5.finishConnection();
        
        c3_2_1.finishConnection();
        c3_2_2.finishConnection();
        c3_2_3.finishConnection();
        c3_2_4.finishConnection();
        c3_2_5.finishConnection();
        
        c4_2_1.finishConnection();
        c4_2_2.finishConnection();
        c4_2_3.finishConnection();
        c4_2_4.finishConnection();
        c4_2_5.finishConnection();
        
        c5_2_1.finishConnection();
        c5_2_2.finishConnection();
        c5_2_3.finishConnection();
        c5_2_4.finishConnection();
        c5_2_5.finishConnection();
        
        Thread.sleep(1000);
        
        //Tercera ronda
        
        Connection c1_3_1 = TM.startConnection(RemoteNode);
        Connection c1_3_2 = TM.startConnection(RemoteNode);
        Connection c1_3_3 = TM.startConnection(RemoteNode);
        Connection c1_3_4 = TM.startConnection(RemoteNode);
        Connection c1_3_5 = TM.startConnection(RemoteNode);
        
        Connection c2_3_1 = TM.startConnection(RemoteNode2);
        Connection c2_3_2 = TM.startConnection(RemoteNode2);
        Connection c2_3_3 = TM.startConnection(RemoteNode2);
        Connection c2_3_4 = TM.startConnection(RemoteNode2);
        Connection c2_3_5 = TM.startConnection(RemoteNode2);
        
        Connection c3_3_1 = TM.startConnection(RemoteNode3);
        Connection c3_3_2 = TM.startConnection(RemoteNode3);
        Connection c3_3_3 = TM.startConnection(RemoteNode3);
        Connection c3_3_4 = TM.startConnection(RemoteNode3);
        Connection c3_3_5 = TM.startConnection(RemoteNode3);
        
        Connection c4_3_1 = TM.startConnection(RemoteNode4);
        Connection c4_3_2 = TM.startConnection(RemoteNode4);
        Connection c4_3_3 = TM.startConnection(RemoteNode4);
        Connection c4_3_4 = TM.startConnection(RemoteNode4);
        Connection c4_3_5 = TM.startConnection(RemoteNode4);
        
        Connection c5_3_1 = TM.startConnection(RemoteNode5);
        Connection c5_3_2 = TM.startConnection(RemoteNode5);
        Connection c5_3_3 = TM.startConnection(RemoteNode5);
        Connection c5_3_4 = TM.startConnection(RemoteNode5);
        Connection c5_3_5 = TM.startConnection(RemoteNode5);
        
        c1_3_1.sendCommand("First connection third round first message...");
        c1_3_2.sendCommand("First connection third round second message...");
        c1_3_3.sendCommand("First connection third round third message...");
        c1_3_4.sendCommand("First connection third round fourth message...");
        c1_3_5.sendCommand("First connection third round fifth message...");
        
        c2_3_1.sendCommand("Second connection third round first message...");
        c2_3_2.sendCommand("Second connection third round second message...");
        c2_3_3.sendCommand("Second connection third round third message...");
        c2_3_4.sendCommand("Second connection third round fourth message...");
        c2_3_5.sendCommand("Second connection third round fifth message...");
        
        c3_3_1.sendCommand("Third connection third round first message...");
        c3_3_2.sendCommand("Third connection third round second message...");
        c3_3_3.sendCommand("Third connection third round third message...");
        c3_3_4.sendCommand("Third connection third round fourth message...");
        c3_3_5.sendCommand("Third connection third round fifth message...");
        
        c4_3_1.sendCommand("Fourth connection third round first message...");
        c4_3_2.sendCommand("Fourth connection third round second message...");
        c4_3_3.sendCommand("Fourth connection third round third message...");
        c4_3_4.sendCommand("Fourth connection third round fourth message...");
        c4_3_5.sendCommand("Fourth connection third round fifth message...");
        
        c5_3_1.sendCommand("Fifth connection third round first message...");
        c5_3_2.sendCommand("Fifth connection third round second message...");
        c5_3_3.sendCommand("Fifth connection third round third message...");
        c5_3_4.sendCommand("Fifth connection third round fourth message...");
        c5_3_5.sendCommand("Fifth connection third round fifth message...");
        
        
        c1_3_1.finishConnection();
        c1_3_2.finishConnection();
        c1_3_3.finishConnection();
        c1_3_4.finishConnection();
        c1_3_5.finishConnection();
        
        c2_3_1.finishConnection();
        c2_3_2.finishConnection();
        c2_3_3.finishConnection();
        c2_3_4.finishConnection();
        c2_3_5.finishConnection();
        
        c3_3_1.finishConnection();
        c3_3_2.finishConnection();
        c3_3_3.finishConnection();
        c3_3_4.finishConnection();
        c3_3_5.finishConnection();
        
        c4_3_1.finishConnection();
        c4_3_2.finishConnection();
        c4_3_3.finishConnection();
        c4_3_4.finishConnection();
        c4_3_5.finishConnection();
        
        c5_3_1.finishConnection();
        c5_3_2.finishConnection();
        c5_3_3.finishConnection();
        c5_3_4.finishConnection();
        c5_3_5.finishConnection();
        
        Thread.sleep(1000);
        
        //Quarta ronda
        
        Connection c1_4_1 = TM.startConnection(RemoteNode);
        Connection c1_4_2 = TM.startConnection(RemoteNode);
        Connection c1_4_3 = TM.startConnection(RemoteNode);
        Connection c1_4_4 = TM.startConnection(RemoteNode);
        Connection c1_4_5 = TM.startConnection(RemoteNode);
        
        Connection c2_4_1 = TM.startConnection(RemoteNode2);
        Connection c2_4_2 = TM.startConnection(RemoteNode2);
        Connection c2_4_3 = TM.startConnection(RemoteNode2);
        Connection c2_4_4 = TM.startConnection(RemoteNode2);
        Connection c2_4_5 = TM.startConnection(RemoteNode2);
        
        Connection c3_4_1 = TM.startConnection(RemoteNode3);
        Connection c3_4_2 = TM.startConnection(RemoteNode3);
        Connection c3_4_3 = TM.startConnection(RemoteNode3);
        Connection c3_4_4 = TM.startConnection(RemoteNode3);
        Connection c3_4_5 = TM.startConnection(RemoteNode3);
        
        Connection c4_4_1 = TM.startConnection(RemoteNode4);
        Connection c4_4_2 = TM.startConnection(RemoteNode4);
        Connection c4_4_3 = TM.startConnection(RemoteNode4);
        Connection c4_4_4 = TM.startConnection(RemoteNode4);
        Connection c4_4_5 = TM.startConnection(RemoteNode4);
        
        Connection c5_4_1 = TM.startConnection(RemoteNode5);
        Connection c5_4_2 = TM.startConnection(RemoteNode5);
        Connection c5_4_3 = TM.startConnection(RemoteNode5);
        Connection c5_4_4 = TM.startConnection(RemoteNode5);
        Connection c5_4_5 = TM.startConnection(RemoteNode5);
        
        c1_4_1.sendCommand("First connection fourth round first message...");
        c1_4_2.sendCommand("First connection fourth round second message...");
        c1_4_3.sendCommand("First connection fourth round third message...");
        c1_4_4.sendCommand("First connection fourth round fourth message...");
        c1_4_5.sendCommand("First connection fourth round fifth message...");
        
        c2_4_1.sendCommand("Second connection fourth round first message...");
        c2_4_2.sendCommand("Second connection fourth round second message...");
        c2_4_3.sendCommand("Second connection fourth round third message...");
        c2_4_4.sendCommand("Second connection fourth round fourth message...");
        c2_4_5.sendCommand("Second connection fourth round fifth message...");
        
        c3_4_1.sendCommand("Third connection fourth round first message...");
        c3_4_2.sendCommand("Third connection fourth round second message...");
        c3_4_3.sendCommand("Third connection fourth round third message...");
        c3_4_4.sendCommand("Third connection fourth round fourth message...");
        c3_4_5.sendCommand("Third connection fourth round fifth message...");
        
        c4_4_1.sendCommand("Fourth connection fourth round first message...");
        c4_4_2.sendCommand("Fourth connection fourth round second message...");
        c4_4_3.sendCommand("Fourth connection fourth round third message...");
        c4_4_4.sendCommand("Fourth connection fourth round fourth message...");
        c4_4_5.sendCommand("Fourth connection fourth round fifth message...");
        
        c5_4_1.sendCommand("Fifth connection fourth round first message...");
        c5_4_2.sendCommand("Fifth connection fourth round second message...");
        c5_4_3.sendCommand("Fifth connection fourth round third message...");
        c5_4_4.sendCommand("Fifth connection fourth round fourth message...");
        c5_4_5.sendCommand("Fifth connection fourth round fifth message...");
        
        
        c1_4_1.finishConnection();
        c1_4_2.finishConnection();
        c1_4_3.finishConnection();
        c1_4_4.finishConnection();
        c1_4_5.finishConnection();
        
        c2_4_1.finishConnection();
        c2_4_2.finishConnection();
        c2_4_3.finishConnection();
        c2_4_4.finishConnection();
        c2_4_5.finishConnection();
        
        c3_4_1.finishConnection();
        c3_4_2.finishConnection();
        c3_4_3.finishConnection();
        c3_4_4.finishConnection();
        c3_4_5.finishConnection();
        
        c4_4_1.finishConnection();
        c4_4_2.finishConnection();
        c4_4_3.finishConnection();
        c4_4_4.finishConnection();
        c4_4_5.finishConnection();
        
        c5_4_1.finishConnection();
        c5_4_2.finishConnection();
        c5_4_3.finishConnection();
        c5_4_4.finishConnection();
        c5_4_5.finishConnection();
        
        Thread.sleep(1000);
        
        //Cinquena ronda
        
        Connection c1_5_1 = TM.startConnection(RemoteNode);
        Connection c1_5_2 = TM.startConnection(RemoteNode);
        Connection c1_5_3 = TM.startConnection(RemoteNode);
        Connection c1_5_4 = TM.startConnection(RemoteNode);
        Connection c1_5_5 = TM.startConnection(RemoteNode);
        
        Connection c2_5_1 = TM.startConnection(RemoteNode2);
        Connection c2_5_2 = TM.startConnection(RemoteNode2);
        Connection c2_5_3 = TM.startConnection(RemoteNode2);
        Connection c2_5_4 = TM.startConnection(RemoteNode2);
        Connection c2_5_5 = TM.startConnection(RemoteNode2);
        
        Connection c3_5_1 = TM.startConnection(RemoteNode3);
        Connection c3_5_2 = TM.startConnection(RemoteNode3);
        Connection c3_5_3 = TM.startConnection(RemoteNode3);
        Connection c3_5_4 = TM.startConnection(RemoteNode3);
        Connection c3_5_5 = TM.startConnection(RemoteNode3);
        
        Connection c4_5_1 = TM.startConnection(RemoteNode4);
        Connection c4_5_2 = TM.startConnection(RemoteNode4);
        Connection c4_5_3 = TM.startConnection(RemoteNode4);
        Connection c4_5_4 = TM.startConnection(RemoteNode4);
        Connection c4_5_5 = TM.startConnection(RemoteNode4);
        
        Connection c5_5_1 = TM.startConnection(RemoteNode5);
        Connection c5_5_2 = TM.startConnection(RemoteNode5);
        Connection c5_5_3 = TM.startConnection(RemoteNode5);
        Connection c5_5_4 = TM.startConnection(RemoteNode5);
        Connection c5_5_5 = TM.startConnection(RemoteNode5);
        
        c1_5_1.sendCommand("First connection fifth round first message...");
        c1_5_2.sendCommand("First connection fifth round second message...");
        c1_5_3.sendCommand("First connection fifth round third message...");
        c1_5_4.sendCommand("First connection fifth round fourth message...");
        c1_5_5.sendCommand("First connection fifth round fifth message...");
        
        c2_5_1.sendCommand("Second connection fifth round first message...");
        c2_5_2.sendCommand("Second connection fifth round second message...");
        c2_5_3.sendCommand("Second connection fifth round third message...");
        c2_5_4.sendCommand("Second connection fifth round fourth message...");
        c2_5_5.sendCommand("Second connection fifth round fifth message...");
        
        c3_5_1.sendCommand("Third connection fifth round first message...");
        c3_5_2.sendCommand("Third connection fifth round second message...");
        c3_5_3.sendCommand("Third connection fifth round third message...");
        c3_5_4.sendCommand("Third connection fifth round fourth message...");
        c3_5_5.sendCommand("Third connection fifth round fifth message...");
        
        c4_5_1.sendCommand("Fourth connection fifth round first message...");
        c4_5_2.sendCommand("Fourth connection fifth round second message...");
        c4_5_3.sendCommand("Fourth connection fifth round third message...");
        c4_5_4.sendCommand("Fourth connection fifth round fourth message...");
        c4_5_5.sendCommand("Fourth connection fifth round fifth message...");
        
        c5_5_1.sendCommand("Fifth connection fifth round first message...");
        c5_5_2.sendCommand("Fifth connection fifth round second message...");
        c5_5_3.sendCommand("Fifth connection fifth round third message...");
        c5_5_4.sendCommand("Fifth connection fifth round fourth message...");
        c5_5_5.sendCommand("Fifth connection fifth round fifth message...");
        
        
        c1_5_1.finishConnection();
        c1_5_2.finishConnection();
        c1_5_3.finishConnection();
        c1_5_4.finishConnection();
        c1_5_5.finishConnection();
        
        c2_5_1.finishConnection();
        c2_5_2.finishConnection();
        c2_5_3.finishConnection();
        c2_5_4.finishConnection();
        c2_5_5.finishConnection();
        
        c3_5_1.finishConnection();
        c3_5_2.finishConnection();
        c3_5_3.finishConnection();
        c3_5_4.finishConnection();
        c3_5_5.finishConnection();
        
        c4_5_1.finishConnection();
        c4_5_2.finishConnection();
        c4_5_3.finishConnection();
        c4_5_4.finishConnection();
        c4_5_5.finishConnection();
        
        c5_5_1.finishConnection();
        c5_5_2.finishConnection();
        c5_5_3.finishConnection();
        c5_5_4.finishConnection();
        c5_5_5.finishConnection();
        
        Thread.sleep(1000);
        
        long executionTime= System.currentTimeMillis()-start;
        System.out.println(executionTime);
        
        
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


