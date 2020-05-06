package ru.kdv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
}



