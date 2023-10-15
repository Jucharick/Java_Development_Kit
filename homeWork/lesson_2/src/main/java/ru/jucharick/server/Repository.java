package ru.jucharick.server;

public interface Repository {
    void save(String log);
    String read();
}
