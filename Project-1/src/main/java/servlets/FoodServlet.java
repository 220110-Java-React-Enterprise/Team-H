package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Food;
import utils.GlobalStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FoodServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		List<Food> foodList = GlobalStore.getFoodList();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(foodList);
		resp.getWriter().print(jsonString);
		resp.setStatus(200);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Food foodObject = mapper.readValue(req.getInputStream(), Food.class);
		GlobalStore.addToFoodList(foodObject);
		resp.setStatus(203);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Food payload = mapper.readValue(req.getInputStream(), Food.class);
		List<Food> list = GlobalStore.getFoodList();
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getFoodId() == payload.getFoodId())
			{
				list.set(i, payload);
				break;
			}
		}
		resp.setStatus(203);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Food payload = mapper.readValue(req.getInputStream(), Food.class);
		List<Food> list = GlobalStore.getFoodList();
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getFoodId() == payload.getFoodId())
			{
				list.remove(i);
				break;
			}
		}
		resp.setStatus(203);
	}
}
