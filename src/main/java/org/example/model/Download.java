package org.example.model;

import org.example.observer.Observable;

public class Download extends Observable {
    private String fileName;
    private String url;
    private long fileSize;
    private DownloadStatus status;
    private double progress;

    public Download(String fileName, String url, long fileSize, DownloadStatus status, double progress) {
        this.fileName = fileName;
        this.url = url;
        this.fileSize = fileSize;
        this.status = status;
        this.progress = progress;
    }

    public String getFileName() {
        return fileName;
    }

    public String getUrl() {
        return url;
    }

    public long getFileSize() {
        return fileSize;
    }

    public DownloadStatus getStatus() {
        return status;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        if (progress < 0 || progress > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100");
        }
        this.progress = progress;
        notifyObservers(this);
    }

    public void setStatus(DownloadStatus status) {
        this.status = status;
        notifyObservers(this);
    }
}