package scriptors;

/**
 * Object Relational Mapping class used to convert data between incompatible type systems using an OOP based language.
 */

public class Scriptor
{

	String sql = "SELECT * FROM table WHERE id = ?";

	String firstPart = "SELECT * FROM ";
	String tableName = "";        //reflect on the object to get this
	String nextPart = " WHERE ";
	String filterColumn = "";     //reflect upon the object for this data as well
	String parameterList = " = ?";

	// Append full SQL Script
	String sqlScript = firstPart + tableName + nextPart + filterColumn + parameterList;

}

/**
 * Mention to team how you now have a better understanding of the scriptor for your ORM!
 */