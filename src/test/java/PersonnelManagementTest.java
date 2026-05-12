import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonnelManagementTest extends BaseStep {

    @BeforeAll
    public static void setup() {
        openChromeDriver();
    }

    @AfterAll
    public static void tearDownAll() {
        BaseStep.driverQuit();
    }

    @Test
    @Order(21)
    @DisplayName("Tarayıcı Açılıyor")
    public void OpenDriver() {
        LogTest.info("Kullanıcı adı Input aranıyor");
        WebElement usernameInput = BaseStep.findElementXpathWithWait("//*[@id=\"login_email\"]", TimeOut.LONG.value);
        BaseStep.clearAndType(usernameInput, "sudee20g@gmail.com", "Kullanıcı Adı");
        LogTest.info("Kullanıcı adı gönderildi");
        WebElement passwordInput = BaseStep.findElementXpathWithWait("//*[@id=\"login_password\"]", TimeOut.LONG.value);
        LogTest.info("Parola Inputu bulunuyor");
        BaseStep.clearAndType(passwordInput, "Sudee20g!", "Şifre");
        LogTest.info("Parola gönderildi");
        LogTest.info("Giriş Yap butonu bulunuyor");
        WebElement loginClickButton = BaseStep.findElementXpathWithWait("(//button[@type='submit'])[1]", TimeOut.LONG.value);
        BaseStep.clickElement(loginClickButton, "Giriş yap butonuna tıklandı");
    }

    @Test
    @Order(22)
    @DisplayName("Çalışan Yönetimi Sayfasına Gidiliyor")
    public void navigateToEmployeeManagement() {
        BaseStep.waitSeconds(3);
        LogTest.info("yönetim paneline dropdown aranıyor");
        WebElement employeeManagementDropdown = BaseStep.findElementXpathWithWait("//li[@class='ant-menu-submenu ant-menu-submenu-inline ant-menu-submenu-open ant-menu-submenu-selected']//div[@role='menuitem']", TimeOut.LONG.value);
        LogTest.info("yönetim paneline  butonuna tıklanıyor");
        BaseStep.clickElement(employeeManagementDropdown, "yönetim paneline butonuna tıklandı");
        LogTest.info("yönetim paneline  butonuna tekrar tıklanıyor");
        BaseStep.waitSeconds(3);
        BaseStep.clickElement(employeeManagementDropdown, "yönetim paneline butonuna tıklandı");
        BaseStep.waitSeconds(3);

        LogTest.info("Çalışan Yönetimi butonuna aranıyor");
        WebElement buttonEmployeeManagement = BaseStep.findElementXpathWithWait("//a[@href='/employee-management']", TimeOut.LONG.value);
        LogTest.info("Çalışan Yönetimi butonuna tıklanıyor");
        BaseStep.clickElement(buttonEmployeeManagement, "çalışan yönetimie butonuna tıklandır");
    }

    @Test
    @Order(23)
    @DisplayName("Çalışan Aranıyor")
    public void searchEmployee() {
        BaseStep.waitSeconds(3);
        LogTest.info("Çalışan aranıyor");
        WebElement buttonSearch = BaseStep.findElementXpathWithWait("//*[@id=\"root\"]/div/section/section/main/div/div/div/div/div[2]/div[1]/div[1]/span/input", TimeOut.LONG.value);
        clearAndType(buttonSearch, "sude", "Çalışan arama kutusu");
        LogTest.info("'sude' ismi aratıldı.");
        BaseStep.waitSeconds(3);
        LogTest.info("Çalışan arama sude yazısı siliniyor");
        BaseStep.clearAndType(buttonSearch, "", "Arama alanı temizlendi");
    }

    @Test
    @Order(24)
    @DisplayName("Çalışan Filtreleniyor")
    public void filterEmployee() {
        LogTest.info("Çalışan Yönetimi filtrele butonuna aranıyor");
        WebElement buttonfilter = BaseStep.findElementXpathWithWait("//*[@id=\"root\"]/div/section/section/main/div/div/div/div/div[2]/div[1]/div[2]/button", TimeOut.LONG.value);
        LogTest.info("Çalışan Yönetimi filtrele butonuna tıklanıyor");
        BaseStep.clickElement(buttonfilter, "çalışan yönetimie filtreleniyor");

        waitSeconds(2);
        LogTest.info("Dropdown açılmaya çalışılıyor...");
        WebElement roleSelector = BaseStep.findElementXpathWithWait("//span[text()='Rol seçin' or text()='Select role']/ancestor::div[contains(@class, 'ant-select-selector')]", TimeOut.LONG.value);
        BaseStep.clickElement(roleSelector, "Rol dropdown alanı");
        LogTest.info("Dropdown tetiklendi.");

        BaseStep.waitSeconds(1);
        LogTest.info("Rol alanına 'Manager' yazılmaya zorlanıyor...");
        WebElement roleInput = BaseStep.findElementXpathWithWait("//div[contains(@class, 'ant-select-item-option-content') and text()='Manager']", TimeOut.LONG.value);
        BaseStep.clickElement(roleInput, "Rol Input Odaklanma");
        BaseStep.waitSeconds(2);

        BaseStep.waitSeconds(1);
        LogTest.info("Organizasyon Birimi seçiliyor...");
        WebElement organizationUnitButton = BaseStep.findElementXpathWithWait("//span[text()='Birim seçin']/ancestor::div[contains(@class, 'ant-select-selector')]", TimeOut.LONG.value);
        BaseStep.clickElement(organizationUnitButton, "Organizasyon Birimi kutusu açıldı");
        BaseStep.waitSeconds(1);

        BaseStep.waitSeconds(1);
        LogTest.info("Listeden birim seçiliyor:...");
        WebElement d1tech = BaseStep.findElementXpathWithWait("//div[contains(@class, 'ant-select-item-option-content') and text()='D1-Tech']", TimeOut.LONG.value);
        BaseStep.clickElement(d1tech, "Birim seçimi tamamlandı");
        BaseStep.waitSeconds(1);

        BaseStep.waitSeconds(1);
        LogTest.info("Pozisyon seçiliyor...");
        WebElement positionButton = BaseStep.findElementXpathWithWait("//input[@id='positions']/ancestor::div[contains(@class, 'ant-select-selector')]", TimeOut.LONG.value);
        BaseStep.clickElement(positionButton, "Pozisyonlar dropdown kutusu açıldı");
        BaseStep.waitSeconds(1);

        BaseStep.waitSeconds(1);
        LogTest.info("Listeden İk:...");
        WebElement ik = BaseStep.findElementXpathWithWait("//div[contains(@class, 'ant-select-item-option-content') and text()='İK']", TimeOut.LONG.value);
        BaseStep.clickElement(ik, "Pozisyon seçimi başarıyla tamamlandı.");
        BaseStep.waitSeconds(1);

        BaseStep.waitSeconds(1);
        LogTest.info("durum seçiliyor...");
        WebElement statusButton = BaseStep.findElementXpathWithWait("//input[@id='status']/ancestor::div[contains(@class, 'ant-select-selector')]", TimeOut.LONG.value);
        BaseStep.clickElement(statusButton, "durum dropdown kutusu açıldı");
        BaseStep.waitSeconds(1);

        BaseStep.waitSeconds(1);
        LogTest.info("Aktif seçeneği seçilecek.");
        WebElement activeOption = BaseStep.findElementXpathWithWait("//div[contains(@class, 'ant-select-item-option-content') and text()='Aktif']", TimeOut.LONG.value);
        BaseStep.clickElement(activeOption, "Aktif seçeneği seçildi");
        BaseStep.waitSeconds(2);

        WebElement statusInput = findElementXpathWithWait("//input[@id='status']", TimeOut.LONG.value);
        statusInput.sendKeys(Keys.ESCAPE);
        LogTest.info("Dropdown ESC ile kapatıldı.");
        waitSeconds(1);

        LogTest.info("Filtreleri temizlemek için 'Temizle' butonuna basılıyor...");
        String clearBtnXpath = "//div[contains(@class, 'ant-modal-footer')]//button[.//span[text()='Temizle']]";
        WebElement temizleBtn = findElementXpathWithWait(clearBtnXpath, TimeOut.LONG.value);
        BaseStep.clickElement(temizleBtn, "Temizle butonu tıklandı");
        LogTest.info("Filtreler temizlendi.");
        waitSeconds(2);

        LogTest.info("'Tamam' butonuna tıklanıyor...");
        WebElement okButton = BaseStep.findElementXpathWithWait("//button//span[text()='Tamam']/ancestor::button", TimeOut.LONG.value);
        BaseStep.clickElement(okButton, "Tamam butonu");
    }

    @Test
    @Order(25)
    @DisplayName("Çalışan İşten Çıkarılıyor")
    public void dismissEmployee() {
        LogTest.info("İşten çıkarma butonuna tıklanıyor...");
        WebElement dismissButton = findElementXpathWithWait("//button[.//span[contains(@class, 'anticon-user-delete')]]", TimeOut.LONG.value);
        BaseStep.clickElement(dismissButton, "İşten çıkarma butonu");
        LogTest.info("İşten çıkarma butonuna tıklandı.");

        waitSeconds(1);
        LogTest.info("Modal üzerindeki 'Çalışanı İşten Çıkar' butonu aranıyor...");
        WebElement dismissEmployeeButton = findElementXpathWithWait("//button[contains(., 'Çalışanı İşten Çıkar')]", TimeOut.LONG.value);
        BaseStep.clickElement(dismissEmployeeButton, "Çalışanı İşten Çıkar Butonu");
        LogTest.info("Butona tıklandı, form açılıyor...");

        LogTest.info("Çalışan seçimi başlatılıyor...");
        WebElement employeeDropdown = findElementXpathWithWait("//span[contains(text(),'Çalışan seçin')]/ancestor::div[contains(@class, 'ant-select-selector')]", TimeOut.LONG.value);
        BaseStep.clickElement(employeeDropdown, "Çalışan listesi açıldı");
        waitSeconds(1);
        LogTest.info("Listeden bir çalışan seçiliyor...");
        WebElement selectedEmployee = findElementXpathWithWait("//div[contains(@class, 'ant-select-item-option-content') and contains(., 'Hakan Güzel')]", TimeOut.LONG.value);
        BaseStep.clickElement(selectedEmployee, "Çalışan listesi açıldı");
        LogTest.info("Çalışan seçimi başarıyla tamamlandı.");

        LogTest.info("İşten çıkarma sebebi seçimi başlatılıyor...");
        WebElement reasonDropdown = findElementXpathWithWait("//input[@id='terminationReasonDefinitionId']/ancestor::div[contains(@class, 'ant-select-selector')]", TimeOut.LONG.value);
        BaseStep.clickElement(reasonDropdown, "Sebep listesi açıldı");
        waitSeconds(1);
        LogTest.info("Sebep seçiliyor: 1-Atendance Issues");
        WebElement option = findElementXpathWithWait("(//div[contains(@class, 'ant-select-item-option-content') and contains(., '1 - Attendance Issues')])[last()]", TimeOut.LONG.value);
        BaseStep.clickElement(option, "1-Atendance Issues seçildi");
        LogTest.info("Sebep seçimi tamamlandı.");

        LogTest.info("İşten çıkarma açıklaması giriliyor...");
        WebElement descriptionField = findElementXpathWithWait("//textarea[@id='comments']", TimeOut.LONG.value);
        descriptionField.clear();
        descriptionField.sendKeys("Sözleşme süresi dolduğu için işten çıkış işlemleri tamamlanmıştır.");
        LogTest.info("Açıklama başarıyla yazıldı.");

        waitSeconds(1);
        LogTest.info("ESC tuşuna basılıyor...");
        WebElement activeElement = driver.switchTo().activeElement();
        activeElement.sendKeys(Keys.ESCAPE);
        LogTest.info("ESC komutu gönderildi.");
    }

    @Test
    @Order(26)
    @DisplayName("Yeni Çalışan Ekleniyor")
    public void addNewEmployee() {
        LogTest.info("'Yeni Çalışan Ekle' butonu aranıyor...");
        WebElement newEmployeeButton = findElementXpathWithWait("//button[.//span[text()='Yeni Çalışan Ekle' or text()='Add New Employee']]", TimeOut.LONG.value);
        BaseStep.clickElement(newEmployeeButton, "Yeni Çalışan Ekle Butonu");
        LogTest.info("Yeni çalışan ekleme formu açılıyor...");
        waitSeconds(1);

        LogTest.info("Çalışan numarası yazılıyor...");
        WebElement employeeNumberField = findElementXpathWithWait("//input[@id='employeeNumber']", TimeOut.LONG.value);
        employeeNumberField.clear();
        employeeNumberField.sendKeys("12345");
        LogTest.info("Çalışan numarası başarıyla girildi.");

        LogTest.info("Çalışan adı giriliyor...");
        WebElement firstNameField = findElementXpathWithWait("//input[@id='firstName']", TimeOut.LONG.value);
        firstNameField.clear();
        firstNameField.sendKeys("Sude");
        LogTest.info("Ad başarıyla girildi: ");

        LogTest.info("Çalışan soyadı giriliyor...");
        WebElement lastNameField = findElementXpathWithWait("//input[@id='lastName']", TimeOut.LONG.value);
        lastNameField.clear();
        lastNameField.sendKeys("Çinay");
        LogTest.info("Soyad başarıyla girildi: ");

        LogTest.info("Çalışan e-postası giriliyor...");
        WebElement emailField = findElementXpathWithWait("//input[@id='email']", TimeOut.LONG.value);
        emailField.clear();
        emailField.sendKeys("sude.cinay@d1-tech.com");
        LogTest.info("E-posta başarıyla girildi: ");

        LogTest.info("Cinsiyet seçimi başlatılıyor...");
        WebElement genderDropdown = findElementXpathWithWait("//input[@id='gender']/ancestor::div[contains(@class, 'ant-select-selector')]", TimeOut.LONG.value);
        BaseStep.clickElement(genderDropdown, "Cinsiyet listesi açıldı");
        waitSeconds(1);
        LogTest.info("Cinsiyet seçiliyor: Kadın");
        WebElement femaleOption = findElementXpathWithWait("//div[contains(@class, 'ant-select-item-option-content') and text()='Kadın']", TimeOut.LONG.value);
        BaseStep.clickElement(femaleOption, "Kadın seçeneği tıklandı");
        LogTest.info("Cinsiyet seçimi başarıyla tamamlandı.");

        LogTest.info("Telefon numarası yazılıyor...");
        WebElement phoneField = findElementXpathWithWait("//input[@id='phoneNumber']", TimeOut.LONG.value);
        phoneField.clear();
        phoneField.sendKeys("5554443322");
        LogTest.info("Telefon numarası başarıyla girildi: ");

        LogTest.info("Takvim açılıyor...");
        WebElement tarihInput = findElementXpathWithWait("//input[@placeholder='Doğum tarihi girin (GG-AA-YYYY)']", TimeOut.LONG.value);
        BaseStep.clickElement(tarihInput, "Tarih alanına tıklandı");
        waitSeconds(1);
        WebElement tarihInput2 = BaseStep.findElementXpathWithWait("//input[@placeholder='Doğum tarihi girin (GG-AA-YYYY)']", TimeOut.LONG.value);
        BaseStep.clearAndType(tarihInput2, "07042003", "İşe Başlama Tarihi girildi");
        tarihInput2.sendKeys(org.openqa.selenium.Keys.ENTER);

        LogTest.info("Organizasyon sekmesine tıklanıyor...");
        WebElement organizationTab = findElementXpathWithWait("//div[@data-node-key='2']", TimeOut.LONG.value);
        BaseStep.clickElement(organizationTab, "Organizasyon sekmesine geçildi");
        waitSeconds(1);
        LogTest.info("Organizasyon sekmesi başarıyla açıldı.");

        LogTest.info("Departman seçimi başlatılıyor...");
        WebElement departmentDropdown = findElementXpathWithWait("//input[@id='organizationalUnitId']", TimeOut.LONG.value);
        BaseStep.clickElement(departmentDropdown, "Departman listesi açıldı");
        waitSeconds(1);
        WebElement crmtest = BaseStep.findElementXpathWithWait("//input[@id='organizationalUnitId']", TimeOut.LONG.value);
        BaseStep.clearAndType(crmtest, " Test Departmanı", " Test Departmanı ");
        crmtest.sendKeys(org.openqa.selenium.Keys.ENTER);
        waitSeconds(2);

        LogTest.info("Form kaydediliyor...");
        WebElement saveButton = findElementXpathWithWait("//button[@type='submit']//span[text()='Kaydet']", TimeOut.LONG.value);
        BaseStep.clickElement(saveButton, "Kaydet butonuna tıklandı");
        LogTest.info("Yeni çalışan başarıyla kaydedildi.");
    }
}
