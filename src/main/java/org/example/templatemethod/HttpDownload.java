package org.example.templatemethod;

import org.example.model.Download;

public class HttpDownload extends AbstractDownload {
    public HttpDownload(Download download) {
        super(download);
    }

    @Override
    protected void authenticate() {
        System.out.println("HTTP download does not require authentication.");
    }

    @Override
    protected void downloadFile() {
        System.out.println("Downloading file via HTTP from " + download.getUrl());
    }
}