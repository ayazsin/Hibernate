package project02_JPA.dao;
import project02_JPA.exception.HbException;

import java.util.List;

public interface CRUDable<T> {
	public int save(T obj) throws HbException;	// CRUD Insert
	public List<T> getAll() throws HbException; // CRUD get all
	public void delete (int id) throws HbException; // CRUD delete	
	public void update (int id, T obj) throws HbException; //CRUD update
}
