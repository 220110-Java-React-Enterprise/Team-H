package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DeliveryRepo;
import dao.IDeliveryRepo;
import models.Delivery;
import utils.FileLogger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeliveryServlet extends HttpServlet
{
	private IDeliveryRepo deliveryRepo;

	public DeliveryServlet()
	{
		super();
		try
		{
			deliveryRepo = new DeliveryRepo();
		}
		catch(Exception e)
		{
			FileLogger.getFileLogger().log(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			List<Delivery> deliveryList = deliveryRepo.readDelivery(new Delivery());
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(deliveryList);
			resp.getWriter().print(jsonString);
			resp.setStatus(200);
		}
		catch(Exception e)
		{
			FileLogger.getFileLogger().log(e);
			resp.setStatus(500);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			Delivery payload = mapper.readValue(req.getInputStream(), Delivery.class);
			deliveryRepo.createDelivery(payload);
			resp.setStatus(203);
		}
		catch(Exception e)
		{
			FileLogger.getFileLogger().log(e);
			resp.setStatus(500);
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			Delivery payload = mapper.readValue(req.getInputStream(), Delivery.class);
			deliveryRepo.updateDelivery(payload);
			resp.setStatus(203);
		}
		catch(Exception e)
		{
			FileLogger.getFileLogger().log(e);
			resp.setStatus(500);
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			Delivery payload = mapper.readValue(req.getInputStream(), Delivery.class);
			deliveryRepo.deleteDelivery(payload);
			resp.setStatus(203);
		}
		catch(Exception e)
		{
			FileLogger.getFileLogger().log(e);
			resp.setStatus(500);
		}

	}
}
