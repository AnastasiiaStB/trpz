package org.example.p2p;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class P2PClient {
    private final int port;

    public P2PClient( int port) {
        this.port = port;
    }

    public void startServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("P2P Server started on port: " + port);
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void sendFile(String filePath, String address, int port) {
        new Thread(() -> {
            try (Socket socket = new Socket(address, port);
                 OutputStream out = socket.getOutputStream();
                 FileInputStream fileInputStream = new FileInputStream(filePath)) {

                System.out.println("Sending file: " + filePath + " to " + address + ":" + port);

                byte[] filePathBytes = filePath.getBytes(StandardCharsets.UTF_8);
                out.write(filePathBytes.length);
                out.write(filePathBytes);
                out.flush();

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                System.out.println("File sent successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void handleClient(Socket clientSocket) {
        try (InputStream in = clientSocket.getInputStream()) {
            int filePathLength = in.read();
            if (filePathLength == -1) {
                System.out.println("Error: File path length not received.");
                return;
            }

            byte[] filePathBytes = new byte[filePathLength];
            in.read(filePathBytes);
            String filePath = new String(filePathBytes, StandardCharsets.UTF_8);

            System.out.println("Receiving file: " + filePath + " from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

            String outputFileName = "received_" + filePath.substring(filePath.lastIndexOf("/") + 1);
            try (FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("File received successfully. Saved as " + outputFileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
