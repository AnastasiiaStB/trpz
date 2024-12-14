package org.example.composite;

import org.example.model.Download;

public class SingleDownload implements DownloadComponent {
    private final Download download;

    public SingleDownload(Download download) {
        this.download = download;
    }

    @Override
    public void start() {
        System.out.println("Starting download: " + download.getFileName());
    }

    @Override
    public void pause() {
        System.out.println("Pausing download: " + download.getFileName());
    }

    @Override
    public void showDetails() {
        System.out.println("Download details: " + download.getFileName() + " from " + download.getUrl());
    }
}