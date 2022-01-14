package project02_JPA.dao;

import project02_JPA.bean.Student;
import project02_JPA.exception.HbException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class StudentDao implements CRUDable<Student> {

	public StudentDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int save(Student obj) throws HbException {
		Session session = HibernateTools.getSessionFactory().openSession();
		session.beginTransaction();
		int id;
		try {
			id = (Integer) session.save(obj);
		} catch (Exception e) {
			throw new HbException ("Cannot insert object: " + obj);
		}
		session.getTransaction().commit();
		session.close();
		return id;
	}
	@Override
	public List<Student> getAll() throws HbException {
		Session session = HibernateTools.getSessionFactory().openSession();
		session.beginTransaction();

		List<Student> students;
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
			criteriaQuery.from(Student.class);
			students = session.createQuery(criteriaQuery).getResultList();
		} catch (Exception e) {
			throw new HbException ("Cannot list");
		}

		session.getTransaction().commit();
		session.close();
		return students;
	}
	@Override
	public void delete(int id) throws HbException {
		Session session = HibernateTools.getSessionFactory().openSession();
		session.beginTransaction();
		Student student=null;
		try {
			student = session.get(Student.class, id);
			session.delete(student);
		} catch (Exception e) {
			throw new HbException ("Cannot delete id: " +id);
		}
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void update(int id, Student obj) throws HbException {
		Session session = HibernateTools.getSessionFactory().openSession();
		session.beginTransaction();

		obj.setId(id); 
		try {
			session.update(obj);//No need to update manually as it will be updated automatically on transaction close.
		} catch (Exception e) {
			throw new HbException ("Cannot update id: " +id);
		}
		session.getTransaction().commit();
		session.close();
	}

}
