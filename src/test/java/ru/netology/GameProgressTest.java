package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameProgressTest {

    @Test
    @DisplayName("Constructor should correctly initialize fields")
    void constructor_shouldSetFieldsCorrectly() {

        GameProgress progress = new GameProgress(100, 1, 1, 100);

        assertEquals(100, progress.getHealth());
        assertEquals(1, progress.getWeapons());
        assertEquals(1, progress.getLevel());
        assertEquals(100, progress.getDistance());
    }

    @Test
    @DisplayName("Different objects should keep independent values")
    void differentObjects_shouldStoreDifferentValues() {

        GameProgress save1 = new GameProgress(100, 1, 1, 100);
        GameProgress save2 = new GameProgress(90, 2, 2, 200);

        // Проверяем первый объект
        assertEquals(100, save1.getHealth());
        assertEquals(1, save1.getWeapons());
        assertEquals(1, save1.getLevel());
        assertEquals(100, save1.getDistance());

        // Проверяем второй объект
        assertEquals(90, save2.getHealth());
        assertEquals(2, save2.getWeapons());
        assertEquals(2, save2.getLevel());
        assertEquals(200, save2.getDistance());
    }
}