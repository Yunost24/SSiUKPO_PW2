import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPI {
@Test
    void shouldCheckSpoonAcularAPI(){
    given()
            .baseUri("https://api.spoonacular.com")
            .header("x-api-key", "f1252da49b1940b0880122422f2b78ff")
            .param("query", "pasta")
            .param("maxFat", "25")
            .param("number", 2)
            .when()
            .get("/recipes/complexSearch")
            .then()
            .statusCode(200)
            .contentType("application/json")
            .body("results[0].id", equalTo(642583));


}
}
