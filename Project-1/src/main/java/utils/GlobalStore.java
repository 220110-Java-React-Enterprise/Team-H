package utils;

import models.Food;

import java.util.ArrayList;
import java.util.List;

public class GlobalStore {
    private static List<Food> foodList = new ArrayList<>();

    public static List<Food> getFoodList() {
        return foodList;
    }

    public static void setFoodList(List<Food> list) {
        foodList = list;
    }

    public static Food getFromFoodList(int index) {
        return foodList.get(index);
    }

    public static void addToFoodList(Food food) {
        foodList.add(food);
    }

    public static void removeFromFoodList(int index) {
        foodList.remove(index);
    }

    public static void removeFromFoodList(Food food) {
        foodList.remove(food);
    }

}
