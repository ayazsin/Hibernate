package project03_oneToMany.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import project02_JPA.exception.HbException;
import project03_oneToMany.model.Question;

import java.util.List;

public class QuestionDao implements CRUDable<Question> {

    public QuestionDao() {
    }

    @Override
    public int save(Question obj) throws HbException {
        Session session = HibernateTools.getSessionFactory().openSession();
        session.beginTransaction();
        int id;
        try {
            id = (Integer) session.save(obj);
        } catch (Exception e) {
            throw new HbException("Cannot insert object: " + obj + " reason: " + e.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public List<Question> getWithFilter() throws HibernateException, HbException {
         // ex: tous les ids > 3 filtrage avec hibernate -> deprecated
        Criteria cr = HibernateTools.getSessionFactory().openSession().createCriteria(Question.class);
        cr.add(Restrictions.gt("id",3));
        return cr.list();
    }

    public List<Question> getWithFilter2() throws HibernateException, HbException {
        // filtrage avec jpa
        return null;
    }



}
