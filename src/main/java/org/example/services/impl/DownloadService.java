package org.example.services.impl;

import org.example.domain.Download;
import org.example.domain.PriorityLevel;
import org.example.repository.IDownloadRepository;
import org.example.services.IDownloadService;

import java.util.List;

public class DownloadService implements IDownloadService {
    private IDownloadRepository downloadRepository;

    public DownloadService(IDownloadRepository downloadRepository) {
        this.downloadRepository = downloadRepository;
    }

    @Override
    public Download startDownload(Integer fileId, Integer userId) {
        return new Download();
    }

    @Override
    public void pauseDownload(Integer downloadId) {
    }

    @Override
    public void resumeDownload(Integer downloadId) {
    }

    @Override
    public void setPriority(Integer downloadId, PriorityLevel level) {
    }

    @Override
    public List<Download> getActiveDownloads(Integer userId) {
        return downloadRepository.findActiveByUserId(userId);
    }
}