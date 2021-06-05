package pl.deren.demo.Spring;

public class PlayerMapper {
    public static PlayerHTTPResponse map(Player shop){
        return PlayerHTTPResponse.builder()
                .username(shop.getUsername())
                .money(shop.getMoney())
                .build();
    }
    public static Player map(PlayerHTTPRequest playerHTTPRequest){
        return Player.playerBuilder()
                .username(playerHTTPRequest.getUsername())
                .money(playerHTTPRequest.getMoney())
                .build();
    }
}
