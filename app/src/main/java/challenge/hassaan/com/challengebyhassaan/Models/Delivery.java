package challenge.hassaan.com.challengebyhassaan.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

/**
 * Created by Muhammad Hassaan on 9/15/2018.
 */

//Hassaan: Model Class to handle DeliveryDb Data for all items
//Hassaan: Using sugar Db library to develop sqlite db for app to save time

public class Delivery  extends SugarRecord<Delivery> implements Parcelable {


    private Location location;

    private String imageUrl;

    private String description;

    /*********************************************************************************/
    //Hassaan: An Empty Constructor to assign values to each key using Object of this class
    /*********************************************************************************/
    public Delivery()
    {
    }

    /*********************************************************************************/
        //Hassaan: Constructor to assign values to all keys of this class in single line
    /***************************************************************************/
    public Delivery(Location location, String imageUrl, String description) {
        this.location = location;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    /*************************************************************************************/
    //Hassaan: Getters and Setters for Keys
    /*************************************************************************************/
    public Location getLocation() {
        return location;
    }

    /*************************************************************************************/
    public void setLocation(Location location) {
        this.location = location;
    }

    /*************************************************************************************/
    public String getImageUrl() {
        return imageUrl;
    }

    /*************************************************************************************/
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /*************************************************************************************/
    public String getDescription() {
        return description;
    }

    /*************************************************************************************/
    public void setDescription(String description) {
        this.description = description;
    }




    /***********************************************************************************************/
    //Hassaan: Parcelable code for this class. so we can pass objects of this class between activities
    /************************************************************************************************/
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.location, flags);
        dest.writeString(this.imageUrl);
        dest.writeString(this.description);
    }

    /************************************************************************************************/
    protected Delivery(Parcel in) {
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.imageUrl = in.readString();
        this.description = in.readString();
    }

    /************************************************************************************************/
    public static final Parcelable.Creator<Delivery> CREATOR = new Parcelable.Creator<Delivery>() {
        @Override
        public Delivery createFromParcel(Parcel source) {
            return new Delivery(source);
        }

        @Override
        public Delivery[] newArray(int size) {
            return new Delivery[size];
        }
    };
    /************************************************************************************************/
}
