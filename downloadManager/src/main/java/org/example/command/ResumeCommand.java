package org.example.command;

public class ResumeCommand implements Command {
    private final DownloadManager manager;

    public ResumeCommand(DownloadManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.resumeCurrent();
    }
}