package chornevich.javaweb.task1.model;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import chornevich.javaweb.task1.service.LocalDateDeserializer;
import chornevich.javaweb.task1.service.LocalDateSerializer;

public class Experience {
	private String idPerson;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate start;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate end;
	private String place;

	public Experience() {

	}

	public Experience(LocalDate start, LocalDate end, String place) {
		this.start = start;
		this.end = end;
		this.place = place;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
