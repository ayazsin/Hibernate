package project03_oneToMany.dao;

import project02_JPA.exception.HbException;

public interface CRUDable <T> {

    public int save(T obj) throws HbException; // CRUD Insert
}
