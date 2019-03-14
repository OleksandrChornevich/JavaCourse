package chornevich.javaweb.task1.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import chornevich.javaweb.task1.enums.CEFR_ACTFL;
import chornevich.javaweb.task1.enums.LANGUAGE;
import chornevich.javaweb.task1.model.Experience;
import chornevich.javaweb.task1.model.Person;
import chornevich.javaweb.task1.service.PersonService;
import chornevich.javaweb.task1.sql.DBconnect;
import chornevich.javaweb.task1.sql.PersonDAO;

public class FirstTaskMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		PersonService persServ = new PersonService();
		persServ.searchPerson("NewText");
		persServ.exportYamlList("PersonList.yml", persServ);

		String dBUrl = "jdbc:postgresql://localhost:5433/CurriculumVitae";
		String dBUser = "postgres";
		String dBPassword = "1986";

		chornevich.javaweb.task1.sql.DBconnect dbConnect = new DBconnect();

		Connection connect = dbConnect.getConnection(dBUrl, dBUser, dBPassword);

		PersonDAO personDAO = new PersonDAO();

		for (Person p : persServ.getPerson()) {
			personDAO.addPersonToDB(connect, p);
		}
		// List<Person> persons = new ArrayList<>();
		// personDAO.getPersonFromDB(connect);

	}

}
