package scriptors;

/**
 * Object Relational Mapping class used to convert data between incompatible type systems using an OOP based language.
 */

/**
 * Mention to team how you now have a better understanding of the scriptor for your ORM!
 */

public class Scriptor
{

	// Not sure what to make the parameter, it's just Object for now
	public static String createSQL(Object o)
	{
		//INSERT INTO table (_) VALUES (?)

		String part1 = "INSERT INTO ";
		String tableName = ""; // reflection or annotation
		String part2 = " (";
		String columnList = ""; // iterate over fields and use reflection or annotations
		String part3 = ") VALUES (";
		String values = "?, ?"; // num of ? should be equal to number of fields
		String part4 = ")";
		return part1 + tableName + part2 + columnList + part3 + values + part4;
	}

	public static String readSQL(Object o)
	{
		// SELECT * FROM table WHERE _ = ?

		String part1 = "SELECT * FROM ";
		String tableName = "";
		String part2 = " WHERE ";
		String columnList = "";
		String parameterList = " = ?";

		return part1 + tableName + part2 + columnList + parameterList;
	}

	public static String updateSQL(Object o)
	{
		// UPDATE table SET _ = ? WHERE _ = ?

		String part1 = "UPDATE ";
		String tableName = "";
		String part2 = " SET ";
		String updateValues = "column = value"; // iterate over and separate by commas
		String part3 = " WHERE ";
		String condition = "primaryKey = value";

		return part1 + tableName + part2 + updateValues + part3 + condition;
	}

	public static String deleteSQL(Object o)
	{
		// DELETE FROM table WHERE _ = ?

		String part1 = "DELETE FROM ";
		String tableName = "";
		String part2 = " WHERE ";
		String columnList = "";
		String parameterList = " = ?";

		return part1 + tableName + part2 + columnList + parameterList;
	}

}
