package ua.com.lhjlbjyjd.miptfoodcourt;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by lhjlbjyjd on 09.02.2018.
 */

public class FoodItemCard extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View card = inflater.inflate(R.layout.list_item_card, container, false);
        card.findViewById(R.id.item_main_layout).setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            public void onSwipeLeft() {
                addToBucket(card);
            }

            public void onSwipeRight(){
                removeFromBucket(card);
            }
        });
        card.findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQuantity = Integer.parseInt(String.valueOf(((AppCompatEditText)card.findViewById(R.id.item_quantity)).getText()));
                if(currentQuantity < 10)
                    ((AppCompatEditText)card.findViewById(R.id.item_quantity)).setText(String.valueOf(currentQuantity+1));
            }
        });
        card.findViewById(R.id.buttonRemove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQuantity = Integer.parseInt(String.valueOf(((AppCompatEditText)card.findViewById(R.id.item_quantity)).getText()));
                if(currentQuantity <= 1)
                    removeFromBucket(card);
                else
                    ((AppCompatEditText)card.findViewById(R.id.item_quantity)).setText(String.valueOf(currentQuantity-1));
            }
        });
        card.findViewById(R.id.item_image).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Рецепт")
                        .setMessage("Тут должен быть рецепт, но я пока тупенький, и не понимаю как его красиво сюда передать")
                        .setNegativeButton("Окей", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create();
                return false;
            }
        });
        return card;
    }

    private void addToBucket(View card){
        card.findViewById(R.id.card_view).setTranslationX(-1*(int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                80,
                getResources().getDisplayMetrics()
        ));//.setLayoutParams(params);
                /*if(!((MainApplication)getActivity().getApplicationContext()).bucket.contains(mDataset.get(position))) {
                    ((MainApplication)getActivity().getApplicationContext()).bucket.add(mDataset.get(position));
                }*/
    }

    private void removeFromBucket(View card){
        card.findViewById(R.id.card_view).setTranslationX((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                0,
                getResources().getDisplayMetrics()
        ));//.setLayoutParams(params);
    }
}
