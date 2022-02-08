package dao;

import models.Delivery;
import models.Food;
import utils.FileLogger;
import web.ConnectionManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRepo implements IDeliveryRepo
{

	private Repository repo;

	public DeliveryRepo()
	{
		repo = new Repository(ConnectionManager.getConnection());
	}

	@Override
	public void createDelivery(Delivery delivery)
	{
		try
		{
			repo.create(delivery);
		}
		catch(SQLException | IllegalAccessException e)
		{
			FileLogger.getFileLogger().log(e);
		}
	}

	@Override
	public List<Delivery> readDelivery(Delivery delivery)
	{
		List<Delivery> deliveryList = new ArrayList<>();
		try
		{
			List<Object> list = repo.read(delivery);
			for(Object o : list)
			{
				deliveryList.add((Delivery) o);
			}
		}
		catch(SQLException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e)
		{
			FileLogger.getFileLogger().log(e);
		}
		return deliveryList;
	}

	@Override
	public void updateDelivery(Delivery delivery)
	{
		try
		{
			repo.update(delivery);
		}
		catch(SQLException | IllegalAccessException e)
		{
			FileLogger.getFileLogger().log(e);
		}
	}

	@Override
	public void deleteDelivery(Delivery delivery)
	{
		try
		{
			repo.delete(delivery);
		}
		catch(SQLException | IllegalAccessException e)
		{
			FileLogger.getFileLogger().log(e);
		}
	}
}
