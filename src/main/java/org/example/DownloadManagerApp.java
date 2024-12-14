package org.example;

import org.example.composite.DownloadGroup;
import org.example.composite.SingleDownload;
import org.example.model.Download;
import org.example.model.DownloadStatus;
import org.example.templatemethod.AbstractDownload;
import org.example.templatemethod.FtpDownload;
import org.example.templatemethod.HttpDownload;
import org.example.templatemethod.HttpsDownload;

public class DownloadManagerApp {
    public static void main(String[] args) {
        Download httpFile = new Download("file1.txt", "http://example.com/file1", 1024, DownloadStatus.PENDING, 0.0);
        Download httpsFile = new Download("file2.txt", "https://secure.com/file2", 2048, DownloadStatus.PENDING, 0.0);
        Download ftpFile = new Download("file3.txt", "ftp://ftpserver.com/file3", 4096, DownloadStatus.PENDING, 0.0);

        SingleDownload httpDownload = new SingleDownload(httpFile);
        SingleDownload httpsDownload = new SingleDownload(httpsFile);
        SingleDownload ftpDownload = new SingleDownload(ftpFile);

        DownloadGroup httpGroup = new DownloadGroup("HTTP Downloads");
        httpGroup.add(httpDownload);
        httpGroup.add(httpsDownload);

        DownloadGroup allDownloads = new DownloadGroup("All Downloads");
        allDownloads.add(httpGroup);
        allDownloads.add(ftpDownload);
        
        allDownloads.showDetails();
        allDownloads.start();
        allDownloads.pause();
    }
}