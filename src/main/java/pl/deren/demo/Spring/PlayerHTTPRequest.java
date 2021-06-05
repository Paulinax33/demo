package pl.deren.demo.Spring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerHTTPRequest {
    private String username;
    private int money;


    public PlayerHTTPRequest(String username, int money) {
        this.username = username;
        this.money = money;
    }


    public static final class PlayerHTTPRequestBuilder {
        private String username;
        private int money;

        private PlayerHTTPRequestBuilder() {
        }

        public static PlayerHTTPRequestBuilder PlayerHTTPRequestBuilder() {
            return new PlayerHTTPRequestBuilder();
        }

        public PlayerHTTPRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PlayerHTTPRequestBuilder money(int money) {
            this.money = money;
            return this;
        }

        public PlayerHTTPRequest build() {
            return new PlayerHTTPRequest(username, money);
        }
    }
}
