package cs.ycp.edu.cs481.ratemydrink.controllers.web_controllers;

import com.rateMyDrink.modelClasses.Beer;
import com.rateMyDrink.modelClasses.Drink;

import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * A simple interface using the Retrofit api to make RESTful requests to make a POST request for a new Beer Object
 */
public interface IPostNewBeer {

    @Headers({"Content-Type: application/json"})
    @POST("/backend/?action=addBeer")
    Drink post(@Body Beer newBeer);

}