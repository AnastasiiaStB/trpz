package org.example.repository.impl;

import org.example.domain.Download;
import org.example.repository.IDownloadRepository;

import java.util.ArrayList;
import java.util.List;

public class DownloadRepository implements IDownloadRepository {
    @Override
    public Download save(Download download) {
        return download;
    }

    @Override
    public Download findById(Integer id) {
        return new Download();
    }

    @Override
    public List<Download> findActiveByUserId(Integer userId) {
        return new ArrayList<>();
    }

    @Override
    public void update(Download download) {
    }
}