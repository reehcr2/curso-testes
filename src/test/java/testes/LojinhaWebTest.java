package testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LojinhaWebTest {
    @Test
    public void testValidarDadosDoProduto(){
        //Preparaçao
        System.setProperty("webdriver.edge.driver", "/home/renato/drivers/edgedriver_linux64/msedgedriver");
        WebDriver navegador = new EdgeDriver();
        navegador.get("http://165.227.93.41/lojinha-web/");

        //Login com usuario reehcr2 e senha 123456
        navegador.findElement(By.cssSelector("#usuario")).sendKeys("reehcr2");
        navegador.findElement(By.id("senha")).sendKeys("123456");
        navegador.findElement(By.cssSelector(".btn")).click();

        //Acessar o produto na lista de produtos
        navegador.findElement(By.linkText("Fone de ouvido jbl 2")).click();

        //Mais de um elemento
        //navegador.findElements(By.linkText("Fone de ouvido jbl 2")).get(0).click();

        //Validaçao do nome do Produto e do nome do primeiro componente
        String produtonome = navegador.findElement(By.cssSelector("#produtonome")).getAttribute("value");
        Assert.assertEquals("Fone de ouvido jbl 2", produtonome);

        String componentenome = navegador.findElements(By.cssSelector(".title")).get(0).getText();
        Assert.assertEquals("Lojinha caixa", componentenome);

        //fechar navegador
        navegador.quit();
    }
}
