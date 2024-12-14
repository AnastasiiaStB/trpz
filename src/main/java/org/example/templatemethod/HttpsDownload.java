package org.example.templatemethod;

import org.example.model.Download;

public class HttpsDownload extends AbstractDownload {
    public HttpsDownload(Download download) {
        super(download);
    }

    @Override
    protected void authenticate() {
        System.out.println("Authenticating via SSL for HTTPS connection.");
    }

    @Override
    protected void downloadFile() {
        System.out.println("Downloading file via HTTPS from " + download.getUrl());
    }
}