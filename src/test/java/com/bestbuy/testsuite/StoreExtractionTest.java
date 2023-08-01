package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println(limit);
    }

    //2. Extract the total
    @Test
    public void test002() {
        int Total = response.extract().path("total");
        System.out.println(Total);
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");
        System.out.println(name);
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> names = response.extract().path("data.name");
        System.out.println(names);
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> Id = response.extract().path("data.id");
        System.out.println(Id);
    }
    //6. Print the size of the data list
    @Test
            public void test006() {
        List<HashMap<String, ?>> size = response.extract().path("data.name");
        int data = size.size();
        System.out.println(data);
    }

    //7. Get all the value of the store where store name = St Cloud

    @Test
    public void test007(){
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name = 'St Cloud'}");
        System.out.println(value);
    }
    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008(){
        List<String> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println(address);
    }
    //9. Get all the services of 8th store

    @Test
    public void test009(){
        List<HashMap<String, ?>> allServices = response.extract().path("data[7].services");
        System.out.println(allServices);
    }
    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010(){
        List<HashMap<String, ?>> storeservice = response.extract().path("data.services*.findAll{it.name == 'Windows Store'}.storeservices");
        System.out.println(storeservice);
    }
    //11. Get all the storeId of all the store
    @Test
    public void test011(){
        List<Integer> storeIds = response.extract().path("data.services.storeservices.storeId");
        System.out.println(storeIds);
    }
    //12. Get id of all the store
    @Test
    public void test012() {
        List<Integer> id = response.extract().path("data.id");
        System.out.println(id);
    }
    //13. Find the store names Where state = ND
    @Test
    public void test013() {
        List<HashMap<String, ?>> storeName = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println(storeName);
    }
    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        List<HashMap<String, ?>> NumberOfServices = response.extract().path("data.findAll{it.name=='Rochester'}.services");
        System.out.println(NumberOfServices);
    }
    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015(){
        List<HashMap<String, ?>> createdAt = response.extract().path("data.services*.findAll{it.name == 'Windows Store'}.createdAt");
        System.out.println(createdAt);
    }
    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016(){
        List<HashMap<String, ?>> nameOfServices = response.extract().path("data.findAll{it.name == 'Fargo'}.services.name");
        System.out.println(nameOfServices);
    }
    //17. Find the zip of all the store
    @Test
    public void test017(){
        List<Integer> zipCode = response.extract().path("data.zip");
        System.out.println(zipCode);
    }
    //18. Find the zip of store name = Roseville
    @Test
    public void test018(){
        List<Integer> zip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println(zip);
    }
    //19. Find the storeservices details of the service name = Magnolia Home Theater

    @Test
    public void test019() {
        List<HashMap<String, ?>> storeServices = response.extract().path("data.services*.findAll{it.name == 'Magnolia Home Theater'}.storeservices");
        System.out.println(storeServices);

    }
    //20. Find the lat of all the stores
    @Test
    public void test020(){
            List<Integer> Lat = response.extract().path("data.lat");
        System.out.println(Lat);
    }


}