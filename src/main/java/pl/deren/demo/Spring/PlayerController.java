package pl.deren.demo.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping(value = "/get/player")
    public PlayerHTTPResponse getPlayerById(@PathVariable long id){
        return playerService.getPlayerById(id);
    }
    @PostMapping(value = "/save/player")
    public long savePlayer(@RequestBody PlayerHTTPRequest playerHTTPRequest){
        return playerService.savePlayer(playerHTTPRequest);
    }
    @PutMapping(value = "/update/player/{id}")
    public long updatePlayerById(@PathVariable long id, @RequestBody PlayerHTTPRequest playerHTTPRequest){
        return playerService.updatePlayerById(id, playerHTTPRequest);
    }
    @DeleteMapping(value = "/delete/player/{id}")
    public boolean deletePlayerById(@PathVariable long id){
        return playerService.deletePlayerById(id);
    }
}
