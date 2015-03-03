package cs.ycp.edu.cs481.ratemydrink.controllers.web_controllers;


import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.rateMyDrink.modelClasses.Beer;

import cs.ycp.edu.cs481.ratemydrink.RETROFIT;
import cs.ycp.edu.cs481.ratemydrink.URLInfo;
import retrofit.converter.GsonConverter;

/**
 * A controller to asynchronously make a GET request to the database for a single Beer object.
 */
public class GetBeerAsync extends AsyncTask<Integer, Void, Beer> {

    @Override
    protected Beer doInBackground(Integer... params) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Beer.class, new DateTypeAdapter())
                .create();

        IGetBeer getBeerService = RETROFIT.getRestAdapterBuilder()
                .setEndpoint(URLInfo.DOMAIN_URL)
                .setConverter(new GsonConverter(gson))
                .build()
                .create(IGetBeer.class);

        return getBeerService.get(params[0]);
    }

}