package ru.netology;

import ru.netology.Installer;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {

        Installer.install();
        String saveGamesPath = "C:\\Users\\admin\\IdeaProjects\\savegames\\";

        // 1. 3 Экземпляра класса
        GameProgress save1 = new GameProgress(100, 1, 1, 100);
        GameProgress save2 = new GameProgress(90, 2, 2, 200);
        GameProgress save3 = new GameProgress(80, 3, 3, 300);

        // 2. Файлы
        saveGame(saveGamesPath + "save1.dat", save1);
        saveGame(saveGamesPath + "save2.dat", save2);
        saveGame(saveGamesPath + "save3.dat", save3);

        // 3. Архивация
        List<String> files = List.of(
                saveGamesPath + "save1.dat",
                saveGamesPath + "save2.dat",
                saveGamesPath + "save3.dat"
        );

        zipFiles(saveGamesPath + "saves.zip", files);

        // 4. Удаляем исходные файлы
        for (String path : files) {
            new File(path).delete();
        }

        System.out.println("Готово!");
    }

    // Методы
    public static void saveGame(String path, GameProgress progress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(progress);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipFiles(String zipPath, List<String> files) {

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))) {

            for (String filePath : files) {

                try (FileInputStream fis = new FileInputStream(filePath)) {

                    ZipEntry entry = new ZipEntry(new File(filePath).getName());
                    zos.putNextEntry(entry);

                    byte[] buffer = new byte[1024];
                    int length;

                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                    }

                    zos.closeEntry();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}