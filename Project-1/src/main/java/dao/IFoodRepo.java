package dao;

import models.Food;

import java.util.List;

public interface IFoodRepo {

    // Method for create
    public void createFood(Food food);

    // Method for read
    public List<Food> readFood(Food food);

    // Method for update
    public void updateFood(Food food);

    // Method for delete
    public void deleteFood(Food food);
}
