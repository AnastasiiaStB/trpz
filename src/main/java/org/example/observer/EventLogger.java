package org.example.observer;

import org.example.model.Download;

public class EventLogger implements Observer {
    @Override
    public void update(Download download) {
        System.out.println("[LOG] File: " + download.getFileName() +
                           " | Status: " + download.getStatus() +
                           " | Progress: " + download.getProgress() + "%");
    }
}