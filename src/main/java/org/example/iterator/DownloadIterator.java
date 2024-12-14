package org.example.iterator;

import org.example.model.Download;

import java.util.List;

public class DownloadIterator implements Iterator {
    private final List<Download> downloads;
    private int position = 0;

    public DownloadIterator(List<Download> downloads) {
        this.downloads = downloads;
    }

    @Override
    public boolean hasNext() {
        return position < downloads.size();
    }

    @Override
    public Download next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        return downloads.get(position++);
    }
}