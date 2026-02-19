import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.GameProgress;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.text.IsEmptyString.emptyString;

public class MainTest {

    @Test
    @DisplayName("Проверка создания объектов прогресса")
    public void testGameProgressCreation() {
        GameProgress save1 = new GameProgress(100, 1, 1, 100);
        GameProgress save2 = new GameProgress(90, 2, 2, 200);

        // Строка не пуста
        assertThat(save1.toString(), not(emptyString()));
        assertThat(save2.toString(), not(emptyString()));


        // Значения в наличии
        assertThat(save1.toString(), containsString("health=100"));
        assertThat(save2.toString(), containsString("health=90"));
        assertThat(save1.toString(), containsString("weapons=1"));
        assertThat(save2.toString(), containsString("weapons=2"));

    }
}
