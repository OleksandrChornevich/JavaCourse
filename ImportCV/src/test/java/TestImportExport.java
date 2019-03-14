import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import chornevich.javaweb.task1.enums.CEFR_ACTFL;
import chornevich.javaweb.task1.enums.LANGUAGE;
import chornevich.javaweb.task1.model.Experience;
import chornevich.javaweb.task1.model.Person;
import chornevich.javaweb.task1.service.PersonService;

class TestImportExport {

	@Test
	void testJSON() {
		Person person = new Person("Anton", "Andrushenko",
				LocalDate.parse("1980-01-01", DateTimeFormatter.ISO_LOCAL_DATE), "Alchevsk", "Avangardna", "0501111111",
				"Anton.A@gmail.com");

		Map<LANGUAGE, CEFR_ACTFL> langSkill = new TreeMap<>();
		langSkill.put(LANGUAGE.valueOf("ENGLISH"), CEFR_ACTFL.valueOf("A1"));
		langSkill.put(LANGUAGE.valueOf("FRENCH"), CEFR_ACTFL.valueOf("B1"));
		langSkill.put(LANGUAGE.valueOf("GERMAN"), CEFR_ACTFL.valueOf("C1"));
		person.setMapOfLanguageSkill(langSkill);

		List<Experience> listOfEdu = new ArrayList<>();
		Experience persEdu1 = new Experience(LocalDate.parse("1984-01-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("1994-01-01", DateTimeFormatter.ISO_LOCAL_DATE), "School 1");
		Experience persEdu2 = new Experience(LocalDate.parse("1994-02-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("1999-02-01", DateTimeFormatter.ISO_LOCAL_DATE), "Univer");

		listOfEdu.add(persEdu1);
		listOfEdu.add(persEdu2);

		person.setEducations(listOfEdu);

		List<Experience> listOfExp = new ArrayList<>();
		Experience persJob1 = new Experience(LocalDate.parse("1999-03-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2019-05-31", DateTimeFormatter.ISO_LOCAL_DATE), "Bank");
		Experience persJob2 = new Experience(LocalDate.parse("2019-06-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2030-07-01", DateTimeFormatter.ISO_LOCAL_DATE), "OshadBank");

		listOfExp.add(persJob1);
		listOfExp.add(persJob2);

		person.setJobs(listOfExp);

		PersonService persServ = new PersonService();
		persServ.exportJson("PersonTestJson", person);

		persServ.searchPerson("NewText");
		int firstElementArrayList = 0;
		Person actual = person;
		Person expected = persServ.getPerson().get(firstElementArrayList);
		assertEquals(actual, expected);

	}

	@Test
	void testXML() throws IOException {
		Person person = new Person("Boris", "Beresov", LocalDate.parse("1985-11-16", DateTimeFormatter.ISO_LOCAL_DATE),
				"Beregove", "Bereganska", "0502222222", "Boris.b@gmail.com");

		Map<LANGUAGE, CEFR_ACTFL> langSkill = new TreeMap<>();
		langSkill.put(LANGUAGE.valueOf("ENGLISH"), CEFR_ACTFL.valueOf("B1"));
		langSkill.put(LANGUAGE.valueOf("FRENCH"), CEFR_ACTFL.valueOf("A1"));
		langSkill.put(LANGUAGE.valueOf("GERMAN"), CEFR_ACTFL.valueOf("C1"));
		person.setMapOfLanguageSkill(langSkill);

		List<Experience> listOfEdu = new ArrayList<>();
		Experience persEdu1 = new Experience(LocalDate.parse("1992-09-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2003-06-01", DateTimeFormatter.ISO_LOCAL_DATE), "School 2");
		Experience persEdu2 = new Experience(LocalDate.parse("2003-09-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2008-07-01", DateTimeFormatter.ISO_LOCAL_DATE), "BHNU");

		listOfEdu.add(persEdu1);
		listOfEdu.add(persEdu2);

		person.setEducations(listOfEdu);

		List<Experience> listOfExp = new ArrayList<>();
		Experience persJob1 = new Experience(LocalDate.parse("2008-08-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2019-05-31", DateTimeFormatter.ISO_LOCAL_DATE), "Shop");
		Experience persJob2 = new Experience(LocalDate.parse("2019-06-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2025-07-01", DateTimeFormatter.ISO_LOCAL_DATE), "Inter");

		listOfExp.add(persJob1);
		listOfExp.add(persJob2);

		person.setJobs(listOfExp);

		PersonService persServ = new PersonService();
		persServ.exportXML("PersonTestXml", person);

		persServ.searchPerson("NewText");
		int secondElementArrayList = 1;
		Person actual = person;
		Person expected = persServ.getPerson().get(secondElementArrayList);
		assertEquals(actual, expected);

	}

	@Test
	void testTXT() {

		Person person4 = new Person("Dmitro", "Dmitrenko",
				LocalDate.parse("1990-11-16", DateTimeFormatter.ISO_LOCAL_DATE), "Dnipro", "Dniprovska", "0503333333",
				"Dmitro@gmail.com");

		Map<LANGUAGE, CEFR_ACTFL> langSkill = new TreeMap<>();
		langSkill.put(LANGUAGE.valueOf("ENGLISH"), CEFR_ACTFL.valueOf("C1"));
		langSkill.put(LANGUAGE.valueOf("FRENCH"), CEFR_ACTFL.valueOf("B1"));
		langSkill.put(LANGUAGE.valueOf("GERMAN"), CEFR_ACTFL.valueOf("A1"));
		person4.setMapOfLanguageSkill(langSkill);

		List<Experience> listOfEdu = new ArrayList<>();
		Experience persEdu1 = new Experience(LocalDate.parse("1996-09-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2006-06-01", DateTimeFormatter.ISO_LOCAL_DATE), "School 3");
		Experience persEdu2 = new Experience(LocalDate.parse("2007-09-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2012-07-01", DateTimeFormatter.ISO_LOCAL_DATE), "Dhnu");

		listOfEdu.add(persEdu1);
		listOfEdu.add(persEdu2);

		person4.setEducations(listOfEdu);

		List<Experience> listOfExp = new ArrayList<>();
		Experience persJob1 = new Experience(LocalDate.parse("2013-07-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2019-05-31", DateTimeFormatter.ISO_LOCAL_DATE), "Firma");
		Experience persJob2 = new Experience(LocalDate.parse("2019-06-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2025-07-01", DateTimeFormatter.ISO_LOCAL_DATE), "BestPlace");

		listOfExp.add(persJob1);
		listOfExp.add(persJob2);

		person4.setJobs(listOfExp);

		PersonService persServTxt = new PersonService();
		persServTxt.searchPerson("NewText");
		int secondElementArrayList = 2;
		Person actual = person4;
		Person expected = persServTxt.getPerson().get(secondElementArrayList);
		assertEquals(actual, expected);

	}

}
