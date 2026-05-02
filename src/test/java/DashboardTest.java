import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DashboardTest extends BaseStep {

        @BeforeAll
        public static void setup() {
                openChromeDriver();
        }

        @AfterAll
        public static void tearDownAll() {
                BaseStep.driverQuit();
        }

        private static final String CARD_ROW_XPATH = "//div[contains(@class,'ant-row') and contains(@class,'mb-4')]";

        @Test
        @Order(1)
        @DisplayName("Tarayıcı Açılıyor")
        public void OpenDriver() {
                LogTest.info("Kullanıcı adı Input aranıyor");
                WebElement usernameInput = BaseStep.findElementXpathWithWait("//*[@id=\"login_email\"]",
                                TimeOut.SHORT.value);
                BaseStep.clearAndType(usernameInput, "sudee20g@gmail.com", "Kullanıcı Adı");
                LogTest.info("Kullanıcı adı gönderildi");
                WebElement passwordInput = BaseStep.findElementXpathWithWait("//*[@id=\"login_password\"]",
                                TimeOut.SHORT.value);
                LogTest.info("Parola Inputu bulunuyor");
                BaseStep.clearAndType(passwordInput, "Sudee20g!", "Şifre");
                LogTest.info("Parola gönderildi");
                LogTest.info("Giriş Yap butonu bulunuyor");
                WebElement loginClickButton = BaseStep.findElementXpathWithWait("(//button[@type='submit'])[1]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(loginClickButton, "Giriş yap butonuna tıklandı");
        }

        @Test
        @Order(2)
        @DisplayName("Dashboard sayfası açılıyor")
        public void dashboardPageTotalEmployeeCard() {
                LogTest.info("Dashboard sayfası testlerine başlanıyor.");
                LogTest.info("Toplam Çalışan kartının elementi bulunuyor.");
                WebElement totalEmployeeCard = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[1]",
                                TimeOut.SHORT.value);
                LogTest.info("Toplam Çalışan kartının elementi bulundu");
                BaseStep.clickElement(totalEmployeeCard, "Toplam Çalışan kartına tıklandı");
                LogTest.info("Toplam Çalışan kartının elementine tıklandı");
                BaseStep.waitSeconds(1);
                LogTest.info("Dashboard sayfasına gitmek için Url metoduna tıklandı.");
                BaseStep.navigateToUrl("https://dhrtest.d1-tech.com.tr/dashboard");
                BaseStep.waitSeconds(1);
                LogTest.info("Dashboard sayfasına geri dönüldü");
        }

        @Test
        @Order(3)
        @DisplayName("Pasif Çalışanlar Kartı Test Ediliyor")
        public void dashboardPagePassiveEmployeeCard() {
                LogTest.info("Pasif Çalışanlar kart elementi aranıyor");
                BaseStep.waitSeconds(1);
                WebElement passiveEmployeeCard = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[2]",
                                TimeOut.SHORT.value);
                LogTest.info("Pasif Çalışanlar kartına tıklanıyor");
                BaseStep.clickElement(passiveEmployeeCard, "Pasif Çalışanlar kartına tıklandı");
                LogTest.info("Pasif Çalışanlar kartına tıklandı");
                LogTest.info("Pasif Çalışanlar Popup Açıldı");
                BaseStep.waitSeconds(1);
                WebElement passiveEmployeePopupCloseButton = BaseStep.findElementXpathWithWait(
                                "//button[@aria-label='Close']", TimeOut.SHORT.value);
                LogTest.info("Pasif Çalışanlar popup kapat butonu bulundu");
                BaseStep.clickElement(passiveEmployeePopupCloseButton, "Pasif Çalışanlar popup kapatıldı");
                LogTest.info("Pasif Çalışanlar Popup kapatıldı");
        }

        @Test
        @Order(4)
        @DisplayName("Departman Kartı Test Ediliyor")
        public void dashboardPageDepartmentCard() {
                LogTest.info("Dashboard sayfasına dönüldü");
                LogTest.info("Departman kartının elementi bulunuyor");
                WebElement departmentButton = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[3]",
                                TimeOut.SHORT.value);
                LogTest.info("Departman kartının elementi bulundu");
                BaseStep.clickElement(departmentButton, "Departmanlar kartına tıklandı");
                BaseStep.waitSeconds(1);
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.ESCAPE).perform();
                LogTest.info("ESC ile kapatma denendi");
        }

        @Test
        @Order(5)
        @DisplayName("Boş Pozisyonlar Kartı Test Ediliyor")
        public void dashboardPageVacantEmployeeCard() {
                LogTest.info("Boş Pozisyonlar kart elementi bulunuyor");
                WebElement vacantEmployeeCard = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[4]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(vacantEmployeeCard, "Boş Pozisyonlar kartına tıklandı");
                LogTest.info("Boş Pozisyonlar kartına tıklandı");
                BaseStep.waitSeconds(1);
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.ESCAPE).perform();
                BaseStep.waitSeconds(1);
        }

        @Test
        @Order(6)
        @DisplayName("Yönetim Doküman Talepleri Kartı Test Ediliyor")
        public void cardDocumentManagementRequest() {
                LogTest.info("Yönetim Doküman Talepleri kartı bulunuyor");
                WebElement cardManagementDocumentRequest = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[7]",
                                TimeOut.SHORT.value);
                LogTest.info("Yönetim Doküman Talepleri kartı bulundu");
                BaseStep.waitSeconds(1);
                BaseStep.clickElement(cardManagementDocumentRequest, "Yönetim Doküman Talepleri kartına tıklandı");
                LogTest.info("Yönetim Doküman Talepleri kartına tıklandı");
                BaseStep.waitSeconds(1);
                BaseStep.navigateToUrl("https://dhrtest.d1-tech.com.tr/dashboard");
                BaseStep.waitSeconds(1);
        }

        @Test
        @Order(7)
        @DisplayName("Çalışan Doküman Talepleri Kartı Test Ediliyor")
        public void cardEmployeeManagementRequest() {
                LogTest.info("Çalışan Doküman Talepleri kartı bulunuyor");
                WebElement cardEmployeeManagementRequest = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[8]",
                                TimeOut.SHORT.value);
                LogTest.info("Çalışan Doküman Talepleri kartı bulundu");
                BaseStep.waitSeconds(1);
                BaseStep.clickElement(cardEmployeeManagementRequest, "Çalışan Doküman Talepleri kartına tıklandı");
                BaseStep.waitSeconds(1);
                BaseStep.navigateToUrl("https://dhrtest.d1-tech.com.tr/dashboard");
        }

        @Test
        @Order(8)
        @DisplayName("Çalışan Tarafından Gönderilen Kartı Test Ediliyor")
        public void cardSendingByEmployee() {
                LogTest.info("Çalışan Tarafından Gönderilen kartı bulunuyor");
                WebElement cardSendingByEmployee = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[9]",
                                TimeOut.SHORT.value);
                LogTest.info("Çalışan Tarafından Gönderilen kartı bulundu");
                BaseStep.waitSeconds(1);
                BaseStep.clickElement(cardSendingByEmployee, "Çalışan Tarafından Gönderilen kartına tıklandı");
                BaseStep.waitSeconds(1);
                BaseStep.navigateToUrl("https://dhrtest.d1-tech.com.tr/dashboard");
        }

        @Test
        @Order(9)
        @DisplayName("İzin Talepleri Kartı Test Ediliyor")
        public void cardLeaveRequest() {
                LogTest.info("İzin Talepleri kartı bulunuyor");
                WebElement cardLeaveRequest = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[10]",
                                TimeOut.SHORT.value);
                LogTest.info("İzin Talepleri kartı bulundu");
                BaseStep.waitSeconds(1);
                BaseStep.clickElement(cardLeaveRequest, "İzin Talepleri kartına tıklandı");
                BaseStep.waitSeconds(1);
                BaseStep.navigateToUrl("https://dhrtest.d1-tech.com.tr/dashboard");
        }

        @Test
        @Order(10)
        @DisplayName("Okunmamış Duyurular Kartı Test Ediliyor")
        public void cardUnreadAnnouncements() {
                LogTest.info("Okunmamış Duyurular kartı bulunuyor");
                WebElement cardUnreadAnnouncements = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[12]",
                                TimeOut.SHORT.value);
                LogTest.info("Okunmamış Duyurular kartı bulundu");
                BaseStep.waitSeconds(1);
                BaseStep.clickElement(cardUnreadAnnouncements, "Okunmamış Duyurular kartına tıklandı");
                BaseStep.waitSeconds(1);
                BaseStep.navigateToUrl("https://dhrtest.d1-tech.com.tr/dashboard");
        }

        @Test
        @Order(11)
        @DisplayName("Yaklaşan Doğum Günleri Kartı Test Ediliyor")
        public void cardUpcomingBirthdays() {
                LogTest.info("Yaklaşan Doğum Günleri kartı bulunuyor");
                WebElement cardUpcomingBirthdays = BaseStep.findElementXpathWithWait(
                                CARD_ROW_XPATH + "/div[13]",
                                TimeOut.SHORT.value);
                LogTest.info("Yaklaşan Doğum Günleri kartı bulundu");
                BaseStep.waitSeconds(1);
                BaseStep.clickElement(cardUpcomingBirthdays, "Yaklaşan Doğum Günleri kartına tıklandı");
                BaseStep.waitSeconds(1);
                BaseStep.navigateToUrl("https://dhrtest.d1-tech.com.tr/dashboard");
        }
}
