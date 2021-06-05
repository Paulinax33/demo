package pl.deren.demo.Hibernate;

public enum TypeOfArena {
    normal(40, 5),
    rankedSoloDuo(25, 5);

    int time;
    int players;

    TypeOfArena(int time, int players){
        this.time = time;
        this.players = players;
    }
}
