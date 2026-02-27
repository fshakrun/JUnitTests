package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class InstallerTest {

    @TempDir
    Path tempDir;

    @Test
    @DisplayName("Installer should create full project structure and write log")
    void install_shouldCreateStructureAndLog() throws IOException {

        // Подменяем путь установки
        Installer.installPath = tempDir.toString();

        // Вызов
        Installer.install();

        // Проверка корневых директорий
        assertTrue(Files.isDirectory(tempDir.resolve("src")));
        assertTrue(Files.isDirectory(tempDir.resolve("res")));
        assertTrue(Files.isDirectory(tempDir.resolve("savegames")));
        assertTrue(Files.isDirectory(tempDir.resolve("temp")));

        // Проверка src/main и src/test
        assertTrue(Files.isDirectory(tempDir.resolve("src/main")));
        assertTrue(Files.isDirectory(tempDir.resolve("src/test")));

        // Проверка файлов в main
        assertTrue(Files.isRegularFile(tempDir.resolve("src/main/Main.java")));
        assertTrue(Files.isRegularFile(tempDir.resolve("src/main/Utils.java")));

        // Проверка папок в res
        assertTrue(Files.isDirectory(tempDir.resolve("res/drawables")));
        assertTrue(Files.isDirectory(tempDir.resolve("res/vectors")));
        assertTrue(Files.isDirectory(tempDir.resolve("res/icons")));

        // Проверка лога
        Path logPath = tempDir.resolve("temp/temp.txt");
        assertTrue(Files.isRegularFile(logPath));

        String content = Files.readString(logPath);

        assertNotNull(content);
        assertFalse(content.isBlank());
        assertTrue(content.contains("src"));
        assertTrue(content.contains("Main.java"));
    }
}