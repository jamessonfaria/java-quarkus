package br.com.jamesson;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutasResourceTest {

    @Inject
    FrutasService frutasService;

    @Test
    public void testEndpoint() {
        given()
         // .when().get("/frutas")
          .then()
             .statusCode(200)
             .body(is("[{\"id\":1,\"nome\":\"Maça\",\"qtd\":5},{\"id\":2,\"nome\":\"Banana\",\"qtd\":2},{\"id\":3,\"nome\":\"Laranja\",\"qtd\":3},{\"id\":4,\"nome\":\"Uva\",\"qtd\":1}]"));
    }

    @Test
    public void testListFrutas() {
        List<Fruta> list = frutasService.list();
        assertFalse(list.isEmpty());
    }

}