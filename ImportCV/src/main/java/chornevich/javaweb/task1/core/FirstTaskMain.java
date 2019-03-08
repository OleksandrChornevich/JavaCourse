package chornevich.javaweb.task1.core;

import java.io.IOException;
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

public class FirstTaskMain {

	public static void main(String[] args) throws IOException {
		Person person = new Person("Petro", "Sidorenko",
				LocalDate.parse("1986-05-16", DateTimeFormatter.ISO_LOCAL_DATE), "Chernivtsi", "Ukrainska 15",
				"0501234567", "Sidorenko.P@gmail.com");

		Map<LANGUAGE, CEFR_ACTFL> langSkill = new TreeMap<>();
		langSkill.put(LANGUAGE.valueOf("ENGLISH"), CEFR_ACTFL.valueOf("B1"));
		langSkill.put(LANGUAGE.valueOf("FRENCH"), CEFR_ACTFL.valueOf("A1"));
		langSkill.put(LANGUAGE.valueOf("GERMAN"), CEFR_ACTFL.valueOf("C1"));
		person.setMapOfLanguageSkill(langSkill);

		List<Experience> listOfEdu = new ArrayList<>();
		Experience persEdu1 = new Experience(LocalDate.parse("1992-09-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2003-06-01", DateTimeFormatter.ISO_LOCAL_DATE), "School 1");
		Experience persEdu2 = new Experience(LocalDate.parse("2003-09-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2008-07-01", DateTimeFormatter.ISO_LOCAL_DATE), "CHNU");
		listOfEdu.add(persEdu1);
		listOfEdu.add(persEdu2);
		person.setEducations(listOfEdu);

		List<Experience> listOfExp = new ArrayList<>();
		Experience persExp1 = new Experience(LocalDate.parse("2008-07-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2019-05-31", DateTimeFormatter.ISO_LOCAL_DATE), "Shop");
		Experience persExp2 = new Experience(LocalDate.parse("2019-06-01", DateTimeFormatter.ISO_LOCAL_DATE),
				LocalDate.parse("2025-07-01", DateTimeFormatter.ISO_LOCAL_DATE), "Inter");
		listOfExp.add(persExp1);
		listOfExp.add(persExp2);
		person.setJobs(listOfExp);

		PersonService persServ = new PersonService();

		persServ.exportJson("Person.json", person);
		persServ.exportXML("Person.xml", person);
	
		persServ.searchPerson("NewText.txt");

		persServ.exportYamlList("PersonList.yml", persServ);
	

	}

}
