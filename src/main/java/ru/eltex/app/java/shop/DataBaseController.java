package ru.eltex.app.java.shop;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataBaseController {
    private Random random = new Random();
    private LinkedList<String> wordsList = new LinkedList<>();

    public String getRandomString() {
        return wordsList.get(random.nextInt(wordsList.size() - 1) + 1);
    }

    private File openFile(String file_path) {
        File path = new File(file_path);
        if (path.exists())
            return path;
        else {
            System.out.println("???? ?? ?????????? ???? ?? ??????????!");
            return null;
        }
    }

    public DataBaseController(String path) {
        File file = openFile(path);
        if (file != null)
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String read;
                while ((read = br.readLine()) != null) {
                    wordsList.add(read);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            } catch (IOException e) {
                System.out.println("I/O error.");
            }
        else
            System.out.println("Ошибка файла не существует!");
    }

}
