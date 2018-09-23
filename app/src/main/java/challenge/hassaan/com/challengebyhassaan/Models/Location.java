package challenge.hassaan.com.challengebyhassaan.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

/**
 * Created by Muhammad Hassaan on 9/15/2018.
 */

//Hassaan: The Model Class to Handle Location Data
public class Location extends SugarRecord<Location> implements Parcelable {

    private String address;

    private double lng;

    private double lat;

    /*********************************************************************************/
    //Hassaan: An Empty Constructor to assign values to each key using Object of this class
    /*********************************************************************************/
   public Location()
    {

    }



    /*********************************************************************************/
    //Hassaan: Constructor to assign values to all keys of this class in single line
    /*********************************************************************************/
    public Location(String address, double lng, double lat) {
        this.address = address;
        this.lng = lng;
        this.lat = lat;
    }


    /*************************************************************************************/
    public String getAddress() {
        return address;
    }

    /*************************************************************************************/
    public void setAddress(String address) {
        this.address = address;
    }

    /*************************************************************************************/
    public double getLng() {
        return lng;
    }

    /*************************************************************************************/
    public void setLng(double lng) {
        this.lng = lng;
    }

    /*************************************************************************************/
    public double getLat() {
        return lat;
    }

    /*************************************************************************************/
    public void setLat(double lat) {
        this.lat = lat;
    }


    /***********************************************************************************************/
    //Hassaan: Parcelable code for this class. so we can pass objects of this class between activities
    /************************************************************************************************/
    @Override
    public int describeContents() {
        return 0;
    }

    /*************************************************************************************************/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeDouble(this.lng);
        dest.writeDouble(this.lat);
    }

    /*************************************************************************************************/
    protected Location(Parcel in) {
        this.address = in.readString();
        this.lng = in.readDouble();
        this.lat = in.readDouble();
    }

    /*************************************************************************************************/
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        /*************************************************************************************************/
        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
