package lv.helloit.lottery.LotteryApp.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    List<User> findAllByLotteryId (Long lotteryId);
    Optional<User> findByEmailAndCode(String email, String code);
    Optional<User> findByCode(String code);
}
