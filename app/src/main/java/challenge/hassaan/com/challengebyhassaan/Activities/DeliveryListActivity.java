package challenge.hassaan.com.challengebyhassaan.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import challenge.hassaan.com.challengebyhassaan.Adapters.DeleviriesListAdapter;
import challenge.hassaan.com.challengebyhassaan.Classes.CommonMethods;
import challenge.hassaan.com.challengebyhassaan.Database.Tables.DeliveryDb;
import challenge.hassaan.com.challengebyhassaan.Interfaces.ApiCall.GetDeliveriesList;
import challenge.hassaan.com.challengebyhassaan.Interfaces.RetrofitInterface;
import challenge.hassaan.com.challengebyhassaan.Models.Delivery;
import challenge.hassaan.com.challengebyhassaan.Models.DeliveryList;
import challenge.hassaan.com.challengebyhassaan.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeliveryListActivity extends AppCompatActivity {

    private Context context;


    ProgressDialog progressDialog = null;
    private TextView textToolBarTitle;

    private RecyclerView recyclerDeliveryList;

    private DeleviriesListAdapter deleviriesListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_list);

        //MH: Initialization at start
        init();

    }


    /***********************************************************************************/
    //Hassaan: Method to get Views reference and store them
    /***********************************************************************************/
    private void init()
    {
        context = this;

        recyclerDeliveryList = findViewById(R.id.recyclerDeliveryList);
        textToolBarTitle = findViewById(R.id.textToolbarTitle);

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getResources().getString(R.string.id_loading));


        //Hassaan: Setting title of this activity as "Things to Deliver"
        textToolBarTitle.setText(context.getResources().getString(R.string.id_things_to_deliver));



      getDeliveryList();
    }


    /***********************************************************************************/
    //Hassaan: Method to get DeliveryDb List from Api using Async Request, so that User Interface
    // not struck while sending request
    /***********************************************************************************/
    private void getDeliveryListFromApi()
    {
        GetDeliveriesList getDeliveriesList = RetrofitInterface.getRetrofitInstance().create(GetDeliveriesList.class);

        Call<DeliveryList> call = getDeliveriesList.getDeliveriesList();

        call.enqueue(new Callback<DeliveryList>() {
            @Override
            public void onResponse(@NonNull Call<DeliveryList> call, @NonNull Response<DeliveryList> response) {

                if(response.body().getDeliveryList() != null) {
                    populateDeliveryListRecycler(response.body().getDeliveryList(),true);
                }
                else
                {
                       getDeliveryListFromDb();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DeliveryList> call, @NonNull Throwable t) {
                //Hassaan: Showing Message if request to get Deliveries is not Successful
                Toast.makeText(context, "No Access!" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }




    //Hassaan: Method to get Delivery list, either from Api or cache
    private void getDeliveryList()
    {
        progressDialog.show();
        if(CommonMethods.isInternetConnected(context)) {
            getDeliveryListFromApi();
        }
        else
        {
            getDeliveryListFromDb();
        }
    }
    /************************************************************************************************/
    //Hassaan: Method to populate DeliveryDb List Adapter
    /************************************************************************************************/
    private void populateDeliveryListRecycler(ArrayList<Delivery> deliveryList,boolean isCacheList)
    {
        progressDialog.dismiss();
        if(deliveryList.size() > 0) {
            deleviriesListAdapter = new DeleviriesListAdapter(deliveryList, context);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            recyclerDeliveryList.setLayoutManager(linearLayoutManager);
            recyclerDeliveryList.setAdapter(deleviriesListAdapter);

            //Hassaan: If List already retreived from database then no need to cache list again
            if(isCacheList) {
             cacheDeliveriesInDb(deliveryList);
            }
        }
        else
        {
            Toast.makeText(context,context.getResources().getString(R.string.id_nothing_to_deliver),Toast.LENGTH_LONG).show();
        }
    }


    /**********************************************************************************************/
    //Hassaan: Method to get List from database
    /**********************************************************************************************/
    private void getDeliveryListFromDb()
    {
        List<Delivery> deliveries = Delivery.listAll(Delivery.class);

        ArrayList<Delivery> deliveryArrayList = new ArrayList<>();
        deliveryArrayList.addAll(deliveries);
        populateDeliveryListRecycler(deliveryArrayList,false);
    }

    /**********************************************************************************************/
    //Hassaan: Method to cache list of deliveries in database
    /***********************************************************************************************/
    private   void cacheDeliveriesInDb(ArrayList<Delivery> deliveries)
    {

        Delivery.deleteAll(Delivery.class);
        for (Delivery delivery:deliveries ) {

            delivery.save();
        }
        //  new saveListInDbAsync().execute(deliveries);
    }



    /**********************************************************************************************/
    private class saveListInDbAsync extends AsyncTask<ArrayList<Delivery> , Void, Void> {


        @Override
        protected void onPreExecute() {
        }

        protected Void doInBackground(ArrayList<Delivery>...deliveries) {
            //Hassaan: Deleting All Previous Records because new records received successfully, so database should be updated
            // accrording to new records

            return null;
        }

        protected void onPostExecute(Void result) {
            // do UI work here

            }
        }
    }

