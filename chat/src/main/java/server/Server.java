package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final static int PORT = 8189;
    private Socket socket;
    private InputStream inputStream;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.startServer();
            server.readFromClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT);) {
            System.out.println("Server started");
            socket = serverSocket.accept();
            System.out.println("New client");
        }
    }

    public void readFromClient() throws IOException {
        inputStream = socket.getInputStream();
        in = new DataInputStream(inputStream);
        String inMessage = in.readUTF();
        System.out.println(inMessage);
    }
}
