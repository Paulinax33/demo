package pl.deren.demo.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }
    public PlayerHTTPResponse getPlayerById(long id){
        return playerRepository.findById(id)
                .map(PlayerMapper::map)
                .orElseThrow(()-> new RuntimeException("Not Found"));
    }
    public long savePlayer(PlayerHTTPRequest playerHTTPRequest){
        Player shop = PlayerMapper.map(playerHTTPRequest);
        return playerRepository.save(shop).getId();
    }
    public boolean deletePlayerById(long id){
        if (playerRepository.existsById(id)){
            playerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public long updatePlayerById(long id, PlayerHTTPRequest playerHTTPRequest){
        Player player = PlayerMapper.map(playerHTTPRequest);
        player.setId(id);
        return playerRepository.save(player).getId();
    }
    public boolean findByMoney(int money){
        if (playerRepository.findByMoney(money)){
            return true;
        }
        return false;
    }
}
