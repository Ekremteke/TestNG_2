package com.infoTech.tests;

import com.infoTech.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsHandleTest extends TestBase {
    @Test
    public void WindowsHandle() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String handle = driver.getWindowHandle();
        System.out.println(handle);

       driver.findElement(By.partialLinkText("Click Here")).click();
       // element.click();

        //Tum sayfalarin handle'ini aliyoruz

        Set<String> tumElementler = driver.getWindowHandles();

        for (String w:tumElementler) {
            System.out.println(w);
        }

        //Set olan listemizi once Array'e cevriyruz
        Object[] array=(Object[]) tumElementler.toArray();

        //istedigimiz sayfanin index'ini yazdirip cagiriyoruz..
        String sonSayfaHandle = array[array.length-2].toString();
        System.out.println("Son sayfa handle => " + sonSayfaHandle);

        Thread.sleep(2000);
        driver.switchTo().window(handle);

    }
}
