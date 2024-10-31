package org.example.services;

import org.example.domain.Download;
import org.example.domain.PriorityLevel;

import java.util.List;

public interface IDownloadService {
    Download startDownload(Integer fileId, Integer userId);

    void pauseDownload(Integer downloadId);

    void resumeDownload(Integer downloadId);

    void setPriority(Integer downloadId, PriorityLevel level);

    List<Download> getActiveDownloads(Integer userId);
}