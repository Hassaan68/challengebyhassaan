package challenge.hassaan.com.challengebyhassaan.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import challenge.hassaan.com.challengebyhassaan.Models.Delivery;
import challenge.hassaan.com.challengebyhassaan.R;
import challenge.hassaan.com.challengebyhassaan.Views.DeliveryListRow;

/**
 * Created by Muhammad Hassaan on 9/15/2018.
 */

public class DeleviriesListAdapter extends RecyclerView.Adapter<DeleviriesListAdapter.DeliveryViewHolder> {

    private ArrayList<Delivery> deliveryList;

    private Context context;


    public DeleviriesListAdapter(ArrayList<Delivery> dataList,Context context) {
        this.deliveryList = dataList;
        this.context = context;
    }

    @Override
    public DeliveryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.delivery_list_row, parent, false);
        return new DeliveryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeliveryViewHolder holder, int position) {


        DeliveryListRow deliveryListRow = holder.deliveryListRow;

        deliveryListRow.populateDeliveriesData(deliveryList.get(position));
    }

    @Override
    public int getItemCount() {
        return deliveryList.size();
    }




       class DeliveryViewHolder extends RecyclerView.ViewHolder {
        DeliveryListRow deliveryListRow;
        DeliveryViewHolder(View itemView) {

            super(itemView);

            deliveryListRow = new DeliveryListRow(itemView,context);

        }
    }
}