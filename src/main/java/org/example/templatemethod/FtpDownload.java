package org.example.templatemethod;

import org.example.model.Download;

public class FtpDownload extends AbstractDownload {
    public FtpDownload(Download download) {
        super(download);
    }

    @Override
    protected void authenticate() {
        System.out.println("Authenticating with FTP credentials.");
    }

    @Override
    protected void downloadFile() {
        System.out.println("Downloading file via FTP from " + download.getUrl());
    }
}