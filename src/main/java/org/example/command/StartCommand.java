package org.example.command;

public class StartCommand implements Command {
    private final DownloadManager manager;

    public StartCommand(DownloadManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.startCurrent();
    }
}