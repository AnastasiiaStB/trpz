package org.example.command;

import org.example.iterator.DownloadIterator;
import org.example.model.Download;
import org.example.model.DownloadStatus;

import java.util.List;

public class DownloadManager {
    private final List<Download> downloads;
    private DownloadIterator iterator;
    private Download currentDownload;

    public DownloadManager(List<Download> downloads) {
        this.downloads = downloads;
        setIterator(new DownloadIterator(downloads));
    }

    public void setIterator(DownloadIterator iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            currentDownload = iterator.next();
        } else {
            currentDownload = null;
        }
    }

    public Download getCurrentDownload() {
        return currentDownload;
    }

    public void moveToNext() {
        if (iterator.hasNext()) {
            currentDownload = iterator.next();
        } else {
            currentDownload = null;
            System.out.println("No more downloads.");
        }
    }

    public void startCurrent() {
        if (currentDownload != null) {
            currentDownload.setStatus(DownloadStatus.IN_PROGRESS);
            System.out.println("Started downloading: " + currentDownload.getFileName());
        } else {
            System.out.println("No current download to start.");
        }
    }

    public void pauseCurrent() {
        if (currentDownload != null && currentDownload.getStatus() == DownloadStatus.IN_PROGRESS) {
            currentDownload.setStatus(DownloadStatus.PAUSED);
            System.out.println("Paused downloading: " + currentDownload.getFileName());
        } else {
            System.out.println("No current download to pause or not in progress.");
        }
    }

    public void resumeCurrent() {
        if (currentDownload != null && currentDownload.getStatus() == DownloadStatus.PAUSED) {
            currentDownload.setStatus(DownloadStatus.IN_PROGRESS);
            System.out.println("Resumed downloading: " + currentDownload.getFileName());
        } else {
            System.out.println("No current download to resume or not paused.");
        }
    }

    public void cancelCurrent() {
        if (currentDownload != null) {
            currentDownload.setStatus(DownloadStatus.PENDING);
            System.out.println("Cancelled downloading: " + currentDownload.getFileName());
        } else {
            System.out.println("No current download to cancel.");
        }
    }
}