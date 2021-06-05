package pl.deren.demo.Hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class LeagueOfLegends extends MOBA{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user;
    private String items;
    @OneToOne
    private Characters characters;
    private int essence;
    private int accountLevel;
    private TypeOfArena arena;


    public LeagueOfLegends(String user, String items, Characters characters, int essence, int accountLevel, TypeOfArena arena, String missions) {
        super(missions);
        this.user = user;
        this.items = items;
        this.characters = characters;
        this.essence = essence;
        this.accountLevel = accountLevel;
        this.arena = arena;
    }

}
