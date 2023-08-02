package com.automationexcercise.api;

import com.automationexcercise.entities.User;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


public class CreateAccount {
    public static void newUser(User user) {
        given()
                .multiPart("name", user.getName())
                .multiPart("email", user.getEmail())
                .multiPart("password", user.getPassword())
                .multiPart("title", user.getGender())
                .multiPart("birth_date", String.valueOf(user.getDateOfBirth().getDayOfMonth()))
                .multiPart("birth_month", String.valueOf(user.getDateOfBirth().getMonth()))
                .multiPart("birth_year", String.valueOf(user.getDateOfBirth().getYear()))
                .multiPart("firstname", user.getName())
                .multiPart("lastname", user.getLastName())
                .multiPart("address1", user.getAddress())
                .multiPart("country", user.getCountry())
                .multiPart("zipcode", user.getZipcode())
                .multiPart("state", user.getState())
                .multiPart("city", user.getCity())
                .multiPart("mobile_number", user.getMobileNumber())
                .when()
                .contentType(ContentType.MULTIPART)
                .post("https://automationexercise.com/api/createAccount")
                .then()
                .assertThat()
                .statusCode(200).log().body();
    }
}
