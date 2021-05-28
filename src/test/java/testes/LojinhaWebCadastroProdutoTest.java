package testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LojinhaWebCadastroProdutoTest {
    @Test
    public void testCadastrarProduto() {
        System.setProperty("webdriver.edge.driver", "/home/renato/drivers/edgedriver_linux64/msedgedriver");
        WebDriver navegador = new EdgeDriver();
        navegador.get("http://165.227.93.41/lojinha-web/");

        navegador.findElement(By.cssSelector("#usuario")).sendKeys("reehcr2");
        navegador.findElement(By.id("senha")).sendKeys("123456");
        navegador.findElement(By.cssSelector(".btn")).click();

        //clicar em add produto
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        //Preencher os dados
        navegador.findElement(By.id("produtonome")).sendKeys("Celular 3");
        navegador.findElement(By.id("produtovalor")).sendKeys("190000");
        navegador.findElement(By.id("produtocores")).sendKeys("Verde");
        navegador.findElements(By.cssSelector(".btn")).get(0).click();

        //Validar a mensagem do Toast
        String mensagemsucesso = navegador.findElement(By.cssSelector(".toast")).getText();
        Assert.assertEquals("Produto adicionado com sucesso", mensagemsucesso);

        System.out.println(mensagemsucesso);
        navegador.quit();
    }

}
