package stormnet;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class Client {

    private static Socket clientSocket; 
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static String call()

    {
        FileInputStream fis;
        Properties property = new Properties();



        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            String host = property.getProperty("db.host");

            System.out.println("HOST: " + host
            );

          return host;


        } catch (IOException e) {
            System.err.println("\n" + "ERROR: No properties file! \"");
            return null;
        }



    }

    public static void main(String[] args) {



        try {
            try {
                clientSocket = new Socket( "localhost", 4115);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("\n" + "Did you want to say something? Enter it here:");
                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                String serverWord = in.readLine();
                System.out.println(serverWord);
            } finally {
                System.out.println("\n" + "The client was closed ...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}

