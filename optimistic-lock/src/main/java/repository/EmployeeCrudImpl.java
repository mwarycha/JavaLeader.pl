package repository;

import model.Employee;
import utils.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmployeeCrudImpl implements EmployeeCrud {

	public Employee saveEmployee(Employee employeeBE) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(employeeBE);
		em.getTransaction().commit();
		return employeeBE;
	}

	public Employee updateEmployee(Employee employeeBE) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(employeeBE);
		em.getTransaction().commit();
		return employeeBE;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployee() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query query = em.createNamedQuery(Employee.FIND_ALL);
		return query.getResultList();
	}
}