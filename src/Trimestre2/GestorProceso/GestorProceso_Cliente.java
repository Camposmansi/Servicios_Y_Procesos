package Trimestre2.GestorProceso;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class GestorProceso_Cliente {

    private final String serverIP;
    private final int serverPort;
    private Socket socket;
    private InputStream is;

    public GestorProceso_Cliente(String serverIP, int serverPort) {
        super();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public static void main(String[] args) {
        String serverIP = "localhost";
        int serverPort = 1028;

        GestorProceso_Cliente servidor = new GestorProceso_Cliente(serverIP, serverPort);

        try {
            servidor.start();
            System.out.println("Mensaje del servidor: " + servidor.is.read());
            servidor.stop();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
    }

    public void start() throws IOException {
        System.out.println("(CLIENTE) Conectando a la conexion...");
        socket = new Socket(serverIP, serverPort);
        is = socket.getInputStream();
        System.out.println("(CLIENTE) Conexion establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(CLIENTE) Cerrando conexiones...");
        is.close();
        socket.close();
        System.out.println("(CLIENTE) Conexiones cerradas.");
    }
}
