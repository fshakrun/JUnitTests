package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("saveGame should create non-empty save file")
    void saveGame_shouldCreateNonEmptyFile(@TempDir Path tempDir) throws IOException {

        Path savePath = tempDir.resolve("save1.dat");
        GameProgress original = new GameProgress(100, 1, 1, 100);

        Main.saveGame(savePath.toString(), original);

        // Файл создан и не пустой
        assertTrue(Files.isRegularFile(savePath));
        assertTrue(Files.size(savePath) > 0);
    }

    @Test
    @DisplayName("zipFiles should create zip with all given files")
    void zipFiles_shouldCreateZipWithAllFiles(@TempDir Path tempDir) throws IOException {

        // Создаём тестовые файлы
        Path file1 = tempDir.resolve("file1.txt");
        Path file2 = tempDir.resolve("file2.txt");

        Files.writeString(file1, "first");
        Files.writeString(file2, "second");

        Path zipPath = tempDir.resolve("test.zip");

        // Вызов тестируемого метода
        Main.zipFiles(zipPath.toString(), List.of(
                file1.toString(),
                file2.toString()
        ));

        // Проверяем, что zip создан и не пустой
        assertTrue(Files.isRegularFile(zipPath));
        assertTrue(Files.size(zipPath) > 0);

        // Проверяем, что внутри архива есть оба файла
        boolean hasFile1 = false;
        boolean hasFile2 = false;

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath.toFile()))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals(file1.getFileName().toString())) {
                    hasFile1 = true;
                }
                if (entry.getName().equals(file2.getFileName().toString())) {
                    hasFile2 = true;
                }
            }
        }

        assertTrue(hasFile1, "Zip archive should contain file1.txt");
        assertTrue(hasFile2, "Zip archive should contain file2.txt");
    }
}

