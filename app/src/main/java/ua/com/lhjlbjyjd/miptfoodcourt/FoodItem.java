package ua.com.lhjlbjyjd.miptfoodcourt;

/**
 * Created by lhjlbjyjd on 08.02.2018.
 */

public class FoodItem {

    public int id;
    public String name;
    public String description;
    public String imageUrl;
    public float price;
    public String recipe;

    public FoodItem(int _id, String _name, String _description, String _imageUrl, float _price, String _recipe){
        id = _id;
        name = _name;
        description = _description;
        imageUrl = _imageUrl;
        price = _price;
        recipe = _recipe;
    }

}
