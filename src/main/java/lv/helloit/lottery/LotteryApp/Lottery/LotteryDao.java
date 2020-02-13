package lv.helloit.lottery.LotteryApp.Lottery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryDao extends CrudRepository<Lottery, Long> {

}
