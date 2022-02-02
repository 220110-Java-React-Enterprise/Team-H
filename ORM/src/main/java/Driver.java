import dao.Repository;
import models.Food;
import scriptors.Scriptor;
import util.ConnectionFactory;

import java.io.FileReader;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

public class Driver {
    public static void main(String[] args) {
        Food food = new Food();
        System.out.println(Scriptor.createSQL(food));
        System.out.println(Scriptor.readSQL(food));
        System.out.println(Scriptor.updateSQL(food));
        System.out.println(Scriptor.deleteSQL(food));

        Connection connection = null;
        try
        {
            Properties p = new Properties();
            FileReader fr = new FileReader("./src/main/resources/connection.properties");
            p.load(fr);
            connection = ConnectionFactory.getConnection(p.getProperty("hostname"), Integer.parseInt(p.getProperty("port")), p.getProperty("dbname"), p.getProperty("username"), p.getProperty("password"));
            Repository repo = new Repository(connection);

            food.setName("Chicken");
            food.setPrice(3.99);
            food.setDescription("It is Chicken.");
            //repo.create(food);

            List<Object> list = repo.read(food);

            ((Food)list.get(1)).setDescription("It might be Chicken.");
            //repo.update((Food)list.get(1));
            //repo.delete((Food)list.get(1));

            for(Object item : list) {
                Food f = (Food)item;
                System.out.println(f.getName() + " " + f.getDescription() + " " + f.getPrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
