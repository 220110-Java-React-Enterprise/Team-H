package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.FoodRepo;
import dao.IFoodRepo;
import models.Food;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FoodServlet extends HttpServlet
{
	private IFoodRepo foodRepo = new FoodRepo();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		List<Food> foodList = foodRepo.readFood(new Food());
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(foodList);
		resp.getWriter().print(jsonString);
		resp.setStatus(200);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Food payload = mapper.readValue(req.getInputStream(), Food.class);
		foodRepo.createFood(payload);
		resp.setStatus(203);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Food payload = mapper.readValue(req.getInputStream(), Food.class);
		foodRepo.updateFood(payload);
		resp.setStatus(203);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Food payload = mapper.readValue(req.getInputStream(), Food.class);
		foodRepo.deleteFood(payload);
		resp.setStatus(203);
	}
}
