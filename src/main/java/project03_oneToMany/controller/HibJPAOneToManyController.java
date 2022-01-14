package project03_oneToMany.controller;

import project02_JPA.exception.HbException;
import project03_oneToMany.dao.QuestionDao;
import project03_oneToMany.model.Answer;
import project03_oneToMany.model.Question;

import java.util.ArrayList;
import java.util.List;

public class HibJPAOneToManyController {

    public static void main(String[] args) {

        Question q=new Question (
                "Qui est fort au tennis?",
                new Answer []{
                        new Answer("Djoko"),
                        new Answer("Nadal"),
                        new Answer("Federer"),});

        QuestionDao qDAO = new QuestionDao();
        try {
            //System.out.println(qDAO.getWithFilter());
            // les 2 tables sont maj!!
            int id = qDAO.save(q);
            System.out.println("Question id: " + id + " inserted");
        } catch (HbException e) {
            System.out.println ("DAO ERROR-> "+e.getMessage());
        }

    }
}
