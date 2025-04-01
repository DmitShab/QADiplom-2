package pojo;

import java.util.ArrayList;
import java.util.List;

public class PostMakeOrderRequestPOJO {
    List<String> ingredients = new ArrayList<>();

    public PostMakeOrderRequestPOJO() {
    }


    public PostMakeOrderRequestPOJO(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
