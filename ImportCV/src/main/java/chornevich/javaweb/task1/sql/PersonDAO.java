package chornevich.javaweb.task1.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import chornevich.javaweb.task1.model.Person;

public class PersonDAO {
static int counter=0;
	public void addToDB(Connection connection, Person person) throws SQLException {
		Statement statement = connection.createStatement();
		
		StringBuilder sqlPerson = new StringBuilder
				("INSERT INTO public.\"person\" "
						+ "(\"firstName\",\"lastName\",\"dateOfBirth\")");
		sqlPerson.append(" VALUES('")
//		.append(PersonDAO.counter)
//		.append("','")
		.append(person.getFirstName())
		.append("','")
		.append(person.getLastName())
		.append("','")
		.append(person.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
		.append("');");
		
		
		System.out.println(sqlPerson.toString());
		//System.out.println(sqlTeacher.toString());
		
		
	statement.executeUpdate(sqlPerson.toString());
	//statement.executeUpdate(sqlTeacher.toString());
	counter++;
	
	}
	
	
}
