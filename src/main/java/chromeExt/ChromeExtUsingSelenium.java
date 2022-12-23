package chromeExt;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeExtUsingSelenium {

    public static void main(String[] args) throws InterruptedException, AWTException {

        //Chrome Ayarlama
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        // Chrome Emparazon Eklentisini Ayarlama
        opt.addExtensions(new File("Emparazon.crx"));
        ChromeDriver driver = new ChromeDriver(opt);
        driver.manage().window().maximize();

        //amazon.com Web Sayfası AÇ
        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        //getData(driver);

        //Chrome EKLENTİ İKONUNU TIKLAMA
        Robot robot = new Robot();
        robot.mouseMove(900,55);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

        //Emparazon İKONUNU TIKLAMA
        robot.mouseMove(800,185);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

        //Emparazon Eklentisi Kullanıcı girişi için; mail ve şifre GİRİŞ YAP
        driver.findElement(By.id("txtUsername")).
                sendKeys("sibelkay2020@gmail.com");
        driver.findElement(By.id("txtPassword")).
                sendKeys("As121212+");
        driver.findElement(By.id("buttonForSignIn")).click();
        Thread.sleep(3000);

        //amazon.com da ÜRÜN ADINI YAZ VE ARAMA Yap-
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);

        //Arama Sonucu Çıkan İLK ÜRÜNÜ TIKLA
        driver.findElement(By.className("s-image")).click();
        Thread.sleep(3000);

        //ÜRÜNÜN Emparazon "Liste Skoru" menüsünü tıkla ve detay göster
        driver.findElement(By.id("listScoreBtn")).click();
        Thread.sleep(5000);

        // ÜRÜNÜN Emparazon "Stok Miktarını Görüntüle" menüsünü tıkla
        driver.findElement(By.id("stockFinder")).click();
        Thread.sleep(5000);

        //Chrome Kapat
        //driver.quit();

        System.out.println("TEST BİTTİ");

    }
}