package lv.helloit.lottery.LotteryApp.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    List<User> findAllByLotteryId (Long lotteryId);
}
