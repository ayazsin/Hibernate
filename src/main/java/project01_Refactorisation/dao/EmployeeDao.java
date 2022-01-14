package project01_Refactorisation.dao;

import project01_Refactorisation.bean.Employee;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EmployeeDao {

    public Employee get(int id) {
        CriteriaBuilder builder = HibernateTool.getSession().getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        org.hibernate.query.Query<Employee> q = HibernateTool.getSession().createQuery(query);

        try {
            return q.getResultList().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }


}
