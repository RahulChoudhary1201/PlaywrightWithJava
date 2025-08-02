package testcases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class TestGenerator {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demo.playwright.dev/todomvc/#/");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("hello there");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).press("Enter");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("good morning");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).press("Enter");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("Good night");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).press("Enter");
            page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("hello there")).getByLabel("Toggle Todo").check();
            page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Good night")).getByLabel("Toggle Todo").check();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Active")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Completed")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear completed")).click();

        }
    }
}