package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer userId;
    private String username;
    private String email;
    private String status;

    public List<Download> getActiveDownloads() {
        return new ArrayList<>();
    }
}
