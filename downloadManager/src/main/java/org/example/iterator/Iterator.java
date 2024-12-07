package org.example.iterator;

import org.example.model.Download;

public interface Iterator {
    boolean hasNext();
    Download next();
}