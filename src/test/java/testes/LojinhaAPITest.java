package testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class LojinhaAPITest {
    private String token;
    @Before
    public void setUp(){
        RestAssured.baseURI = "http://165.227.93.41";
        RestAssured.basePath = "lojinha";

        token = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                        "\t\"usuariologin\": \"reehcr2\",\n" +
                        "\t\"usuariosenha\": \"123456\"\n" +
                        "}")
                .when()
                    .post("login")
                .then()
                    .extract()
                        .path("data.token");

    }

    @Test
    public void testBuscarDadosDeUmProdutoEspecifico(){

        RestAssured
                .given()
                    .header("token",token)
                .when()
                    .get("produto/13284")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.produtonome", Matchers.equalTo("Fone de ouvido jbl 2"))
                        .body("data.componentes[0].componentenome", Matchers.equalTo("caixa"))
                        .body("message", Matchers.equalTo("Detalhando dados do produto"));

    }

    @Test
    public void testBuscarDadosDeUmComponenteDeProduto(){

        RestAssured
                .given()
                    .header("token", token)
                .when()
                    .get("produto/13284/componente/8274")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.componentenome", Matchers.equalTo("caixa"))
                        .body("data.componentequantidade", Matchers.equalTo(222))
                        .body("message", Matchers.equalTo("Detalhando dados do componente de produto"));

    }
}
