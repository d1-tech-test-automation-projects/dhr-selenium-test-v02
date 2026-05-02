import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyLeavesTest extends BaseStep {

    @BeforeAll
    public static void setup() {
        openChromeDriver();
    }

    @AfterAll
    public static void tearDownAll() {
        BaseStep.driverQuit();
    }

    @Test
    @Order(161)
    @DisplayName("Tarayıcı Açılıyor")
    public void OpenDriver() {
        LogTest.info("Kullanıcı adı Input aranıyor");
        WebElement usernameInput = BaseStep.findElementXpathWithWait("//*[@id=\"login_email\"]", TimeOut.SHORT.value);
        BaseStep.clearAndType(usernameInput, "sudee20g@gmail.com", "Kullanıcı Adı");
        LogTest.info("Kullanıcı adı gönderildi");
        WebElement passwordInput = BaseStep.findElementXpathWithWait("//*[@id=\"login_password\"]", TimeOut.SHORT.value);
        LogTest.info("Parola Inputu bulunuyor");
        BaseStep.clearAndType(passwordInput, "Sudee20g!", "Şifre");
        LogTest.info("Parola gönderildi");
        LogTest.info("Giriş Yap butonu bulunuyor");
        WebElement loginClickButton = BaseStep.findElementXpathWithWait("(//button[@type='submit'])[1]", TimeOut.SHORT.value);
        BaseStep.clickElement(loginClickButton, "Giriş yap butonuna tıklandı");
    }
}
