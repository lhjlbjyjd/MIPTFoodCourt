package ua.com.lhjlbjyjd.miptfoodcourt;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lhjlbjyjd on 08.02.2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<FoodItem> mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View layout;
        public TextView mName;
        public TextView mDescription;
        public TextView mPrice;
        public ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.card_view);
            mName = v.findViewById(R.id.item_name);
            mDescription = v.findViewById(R.id.item_description);
            mPrice = v.findViewById(R.id.item_price);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<FoodItem> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        /*holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!((MainApplication)context.getApplicationContext()).bucket.contains(mDataset.get(position))) {
                    holder.layout.setBackgroundColor(Color.GREEN);
                    Log.d("S", "ADDED");
                    ((MainApplication)context.getApplicationContext()).bucket.add(mDataset.get(position));
                }else {
                    holder.layout.setBackgroundColor(Color.WHITE);
                    Log.d("S", "DELETED");
                    ((MainApplication)context.getApplicationContext()).bucket.remove(mDataset.get(position));
                }
            }
        });*/
        holder.mName.setText(mDataset.get(position).name);
        holder.mDescription.setText(mDataset.get(position).description);
        holder.mPrice.setText(String.valueOf(mDataset.get(position).price) + " руб");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
