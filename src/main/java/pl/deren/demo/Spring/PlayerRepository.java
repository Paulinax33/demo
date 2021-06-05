package pl.deren.demo.Spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    boolean findByMoney(int money);
    String findByUsername(String username);
    int countByMoney(int money);
}
