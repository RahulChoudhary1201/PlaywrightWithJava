package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class LaunchInNonIncognito {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));

        Page page = context.newPage();
        page.navigate("https://google.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        context.close();
        playwright.close();
    }
}
