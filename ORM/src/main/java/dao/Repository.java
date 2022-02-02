package dao;

import scriptors.Scriptor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository
{
	private Connection connection;

	public Repository(Connection connection)
	{
		this.connection = connection;
	}

	public Connection getConnection()
	{
		return connection;
	}

	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}

	public void create(Object obj) throws SQLException
	{
		PreparedStatement pstmt = connection.prepareStatement(Scriptor.createSQL(obj), Statement.RETURN_GENERATED_KEYS);

		// come back

		pstmt.execute();
	}

	public List<Object> read(Object obj) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
	{
		PreparedStatement pstmt = connection.prepareStatement(Scriptor.readSQL(obj), Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = pstmt.executeQuery();

		List<Object> list = new ArrayList<>();

		while(rs.next()) {
			Object o = obj.getClass().getConstructor().newInstance();

			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields)
			{
				field.setAccessible(true);
				field.set(o, rs.getObject(field.getName()));
				field.setAccessible(false);
			}
			list.add(o);
		}

		return list;
	}
}
