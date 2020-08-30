package org.base2tecnologia.aldreamor.test;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;
import java.util.List;

@ExtendWith(SeleniumExtension.class)
public class OneTest {

    ChromeDriver driver;
    FirefoxDriver driver2;

    public OneTest(ChromeDriver driver) {
        this.driver = driver;
    }

    /*public OneTest(ChromeDriver driver,FirefoxDriver driver2) {
        this.driver = driver;
        this.driver2 = driver2;
    }*/

    /*@Test
    @DisplayName("Esse aqui vai ser meu primeiro Teste")
    void deveExecutarOPrimeiroTeste() {
        int value = 0;
        Assertions.assertThat(0).isEqualTo(0);
    }*/

    @Test
    @DisplayName("Acessando via Chrome a página principal do base2")
    public void testWithOneChrome() {
        driver.get("https://www.base2.com.br/");
        Assertions.assertThat(driver.getTitle()).contains("Home - Especialistas em Testes de Software e Crowdtest | Base2");
    }

    @Test
    @DisplayName("Navegando no site Base2")
    public void testNavegandoSite() {
        try {
            driver.get("https://www.base2.com.br/");

            String value = driver.findElement(By.cssSelector("#menu-item-729")).getTagName();
            System.out.println("Menu encontrado "+value);

            /*WebElement menu = driver.findElement(By.cssSelector("#menu-item-729"));
            //WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'Seja um Testador')]"));
            //driver.findElement(By.id("menu-item-729")).click();
            Actions actions = new Actions(driver);
            //Instant wait = null;
            //wait.until(ExpectedConditions.visibilityOfElementLocated((menu));
            actions.moveToElement(menu);
            actions.click();
            actions.perform();
            //encontra segundo menu e acessa o menu<br>
           // driver.findElement(By.linkText("Seja um Testador")).click();

            /*Actions acao = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(menu));
            WebElement menuMouseOver = driver.findElement(menu);
            acao.moveToElement(menuMouseOver).moveToElement(driver.findElement(itemMenu)).click().build().perform();


            Actions acao = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(menu));
            acao.moveToElement(driver.findElement(menu));
            acao.moveToElement(driver.findElement(itemMenu));
            acao.click();
            acao.perform()*/



        } finally {
            driver.quit();
        }
    }

    /*@Test
    @DisplayName("Acessando via Firefox a página principal do base2")
    public void testWithOneFirefox(){
        driver2.get("https://www.base2.com.br/");
        Assertions.assertThat(driver2.getTitle()).contains("Home - Especialistas em Testes de Software e Crowdtest | Base2");
    }*/
}
