package chornevich.javaweb.task1.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import chornevich.javaweb.task1.enums.CEFR_ACTFL;
import chornevich.javaweb.task1.enums.LANGUAGE;
import chornevich.javaweb.task1.model.Experience;
import chornevich.javaweb.task1.model.Person;

public class PersonDAO {

	public void addPersonToDB(Connection connection, Person person) throws SQLException {

		String insertPersonSQL = "INSERT INTO public.person"
				+ "(\"firstName\",\"lastName\",\"dateOfBirth\",\"city\",\"address\") VALUES" + "(?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSQL,
				PreparedStatement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, person.getFirstName());
		preparedStatement.setString(2, person.getLastName());
		preparedStatement.setDate(3,
				java.sql.Date.valueOf(person.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE)));
		preparedStatement.setString(4, person.getCity());
		preparedStatement.setString(5, person.getAddress());
		preparedStatement.executeUpdate();

		ResultSet rs = preparedStatement.getGeneratedKeys();

		if (rs.next()) {
			person.setIdPerson(rs.getInt(4));
		}

		String insertContactSQL = "INSERT INTO public.contact" + "(\"mobileNumber\",\"email\",\"idcontact\") VALUES"
				+ "(?,?,?)";
		preparedStatement = connection.prepareStatement(insertContactSQL);
		preparedStatement.setString(1, person.getMobileNumber());
		preparedStatement.setString(2, person.geteMail());
		preparedStatement.setInt(3, person.getIdPerson());
		preparedStatement.executeUpdate();

		String insertEducationSQL = "INSERT INTO public.education"
				+ "(\"start\",\"end\",\"place\",\"ideducation\") VALUES" + "(?,?,?,?)";
		for (Experience ed : person.getEducations()) {
			preparedStatement = connection.prepareStatement(insertEducationSQL);
			preparedStatement.setDate(1, java.sql.Date.valueOf(ed.getStart().format(DateTimeFormatter.ISO_LOCAL_DATE)));
			preparedStatement.setDate(2, java.sql.Date.valueOf(ed.getStart().format(DateTimeFormatter.ISO_LOCAL_DATE)));
			preparedStatement.setString(3, ed.getPlace());
			preparedStatement.setInt(4, person.getIdPerson());
			preparedStatement.executeUpdate();
		}

		String insertJobSQL = "INSERT INTO public.job" + "(\"start\",\"end\",\"place\",\"idjob\") VALUES" + "(?,?,?,?)";
		for (Experience job : person.getJobs()) {
			preparedStatement = connection.prepareStatement(insertJobSQL);
			preparedStatement.setDate(1,
					java.sql.Date.valueOf(job.getStart().format(DateTimeFormatter.ISO_LOCAL_DATE)));
			preparedStatement.setDate(2,
					java.sql.Date.valueOf(job.getStart().format(DateTimeFormatter.ISO_LOCAL_DATE)));
			preparedStatement.setString(3, job.getPlace());
			preparedStatement.setInt(4, person.getIdPerson());
			preparedStatement.executeUpdate();
		}

		String insertLangSkillsSQL = "INSERT INTO public.languageSkill"
				+ "(\"language\",\"cefractfl\",\"idlanguageSkill\" VALUES" + "(?::languageenum, ?::cefractflenum, ?)";
		Set<Map.Entry<LANGUAGE, CEFR_ACTFL>> langSkillEntry = person.getMapOfLanguageSkill().entrySet();
		Iterator<Map.Entry<LANGUAGE, CEFR_ACTFL>> langSkillIterator = langSkillEntry.iterator();
		while (langSkillIterator.hasNext()) {
			Map.Entry<LANGUAGE, CEFR_ACTFL> entry = langSkillIterator.next();
			{
				preparedStatement = connection.prepareStatement(insertLangSkillsSQL);
				preparedStatement.setString(1, entry.getKey().toString());
				preparedStatement.setString(2, entry.getValue().toString());
				preparedStatement.setInt(3, person.getIdPerson());
				preparedStatement.executeUpdate();
			}
		}

	}

	public List<Person> getPersonFromDB(Connection connection) throws SQLException {
		List<Person> persons = new ArrayList<>();

		String selectPersonSQL = "SELECT * FROM public.person";
		PreparedStatement preparedStatement = connection.prepareStatement(selectPersonSQL);
		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			Person person = new Person();
			person.setIdPerson(result.getInt("idperson"));
			person.setFirstName(result.getString("firstName"));
			person.setLastName(result.getString("lastName"));
			person.setCity(result.getString("city"));
			person.setAddress(result.getString("address"));
			person.setDateOfBirth(LocalDate.parse((result.getString("dateOfBirth")), DateTimeFormatter.ISO_LOCAL_DATE));
			persons.add(person);
		}

		System.out.println(persons);
		return persons;

	}

}
