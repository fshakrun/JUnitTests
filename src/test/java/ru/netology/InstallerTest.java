package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InstallerTest {

    @Test
    @DisplayName("Installer.install() test")
    public void testInstallMethodInvocation() {

        // Вызов
        Installer installer = new Installer();
        installer.install(); 

        // Наличие папок
        File baseDir = new File(Installer.installPath);
        assertThat(new File(baseDir, "src").exists(), is(true));
        assertThat(new File(baseDir, "res").exists(), is(true));
        assertThat(new File(baseDir, "savegames").exists(), is(true));
        assertThat(new File(baseDir, "temp").exists(), is(true));
    }

    @Test
    @DisplayName("Installation Path Test")
    public void testInstallPath() {

        String path = Installer.installPath;

        // Путь не пустой
        assertThat(path, notNullValue());

        // Точное совпадение
        assertThat(path, equalTo("C:\\Users\\admin\\IdeaProjects"));

        // Путь содержит ту или иную папку
        assertThat(path, containsString("admin"));
        assertThat(path, containsString("IdeaProjects"));

        // Путь начинается с определенного значения
        assertThat(path, startsWith("C:\\Users"));

        // Путь заканчивается на определенное значение
        assertThat(path, endsWith("IdeaProjects"));

        // Путь не содержит определенных значений
        assertThat(path, not("D:\\Users\\admin\\IdeaProjects"));
    }

}

