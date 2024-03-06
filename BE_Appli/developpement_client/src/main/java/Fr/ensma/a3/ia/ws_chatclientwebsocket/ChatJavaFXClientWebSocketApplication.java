package Fr.ensma.a3.ia.ws_chatclientwebsocket;

import jdk.internal.jshell.tool.MessageHandler;
import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;

public class ChatJavaFXClientWebSocketApplication {
    private void connect (String wsUri){
        final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
        ClientManager client = ClientManager.createClient();
        try{
            currentSession = client.connectToServer(new Endpoint(){
                @Override
                public void onOpen(Session session, EndpointConfig config) {
                    writeMessage("Connect to WSEndpoint.");
                    session.addMessageHandler(new MessageHandler().whole<String>() {
                        @Override
                                public void onMessage(String message) {
                            writeMessage (message);
                        }
                    });
                }
            }, cec, new URI(wsUri));
        } catch (DeploymentException e) {
            e.printStackTrace();;
        }
    }
}
