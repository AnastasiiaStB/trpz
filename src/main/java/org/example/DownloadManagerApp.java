package org.example;

import org.example.command.*;
import org.example.model.Download;
import org.example.model.DownloadStatus;

import java.util.Arrays;

public class DownloadManagerApp {
    public static void main(String[] args) {
        Download file1 = new Download("file1.zip", "https://example.com/file1.zip", 100, DownloadStatus.PENDING, 0);
        Download file2 = new Download("file2.zip", "https://example.com/file2.zip", 200, DownloadStatus.PENDING, 0);

        DownloadManager manager = new DownloadManager(Arrays.asList(file1, file2));
        CommandInvoker invoker = new CommandInvoker();

        Command startCommand = new StartCommand(manager);
        Command pauseCommand = new PauseCommand(manager);
        Command resumeCommand = new ResumeCommand(manager);
        Command cancelCommand = new CancelCommand(manager);

        invoker.executeCommand(startCommand);
        invoker.executeCommand(pauseCommand);
        invoker.executeCommand(resumeCommand);
        invoker.executeCommand(cancelCommand);

        manager.moveToNext();

        invoker.executeCommand(startCommand);
    }
}