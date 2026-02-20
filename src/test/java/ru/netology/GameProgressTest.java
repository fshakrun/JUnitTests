package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;

public class GameProgressTest {

    @Test
    @DisplayName("Game Progress String Content Test")
    public void testToString() {
        GameProgress progress = new GameProgress(94, 2, 5, 254.12);
        String result = progress.toString();

        // Все в наличии
        assertThat(result, allOf(
                containsString("health=94"),
                containsString("weapons=2"),
                containsString("lvl=5"),
                containsString("distance=254.12")
        ));
    }
}

