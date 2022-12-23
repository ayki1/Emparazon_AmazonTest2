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

        //Chrome EKLENTİ İKONUNU TIKLAMA
        Robot robot = new Robot();
        robot.mouseMove(900,55); // mouse koordinata git
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
                sendKeys("yusufbatur2017@gmail.com");
        driver.findElement(By.id("txtPassword")).
                sendKeys("aaaaaa");
        driver.findElement(By.id("buttonForSignIn")).click();
        Thread.sleep(3000);

        //amazon.com da ÜRÜN ADINI YAZ VE ARAMA Yap-
        driver.findElement(By.id("twotabsearchtextbox")).
                sendKeys("shoe");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);

        //Arama Sonucu Çıkan İLK ÜRÜNÜ TIKLA
        driver.findElement(By.className("s-image")).click();
        Thread.sleep(3000);

        //ÜRÜNÜN Emparazon "KAR MARJI HESAPLA" menüsünü tıkla ve detay göster
        driver.findElement(By.id("profitMargin")).click();
        Thread.sleep(3000);

        // ÜRÜNÜN Emparazon "ÜRÜN FİYAT DEĞİŞTİR" menüsü girdi yap ve
        // verileri yazdır
        WebElement urunFiyat= driver.findElement(By.id("priceInput"));
        System.out.println("productPrice.getText() = " + urunFiyat.getText());

        WebElement netKar= driver.findElement(By.id("netRevenue"));
        System.out.println("netKar.getText() = " + netKar.getText());
        driver.findElement(By.id("priceInput")).sendKeys("150");

        System.out.println("productPrice.getText() = " + urunFiyat.getText());
        System.out.println("netKar.getText() = " + netKar.getText());

        Thread.sleep(3000);

        //Chrome Kapat
        //driver.quit();

        System.out.println("TEST BİTTİ");

    }
}