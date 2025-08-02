package testcases;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://google.com");
        System.out.println(page.title());
        Thread.sleep(3000);
        page.close();
        playwright.close();
    }


}
