package be.belfius.sbcrudrw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "employees")
public class EmployeeLombok {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long id;
	@Getter
	@Column(name= "first_name")
	private String firstName;
	@Getter
	@Column(name= "last_name")
	private String lastName;
	@Getter
	@Column(name= "email_id")
	private String emailId;

}
