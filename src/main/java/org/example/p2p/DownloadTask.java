package org.example.p2p;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class DownloadTask implements Runnable {
    private final String id;
    private final String url;
    private final String outputFile;
    private volatile boolean paused = false;
    private volatile boolean running = true;
    private long downloadedSize = 0;
    private long totalSize = -1;

    public DownloadTask(String url, String outputFile) {
        this.id = UUID.randomUUID().toString();
        this.url = url;
        this.outputFile = outputFile;
    }

    public String getId() {
        return id;
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
        synchronized (this) {
            notify();
        }
    }

    public String getStatistics() {
        return String.format("ID: %s, URL: %s, Downloaded: %d/%d bytes", id, url, downloadedSize, totalSize);
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            totalSize = connection.getContentLength();
            byte[] dataBuffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                synchronized (this) {
                    while (paused) {
                        wait();
                    }
                }
                if (!running) break;

                fileOutputStream.write(dataBuffer, 0, bytesRead);
                downloadedSize += bytesRead;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}