package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class LaunchDiffBrowser {
    public static void main(String[] args) throws InterruptedException {

        String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        String edgePath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
        String firefoxPath = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
//        openFirefox(firefoxPath);
        openEdge(edgePath);
        openChrome(chromePath);


    }

    public static void openChrome(String chromePath) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)).setArgs(Arrays.asList("--start-maximized")));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://youtube.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }

    public static void openEdge(String edgePath) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setExecutablePath(Paths.get(edgePath)).setArgs(Arrays.asList("--start-maximized")));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://youtube.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }

    public static void openFirefox(String firefoxPath) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(firefoxPath)).setArgs(Arrays.asList("--start-maximized")));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://youtube.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
