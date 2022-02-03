package dao;


import models.Food;
import java.util.List;

public class FoodRepo implements IFoodRepo {
    private Repository repo;

    public FoodRepo(){
        // Read the properties file

        // make a new connection

        // hand off connection to the repo.
    }

    @Override
    public void createFood(Food food) {

    }

    @Override
    public List<Food> readFood(Food food) {
        return null;
    }

    @Override
    public void updateFood(Food food) {

    }

    @Override
    public void deleteFood(Food food) {

    }
}
