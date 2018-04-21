import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public  class EndPoint {

    @OnOpen
    public void OnOpen(Session session) {
        System.out.println("[open]");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("[" + message + "] ");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("[close]");
    }
}