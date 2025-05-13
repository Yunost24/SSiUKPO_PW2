import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class TestCard {
    @Test

    void shouldCheckCardOrdering (){

        InputStream testData = this.getClass().getClassLoader().getResourceAsStream("datatest.json");
        given()
                .baseUri("https://functions.yandexcloud.net")
                .body(testData)
                .with()
                .contentType(ContentType.JSON)
                .when()
                .post("/d4e8qsrmeednndemfsus")
                .then()
                .statusCode(200)
                .body("data.name", equalTo("Cергей"))
                .body("success", equalTo(true))
                .assertThat().body(matchesJsonSchemaInClasspath("testDataCard.Schema.json"));

    }

}
