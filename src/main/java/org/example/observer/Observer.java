package org.example.observer;

import org.example.model.Download;

public interface Observer {
    void update(Download download);
}
