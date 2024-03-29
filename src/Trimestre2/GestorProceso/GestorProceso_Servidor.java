package Trimestre2.GestorProceso;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GestorProceso_Servidor {

    private final ServerSocket serverSocket;


    public GestorProceso_Servidor(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("(SERVIDOR) Conexion establecida");
            new GestorProceso(socket).start();
        }
    }

    public static void main(String[] args) {
        try {
            GestorProceso_Servidor servidor = new GestorProceso_Servidor(1028);
            servidor.stop();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
        System.out.println("(SERVIDOR) Conexiones cerradas.");
    }


}
