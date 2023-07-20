package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        Main Test = new Main();
        Test.crawl();
    }

    private WebDriver driver;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Selenium_Java/Selenium/chromedriver.exe";

    private String base_url;

    public Main() {
        super();

        System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH);

        //Drvier Setup
        driver = new ChromeDriver();
        base_url = "https://www.naver.com";
    }

    public void crawl() {

        try{
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request한 것과 같다)
            driver.get(base_url);
            System.out.println(driver.getPageSource());
        }catch (Exception e){

            e.printStackTrace();

        }finally {
            driver.close();
        }
    }
}

