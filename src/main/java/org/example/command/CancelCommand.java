package org.example.command;

public class CancelCommand implements Command {
    private final DownloadManager manager;

    public CancelCommand(DownloadManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.cancelCurrent();
    }
}