package challenge.hassaan.com.challengebyhassaan.Interfaces;

import challenge.hassaan.com.challengebyhassaan.Classes.AppConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Muhammad Hassaan on 9/15/2018.
 */

public class RetrofitInterface {

    private static Retrofit retrofit;
    private static final String BASE_URL = AppConstants.BASE_URL;

    /**
     * Create an instance of Retrofit object
     * */
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
