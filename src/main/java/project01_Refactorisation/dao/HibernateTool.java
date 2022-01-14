package project01_Refactorisation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import project01_Refactorisation.bean.Employee;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateTool {
	
	private static final String HIB_CFG_FILE="hibernate.cfg.xml";
	
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	static{
		try{
			//Creation d'un ServiceRegistry avec le fichier de config Hibernate
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
					configure(HIB_CFG_FILE).build(); 
			// mise en place des data et de la partie "usine"
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
			// ouverture session
			sessionFactory = meta.getSessionFactoryBuilder().build();  

		}catch (Exception e) {
			System.err.println("Session cannot be opened: " + e.getMessage());
			System.exit(1);
		}	
	}

	public static Session getSession() {
		// ouverture transaction s�curis�e
		session = sessionFactory.openSession();
		return session;
	}

	public static void close() { // on ferme tout
		try {
			session.close();
			sessionFactory.close();
		}catch (Throwable ex) {
			System.err.println("Session cannot be closed: " + ex);
			throw new ExceptionInInitializerError(ex);
		}	
	}

	public static void likeFilter(Session session, List<Employee> employees) {

		// exemple de codage: faire un like
		// criteria Builder = le point d'entrée
		CriteriaBuilder cb = session.getCriteriaBuilder();
		// CriteriaQuery = la commande
		CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
		// le root (ce qui est issu du "from")
		Root<Employee> eRoot = criteriaQuery.from(Employee.class);
		// rajout du "where" et le filtre (ici "lastname" commence par "K")
		criteriaQuery
				.select(eRoot)
				.where(cb.like(eRoot.get("lastName"),"K%"));
		// exécution et récup liste
		employees = session
				.createQuery(criteriaQuery)
				.getResultList();
		// affichage
		employees.forEach(System.out::println);

	}
}
