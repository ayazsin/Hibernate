package project04_manyToMany.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PLAYER")
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "P_NAME", nullable = false, length = 100)
    private String pName;

    @ManyToMany(targetEntity = Sponsor.class,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "p_sponsor",
            joinColumns = @JoinColumn(name = "p_id", nullable = false, referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "s_id", nullable = false, referencedColumnName = "id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"p_id", "s_id"} )})
    private Set<Sponsor> fSponsors = new HashSet<>();

    public Player() {
        super();
    }

    public Player(String pName, Sponsor[] sponsors) {
        super();
        this.pName = pName;
        if (sponsors != null) for(Sponsor s : sponsors) this.fSponsors.add(s);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Set<Sponsor> getfSponsors() {
        return fSponsors;
    }

    public void setfSponsors(Set<Sponsor> fSponsors) {
        this.fSponsors = fSponsors;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", fSponsors=" + fSponsors +
                '}';
    }
}
