package chornevich.javaweb.task1.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import chornevich.javaweb.task1.enums.CEFR_ACTFL;
import chornevich.javaweb.task1.enums.LANGUAGE;
import chornevich.javaweb.task1.model.Experience;
import chornevich.javaweb.task1.model.Person;

public class PersonService {

	private List<Person> persons = new ArrayList<>();

	public List<Person> getPerson() {
		return persons;
	}

	public void setPerson(List<Person> person) {
		this.persons = person;
	}

	// *************
	public String importTxt(BufferedReader br, String line) {

		Experience bufferEdu = new Experience();
		Experience bufferJob = new Experience();
		Person bufferPerson = new Person();
		Map<LANGUAGE, CEFR_ACTFL> bufferLS = new TreeMap<>();
		List<Experience> bufferEducations = new ArrayList<>();
		List<Experience> bufferJobs = new ArrayList<>();

		try {
			if (line.indexOf("firstName:") != -1) {
				bufferPerson.setFirstName(line.substring(line.indexOf(':') + 1));
				line = br.readLine();
			}
			if (line.indexOf("lastName:") != -1) {
				bufferPerson.setLastName(line.substring(line.indexOf(':') + 1));
				line = br.readLine();
			}
			if (line.indexOf("dateOfBirth:") != -1) {
				bufferPerson.setDateOfBirth(
						LocalDate.parse(line.substring(line.indexOf(':') + 1), DateTimeFormatter.ISO_LOCAL_DATE));
				line = br.readLine();
			}
			if (line.indexOf("city:") != -1) {
				bufferPerson.setCity(line.substring(line.indexOf(':') + 1));
				line = br.readLine();
			}
			if (line.indexOf("address:") != -1) {
				bufferPerson.setAddress(line.substring(line.indexOf(':') + 1));
				line = br.readLine();
			}
			if (line.indexOf("mobileNumber:") != -1) {
				bufferPerson.setMobileNumber(line.substring(line.indexOf(':') + 1));
				line = br.readLine();
			}
			if (line.indexOf("eMail:") != -1) {
				bufferPerson.seteMail(line.substring(line.indexOf(':') + 1));
				line = br.readLine();
			}
			if (line.indexOf("languageSkills:") != -1) {
				line = br.readLine();

				while (!line.startsWith("e")) {
					String bufferLanguage = null;
					String bufferLevel = null;

					if (line.indexOf("language:") != -1) {
						bufferLanguage = line.substring(line.indexOf(':') + 1);
						line = br.readLine();
					}
					if (line.indexOf("level:") != -1) {
						bufferLevel = line.substring(line.indexOf(':') + 1);
						line = br.readLine();
					}
					bufferLS.put(LANGUAGE.valueOf(bufferLanguage), CEFR_ACTFL.valueOf(bufferLevel));

				}
				bufferPerson.setMapOfLanguageSkill(bufferLS);
			}
			if (line.indexOf("educations:") != -1) {
				line = br.readLine();
				while (!line.startsWith("j")) {
					//
					if (line.indexOf("start:") != -1) {
						bufferEdu.setStart(LocalDate.parse(line.substring(line.indexOf(':') + 1),
								DateTimeFormatter.ISO_LOCAL_DATE));
						line = br.readLine();
					}
					if (line.indexOf("end:") != -1) {
						bufferEdu.setEnd(LocalDate.parse(line.substring(line.indexOf(':') + 1),
								DateTimeFormatter.ISO_LOCAL_DATE));
						line = br.readLine();
					}
					if (line.indexOf("place:") != -1) {
						bufferEdu.setPlace(line.substring(line.indexOf(':') + 1));
						line = br.readLine();
					}
					bufferEducations.add(bufferEdu);
				}
				bufferPerson.setEducations(bufferEducations);
			}

			if (line.indexOf("jobs:") != -1) {
				line = br.readLine();
				for (;;) {
					//
					if (line.indexOf("start:") != -1) {
						bufferJob.setStart(LocalDate.parse(line.substring(line.indexOf(':') + 1),
								DateTimeFormatter.ISO_LOCAL_DATE));
						line = br.readLine();
					}
					if (line.indexOf("end:") != -1) {
						bufferJob.setEnd(LocalDate.parse(line.substring(line.indexOf(':') + 1),
								DateTimeFormatter.ISO_LOCAL_DATE));
						line = br.readLine();
					}
					if (line.indexOf("place:") != -1) {
						bufferJob.setPlace(line.substring(line.indexOf(':') + 1));

						line = br.readLine();
					}
					bufferJobs.add(bufferJob);
					if (line == null)
						break;
					if (line.startsWith("f") || line.startsWith("{") || line.startsWith("<"))
						break;

				}
				bufferPerson.setJobs(bufferJobs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.persons.add(bufferPerson);
		return line;
	}

	public void exportJson(String fileName, Person cv) {

		ObjectMapper mapper = new ObjectMapper();

		File file = new File(fileName);
		try {
			// Serialize Java object info JSON file.
			mapper.writeValue(file, cv);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Person importJson(String line) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			// Deserialize JSON file into Java object.
			Person person = new Person();
			person = mapper.readValue(line, Person.class);
			return person;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String exportYaml(String fileName, Person cv) {

		//
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		File file = new File(fileName);
		// Write object as YAML file
		try {
			mapper.writeValue(file, cv);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//

		return null;

	}

	public String exportYamlList(String fileName, PersonService cvServ) {

		//
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		File file = new File(fileName);
		// Write object as YAML file
		try {
			mapper.writeValue(file, cvServ);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//

		return null;

	}

	public void exportXML(String fileName, Person cv) throws IOException {
		//
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.writeValue(new File(fileName), cv);
	}

	public Person importXML(String line) throws IOException {
		Person person = new Person();
		XmlMapper xmlMapper = new XmlMapper();
		person = xmlMapper.readValue(line, Person.class); 
		return person;

	}

	public void searchPerson(String fileName) {

		File file = new File(fileName);
		boolean textFlag = false;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			line = br.readLine();
			while (line != null) {
				textFlag = false;

				if (line.startsWith("<")) {
					this.persons.add(this.importXML(line));
				} else if (line.startsWith("{")) {
					this.persons.add(this.importJson(line));
				} else if (line.startsWith("f")) {
					line = this.importTxt(br, line);
					textFlag = true;
				}

				if (!textFlag)
					line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Unable to read file " + file.toString());
		}

	}

}
