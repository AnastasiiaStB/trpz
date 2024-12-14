package org.example.composite;

import java.util.ArrayList;
import java.util.List;

public class DownloadGroup implements DownloadComponent {
    private final String groupName;
    private final List<DownloadComponent> components = new ArrayList<>();

    public DownloadGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(DownloadComponent component) {
        components.add(component);
    }

    public void remove(DownloadComponent component) {
        components.remove(component);
    }

    @Override
    public void start() {
        System.out.println("Starting all downloads in group: " + groupName);
        for (DownloadComponent component : components) {
            component.start();
        }
    }

    @Override
    public void pause() {
        System.out.println("Pausing all downloads in group: " + groupName);
        for (DownloadComponent component : components) {
            component.pause();
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Details for group: " + groupName);
        for (DownloadComponent component : components) {
            component.showDetails();
        }
    }
}