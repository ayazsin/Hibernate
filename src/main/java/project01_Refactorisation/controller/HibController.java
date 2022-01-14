package project01_Refactorisation.controller;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project01_Refactorisation.bean.Employee;
import project01_Refactorisation.dao.EmployeeDao;
import project01_Refactorisation.dao.HibernateTool;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class HibController {    
	public static void main(String[] args) {
		try {
			Session session = HibernateTool.getSession();
				// d�marrage transaction
			Transaction t = session.beginTransaction();
				// insertion

			session.save(new Employee(30, "Georges", "Clooney"));
			session.save(new Employee(40, "Leonardo", "Di Caprio"));
			session.save(new Employee(50, "Nicole", "Kidman"));
				// tentative de lecture

			Employee e = (Employee)session.get(Employee.class, 50);
			if(e != null)
				System.out.println("\nEmployee Record is: " + e);

				// tentative de delete
			//session.delete((Employee)session.get(Employee.class, 30));

			// Tous les Employes

			CriteriaQuery<Employee> criteriaQuery = session.getCriteriaBuilder().createQuery(Employee.class);
			criteriaQuery.from(Employee.class);
			List<Employee> employees = session.createQuery(criteriaQuery).getResultList();
			employees.forEach(System.out::println);

			HibernateTool.likeFilter(session, employees);

//			EmployeeDao el = new EmployeeDao();
//			System.out.println("=====>" + el.get(50));



			t.commit();  // validation transaction

			// fermeture usine+session
			HibernateTool.close();
		}
		catch (Exception e) {
			System.out.println ("Erreur hibernate " + e.getMessage());
		}
	}
}