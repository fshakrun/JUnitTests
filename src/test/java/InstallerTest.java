import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.Installer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.netology.Installer.installPath;


public class InstallerTest {

    Installer installer = new Installer();

    @Test
    @DisplayName("Installation Path Test")
    public void testInstallPath() {

        // Путь не пустой
        assertThat(installPath, notNullValue());

        // Точное совпадение
        assertThat(installPath, equalTo("C:\\Users\\admin\\IdeaProjects"));

        // Путь содержит ту или иную папку
        assertThat(installPath, containsString("admin"));
        assertThat(installPath, containsString("IdeaProjects"));

        // Путь начинается с определенного значения
        assertThat(installPath, startsWith("C:\\Users"));

        // Путь заканчивается на определенное значение
        assertThat(installPath, endsWith("IdeaProjects"));

        // Путь не содержит определенных значений
        assertThat(installPath,not("D:\\Users\\admin\\IdeaProjects"));

    }

}
