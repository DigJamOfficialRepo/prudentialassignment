import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class ApiTest {
    @Test
    public void checkStatus(){
        RestAssured.baseURI = "http://localhost:8080";
        given()
                .header ("Content-type","application/json")
                .queryParam("bookName","theSecret")
                .when()
                .get ("/mockApi/get")
                .then ()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void checkBody(){
    RestAssured.baseURI = "http://localhost:8080";
    given()
                .header ("Content-type","application/json")
                .queryParam("bookName","theSecret")
                .when()
                .get("/mockApi/get")
                .then()
                .assertThat()
                .body("author",equalTo("Rhonda Byrne"))
                .body ("pages",equalTo(198) )
                .body( "ISBN",equalTo("978-1-58270-170-7"));

        }
}