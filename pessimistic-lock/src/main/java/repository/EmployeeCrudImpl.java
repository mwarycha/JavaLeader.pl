package repository;

import model.Employee;
import utils.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.concurrent.TimeUnit;

public class EmployeeCrudImpl implements EmployeeCrud {

	public Employee saveEmployee(Employee employeeBE) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(employeeBE);
		em.getTransaction().commit();
		return employeeBE;
	}

	public void updateEmployee() {
		System.out.println("before update employee");
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Employee employee = em.find(Employee.class, 1, LockModeType.PESSIMISTIC_READ);
		System.out.println(employee);
		System.out.println("after lock PESSIMISTIC_WRITE");
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("waiting 1 second");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		employee.setName("new emp name");
		em.getTransaction().commit();
		System.out.println("after updated");
	}

	public void readEmployee() {

		System.out.println("read employee");

		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Employee employee = em.find(Employee.class, 1, LockModeType.PESSIMISTIC_READ);
		System.out.println(employee);
		System.out.println("after lock PESSIMISTIC_READ");
		em.getTransaction().commit();
		System.out.println("after read");
	}
}