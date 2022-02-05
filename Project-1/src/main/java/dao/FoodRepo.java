package dao;

import models.Food;
import utils.FileLogger;
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
		// TODO: DriverManager fails to connect here "No suitable Driver found"
		repo = new Repository(ConnectionManager.getConnection());
	}

	public void createFood(Food food)
	{
		try
		{
			repo.create(food);
		}
		catch(SQLException | IllegalAccessException e)
		{
			FileLogger.getFileLogger().log(e);
		}

	}

	public List<Food> readFood(Food food)
	{
		List<Food> foodList = new ArrayList<>();
		try
		{
			List<Object> list = repo.read(food);
			for(Object o : list)
			{
				foodList.add((Food) o);
			}
		}
		catch(SQLException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e)
		{
			FileLogger.getFileLogger().log(e);
		}
		return foodList;
	}

	public void updateFood(Food food)
	{
		try
		{
			repo.update(food);
		}
		catch(SQLException | IllegalAccessException e)
		{
			FileLogger.getFileLogger().log(e);
		}
	}

	public void deleteFood(Food food)
	{
		try
		{
			repo.delete(food);
		}
		catch(SQLException | IllegalAccessException e)
		{
			FileLogger.getFileLogger().log(e);
		}
	}

}
