package pl.deren.demo.Spring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerHTTPResponse {
    private String username;
    private int money;


    public PlayerHTTPResponse(String username, int money) {
        this.username = username;
        this.money = money;
    }

    public static PlayerHTTPResponseBuilder builder() {
        return new PlayerHTTPResponseBuilder();
    }


    public static final class PlayerHTTPResponseBuilder {
        private String username;
        private int money;

        private PlayerHTTPResponseBuilder() {
        }

        public static PlayerHTTPResponseBuilder playerHTTPResponseBuilder() {
            return new PlayerHTTPResponseBuilder();
        }

        public PlayerHTTPResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PlayerHTTPResponseBuilder money(int money) {
            this.money = money;
            return this;
        }

        public PlayerHTTPResponse build() {
            return new PlayerHTTPResponse(username, money);
        }
    }
}
