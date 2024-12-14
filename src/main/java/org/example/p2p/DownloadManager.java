package org.example.p2p;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager {
    private final Map<String, DownloadTask> tasks = new ConcurrentHashMap<>();
    private final P2PClient p2pClient;

    public DownloadManager(int p2pPort) {
        this.p2pClient = new P2PClient(p2pPort);
        this.p2pClient.startServer();
    }

    public void addDownload(String url, String outputFile) {
        DownloadTask task = new DownloadTask(url, outputFile);
        tasks.put(task.getId(), task);
        new Thread(task).start();
    }

    public void pauseDownload(String id) {
        tasks.get(id).pause();
    }

    public void resumeDownload(String id) {
        tasks.get(id).resume();
    }

    public void sendFile(String filePath, String address, int port) {
        p2pClient.sendFile(filePath, address, port);
    }

    public void showStatistics() {
        tasks.values().forEach(task -> System.out.println(task.getStatistics()));
    }
}