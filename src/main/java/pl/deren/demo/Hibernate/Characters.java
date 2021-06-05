package pl.deren.demo.Hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String mage;
    private String fighter;
    private String tank;
    private String marksman;
    private String assassin;
    private String support;

    public Characters(String mage, String fighter, String tank, String  marksman, String assassin, String support) {
        this.mage = mage;
        this.fighter = fighter;
        this.tank = tank;
        this.marksman = marksman;
        this.assassin = assassin;
        this.support = support;
    }
}
