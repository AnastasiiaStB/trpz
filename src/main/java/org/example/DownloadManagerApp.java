package org.example;

import org.example.command.*;
import org.example.model.Download;
import org.example.model.DownloadStatus;
import org.example.observer.EventLogger;
import org.example.observer.ProgressDisplay;

import java.util.Arrays;

public class DownloadManagerApp {
    public static void main(String[] args) {
        Download download = new Download("file1.zip", "http://example.com/file1.zip", 1000, DownloadStatus.PENDING, 0);

        ProgressDisplay progressDisplay = new ProgressDisplay();
        EventLogger eventLogger = new EventLogger();

        download.addObserver(progressDisplay);
        download.addObserver(eventLogger);

        download.setStatus(DownloadStatus.IN_PROGRESS);
        download.setProgress(25.0);
        download.setProgress(50.0);
        download.setStatus(DownloadStatus.COMPLETED);
    }
}