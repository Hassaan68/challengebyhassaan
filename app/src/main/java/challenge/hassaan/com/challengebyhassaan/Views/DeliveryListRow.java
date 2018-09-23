package challenge.hassaan.com.challengebyhassaan.Views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import challenge.hassaan.com.challengebyhassaan.Models.Delivery;
import challenge.hassaan.com.challengebyhassaan.R;

/**
 * Created by Muhammad Hassaan on 9/15/2018.
 */

public class DeliveryListRow {

    private Context context;
    private View deliveryView;
    private ImageView imgDelivery;
    private TextView textDeliveryDescription;


    /**********************************************************************************************/
    public DeliveryListRow(View deliveryView, Context context )
    {
        this.deliveryView = deliveryView;
        this.context = context;
        init();
    }
    /**********************************************************************************************/


    /**********************************************************************************************/
    private void init()
    {

        imgDelivery = deliveryView.findViewById(R.id.imgDelivery);
        textDeliveryDescription = deliveryView.findViewById(R.id.textDeliveryDescription);
    }

    /**********************************************************************************************/
    public void populateDeliveriesData(Delivery delivery)
    {
        textDeliveryDescription.setText(delivery.getDescription());
        loadDeliveryImage(delivery.getImageUrl());
    }


    /**********************************************************************************************/
    private void loadDeliveryImage(String deliveryImageUrl)
    {
        //Hassaan: request to add place holder on image in request
        RequestOptions options = new RequestOptions()
                .fitCenter()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);


        Glide.with(context).load(deliveryImageUrl).apply(options).into(imgDelivery);
    }

    /**********************************************************************************************/

}
