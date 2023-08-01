package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class ProductsExtractionTest {
    static ValidatableResponse response;
    
    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);



       
    }


//    http://localhost:3030/products

    // 21. Extract the limit
    @Test
    public void test021(){
      int limit = response.extract().path("limit");
        System.out.println("The value of limits are :" + limit);
    }
    //22. Extract the total
    @Test
    public void test022(){
        int total = response.extract().path("total");
        System.out.println("Total no of products are :" + total);
    }
    //23. Extract the name of 5th product
    @Test
    public void test023(){
        String name = response.extract().path("data[5].name");
        System.out.println("Name of the 5th product is :"+ name);
    }
    //24. Extract the names of all the products
    @Test
    public void test024(){
      List<String> listAllProducts = response.extract().path("data.name");
        System.out.println("list of all name are :" + listAllProducts);
    }
    //25. Extract the productId of all the products
    @Test
    public void test025(){
      List<Integer> allProductsId = response.extract().path("data.id");
        System.out.println("Product Id of all Products:" + allProductsId);

    }

    //26. Print the size of the data list
    @Test
    public void test026(){
        List<String>  size = response.extract().path("data.name");
        int data = size.size();
        System.out.println("The size of the data is :"+ data);
     }
    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test027(){
      List<HashMap<String,?>>  name = response.extract().path("data.findAll{it.name =='Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("The value of the product where product name is :"+ name);
    }
    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test028(){
        List<HashMap<String, ?>> model = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("get the model of the product where product name :"+ model);
    }
    //29. Get all the categories of 8th products
    @Test
    public void test029(){
       List<HashMap<String, ?>> allCategories = response.extract().path("data[7].categories");
        System.out.println(allCategories);
    }
    //30. Get categories of the store where product id = 150115
    @Test
    public void test030(){
        List<HashMap<String, ?>> Categories1 = response.extract().path("data[3].categories");
        System.out.println(Categories1);
    }
    //31. Get all the descriptions of all the products
    @Test
    public void test031(){
      List<String> description = response.extract().path("data.description");
        System.out.println(description);
    }
    //32. Get id of all the all categories of all the products
    @Test
    public void test032(){
        List<String> id = response.extract().path("data.categories.id");
        System.out.println(id);
    }
    //33. Find the product names Where type = HardGood
    @Test
    public void test033(){
        List<HashMap<String, ?>> nameType = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("get the products name where type = HardGood :"+ nameType);
    }
    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034(){
        List<HashMap<String, ?>> numbersOfCategories = response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("Find the categories name where name = Duracell - AA 1.5V CopperTop Batteries (4-Pack) :"+ numbersOfCategories);
    }
    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035(){
        List<String> createdAt =  response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println(createdAt);
    }
    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void test036(){
        List<HashMap<String, ?>> nameOfCategories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println("Find the categories name where name = Energizer - MAX Batteries AA (4-Pack) :"+ nameOfCategories);
    }
    //37. Find the manufacturer of all the products
    @Test
    public void test037(){
        List<HashMap<String, ?>> manufacturer = response.extract().path("data.manufacturer");
        System.out.println(manufacturer);
    }
    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test038(){
        List<HashMap<String, ?>> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
        System.out.println(image);
    }
    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039(){
        List<String> createdAt =  response.extract().path("data.findAll{it.price > 5.99}.createdAt");
        System.out.println(createdAt);
    }
    //40. Find the uri of all the products
    @Test
    public void test040(){
       List<String> URl = response.extract().path("data.url");
        System.out.println(URl);
    }
}
