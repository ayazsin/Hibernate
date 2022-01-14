package project04_manyToMany.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import project02_JPA.exception.HbException;
import project03_oneToMany.dao.HibernateTools;
import project04_manyToMany.model.Player;

import java.util.List;

public class PlayerDao implements CRUDable<Player> {

    public PlayerDao() {
    }

    @Override
    public int save(Player obj) throws HbException {
        Session session = project04_manyToMany.dao.HibernateTools.getSessionFactory().openSession();
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

    public List<Player> getWithFilter() throws HibernateException, HbException {
        // ex: tous les ids > 3 filtrage avec hibernate -> deprecated
        Criteria cr = HibernateTools.getSessionFactory().openSession().createCriteria(Player.class);
        cr.add(Restrictions.gt("id",3));
        return cr.list();
    }

    public List<Player> getWithFilter2() throws HibernateException, HbException {
        // filtrage avec jpa
        return null;
    }


}
