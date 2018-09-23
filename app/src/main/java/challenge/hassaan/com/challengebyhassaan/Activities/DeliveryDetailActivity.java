package challenge.hassaan.com.challengebyhassaan.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

import challenge.hassaan.com.challengebyhassaan.Models.Delivery;
import challenge.hassaan.com.challengebyhassaan.R;

public class DeliveryDetailActivity extends AppCompatActivity {


    private Context context;

    private TextView textToolbarTitle;
    private TextView textDeliveryDescription;

    private Delivery delivery;
    private  ImageView  imgDelivery;

    private SupportMapFragment deliveryMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_detail);

        delivery  = getIntent().getParcelableExtra("deliveryDetails");

        init();
    }

    private void init()
    {
        context = this;
        textToolbarTitle = findViewById(R.id.textToolbarTitle);

        imgDelivery = findViewById(R.id.imgDelivery);


        textToolbarTitle.setText(context.getResources().getString(R.string.id_delivery_etails));

      //  deliveryMap = findViewById(R.id.deliveryMap);
        populateData();

    }


    private void populateData()
    {
        if(delivery != null)
        {
            textDeliveryDescription.setText(delivery.getDescription());

        }
    }
}
