package chornevich.javaweb.task1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import chornevich.javaweb.task1.enums.CEFR_ACTFL;
import chornevich.javaweb.task1.enums.LANGUAGE;
import chornevich.javaweb.task1.service.LocalDateDeserializer;
import chornevich.javaweb.task1.service.LocalDateSerializer;

public class Person {

	private int idPerson;
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

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((educations == null) ? 0 : educations.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + idPerson;
		result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mapOfLanguageSkill == null) ? 0 : mapOfLanguageSkill.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (educations == null) {
			if (other.educations != null)
				return false;
		} else if (!educations.equals(other.educations))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idPerson != other.idPerson)
			return false;
		if (jobs == null) {
			if (other.jobs != null)
				return false;
		} else if (!jobs.equals(other.jobs))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mapOfLanguageSkill == null) {
			if (other.mapOfLanguageSkill != null)
				return false;
		} else if (!mapOfLanguageSkill.equals(other.mapOfLanguageSkill))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.idPerson + "" + this.firstName + " " + this.lastName + " " + this.dateOfBirth;

	}

}
