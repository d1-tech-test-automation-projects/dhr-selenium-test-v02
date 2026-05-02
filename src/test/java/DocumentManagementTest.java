import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DocumentManagementTest extends BaseStep {

        @BeforeAll
        public static void setup() {
                openChromeDriver();
        }

        @AfterAll
        public static void tearDownAll() {
                BaseStep.driverQuit();
        }

        @Test
        @Order(31)
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
        @Order(32)
        @DisplayName("Döküman Yönetimi Sayfasına Gidiliyor ve Tablar Geziliyor")
        public void navigateToDocumentManagementTabs() {
                BaseStep.waitSeconds(3);
                LogTest.info("Döküman paneline dropdown aranıyor");
                WebElement buttonDocumentManagement = BaseStep.findElementXpathWithWait(
                                "//a[@href='/documents-management']",
                                TimeOut.SHORT.value);
                LogTest.info("Döküman Yönetimi butonuna tıklanıyor");
                BaseStep.clickElement(buttonDocumentManagement, "Döküman yönetimie butonuna tıklandır");
                LogTest.info("Çalışan döküman talebi butonu aranıyor");
                WebElement buttonEmployeeDocumentRequests = BaseStep
                                .findElementXpathWithWait("//*[@id=\"rc-tabs-0-tab-employee\"]", TimeOut.SHORT.value);
                LogTest.info("Çalışan döküman talebi butonuna tıklanıyor");
                BaseStep.clickElement(buttonEmployeeDocumentRequests, "Döküman yönetimie butonuna tıklandır");
                waitSeconds(1);

                LogTest.info("Yönetim Tarafından Gönderilen butonu aranıyor");
                WebElement buttonSendingbyManagement = BaseStep.findElementXpathWithWait(
                                "//div[contains(@id, 'sending-by-management') and @role='tab']", TimeOut.SHORT.value);
                LogTest.info("Yönetim Tarafından Gönderilen butonuna tıklanıyor");
                BaseStep.clickElement(buttonSendingbyManagement, "Yönetim Tarafından Gönderilen butonuna tıklandır");
                waitSeconds(1);

                LogTest.info("Çalışan Tarafından Gönderilen butonu aranıyor");
                WebElement buttonSendingbyEmployee = BaseStep
                                .findElementXpathWithWait("//*[@id=\"rc-tabs-0-tab-sending-by-employee\"]",
                                                TimeOut.SHORT.value);
                LogTest.info("Çalışan Tarafından Gönderilen butonuna tıklanıyor");
                BaseStep.clickElement(buttonSendingbyEmployee, "Çalışan Tarafından Gönderilen butonuna tıklandır");
                waitSeconds(1);

                LogTest.info("Yönetim Döküman Talepleri butonu aranıyor");
                WebElement buttonManagementDocumentRequests = BaseStep
                                .findElementXpathWithWait("//*[@id=\"rc-tabs-0-tab-management\"]", TimeOut.SHORT.value);
                LogTest.info("Yönetim Döküman Talepleri butonuna tıklanıyor");
                BaseStep.clickElement(buttonManagementDocumentRequests, "Yönetim Döküman Talepleri butonuna tıklandır");
                waitSeconds(1);

                LogTest.info("Tablodaki ilgili satır için Detaylar butonuna basılıyor...");
                WebElement DetailsBtnXpath = BaseStep.findElementXpathWithWait("//button[.//span[text()='Detaylar']]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(DetailsBtnXpath, "Detaylar butonu tıklandı");
                LogTest.info("Detaylar ekranı açılıyor.");
                waitSeconds(2);

                LogTest.info("Modalı kapatmak için 'Kapat' butonuna basılıyor...");
                WebElement closeBtn = findElementXpathWithWait(
                                "//div[contains(@class, 'ant-modal-footer')]//button[.//span[text()='Kapat']]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(closeBtn, "Kapat butonu tıklandı");
                LogTest.info("Modal kapatıldı.");
                waitSeconds(1);

                LogTest.info("Dışa Aktar butonu aranıyor");
                WebElement buttonExport = BaseStep.findElementXpathWithWait(
                                "//button[contains(@class, 'ant-btn') and .//span[contains(@class, 'anticon-export')]]",
                                TimeOut.SHORT.value);
                LogTest.info("Dışa Aktar butonuna tıklanıyor");
                BaseStep.clickElement(buttonExport, "Dışa Aktar butonuna tıklandır");
        }

        @Test
        @Order(33)
        @DisplayName("Durum Filtreleri Uygulanıyor")
        public void applyStatusFilters() {
                LogTest.info("Durum Filtreleri işlemleri başlatılıyor...");

                LogTest.info("'Çalışan Beklemesinde' filtresi aranıyor...");
                WebElement buttonPendingbyEmployee = BaseStep
                                .findElementXpathWithWait("//label[contains(., 'Çalışan Beklemesinde')]",
                                                TimeOut.SHORT.value);
                BaseStep.clickElement(buttonPendingbyEmployee, "Çalışan Beklemesinde Checkbox");
                LogTest.info("'Çalışan Beklemesinde' başarıyla seçildi.");

                LogTest.info("'Yönetim Beklemesinde' filtresi aranıyor...");
                WebElement buttonPendingbyManagement = BaseStep
                                .findElementXpathWithWait("//label[contains(., 'Yönetim Beklemesinde')]",
                                                TimeOut.SHORT.value);
                BaseStep.clickElement(buttonPendingbyManagement, "Yönetim Beklemesinde Checkbox");
                LogTest.info("'Yönetim Beklemesinde' başarıyla seçildi.");

                LogTest.info("'Onaylandı' filtresi aranıyor...");
                WebElement buttonApproved = BaseStep.findElementXpathWithWait("//label[contains(., 'Onaylandı')]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(buttonApproved, "Onaylandı Checkbox");
                LogTest.info("'Onaylandı' başarıyla seçildi.");

                LogTest.info("'Reddedildi' filtresi aranıyor...");
                WebElement buttonRejected = BaseStep.findElementXpathWithWait("//label[contains(., 'Reddedildi')]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(buttonRejected, "Reddedildi Checkbox");
                LogTest.info("'Reddedildi' başarıyla seçildi.");

                LogTest.info("'İptal edildi' filtresi aranıyor...");
                WebElement buttonCanceled = BaseStep.findElementXpathWithWait("//label[contains(., 'İptal Edildi')]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(buttonCanceled, "İptal Edildi Checkbox");
                LogTest.info("'İptal edildi' başarıyla seçildi.");
                LogTest.info("Tüm durum filtreleri (5 adet) eksiksiz olarak işaretlendi.");
        }

        @Test
        @Order(34)
        @DisplayName("Kişi Seçiliyor ve Dışa Aktarılıyor")
        public void selectEmployeeAndExport() {
                LogTest.info("'Çalışan Seç aranıyor...");
                WebElement buttonSelectEmployees = BaseStep.findElementXpathWithWait(
                                "(//button[contains(., 'Select Employees') or contains(., 'Çalışan Seç')])[last()]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(buttonSelectEmployees, "Çalışan Seç");
                LogTest.info("Çalışan Seç tıklandı.");

                LogTest.info("'Tümünü Seç aranıyor...");
                WebElement buttonSelectAll = BaseStep.findElementXpathWithWait(
                                "//div[contains(@class, 'ant-modal-content')]//span[text()='Tümünü Seç']/..",
                                TimeOut.LONG.value);
                BaseStep.clickElement(buttonSelectAll, "Tümünü Seç");
                LogTest.info("Tümünü Seç tıklandı.");
                BaseStep.waitSeconds(4);

                LogTest.info("'Seçimi Onayla...");
                WebElement buttonConfirmSelection = BaseStep.findElementXpathWithWait(
                                "//div[contains(@class, 'ant-modal-content')]//div[contains(@class, 'ant-modal-footer')]//button[.//span[contains(text(), 'Confirm') or contains(text(), 'Onayla')]]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(buttonConfirmSelection, "Seçimi Onayla");
                LogTest.info("Seçimi Onayla");

                LogTest.info("'Dışa Aktar butonu aranıyor...");
                WebElement buttonExportt = BaseStep.findElementXpathWithWait(
                                "//div[contains(@class, 'ant-modal-content')]//form//button[@type='submit'][.//span[contains(text(), 'Export') or contains(text(), 'Dışa Aktar')]]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(buttonExportt, "Dışa Aktar butonu tıklanıyor");
                LogTest.info("Dışa Aktar butonu tıklanıyor");
        }

        @Test
        @Order(35)
        @DisplayName("Döküman Gönderiliyor")
        public void sendDocument() {
                LogTest.info("'Döküman Gönder butonu aranıyor...");
                WebElement buttonSendDocument = BaseStep.findElementXpathWithWait(
                                "//button[.//span[@aria-label='send']]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(buttonSendDocument, "Döküman Gönder butonu tıklanıyor");
                LogTest.info("Döküman Gönder tıklanıyor");

                LogTest.info("Doküman adı giriliyor...");
                BaseStep.waitSeconds(1);
                WebElement inputDocumentName = BaseStep.findElementXpathWithWait(
                                "//input[@placeholder='Doküman adını girin']",
                                TimeOut.SHORT.value);
                BaseStep.clearAndType(inputDocumentName, "Test Dokümanı 2026", "Doküman Adı Alanı");
                LogTest.info("Doküman adı başarıyla yazıldı.");

                LogTest.info("'Çalışan Seç' aranıyor...");
                WebElement buttonSelectEmployees2 = BaseStep.findElementXpathWithWait(
                                "(//button[contains(., 'Select Employees') or contains(., 'Çalışan Seç')])[last()]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(buttonSelectEmployees2, "Çalışan Seç");
                LogTest.info("Çalışan Seç tıklandı.");

                LogTest.info("'Tümünü Seç' aranıyor...");
                BaseStep.waitSeconds(3);
                WebElement buttonSelectAll2 = BaseStep.findElementXpathWithWait(
                                "(//span[text()='Tümünü Seç']/..)[last()]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(buttonSelectAll2, "Tümünü Seç");
                LogTest.info("Tümünü Seç tıklandı.");
                BaseStep.waitSeconds(4);

                LogTest.info("'Seçimi Onayla...");
                BaseStep.waitSeconds(1);
                WebElement buttonConfirmSelection2 = BaseStep.findElementXpathWithWait(
                                "(//div[contains(@class, 'ant-modal-footer')]//button[contains(., 'Seçimi Onayla')])[last()]",
                                TimeOut.LONG.value);
                BaseStep.clickElement(buttonConfirmSelection2, "Seçimi Onayla");
                LogTest.info("Seçimi Onayla tıklandı.");

                waitSeconds(1);
                LogTest.info("ESC tuşuna basılıyor...");
                WebElement activeElement = driver.switchTo().activeElement();
                activeElement.sendKeys(Keys.ESCAPE);
                LogTest.info("ESC komutu gönderildi.");
        }
        /*
         * @Test
         * 
         * @Order(36)
         * 
         * @DisplayName("Talep Oluşturuluyor")
         * public void createRequest() {
         * LogTest.info("Talep oluşturuluyor...");
         * WebElement createRequestButton =
         * findElementXpathWithWait("//button[.//span[@aria-label='plus']]",
         * TimeOut.SHORT.value);
         * BaseStep.clickElement(createRequestButton, "Talep Oluştur butonuna basıldı");
         * LogTest.info("Talep oluşturuldu");
         * waitSeconds(1);
         * 
         * LogTest.info("Çalışan Seç butonu tıklanıyor...");
         * WebElement selectEmployeeButton = findElementXpathWithWait(
         * "(//button[contains(., 'Select Employees') or contains(., 'Çalışan Seç')])[last()]"
         * ,
         * TimeOut.SHORT.value);
         * BaseStep.clickElement(selectEmployeeButton, "Çalışan Seç butonuna basıldı");
         * LogTest.info("Çalışan seçim listesi açıldı.");
         * 
         * waitSeconds(2);
         * LogTest.info("Çalışan listesinde 'Tümünü Seç' butonuna tıklanıyor...");
         * WebElement selectAllButton =
         * findElementXpathWithWait("(//span[text()='Tümünü Seç']/..)[last()]",
         * TimeOut.SHORT.value);
         * BaseStep.clickElement(selectAllButton, "Tümünü Seç butonuna basıldı");
         * LogTest.info("Tüm çalışanlar başarıyla seçildi.");
         * 
         * waitSeconds(2);
         * LogTest.info("Seçimi Temizle butonuna tıklanıyor...");
         * WebElement clearButton =
         * findElementXpathWithWait("(//button[.//span[text()='Temizle']])[last()]",
         * TimeOut.SHORT.value);
         * BaseStep.clickElement(clearButton, "Temizle butonuna basıldı");
         * LogTest.info("Seçimler başarıyla temizlendi.");
         * waitSeconds(1);
         * 
         * LogTest.
         * info("Çalışan listesinden Kutay Alptürk seçiliyor (Dış div odaklı)...");
         * String kutayDivXpath =
         * "//div[contains(text(), 'Kutay Alptürk')]/ancestor::div[contains(@class, 'ant-card-body')]//label[contains(@class, 'ant-checkbox-wrapper')]"
         * ;
         * WebElement kutayCard = BaseStep.findElementXpathWithWait(kutayDivXpath, 10);
         * BaseStep.clickElement(kutayCard, "Kutay Alptürk dış kart alanı");
         * BaseStep.waitSeconds(1);
         * LogTest.info("Kutay Alptürk kartı başarıyla tetiklendi.");
         * 
         * waitSeconds(2);
         * LogTest.
         * info("Seçilen çalışanları onaylamak için 'Confirm Selection' butonuna basılıyor..."
         * );
         * WebElement confirmBtn = findElementXpathWithWait(
         * "//div[contains(@class, 'ant-modal-wrap') and not(contains(@style, 'display: none'))]"
         * +
         * "//div[contains(@class, 'ant-modal-footer')]" +
         * "//button[contains(@class, 'ant-btn-primary')][.//span[contains(text(), 'Confirm') or contains(text(), 'Onayla')]]"
         * ,
         * TimeOut.SHORT.value);
         * BaseStep.clickElement(confirmBtn,
         * "Confirm Selection butonu JS ile tetiklendi");
         * LogTest.info("Çalışan seçimi başarıyla onaylandı.");
         * 
         * BaseStep.waitSeconds(1);
         * LogTest.info("Açıklama alanına veri girişi yapılıyor...");
         * WebElement descriptionArea = findElementXpathWithWait(
         * "//div[contains(@class, 'ant-modal-wrap') and not(contains(@style, 'display: none'))]//textarea[@id='description']"
         * ,
         * TimeOut.SHORT.value);
         * BaseStep.clickElement(descriptionArea, "Açıklama alanına tıklandı");
         * BaseStep.clearAndType(descriptionArea, "Açıklama metni yazılıyor",
         * "Test dokümanı için açıklama metnidir.");
         * LogTest.info("Açıklama alanına veri girişi yapıldı...");
         * BaseStep.waitSeconds(1);
         * 
         * LogTest.info("Talebi tamamlamak için 'Create Request' butonuna basılıyor..."
         * );
         * WebElement createBtn = findElementXpathWithWait(
         * "//div[contains(@class, 'ant-modal-wrap') and not(contains(@style, 'display: none'))]"
         * +
         * "//form//button[@type='submit'][.//span[contains(text(), 'Create Request') or contains(text(), 'Talep Oluştur')]]"
         * ,
         * TimeOut.SHORT.value);
         * BaseStep.clickElement(createBtn,
         * "Create Request/Talep Oluştur butonu JS ile tıklandı");
         * LogTest.info("Talep başarıyla oluşturuldu.");
         * 
         * }
         * 
         */

        @Test
        @Order(36)
        @DisplayName("Ekip Dosyaları Sekmesine Geçiş Yapılıyor")
        public void navigateToTeamFiless() {
                LogTest.info("Ekip Dosyaları (Team Files) sekmesine geçiş yapılıyor...");
                WebElement teamFilesTab = findElementXpathWithWait("//div[@data-node-key='team-files']",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(teamFilesTab, "Team Files sekmesine tıklandı");
                BaseStep.waitSeconds(1);
                LogTest.info("Ekip Dosyaları alanı başarıyla açıldı.");

                LogTest.info("Tablodan Naci Eren Kılıç kullanıcısının detaylarına gidiliyor...");
                WebElement detailsBtn = BaseStep.findElementXpathWithWait(
                                "//tr[contains(., 'Naci Eren Kılıç')]//button[contains(., 'Detaylar')]",
                                TimeOut.SHORT.value);
                BaseStep.clickElement(detailsBtn, "Naci Eren Kılıç Detaylar Butonu");
                BaseStep.waitSeconds(2);

                BaseStep.waitSeconds(1);
                LogTest.info("ESC tuşuna basılıyor...");
                WebElement activeElement = driver.switchTo().activeElement();
                activeElement.sendKeys(Keys.ESCAPE);
                LogTest.info("ESC komutu gönderildi.");
                BaseStep.waitSeconds(1);

                LogTest.info("Çalışan arama alanına 'Sena' yazılıyor...");
                WebElement searchBox11 = BaseStep.findElementXpathWithWait(
                                "//input[@placeholder='Çalışan adı veya numarası ile ara...']", TimeOut.SHORT.value);
                BaseStep.clearAndType(searchBox11, "Asena", "Arama kutusuna isim yazılıyor");
                BaseStep.waitSeconds(3);

                LogTest.info("Arama alanı temizleniyor...");
                String searchInputXpath = "//input[@placeholder='Çalışan adı veya numarası ile ara...']";
                WebElement searchBox2 = BaseStep.findElementXpathWithWait(searchInputXpath, TimeOut.SHORT.value);
                BaseStep.clearAndType(searchBox2, "", "Arama Kutusu Temizleme İşlemi");
                BaseStep.waitSeconds(2);
                LogTest.info("İşlem başarıyla tamamlandı.");

                LogTest.info("Departman filtresi açılıyor...");
                String selectBoxXpath = "//span[text()='Birime göre filtrele']/ancestor::div[contains(@class, 'ant-select')]";
                WebElement selectBox = BaseStep.findElementXpathWithWait(selectBoxXpath, 10);
                BaseStep.clickElement(selectBox, "Departman Seçim Kutusu");

                BaseStep.waitSeconds(1);
                LogTest.info("Listeden 'TEST DEPERTMANI' seçiliyor...");
                String optionXpath = "(//div[contains(@class, 'ant-select-item-option-content') and text()='TEST DEPERTMANI'])[last()]";
                WebElement option = BaseStep.findElementXpathWithWait(optionXpath, 5);
                BaseStep.clickElement(option, "TEST DEPERTMANI Seçeneği");
                BaseStep.waitSeconds(1);
                LogTest.info("Departman başarıyla seçildi.");

            LogTest.info("Şirket Dosyaları (Company Files) sekmesine geçiş yapılıyor...");
            WebElement companyTab = BaseStep.findElementXpathWithWait("//div[@data-node-key='company-files']", TimeOut.SHORT.value);
            BaseStep.clickElement(companyTab, "Şirket dosyaları açıldı");
            BaseStep.waitSeconds(2);
            LogTest.info("Şirket Dosyaları alanı başarıyla açıldı.");

            LogTest.info("Dosya arama alanına veri giriliyor...");
            String searchInputXpath3 = "//input[@placeholder='Dosya adı, birim veya yükleyen ile ara...']";
            WebElement searchBox = BaseStep.findElementXpathWithWait(searchInputXpath3, 10);
            BaseStep.clearAndType(searchBox, "Aylık Rapor", "Arama kutusuna dosya adı yazıldı");
            BaseStep.waitSeconds(2);
            LogTest.info("Arama işlemi tetiklendi.");

                LogTest.info("Dosya arama alanı temizleniyor...");
                String searchInputXpath4 = "//input[@placeholder='Dosya adı, birim veya yükleyen ile ara...']";
                WebElement fileSearchBox = BaseStep.findElementXpathWithWait(searchInputXpath4, TimeOut.SHORT.value);
                BaseStep.clearAndType(fileSearchBox, "", "Dosya Arama Kutusu Temizleme İşlemi");
                BaseStep.waitSeconds(2);
                LogTest.info("Dosya arama alanı başarıyla temizlendi.");

            LogTest.info("Birim filtresi açılıyor...");
            String selectBoxXpath2 = "//span[text()='Birime göre filtrele']/ancestor::div[contains(@class, 'ant-select-selector')]";
            WebElement selectBox2 = BaseStep.findElementXpathWithWait(selectBoxXpath2, 10);
            BaseStep.clickElement(selectBox2, "Birim Seçim Kutusu");

            BaseStep.waitSeconds(1);
            LogTest.info("Listeden 'D1-Tech' seçiliyor...");
            String optionXpath2 = "(//div[contains(@class, 'ant-select-item-option-content') and text()='D1-Tech'])[last()]";
            WebElement option2 = BaseStep.findElementXpathWithWait(optionXpath2, 5);
            BaseStep.clickElement(option2, "D1-Tech Seçeneği");
            BaseStep.waitSeconds(1);
            LogTest.info("Birim başarıyla seçildi.");

                LogTest.info("Yeni Dosya ekleme süreci başlatılıyor...");
                String addNewFileBtnXpath = "//span[text()='Yeni Dosya']/parent::button";
                WebElement createButton = BaseStep.findElementXpathWithWait(addNewFileBtnXpath, TimeOut.SHORT.value);
                BaseStep.clickElement(createButton, "Yeni Dosya Butonu");
                BaseStep.waitSeconds(1);
                LogTest.info("Yeni Dosya penceresi açıldı.");

                LogTest.info("Döküman adı alanına veri girişi yapılıyor...");
                String docNameFieldXpath = "//input[@id='documentName']";
                WebElement docNameInput = BaseStep.findElementXpathWithWait(docNameFieldXpath, TimeOut.SHORT.value);
                BaseStep.clearAndType(docNameInput, "Deneme Dökümanı", "Döküman Adı Giriş İşlemi");
                BaseStep.waitSeconds(1);
                LogTest.info("Döküman adı başarıyla yazıldı.");

                LogTest.info("Modal içindeki birim seçim kutusu açılıyor...");
                String modalUnitDropdownXpath = "//input[@id='organizationalUnitId']/ancestor::div[contains(@class, 'ant-select-selector')]";
                WebElement unitSelectionContainer = BaseStep.findElementXpathWithWait(modalUnitDropdownXpath, TimeOut.SHORT.value);
                BaseStep.clickElement(unitSelectionContainer, "Birim Seçim Kutusu");

                BaseStep.waitSeconds(1);
                LogTest.info("Listeden 'TEST DEPERTMANI' seçiliyor...");
                String targetDepartmentOptionXpath = "(//div[contains(@class, 'ant-select-item-option-content') and text()='TEST DEPERTMANI'])[last()]";
                WebElement departmentOption = BaseStep.findElementXpathWithWait(targetDepartmentOptionXpath, TimeOut.SHORT.value);
                BaseStep.clickElement(departmentOption, "TEST DEPERTMANI Seçeneği");
                BaseStep.waitSeconds(1);
                LogTest.info("Birim seçimi modal üzerinde tamamlandı.");

                BaseStep.waitSeconds(3);
                LogTest.info("Dosya yükleme alanı aranıyor...");
                String fileUploadInputXpath = "//input[@type='file' and @accept]";
                BaseStep.uploadFileFromProject(fileUploadInputXpath, "deneme.pdf", "Şirket dökümanı başarıyla yüklendi");
                BaseStep.waitSeconds(5);
                LogTest.info("Dosya yükleme işlemi tamamlandı.");

                LogTest.info("Yükle butonuna tıklanıyor...");
                WebElement uploadBtn = BaseStep.findElementXpathWithWait("//div[contains(@class, 'ant-modal-content')]//button[.//span[text()='Yükle']]", TimeOut.SHORT.value);
                BaseStep.clickElement(uploadBtn, "Yükle Butonu");
                BaseStep.waitSeconds(2);
                LogTest.info("Yükleme işlemi onaylandı ve modal kapatılıyor.");
        }
}