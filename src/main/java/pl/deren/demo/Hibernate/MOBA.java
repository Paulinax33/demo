package pl.deren.demo.Hibernate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MOBA {
    private String missions;

    public MOBA(String missions) {
        this.missions = missions;
    }
}
