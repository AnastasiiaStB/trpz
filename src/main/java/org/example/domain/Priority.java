package org.example.domain;

public class Priority {
    private PriorityLevel priorityLevel;
    private Integer speedLimit;

    public void updatePriorityLevel(PriorityLevel level) {
        this.priorityLevel = level;
    }
}