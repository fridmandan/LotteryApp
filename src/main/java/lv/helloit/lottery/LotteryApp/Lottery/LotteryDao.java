package lv.helloit.lottery.LotteryApp.Lottery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotteryDao extends CrudRepository<Lottery, Long> {
    Optional<Lottery> findByTitle(String title);
    List<Lottery> findAll();
}
