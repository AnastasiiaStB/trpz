package org.example;

import org.example.iterator.DownloadIterator;
import org.example.iterator.Iterator;
import org.example.model.Download;
import org.example.model.DownloadStatus;

import java.util.ArrayList;
import java.util.List;

public class DownloadManagerApp {
    public static void main(String[] args) {
        List<Download> downloads = new ArrayList<>();
        downloads.add(new Download("file1.zip", "http://example.com/file1.zip", 1000, DownloadStatus.IN_PROGRESS, 50.0));
        downloads.add(new Download("file2.zip", "http://example.com/file2.zip", 2000, DownloadStatus.COMPLETED, 100.0));
        downloads.add(new Download("file3.zip", "http://example.com/file3.zip", 1500, DownloadStatus.PAUSED, 25.0));

        Iterator iterator = new DownloadIterator(downloads);

        System.out.println("Downloads:");
        while (iterator.hasNext()) {
            Download download = iterator.next();
            System.out.println("File: " + download.getFileName() +
                    ", Status: " + download.getStatus() +
                    ", Progress: " + download.getProgress() + "%");
        }
    }
}