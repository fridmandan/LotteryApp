package lv.helloit.lottery.LotteryApp.User;

import lv.helloit.lottery.LotteryApp.Lottery.Lottery;
import lv.helloit.lottery.LotteryApp.Lottery.LotteryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    LotteryDao lotteryDao;
    @Autowired
    UserDao userDao;

    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setLotteryId(userDto.getLotteryId());
        user.setEmail(userDto.getEmail());
        user.setCode(userDto.getCode());
        userDao.save(user);
    }

    public String chooseWinner(Long id) {
        int leftBorder = 0;
        List<User> winnerBracket = userDao.findAllByLotteryId(id);
        int rightBorder = winnerBracket.size();
        int winnerPositionInList = leftBorder + (int) (Math.random() * rightBorder);
        Optional<Lottery> lottery = lotteryDao.findById(id);
        User winner = winnerBracket.get(winnerPositionInList);
        lottery.ifPresent(value -> value.setWinnerId(winner.getId()));
        return winner.getCode();


    }
}
