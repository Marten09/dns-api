package ru.marten.dnsapi.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Parser {
    private static final String url = "https://www.citilink.ru/catalog/videokarty/?pf=discount.any%2Crating.any&f=discount.any%2Crating.any%2C9368_29nvidiad1d1geforced1rtxd14070ti";

    public Elements getAllElementsFromHtmlPage() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36");
        options.addArguments("--headless", "--window-size=1920,1200", "--ignore-certificate-errors", "--silent");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(url);
        Document doc = Jsoup.parse(webDriver.getPageSource());
        return doc.select(".app-catalog-15mhgn3 [data-meta-price]");
    }
}
