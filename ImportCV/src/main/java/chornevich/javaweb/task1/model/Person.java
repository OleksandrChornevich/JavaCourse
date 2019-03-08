package chornevich.javaweb.task1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import chornevich.javaweb.task1.enums.CEFR_ACTFL;
import chornevich.javaweb.task1.enums.LANGUAGE;
import chornevich.javaweb.task1.service.LocalDateDeserializer;
import chornevich.javaweb.task1.service.LocalDateSerializer;

public class Person {
	private String firstName;
	private String lastName;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateOfBirth;
	private String city;
	private String address;
	private String mobileNumber;
	private String eMail;
	private Map<LANGUAGE, CEFR_ACTFL> mapOfLanguageSkill = new TreeMap<>();
	private List<Experience> educations = new ArrayList<>();
	private List<Experience> jobs = new ArrayList<>();

	public Person() {

	}

	public Person(String firstName, String lastName, LocalDate dateOfBirth, String city, String address,
			String mobileNumber, String eMail) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.eMail = eMail;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Map<LANGUAGE, CEFR_ACTFL> getMapOfLanguageSkill() {
		return mapOfLanguageSkill;
	}

	public void setMapOfLanguageSkill(Map<LANGUAGE, CEFR_ACTFL> mapOfLanguageSkill) {
		this.mapOfLanguageSkill = mapOfLanguageSkill;
	}

	public List<Experience> getEducations() {
		return educations;
	}

	public void setEducations(List<Experience> educations) {
		this.educations = educations;
	}

	public List<Experience> getJobs() {
		return jobs;
	}

	public void setJobs(List<Experience> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.dateOfBirth;

	}

}
