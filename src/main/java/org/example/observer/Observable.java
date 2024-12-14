package org.example.observer;

import org.example.model.Download;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(Download download) {
        for (Observer observer : observers) {
            observer.update(download);
        }
    }
}