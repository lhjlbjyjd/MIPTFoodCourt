package ua.com.lhjlbjyjd.miptfoodcourt;

import android.app.Application;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhjlbjyjd on 08.02.2018.
 */

public class MainApplication extends Application {

    public List<FoodItem> foodList = new ArrayList<>();
    public List<FoodItem> bucket = new ArrayList<>();
    public ListAdapter adapter;

    public void refreshFoodList(){
        new RefreshTask().execute();
    }

    private class RefreshTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            //Связь с сервером
            String testString = "[{\"id\":0,\"name\":\"Продукт 0\",\"description\":\"lorem ipsum\",\"imageUrl\":\"not yet\",\"recipe\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu pretium nulla. Praesent eleifend, felis ut varius accumsan, nunc lacus vestibulum purus, tincidunt cursus nibh odio nec nunc. Curabitur dictum ullamcorper ornare. Sed sed sem felis. Ut enim elit, rutrum id orci non, molestie rutrum tortor. Pellentesque ac laoreet dolor. Donec nec urna quis lectus pulvinar lacinia. Nulla in erat dolor. Aliquam mattis gravida sem, id tristique eros malesuada id. Sed ligula eros, porta vel erat ut, venenatis gravida enim. Ut id porttitor lectus, id luctus enim.\",\"price\":1000.1},{\"id\":1,\"name\":\"Продукт 1\",\"description\":\"lorem ipsum\",\"imageUrl\":\"not yet\",\"recipe\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu pretium nulla. Praesent eleifend, felis ut varius accumsan, nunc lacus vestibulum purus, tincidunt cursus nibh odio nec nunc. Curabitur dictum ullamcorper ornare. Sed sed sem felis. Ut enim elit, rutrum id orci non, molestie rutrum tortor. Pellentesque ac laoreet dolor. Donec nec urna quis lectus pulvinar lacinia. Nulla in erat dolor. Aliquam mattis gravida sem, id tristique eros malesuada id. Sed ligula eros, porta vel erat ut, venenatis gravida enim. Ut id porttitor lectus, id luctus enim.\",\"price\":1000.1},{\"id\":2,\"name\":\"Продукт 2\",\"description\":\"lorem ipsum\",\"imageUrl\":\"not yet\",\"recipe\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu pretium nulla. Praesent eleifend, felis ut varius accumsan, nunc lacus vestibulum purus, tincidunt cursus nibh odio nec nunc. Curabitur dictum ullamcorper ornare. Sed sed sem felis. Ut enim elit, rutrum id orci non, molestie rutrum tortor. Pellentesque ac laoreet dolor. Donec nec urna quis lectus pulvinar lacinia. Nulla in erat dolor. Aliquam mattis gravida sem, id tristique eros malesuada id. Sed ligula eros, porta vel erat ut, venenatis gravida enim. Ut id porttitor lectus, id luctus enim.\",\"price\":1000.1},{\"id\":3,\"name\":\"Продукт 3\",\"description\":\"lorem ipsum\",\"imageUrl\":\"not yet\",\"recipe\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu pretium nulla. Praesent eleifend, felis ut varius accumsan, nunc lacus vestibulum purus, tincidunt cursus nibh odio nec nunc. Curabitur dictum ullamcorper ornare. Sed sed sem felis. Ut enim elit, rutrum id orci non, molestie rutrum tortor. Pellentesque ac laoreet dolor. Donec nec urna quis lectus pulvinar lacinia. Nulla in erat dolor. Aliquam mattis gravida sem, id tristique eros malesuada id. Sed ligula eros, porta vel erat ut, venenatis gravida enim. Ut id porttitor lectus, id luctus enim.\",\"price\":1000.1},{\"id\":4,\"name\":\"Продукт 4\",\"description\":\"lorem ipsum\",\"imageUrl\":\"not yet\",\"recipe\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu pretium nulla. Praesent eleifend, felis ut varius accumsan, nunc lacus vestibulum purus, tincidunt cursus nibh odio nec nunc. Curabitur dictum ullamcorper ornare. Sed sed sem felis. Ut enim elit, rutrum id orci non, molestie rutrum tortor. Pellentesque ac laoreet dolor. Donec nec urna quis lectus pulvinar lacinia. Nulla in erat dolor. Aliquam mattis gravida sem, id tristique eros malesuada id. Sed ligula eros, porta vel erat ut, venenatis gravida enim. Ut id porttitor lectus, id luctus enim.\",\"price\":1000.1},{\"id\":5,\"name\":\"Продукт 5\",\"description\":\"lorem ipsum\",\"imageUrl\":\"not yet\",\"recipe\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu pretium nulla. Praesent eleifend, felis ut varius accumsan, nunc lacus vestibulum purus, tincidunt cursus nibh odio nec nunc. Curabitur dictum ullamcorper ornare. Sed sed sem felis. Ut enim elit, rutrum id orci non, molestie rutrum tortor. Pellentesque ac laoreet dolor. Donec nec urna quis lectus pulvinar lacinia. Nulla in erat dolor. Aliquam mattis gravida sem, id tristique eros malesuada id. Sed ligula eros, porta vel erat ut, venenatis gravida enim. Ut id porttitor lectus, id luctus enim.\",\"price\":1000.1}]";
            try {
                List<FoodItem> tempList = new ArrayList<>();
                JSONArray array = new JSONArray(testString);
                for (int i = 0; i < array.length(); i++){
                    tempList.add(new FoodItem(array.getJSONObject(i).getInt("id"),array.getJSONObject(i).getString("name"),
                            array.getJSONObject(i).getString("description"),array.getJSONObject(i).getString("imageUrl"),
                            array.getJSONObject(i).getLong("price"), array.getJSONObject(i).getString("recipe")));
                }
                foodList.clear();
                foodList = tempList;
                if(adapter != null)
                    adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
