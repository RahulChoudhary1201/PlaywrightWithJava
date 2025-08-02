package testcases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.Arrays;

public class NavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        Page page = context.newPage();
        page.navigate("https://google.com");
        System.out.println(page.title());
        Thread.sleep(1000);
        page.navigate("https://youtube.com");
        System.out.println(page.title());
        page.goBack(new Page.GoBackOptions().setTimeout(1000));
        page.goForward(new Page.GoForwardOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        page.reload(new Page.ReloadOptions().setWaitUntil(WaitUntilState.LOAD));




        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
