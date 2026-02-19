package ru.netology;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Installer {

    public static String installPath = "C:\\Users\\admin\\IdeaProjects";

    public static void install() {


        StringBuilder log = new StringBuilder();

        // Создаются папки src, res, savegames, temp

        File src = new File(installPath + "/src");
        File res = new File(installPath + "/res");
        File savegames = new File(installPath + "/savegames");
        File temp = new File(installPath + "/temp");

        if (src.mkdir()) log.append("Папка src создана");
        if (res.mkdir()) log.append("Папка res создана");
        if (savegames.mkdir()) log.append("Папка savegames создана");
        if (temp.mkdir()) log.append("Папка temp создана");

        // В каталоге src создаются две директории: main, test
        File main = new File(src, "main");
        File test = new File(src, "test");

        if (main.mkdir()) log.append("Папка main создана");
        if (test.mkdir()) log.append("Папка test создана");

        // В подкаталоге main создаются два файла: Main.java, Utils.java
        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");

        try {
            if (mainJava.createNewFile())
                log.append("Файл Main.java создан");

            if (utilsJava.createNewFile())
                log.append("Файл Utils.java создан");

        } catch (IOException e) {
            log.append("Ошибка при создании файлов в main");
            e.printStackTrace();
        }

        // В каталог res создаются три директории: drawables, vectors, icons
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");

        if (drawables.mkdir()) log.append("Папка drawables создана");
        if (vectors.mkdir()) log.append("Папка vectors создана");
        if (icons.mkdir()) log.append("Папка icons создана");

        // В директории temp создается файл temp.txt
        File tempFile = new File(temp, "temp.txt");

        try {
            if (tempFile.createNewFile())
                log.append("Файл temp.txt создан");

            // Запись лога в temp.txt
            FileWriter writer = new FileWriter(tempFile);
            writer.write(log.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Установка завершена!");
    }


}
