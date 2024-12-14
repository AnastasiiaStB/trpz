package org.example;

import org.example.p2p.DownloadManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DownloadManagerApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter P2P server port:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int port = Integer.parseInt(reader.readLine());

        DownloadManager manager = new DownloadManager(port);
        System.out.println("Download Manager with P2P Server Started.");
        System.out.println("Commands: ADD [URL] [FILE], PAUSE [ID], RESUME [ID], SHOW, SEND [FILE] [HOST] [PORT], EXIT");

        while (true) {
            String input = reader.readLine();
            String[] parts = input.split(" ", 4);

            switch (parts[0].toUpperCase()) {
                case "ADD":
                    manager.addDownload(parts[1], parts[2]);
                    break;
                case "PAUSE":
                    manager.pauseDownload(parts[1]);
                    break;
                case "RESUME":
                    manager.resumeDownload(parts[1]);
                    break;
                case "SHOW":
                    manager.showStatistics();
                    break;
                case "SEND":
                    manager.sendFile(parts[1], parts[2], Integer.parseInt(parts[3]));
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}