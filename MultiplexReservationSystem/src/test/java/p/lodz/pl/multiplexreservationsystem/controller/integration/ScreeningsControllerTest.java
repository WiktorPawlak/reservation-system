package p.lodz.pl.multiplexreservationsystem.controller.integration;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

class ScreeningsControllerTest {

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void getScreeningsWithMoviesIntegrationTest() {

        get("/screenings").then().statusCode(200).assertThat()
                .body(
                        "[0].title", equalTo("Batman"),
                        "[0].duration", equalTo("02:56:00")
                );
    }

    @Test
    void getSingleScreeningIntegrationTest() {

        get("/screenings/1").then().statusCode(200).assertThat()
                .body(
                        "id", equalTo(1),
                        "seats[0].row", equalTo(1),
                        "seats[0].seatNumber", equalTo(2),
                        "seats[1].row", equalTo(1),
                        "seats[1].seatNumber", equalTo(3),
                        "seats[2].row", equalTo(1),
                        "seats[2].seatNumber", equalTo(4)
                );
    }

    @Test
    void getScreeningsWithinPeriodIntegretionTest() {

        get("/screenings/2022-04-19T11:00,2023-04-19T11:00?page=-3").then().statusCode(200).assertThat().and()
                .body(
                        "[0].title", equalTo("Batman"),
                        "[0].duration", equalTo("02:56:00"),
                        "[1].title", equalTo("Fantastic Beasts: The Secrets of Dumbledore"),
                        "[1].duration", equalTo("01:30:00"),
                        "[2].title", equalTo("Morbius"),
                        "[2].duration", equalTo("01:32:00")
                );
    }
}