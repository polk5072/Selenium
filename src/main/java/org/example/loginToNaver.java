package org.example;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginToNaver {

    public static void main(String[] args) {
        loginToNaver Test = new loginToNaver();
        Test.login();
    }

    private WebDriver driver;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Selenium_Java/Selenium/chromedriver.exe";

    private String base_url;

    public loginToNaver(){
        super();

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        driver = new ChromeDriver();
        base_url = "https://www.naver.com";
    }

    public void login() {

        try {
            driver.get(base_url);

            //login 버튼 Xpath 엘리먼트 찾기
            WebElement button = driver.findElement(By.xpath("//*[@id=\"account\"]/div/a"));
            button.click();

            // ID/PW 입력
            WebElement inputID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
            WebElement inputPW = driver.findElement(By.xpath("//*[@id=\"pw\"]"));

            inputID.sendKeys("polk5072");
            inputPW.sendKeys("Asd4491324!");

            Thread.sleep(20000);

            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"log.login\"]"));
            loginButton.click();

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            driver.quit();

        }
    }

}
