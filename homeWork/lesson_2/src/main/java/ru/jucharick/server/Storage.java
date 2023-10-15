package ru.jucharick.server;

public class Storage implements Repository{
    public static final String LOG_PATH = "./src/main/java/ru/jucharick/lesson_2/server/log.txt";


    @Override
    public void save(String log) {
    }

    @Override
    public String read() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }
}
