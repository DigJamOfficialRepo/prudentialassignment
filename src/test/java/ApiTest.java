import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class ApiTest {
    @Test
    public void checkStatus(){
        RestAssured.baseURI = "https://681ad72b-5900-4b7e-9e82-bd11b26dadd1.mock.pstmn.io";
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
        RestAssured.baseURI = "https://681ad72b-5900-4b7e-9e82-bd11b26dadd1.mock.pstmn.io";
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
