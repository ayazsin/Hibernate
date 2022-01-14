package project04_manyToMany.controller;

import project02_JPA.exception.HbException;
import project04_manyToMany.dao.PlayerDao;
import project04_manyToMany.model.Player;
import project04_manyToMany.model.Sponsor;

public class HibJPAManyToManyController {

    public static void main(String[] args) {

        Sponsor puma = new Sponsor("puma");
        Player [] fPs = new Player[] {
                new Player("Griezman", new Sponsor[] {
                        new Sponsor("Nike"),
                        puma,
                        new Sponsor("Adidas")
                }),
                new Player("Pogba",
                        new Sponsor[] {
                                new Sponsor("Decathlon"),
                                puma
                        })
        };

        PlayerDao pDAO = new PlayerDao();
        try {
            for (Player p:fPs) {
                int id = pDAO.save(p);
                System.out.println(p.getpName() + ", id: " + id + " inserted");
            }
        }catch (HbException e) {
            System.out.println("DAO ERROR->" + e.getMessage());
        }






    }
}
