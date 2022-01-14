package project02_JPA.dao;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import project02_JPA.bean.Address;
import project02_JPA.exception.HbException;

import java.util.List;


public class AddressDao implements CRUDable<Address> {

	public AddressDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int save(Address obj) throws HbException {
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
	public List<Address> getAll() throws HbException {
		Session session = HibernateTools.getSessionFactory().openSession();
		session.beginTransaction();

		List<Address> addresses;
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Address> criteriaQuery = cb.createQuery(Address.class);
			criteriaQuery.from(Address.class);
			addresses = session.createQuery(criteriaQuery).getResultList();
		} catch (Exception e) {
			throw new HbException ("Cannot list");
		}

		session.getTransaction().commit();
		session.close();
		return addresses;
	}

	@Override
	public void delete(int id) throws HbException {
		Session session = HibernateTools.getSessionFactory().openSession();
		session.beginTransaction();
		Address address=null;
		try {
			address = session.get(Address.class, id);
			session.delete(address);
		} catch (Exception e) {
			throw new HbException ("Cannot delete id: " +id);
		}
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void update(int id, Address obj) throws HbException {
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
