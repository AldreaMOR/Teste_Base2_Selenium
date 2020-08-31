package org.base2tecnologia.aldreamor.test;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@ExtendWith(SeleniumExtension.class)
public class OneTest {

    ChromeDriver driver;
    //FirefoxDriver driver2;

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
    @DisplayName("Eu como usuário quero acessar a página principal do base2 via navegador Chrome")
    public void deveAcessarPaginaPrincipal() {
        driver.get("https://www.base2.com.br/");
        Assertions.assertThat(driver.getTitle()).contains("Home - Especialistas em Testes de Software e Crowdtest | Base2");
    }

    @Test
    @DisplayName("Eu como usuário quero navegar pelo menu da página principal do base2")
    public void deveNavegarMenu() {
        try {
            driver.get("https://www.base2.com.br/");

           /* WebElement webElementTitle =
                    driver.findElement(By.cssSelector("a[href=\"https://www.base2.com.br/seja-um-testador/\"]"));
            Assertions.assertThat(webElementTitle.getText()).isEqualTo("Seja um Testador");*/

            driver.findElement(By.cssSelector("a[href=\"https://www.base2.com.br/seja-um-testador/\"]")).isSelected();
            //driver.findElement(By.cssSelector("li[\"menu-item-729\"]")).isSelected();

            /*ArrayList tabs = new ArrayList (driver.getWindowHandles());
            driver.switchTo().window((String) tabs.get(1));*/

        } finally {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Eu como usuário quero clicar no botão 'Instruções' localizado abaixo de 'Como Relatar Bugs' " +
            "para acessar a página correspondente, após o acesso do Menu CrowdTest > Seja um testador.")
    public void deveClicarNoBotaoInstrucoesComLegendaComoRelatarBugs() throws InterruptedException {
        driver.get("https://www.base2.com.br/seja-um-testador/");

        driver.findElement(By.cssSelector("a[href=\"/instrucoes-para-relatar-bugs\"]")).click();

        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));

        WebElement webElementTitle = driver.findElement(By.cssSelector("h3.widget-title"));
        Assertions.assertThat(webElementTitle.getText()).isEqualTo("Instruções para relatar bugs".toUpperCase());
    }

    @Test
    @DisplayName("Eu como usuário quero navegar na página 'Instruções para relatar bugs' e visualizar o link 'tipos de bugs'.")
    public void devoVisualizarLinkTiposdeBugs() {
        driver.get("https://www.base2.com.br/instrucoes-para-relatar-bugs/");

        WebElement webElementTitle =
                driver.findElement(By.cssSelector("a[href=\"https://app.crowdtest.me/tipos-bugs-softwares/\"]"));
        Assertions.assertThat(webElementTitle.getText()).isEqualTo("tipos de bugs");

    }

    @Test
    @DisplayName("Eu como usuário quero navegar na página 'Instruções para relatar bugs' e clicar no link 'tipos de bugs'.")
    public void devoClicarLinkTiposdeBugs() {
        driver.get("https://www.base2.com.br/instrucoes-para-relatar-bugs/");

        driver.findElement(By.cssSelector("a[href=\"https://app.crowdtest.me/tipos-bugs-softwares/\"]")).click();

        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));

        //delay
        Assertions.assertThat(driver.getTitle()).contains("page");

    }

    @Test
    @DisplayName("Eu como usuário quero visualizar a página Tipos de Testes, após acessar o link.")
    public void devoVisualizarPaginaAposClicarLink() {
        try {
            /*Este teste irá dar erro porque a página não existe.*/
            driver.get("https://app.crowdtest.me/tipos-bugs-softwares/");
            //captureNetworkTraffic();
            Assertions.assertThat(driver.getTitle()).contains("Tipos de teste");
            /*Boolean value = driver.getTitle().contains("Tipos de teste");

            if (value) {
                System.out.println("Title encontrado!");
            }else{
                System.out.println("Title encontrado foi "+driver.getTitle());
            }*/

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
