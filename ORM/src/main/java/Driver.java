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
            List<Object> list = repo.read(food);
            for(Object item : list) {
                Food f = (Food)item;
                System.out.println(f.getName() + " " + f.getDescription() + " " + f.getPrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
