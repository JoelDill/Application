package Performance;





import es.bsc.comm.Connection;
import es.bsc.comm.MessageHandler;
import es.bsc.comm.TransferManager;
import es.bsc.comm.exceptions.CommException;
import es.bsc.comm.nio.NIOEventManager;
import es.bsc.comm.nio.NIONode;
import es.bsc.comm.stage.Transfer;
//import es.bsc.compss.agent.comm.messages.AddResourcesCommand;


import java.io.IOException;
import java.sql.Timestamp;

public class AvaluacioRendiment2 {

	protected static final TransferManager TM = new TransferManager();
	
    static Integer message_number = 1;
	
	static NIONode RemoteNode = new NIONode("127.0.0.40", 46300);
	
	public static void main(String[] args) throws CommException, InterruptedException {
    	
    	Handler h = new Handler();
        TM.init(NIOEventManager.class.getCanonicalName(), null, h);
        
        NIONode nodeServer = new NIONode("127.0.0.50", 46400);
        TM.startServer(nodeServer);
        
        TM.join();
      
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
            System.out.println("Received cmd " + cmd.toString() + " " + new Timestamp(System.currentTimeMillis()));
            cnctn.finishConnection();
            if(message_number<1001) {
            	try {
            		Connection c_ans= TM.startConnection(RemoteNode);
            		c_ans.sendCommand("Side 2 message " + message_number);
            		++message_number;
            		c_ans.finishConnection();
            	} catch (InterruptedException e) {
            		// TODO Auto-generated catch block
            		e.printStackTrace();
            	}
            }
            
        }
   
        @Override
        public void writeFinished(Connection cnctn, Transfer trnsfr) {
        	 System.out.println("Command sent " + trnsfr.getArray().length + " " + trnsfr.getObject().toString()+ " " + new Timestamp(System.currentTimeMillis()));
        }

        @Override
        public void connectionFinished(Connection cnctn) {
            System.out.println("Connection Finished " + cnctn+ " " + new Timestamp(System.currentTimeMillis()));
            if(message_number==1001) {
            	TM.shutdown(true, cnctn);
            }
        }

        @Override
        public void shutdown() {
            System.out.println("Powering off Handler");
        }

    }

}


