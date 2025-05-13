import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestSUT {

    @Test

    void shouldCheckSUT(){
        given()
                .baseUri("https://localhost:9999")
                .when()
                .get("/api/v1/demo/accounts")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=UTF-8")
                .body("[0].id",equalTo(1))
                .body("[0].currency",equalTo("RUB"))
                .body("[0].balance",equalTo(992821429));
    }

}
