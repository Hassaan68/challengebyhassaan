package challenge.hassaan.com.challengebyhassaan.Classes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;

import challenge.hassaan.com.challengebyhassaan.Database.Tables.DeliveryDb;
import challenge.hassaan.com.challengebyhassaan.Models.Delivery;

/**
 * Created by Raja Hamid Mahmoodd on 9/15/2018.
 */

public class CommonMethods {



    //Hassaan:Method to Check Internet Connetivity
    public static boolean isInternetConnected(Context context) {
        boolean isConnected = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    isConnected = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    isConnected = true;
        }
        return isConnected;
    }



}
