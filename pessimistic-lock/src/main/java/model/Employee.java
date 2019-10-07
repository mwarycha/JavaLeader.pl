package model;// Import statements

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
	@NamedQuery(name = Employee.FIND_ALL, query = "SELECT e FROM Employee e order by e.name"),
})
@Entity
@Table(name = "JL_EMP")
public class Employee implements Serializable {

private static final long serialVersionUID = 1607726899931733607L;
	
	public static final String FIND_ALL = "demo.model.Employee.find_all";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "version_num")
	@Version
	private int version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", version=" + version +
				'}';
	}
}
