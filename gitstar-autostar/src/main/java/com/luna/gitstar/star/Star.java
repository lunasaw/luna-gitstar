package com.luna.gitstar.star;

import com.luna.common.utils.CountDownUtils;
import com.luna.gitstar.MyChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author luna@mac
 * @className Star.java
 * @description TODO
 * @createTime 2021年01月21日 15:27:00
 */
public class Star {

    private static String       STAR_ID_SELECTOR      = "#data_list>li:nth-child(1)>div>div.fl>div>a";

    private static String       STAR_BUTTON_SELECTOR  = "#btnStar";

    private static String       PAGE_SELECTOR         = "#layui-laypage-2>a:nth-child(3)";

    private static final String DASHBOARD_ID_SELECTOR =
        "body>div:nth-child(1)>div.title_container>div>div:nth-child(1)>div>a";

    /**
     * star
     * 
     * @throws InterruptedException
     */
    public static void star() throws InterruptedException {
        Thread.sleep(2000L);
        for (int i = 1; i < 20; i++) {
            WebDriverWait wait = new WebDriverWait(MyChromeDriver.chromeDriver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(DASHBOARD_ID_SELECTOR)));
            STAR_ID_SELECTOR = "#data_list>li:nth-child(" + i + ")>div>div.fl>div>a";
            CountDownUtils.countDown(3);
            MyChromeDriver.chromeDriver
                .findElement(By.cssSelector(STAR_ID_SELECTOR))
                .click();

            // 获取当前页面句柄
            String handle = MyChromeDriver.chromeDriver.getWindowHandle();
            // 获取所有句柄，循环判断是否等于当前句柄
            for (String handles : MyChromeDriver.chromeDriver.getWindowHandles()) {
                if (handles.equals(handle)) {
                    continue;
                }
                MyChromeDriver.chromeDriver.switchTo().window(handles);
            }

            WebElement element = MyChromeDriver.chromeDriver
                .findElement(By.cssSelector(STAR_BUTTON_SELECTOR));
            CountDownUtils.countDown(3);

            // 点击
            try {
                element.click();
            } catch (Exception e) {
                MyChromeDriver.chromeDriver.close();

                MyChromeDriver.chromeDriver.switchTo().window(handle);
            }

            CountDownUtils.countDown(4);
            MyChromeDriver.chromeDriver.close();
            MyChromeDriver.chromeDriver.switchTo().window(handle);
        }
    }

    public static void changePage(int startPage, int pageSize) {

        for (int i = startPage; i < pageSize; i++) {

            for (int i1 = 1; i1 < startPage; i1++) {
                WebDriverWait wait = new WebDriverWait(MyChromeDriver.chromeDriver, 20);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("layui-laypage-next")));

                CountDownUtils.countDown(3);
                MyChromeDriver.chromeDriver
                    .findElement(By.className("layui-laypage-next"))
                    .click();
            }
            try {
                star();
            } catch (InterruptedException e) {

            }

            WebDriverWait wait = new WebDriverWait(MyChromeDriver.chromeDriver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("layui-laypage-next")));

            CountDownUtils.countDown(3);
            MyChromeDriver.chromeDriver
                .findElement(By.className("layui-laypage-next"))
                .click();

        }
    }
}
