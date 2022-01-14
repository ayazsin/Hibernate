package project04_manyToMany.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SPONSOR")
public class Sponsor implements Serializable {

    private static final long serialVersionUID = -578848996893330737L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "S_NAME", nullable = false, length = 100, unique = true)
    private String sName;

    @ManyToMany(mappedBy = "fSponsors", targetEntity = Player.class)
    private Set <Player> players = new HashSet<>();

    public Sponsor() {
        super();
    }


    public Sponsor(String sName) {
        this.sName = sName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
    public void addPlayer(Player p) {
        this.players.add(p);
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "id=" + id +
                ", sName='" + sName + '\'' +
                ", players=" + players +
                '}';
    }
}
