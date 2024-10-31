package org.example.repository;

import org.example.domain.Download;

import java.util.List;

public interface IDownloadRepository {
    Download save(Download download);
    Download findById(Integer id);
    List<Download> findActiveByUserId(Integer userId);
    void update(Download download);
}