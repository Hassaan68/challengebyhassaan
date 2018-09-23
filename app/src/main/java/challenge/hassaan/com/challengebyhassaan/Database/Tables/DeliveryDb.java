package challenge.hassaan.com.challengebyhassaan.Database.Tables;

import com.orm.SugarRecord;

import challenge.hassaan.com.challengebyhassaan.Models.Delivery;

/**
 * Created by Raja Hamid Mahmoodd on 9/15/2018.
 */


public class DeliveryDb extends Delivery {


    /*************************************************************************/
    //MH: Keys to Save in Database for caching
    private double latitude;

    private double longitude;


     public DeliveryDb()
    {}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
