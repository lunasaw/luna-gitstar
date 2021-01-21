package com.luna.gitstar.login;

import com.luna.gitstar.MyChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author luna@mac
 * @className Login.java
 * @description TODO
 * @createTime 2021年01月21日 15:20:00
 */
public class Login {

    private static final String DASHBOARD_ID_SELECTOR =
        "body>div:nth-child(1)>div.title_container>div>div:nth-child(1)>div>a";

    /**
     * 登录
     *
     * @param token
     * @throws InterruptedException
     */
    public static void login(String token) throws InterruptedException {
        MyChromeDriver.chromeDriver.get("https://gitstar.com.cn/auth_by_self");
        Thread.sleep(2000L);
        // 使用额token定位手机号的输入框
        WebElement inputEmail = MyChromeDriver.chromeDriver
            .findElement(By.cssSelector("#token"));
        // 清除输入框内容
        inputEmail.clear();
        // 输入token
        inputEmail.sendKeys(token);
        // 休息一秒
        Thread.sleep(1000L);
        // 提交
        MyChromeDriver.chromeDriver
            .findElement(By.cssSelector("body>div>div.layui-form-item>button"))
            .click();
        WebDriverWait wait = new WebDriverWait(MyChromeDriver.chromeDriver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(DASHBOARD_ID_SELECTOR)));
    }

    public static void main(String[] args) throws InterruptedException {
        login("853ccd360419bb9ab76de6836287444dcdbd6a8d");
    }

}
