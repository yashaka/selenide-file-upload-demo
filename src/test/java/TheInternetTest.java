import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TheInternetTest {
    @Test
    void fileUpload() {
        // GIVEN
        open("https://the-internet.herokuapp.com/upload");
        executeJavaScript(
                "document.getElementById('file-upload').style.display = 'none'"
        );
        $("#file-upload").shouldBe(hidden);

        // WHEN
        $("#file-upload").uploadFromClasspath("temp.txt");
        $("#file-submit").click();

        // THEN
        $("#uploaded-files").shouldHave(text("temp.txt"));
    }
}
