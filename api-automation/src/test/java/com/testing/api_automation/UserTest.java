package com.testing.api_automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserTest {

    public static String baseURI = "https://practice.expandtesting.com/notes/api";
    public static String email = "user" + System.currentTimeMillis() + "@test.com";
    public static String password = "User@123";
    public static String token;

    @Test(priority = 1, description = "TC01: Register new user with valid details")
    public void createUser() {
        RestAssured.baseURI = baseURI;

        Response response = given()
            .header("Content-Type", "application/json")
            .body("{\"name\": \"Test User\", \"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
        .when()
            .post("/users/register")
        .then()
            .statusCode(201)
            .body("message", equalTo("User account created successfully"))
            .extract().response();

        System.out.println("Registered new user: " + email);
        System.out.println("New user: " + response.asPrettyString());
    }

    @Test(priority = 2, description = "TC04: Login with valid credentials")
    public void loginUser() {
        RestAssured.baseURI = baseURI;

        Response response = given()
            .header("Content-Type", "application/json")
            .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
        .when()
            .post("/users/login")
        .then()
            .statusCode(200)
            .body("message", equalTo("Login successful"))
            .extract().response();

        token = response.path("data.token");
        System.out.println("Logged in with token: " + token);
    }

    @Test(priority = 3, description = "TC07: Create new note with valid fields")
    public void createNote() {
        RestAssured.baseURI = baseURI;

        String requestBody = """
        {
            "title": "Practice WebApp UI",
            "description": "Finish the development of the UI Automation Practice WebApp",
            "category": "Home"
        }
        """;

        Response response = given()
            .header("Content-Type", "application/json")
            .header("x-auth-token", token)
            .body(requestBody)
        .when()
            .post("/notes")
        .then()
            .statusCode(200)
            .body("success", equalTo(true))
            .body("message", equalTo("Note successfully created"))
            .body("data.title", equalTo("Practice WebApp UI"))
            .body("data.description", equalTo("Finish the development of the UI Automation Practice WebApp"))
            .body("data.category", equalTo("Home"))
            .body("data.completed", equalTo(false))
            .extract()
            .response();

        String noteId = response.path("data.id");
        System.out.println("Note created with ID: " + noteId);
    }

    @Test(priority = 4, description = "TC09: Create new note with valid fields")
    public void getAllNotes() {
        RestAssured.baseURI = baseURI;

        Response response = given()
            .header("x-auth-token", token)
        .when()
            .get("/notes")
        .then()
            .statusCode(200)
            .body("data", not(empty()))
            .extract().response();

        System.out.println("All notes: " + response.asPrettyString());
    }
}
