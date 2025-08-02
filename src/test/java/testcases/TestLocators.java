package testcases;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class TestLocators {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        Page page = context.newPage();
        page.navigate("https://accounts.google.co.in/");
        String id="identifierId";
//        page.locator("id="+id).fill("rk155898@gmail.com");
        page.locator("[id=identifierId]").pressSequentially("rk155898@gmail.com", new Locator.PressSequentiallyOptions().setDelay(100));
//        page.fill("id=identifierId","rk155898@gmail.com");
//        page.fill("type=email","rk155898@gmail.com");
//        page.click("text=Next");
        page.click("button:has-text('Next')");
        Thread.sleep(3000);
        page.close();
        context.close();
        browser.close();
        playwright.close();


    }
}
