import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * DHR projesinin tüm modül testlerini sıralı şekilde çalıştıran Suite sınıfı.
 *
 * Çalıştırma:
 *   mvn test -Dtest=DhrAllModulesSuite
 *
 * Yeni bir modül test sınıfı eklediğinizde:
 *   1. Yeni sınıfı yazın (örn: DhrLeaveModuleTest.java)
 *   2. Aşağıdaki @SelectClasses listesine ekleyin
 *   3. Suite'i çalıştırdığınızda otomatik olarak sıralı çalışır
 *
 * Sıralama kuralı:
 *   - Sınıflar @SelectClasses içindeki yazım sırasına göre çalışır
 *   - Her sınıfın içindeki @Test metodları @Order annotation'ına göre sıralı çalışır
 */
@Suite
@SuiteDisplayName("DHR All Modules Test Suite")
@SelectClasses({
        DashboardTest.class,
        PersonnelManagementTest.class,
        DocumentManagementTest.class,
        LeaveManagementTest.class,
        /*
        AttendanceTrackingTest.class,
        InventoryManagementTest.class,
        StockManagementTest.class,
        TaskManagementTest.class,
        CvAnalyzerTest.class,
        OvertimeManagementTest.class,
        PayrollManagementTest.class,
        PerformanceManagementTest.class,
        MyDashboardTest.class,
        MyInformationTest.class,
        MyDocumentsTest.class,
        MyLeavesTest.class,
        MyAttendanceTest.class,
        MyInventoriesTest.class,
        MyTasksTest.class,
        MyOvertimesTest.class,
        MyPayrollsTest.class,
        MyPerformanceTest.class
        */
         
})
@ConfigurationParameter(
        key = "junit.jupiter.testclass.order.default",
        value = "org.junit.jupiter.api.ClassOrderer$OrderAnnotation"
)
public class DhrAllModulesSuite {

}
