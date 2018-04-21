import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class Client {

    static boolean connected = false;

    @OnError
    public void onError(Session session, Throwable cause) {
        System.out.println("error : " + session.getId() + ", " + cause.getMessage());
    }

    @OnMessage
    public void onMessage(String msg, Session session) {
        System.out.println("onMessage : " + msg);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println("closed");
        connected = false;
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("opened");
    }
}