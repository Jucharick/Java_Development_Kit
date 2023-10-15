package ru.jucharick.server;

import java.io.FileWriter;
import java.io.FileReader;

public class Storage implements Repository{
    public static final String PATH = "./src/main/java/ru/jucharick/server/log.txt";


    @Override
    public void save(String log) {
        try (FileWriter writer = new FileWriter(PATH, true)){
            writer.write(log);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
