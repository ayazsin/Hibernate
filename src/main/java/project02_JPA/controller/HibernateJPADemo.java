package project02_JPA.controller;

import project02_JPA.bean.Address;
import project02_JPA.bean.Student;
import project02_JPA.dao.AddressDao;
import project02_JPA.dao.StudentDao;
import project02_JPA.exception.HbException;

import java.util.List;

/**
 * Class used to perform CRUD operation on database with Hibernate API's
 * 
 */
public class HibernateJPADemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
			// student Handling
		StudentDao studentDAO = new StudentDao();
			// address Handling
		AddressDao addressDAO = new AddressDao();
		
		try {
			List<Student> students = studentDAO.getAll();
			System.out.println("Init: List of all persisted students >>>");
			for (Student student : students)
				System.out.println("\tPersisted Student :" + student);
				/* Save few objects with hibernate  */
			int studentId1 = studentDAO.save(
					new Student("James", "Gray", "Basket"));
			int studentId2 = studentDAO.save(
					new Student("Jim", "Murray", "Science"));
			int studentId3 = studentDAO.save(new Student
					("John", "Doe", "Physics"));
			int studentId4 = studentDAO.save(new Student
					("Bill", "Gates", "Maths"));
				/* Retrieve all saved objects */
			students = studentDAO.getAll();
			for (Student student : students) 
				System.out.println("\tPersisted Student :" + student);
				/* Update an object */
			studentDAO.update(studentId4, new Student
					("Bill", "Gates", "Economy"));
				/* Deletes an object */
			studentDAO.delete(studentId2);

			List<Student> remaingStudents = studentDAO.getAll();
			System.out.println("List of all persisted students after a delete &an update >>>");
			for (Student student : remaingStudents) {
				System.out.println("\tPersisted Student :" + student);
			}
			
			
			System.out.println("Add address >>>");
			int addId1 = addressDAO.save(
					new Address(10, "rue de La canebi�re", "Marseille", 13000, "France"));
			
		} catch (HbException e) {
			System.out.println ("DAO ERROR-> "+e.getMessage());
		}

	}


}
