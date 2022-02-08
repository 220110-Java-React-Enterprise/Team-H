package dao;

import models.Delivery;

import java.util.List;

public interface IDeliveryRepo {

	// Method for create
	public void createDelivery(Delivery delivery);

	// Method for read
	public List<Delivery> readDelivery(Delivery delivery);

	// Method for update
	public void updateDelivery(Delivery delivery);

	// Method for delete
	public void deleteDelivery(Delivery delivery);
}
