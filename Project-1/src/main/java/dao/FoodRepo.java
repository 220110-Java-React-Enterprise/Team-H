package dao;


import models.Food;
import web.ConnectionManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodRepo implements IFoodRepo
{
	private Repository repo;

	public FoodRepo()
	{
		repo = new Repository(ConnectionManager.getConnection());
	}

	@Override
	public void createFood(Food food)
	{
		try
		{
			repo.create(food);
		}
		catch(SQLException | IllegalAccessException e)
		{
			// Add Logging
		}

	}

	@Override
	public List<Food> readFood(Food food)
	{
		List<Food> foodList = new ArrayList<>();
		try
		{
			List<Object> list = repo.read(food);

			for(Object o : list)
			{
				foodList.add((Food)o);
			}
		}
		catch(SQLException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e)
		{
			// Add Logging
		}
		return foodList;
	}

	@Override
	public void updateFood(Food food)
	{
		try
		{
			repo.update(food);
		}
		catch(SQLException | IllegalAccessException e)
		{
			// Add Logging
		}
	}

	@Override
	public void deleteFood(Food food)
	{
		try
		{
			repo.delete(food);
		}
		catch(SQLException | IllegalAccessException e)
		{
			// Add Logging
		}
	}

}
