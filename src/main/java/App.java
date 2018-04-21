import java.io.IOException;
import java.net.URI;

import javax.websocket.DeploymentException;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;
import org.glassfish.tyrus.server.Server;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    
    public static void main(String[] args) {
        if (args[0] == null) {
            System.exit(1);
        } else if (args[0].equals("server")) {
            startServer();
            
        } else if (args[0].equals("client")) {
            startClient();
        }
    }

    private static void startServer() {
        Server server = new Server("localhost", 9999, "/ws", null, EndPoint.class);
        try {
            server.start();
            System.in.read();
        } catch (DeploymentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            server.stop();
        }

    }

    private static void startClient() {
        ClientManager client = ClientManager.createClient();
        URI path = URI.create("ws://localhost:9999/ws/echo");
        Session session;
		try {
            session = client.connectToServer(Client.class, path);
            while(session.isOpen()) {
                Thread.sleep(1000);
                session.getBasicRemote().sendText("Hello!");
            }
		} catch (DeploymentException | IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
