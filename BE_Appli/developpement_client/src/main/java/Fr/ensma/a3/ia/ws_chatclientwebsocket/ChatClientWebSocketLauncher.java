package Fr.ensma.a3.ia.ws_chatclientwebsocket;

import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.glassfish.tyrus.client.ClientManager;

import jakarta.websocket.Session;
public class ChatClientWebSocketLauncher {
    private static CountDownLatch messageLatch = new CountDownLatch(1);
    public static void main (String[] args) {
        try {
            ClientMAnager client = ClientMAnager.createClient();
            Session currentSession = client.connectToServer( new ChatClientEndpoint (messageLatch)),
                    new URI("AJOUTER L'ADRESSE DE CONNECTION"));
            currentSession.getBasicRemote().sendText("My First Message");
            messageLatch.await(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
