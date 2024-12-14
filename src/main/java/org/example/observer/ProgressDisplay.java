package org.example.observer;

import org.example.model.Download;

public class ProgressDisplay implements Observer {
    @Override
    public void update(Download download) {
        System.out.println("Download updated: " + download.getFileName() +
                           " | Status: " + download.getStatus() +
                           " | Progress: " + download.getProgress() + "%");
    }
}