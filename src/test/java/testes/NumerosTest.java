//Teste de unidade

package testes;

import numeros.Numeros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {
    //Declarar que numeros e um atributo da classe NumerosTest
    private Numeros numeros;

    //Isolar o que e igual nos testes
    @Before
    public void setUp(){
        numeros = new Numeros();
    }

    @Test
    public void testeValidarSeEUmaUnidade(){
        //Vou utilizar o metodo eUmaUnidade passando o valor 9, que se trata de uma unidade
        boolean eUnidade = numeros.eUmaUnidade(9);

        //Validar que a resposta e verdadeira
        Assert.assertTrue(eUnidade);
    }

    @Test
    public void testeValidarSeUmNumeroNaoEUmaUnidade(){
        //Vou utilizar o metodo eUmaUnidade passando o valor 10, que nao trata se de uma unidade
        boolean eUnidade = numeros.eUmaUnidade(10);

        //Validar que a resposata e falsa
        Assert.assertFalse(eUnidade);
    }
}
