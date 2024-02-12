package Fr.ensma.a3.ia.ws_chatclientwebsocket;

import jdk.internal.org.jline.terminal.TerminalBuilder;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@ClientEndpoint
public class ChatClientEndpoint {
    private CountDownLatch countDownLatch;

    public ChatClientEndpoint(CountDownLatch pCountDownLatch) {
        this.countDownLatch = pCountDownLatch;
    }

    @OnOpen
    public void onOpen (Session session) throws IOException {}

    @OnOpen
    public void onMessage(String message){
        System.out.println("Received message: " + message);
        countDownLatch.countDown();
    }
}
