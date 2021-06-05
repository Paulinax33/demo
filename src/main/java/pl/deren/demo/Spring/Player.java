package pl.deren.demo.Spring;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.DOMImplementationList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private int money;


    public Player(String username, int money) {
        this.username = username;
        this.money = money;

    }
    public Player() {

    }

    public static PlayerBuilder playerBuilder() {
        return new PlayerBuilder();
    }

    public static final class PlayerBuilder {
        private long id;
        private String username;
        private int money;

        private PlayerBuilder() {
        }

        public static PlayerBuilder PlayerBuilder() {
            return new PlayerBuilder();
        }

        public PlayerBuilder id(long id) {
            this.id = id;
            return this;
        }

        public PlayerBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PlayerBuilder money(int money) {
            this.money = money;
            return this;
        }

        public Player build() {
            Player player = new Player();
            player.setId(id);
            player.setUsername(username);
            player.setMoney(money);
            return player;
        }
    }
}
}