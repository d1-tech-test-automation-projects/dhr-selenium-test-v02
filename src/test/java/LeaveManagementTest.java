import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LeaveManagementTest extends BaseStep {

        @BeforeAll
        public static void setup() {
                openChromeDriver();
        }

        @AfterAll
        public static void tearDownAll() {
                BaseStep.driverQuit();
        }

        @Test
        @Order(41)
        @DisplayName("Tarayıcı Açılıyor")
        public void openDriver() {
                LogTest.info("Kullanıcı adı Input aranıyor");
                WebElement usernameInput = BaseStep.findElementXpathWithWait("//*[@id=\"login_email\"]",
                                TimeOut.LONG.value);
                BaseStep.clearAndType(usernameInput, "sudee20g@gmail.com", "Kullanıcı Adı");
                LogTest.info("Kullanıcı adı gönderildi");
                WebElement passwordInput = BaseStep.findElementXpathWithWait("//*[@id=\"login_password\"]",
                                TimeOut.LONG.value);
                LogTest.info("Parola Inputu bulunuyor");
                BaseStep.clearAndType(passwordInput, "Sudee20g!", "Şifre");
                LogTest.info("Parola gönderildi");
                LogTest.info("Giriş Yap butonu bulunuyor");
                WebElement loginClickButton = BaseStep.findElementXpathWithWait("(//button[@type='submit'])[1]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(loginClickButton, "Giriş yap butonuna tıklandı");
        }

        @Test
        @Order(42)
        @DisplayName("İzin Yönetimi Sayfasına Navigasyon")
        public void navigateToLeaveManagementPage() {
                BaseStep.waitSeconds(3);
                LogTest.info("İzin Yönetimi menüsüne tıklanıyor...");
                WebElement leaveManagementLink = BaseStep.findElementXpathWithWait(
                                "//aside//a[@href='/leaves-management' or contains(., 'İzin Yönetimi')]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(leaveManagementLink, "İzin Yönetimi Menüsü");
                BaseStep.waitSeconds(3);
                LogTest.info("İzin Yönetimi sayfası açıldı.");
        }

        @Test
        @Order(43)
        @DisplayName("Talepler Sekmesi İnceleniyor")
        public void inspectLeaveRequestsTab() {
                LogTest.info("Talepler sekmesine tıklanıyor...");
                WebElement requestsTab = BaseStep.findElementXpathWithWait(
                                "//div[@data-node-key='my-approvals']//div[contains(@class, 'ant-tabs-tab-btn')]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(requestsTab, "Talepler Sekmesi");
                BaseStep.waitSeconds(2);
                LogTest.info("Talepler sekmesi başarıyla açıldı.");

                LogTest.info("Çalışan arama alanına veri giriliyor...");
                WebElement searchInput = BaseStep.findElementXpathWithWait(
                                "//input[@placeholder='Çalışan adı veya numarası']",
                                TimeOut.LONG.value);
                BaseStep.clearAndType(searchInput, "Sude", "Çalışan Arama");
                BaseStep.waitSeconds(2);
                LogTest.info("Arama işlemi tamamlandı.");

                LogTest.info("Arama alanı temizleniyor...");
                WebElement searchInputClear = BaseStep.findElementXpathWithWait(
                                "//input[@placeholder='Çalışan adı veya numarası']",
                                TimeOut.LONG.value);
                BaseStep.clearAndType(searchInputClear, "", "Arama Kutusu Temizleme");
                BaseStep.waitSeconds(2);
                LogTest.info("Arama alanı temizlendi.");

                LogTest.info("Departman filtresi açılıyor...");
                WebElement departmentFilter = BaseStep.findElementXpathWithWait(
                                "//span[contains(., 'Departmana Göre Fil')]/ancestor::div[contains(@class, 'ant-select')]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(departmentFilter, "Departman Filtresi");
                BaseStep.waitSeconds(1);

                LogTest.info("Departman listesinden 'TEST DEPERTMANI' seçiliyor...");
                WebElement departmentOption = BaseStep.findElementXpathWithWait(
                                "(//div[contains(@class, 'ant-select-item-option-content') and contains(., 'TEST DEPERTMANI')])[last()]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(departmentOption, "TEST DEPERTMANI Seçeneği");
                BaseStep.waitSeconds(2);
                LogTest.info("Departman filtresi başarıyla uygulandı.");

                LogTest.info("Filtreleri Temizle butonuna tıklanıyor...");
                WebElement clearFiltersBtn = BaseStep.findElementXpathWithWait(
                                "//button[.//span[contains(., 'Filtreleri Temizle')]]", TimeOut.LONG.value);
                BaseStep.clickElement(clearFiltersBtn, "Filtreleri Temizle");
                BaseStep.waitSeconds(2);
                LogTest.info("Filtreler temizlendi.");
        }

        @Test
        @Order(44)
        @DisplayName("Talep Alt Sekmeleri Geziliyor")
        public void navigateRequestSubTabs() {
                LogTest.info("Bekleyen Talepler sekmesine tıklanıyor...");
                WebElement pendingTab = BaseStep.findElementXpathWithWait(
                                "//div[@data-node-key='2']//div[contains(@class, 'ant-tabs-tab-btn')]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(pendingTab, "Bekleyen Talepler Sekmesi");
                BaseStep.waitSeconds(3);
                LogTest.info("Bekleyen Talepler sekmesi açıldı.");

                LogTest.info("Onaylanan Talepler sekmesine tıklanıyor...");
                WebElement approvedTab = BaseStep.findElementXpathWithWait(
                                "//div[@data-node-key='3']//div[contains(@class, 'ant-tabs-tab-btn')]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(approvedTab, "Onaylanan Talepler Sekmesi");
                BaseStep.waitSeconds(3);
                LogTest.info("Onaylanan Talepler sekmesi açıldı.");

                LogTest.info("Reddedilen Talepler sekmesine tıklanıyor...");
                WebElement rejectedTab = BaseStep.findElementXpathWithWait(
                                "//div[@data-node-key='4']//div[contains(@class, 'ant-tabs-tab-btn')]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(rejectedTab, "Reddedilen Talepler Sekmesi");
                BaseStep.waitSeconds(3);
                LogTest.info("Reddedilen Talepler sekmesi açıldı.");

                LogTest.info("Tüm Talepler sekmesine geri dönülüyor...");
                WebElement allRequestsTab = BaseStep.findElementXpathWithWait(
                                "//div[@data-node-key='1']//div[contains(@class, 'ant-tabs-tab-btn')]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(allRequestsTab, "Tüm Talepler Sekmesi");
                BaseStep.waitSeconds(3);
                LogTest.info("Tüm Talepler sekmesine geri dönüldü.");
        }

        @Test
        @Order(45)
        @DisplayName("Talep Detayları İnceleniyor ve Dışa Aktarılıyor")
        public void viewRequestDetailsAndExport() {
                LogTest.info("İlk talebin Detaylar butonuna tıklanıyor...");
                WebElement detailsBtn = BaseStep.findElementXpathWithWait("(//button[.//span[text()='Detaylar']])[1]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(detailsBtn, "Detaylar Butonu");
                BaseStep.waitSeconds(2);
                LogTest.info("Detaylar modalı açıldı.");

                LogTest.info("Detaylar modalı kapatılıyor...");
                WebElement closeBtn = BaseStep.findElementXpathWithWait(
                                "//div[contains(@class, 'ant-modal-content')]//button[.//span[text()='Kapat']]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(closeBtn, "Kapat Butonu");
                BaseStep.waitSeconds(1);
                LogTest.info("Detaylar modalı kapatıldı.");

                LogTest.info("Ana sayfadaki Dışa Aktar butonuna tıklanıyor...");
                WebElement exportBtn = BaseStep.findElementXpathWithWait(
                                "//button[.//span[contains(text(), 'Dışa Aktar')]]", TimeOut.LONG.value);
                BaseStep.clickElement(exportBtn, "Dışa Aktar Butonu");
                BaseStep.waitSeconds(2);

                LogTest.info("Çalışan Seç butonuna tıklanıyor...");
                WebElement selectEmployeeBtn = BaseStep.findElementXpathWithWait(
                                "//div[contains(@class, 'ant-modal-content')]//button[.//span[contains(text(), 'Çalışan Seç')]]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(selectEmployeeBtn, "Çalışan Seç Butonu");
                BaseStep.waitSeconds(2);

                LogTest.info("Çalışan aranıyor...");
                WebElement employeeSearch = BaseStep.findElementXpathWithWait(
                                "(//div[contains(@class, 'ant-modal-content')])[last()]//input[contains(@placeholder, 'Çalışan ara')]",
                                TimeOut.LONG.value);
                BaseStep.clearAndType(employeeSearch, "Sude", "Çalışan Arama");
                BaseStep.waitSeconds(2);

                LogTest.info("Tümünü Seç butonuna tıklanarak çalışan seçiliyor...");
                WebElement selectAllBtn = BaseStep.findElementXpathWithWait(
                                "(//div[contains(@class, 'ant-modal-content')])[last()]//button[.//span[contains(text(), 'Tümünü Seç')]]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(selectAllBtn, "Tümünü Seç");
                BaseStep.waitSeconds(1);

                LogTest.info("Çalışan seçimi Tamamlanıyor...");
                WebElement innerOkBtn = BaseStep.findElementXpathWithWait(
                                "(//div[contains(@class, 'ant-modal-content')])[last()]//button[.//span[contains(., 'Seçimi Onayla')]]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(innerOkBtn, "Çalışan Seçimi Onay");
                BaseStep.waitSeconds(1);

                LogTest.info("Modal üzerinden Dışa Aktar'a basılarak işlem sonlandırılıyor...");
                WebElement submitExportBtn = BaseStep.findElementXpathWithWait(
                                "//div[contains(@class, 'ant-modal-content')]//button[contains(@class, 'ant-btn-primary') and .//span[contains(., 'Dışa Aktar') or contains(., 'Export')]]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(submitExportBtn, "Son Dışa Aktar Butonu");
                BaseStep.waitSeconds(2);

                LogTest.info("Dışa Aktar işlemi tamamlandı.");
        }

}
