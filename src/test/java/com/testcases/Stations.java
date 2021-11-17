package com.testcases;
import baseclass.com.baseclass;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Stations extends baseclass{



    @Test
    public void addstationInvalid(){
        RestAssured.baseURI=baseurl; //This can be set in base class
        //Common header can be set using 
        /*
        @BeforeClass
	    public static void setup() {
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.addHeader("Content-Typ", "application/json");
		requestspec=builder.build();
        
        Then to use 
        Instead of >>
        .header("Content-Type","application/json")
        use this
        .spec(requestspec)
	}
        */
        
        /*
        Don't pass body directly , Create payload separatly 
        */
        given()
            .header("Content-Type","application/json")
            .queryParam("appid",apiId)
            .body("{\n" +
                "  \"external_id\": \"SF_TEST001\",\n" +
                "  \"name\": \"San Francisco Test Station\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}")
            .when()
            .post("/data/3.0/stations")
            .then()
            .log().all()
            .statusCode(201);
    }
}
