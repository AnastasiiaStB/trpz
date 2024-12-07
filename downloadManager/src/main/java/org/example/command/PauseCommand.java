package org.example.command;

public class PauseCommand implements Command {
    private final DownloadManager manager;

    public PauseCommand(DownloadManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.pauseCurrent();
    }
}