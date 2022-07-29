package com.sparta.northwind.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class EmployeeDto implements Serializable {
	private final Integer id;
	private final String lastName;
	private final String firstName;
	private final String title;
	private final String titleOfCourtesy;
	private final Instant birthDate;
	private final Instant hireDate;
	private final String address;
	private final String city;
	private final String region;
	private final String postalCode;
	private final String country;
	private final String homePhone;
	private final String extension;
	private final byte[] photo;
	private final String notes;
	private final String photoPath;
	private final Double salary;

	public EmployeeDto(Integer id, String lastName, String firstName, String title, String titleOfCourtesy, Instant birthDate, Instant hireDate, String address, String city, String region, String postalCode, String country, String homePhone, String extension, byte[] photo, String notes, String photoPath, Double salary) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.titleOfCourtesy = titleOfCourtesy;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.homePhone = homePhone;
		this.extension = extension;
		this.photo = photo;
		this.notes = notes;
		this.photoPath = photoPath;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getTitle() {
		return title;
	}

	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public Instant getHireDate() {
		return hireDate;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getRegion() {
		return region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getExtension() {
		return extension;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public String getNotes() {
		return notes;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public Double getSalary() {
		return salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmployeeDto entity = (EmployeeDto) o;
		return Objects.equals(this.id, entity.id) &&
				Objects.equals(this.lastName, entity.lastName) &&
				Objects.equals(this.firstName, entity.firstName) &&
				Objects.equals(this.title, entity.title) &&
				Objects.equals(this.titleOfCourtesy, entity.titleOfCourtesy) &&
				Objects.equals(this.birthDate, entity.birthDate) &&
				Objects.equals(this.hireDate, entity.hireDate) &&
				Objects.equals(this.address, entity.address) &&
				Objects.equals(this.city, entity.city) &&
				Objects.equals(this.region, entity.region) &&
				Objects.equals(this.postalCode, entity.postalCode) &&
				Objects.equals(this.country, entity.country) &&
				Objects.equals(this.homePhone, entity.homePhone) &&
				Objects.equals(this.extension, entity.extension) &&
				Objects.equals(this.photo, entity.photo) &&
				Objects.equals(this.notes, entity.notes) &&
				Objects.equals(this.photoPath, entity.photoPath) &&
				Objects.equals(this.salary, entity.salary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, address, city, region, postalCode, country, homePhone, extension, photo, notes, photoPath, salary);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"lastName = " + lastName + ", " +
				"firstName = " + firstName + ", " +
				"title = " + title + ", " +
				"titleOfCourtesy = " + titleOfCourtesy + ", " +
				"birthDate = " + birthDate + ", " +
				"hireDate = " + hireDate + ", " +
				"address = " + address + ", " +
				"city = " + city + ", " +
				"region = " + region + ", " +
				"postalCode = " + postalCode + ", " +
				"country = " + country + ", " +
				"homePhone = " + homePhone + ", " +
				"extension = " + extension + ", " +
				"photo = " + photo + ", " +
				"notes = " + notes + ", " +
				"photoPath = " + photoPath + ", " +
				"salary = " + salary + ")";
	}
}
