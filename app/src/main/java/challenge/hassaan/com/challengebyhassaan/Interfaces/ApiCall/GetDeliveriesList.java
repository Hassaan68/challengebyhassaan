package challenge.hassaan.com.challengebyhassaan.Interfaces.ApiCall;

import java.util.ArrayList;

import challenge.hassaan.com.challengebyhassaan.Models.Delivery;
import challenge.hassaan.com.challengebyhassaan.Models.DeliveryList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Muhammad Hassaan on 9/15/2018.
 */

public interface GetDeliveriesList {

    @GET("/deliveries")
    Call<DeliveryList> getDeliveriesList();
}
