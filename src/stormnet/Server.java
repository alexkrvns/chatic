package stormnet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;


    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4115);
                System.out.println("\n" + "Server is running!");
                clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine();
                    System.out.println(word);

                    out.write("Hi, this is the Server! I confirm, what you wrote : " + word + "\n");
                    out.flush();

                } finally {
                    System.out.println("dfjkhgkdf");
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("\n" + "Server is closed!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

