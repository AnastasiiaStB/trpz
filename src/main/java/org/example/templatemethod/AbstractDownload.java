package org.example.templatemethod;

import org.example.model.Download;

public abstract class AbstractDownload {
    protected Download download;

    public AbstractDownload(Download download) {
        this.download = download;
    }

    public final void executeDownload() {
        establishConnection();
        authenticate();
        downloadFile();
        closeConnection();
    }

    protected void establishConnection() {
        System.out.println("Connecting to " + download.getUrl());
    }

    protected abstract void authenticate();

    protected abstract void downloadFile();

    protected void closeConnection() {
        System.out.println("Closing connection for " + download.getUrl());
    }
}