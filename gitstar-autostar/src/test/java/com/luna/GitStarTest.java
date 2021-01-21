package com.luna;

import com.luna.gitstar.MyChromeDriver;
import com.luna.gitstar.login.Login;
import com.luna.gitstar.star.Star;
import org.junit.Test;
import sun.rmi.runtime.Log;

/**
 * @author luna@mac
 * @className GitStarTest.java
 * @description TODO
 * @createTime 2021年01月21日 15:35:00
 */
public class GitStarTest {

    @Test
    public void autoStar() throws InterruptedException {
        Login.login("3e9be0cfbac0630cbfadb09e26b802962f9e1869");
        Star.changePage(2, 5);
        MyChromeDriver.chromeDriver.quit();
    }

}
