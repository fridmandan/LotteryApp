package lv.helloit.lottery.LotteryApp.User;

import lv.helloit.lottery.LotteryApp.Lottery.Lottery;
import lv.helloit.lottery.LotteryApp.Lottery.LotteryDao;
import lv.helloit.lottery.LotteryApp.Lottery.LotteryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    LotteryDao lotteryDao;
    @Autowired
    UserDao userDao;

    public String registerUser(UserDto userDto) throws LotteryException {
        Long lotteryId = userDto.getLotteryId();
        Optional <Lottery> potentialLottery = lotteryDao.findById(lotteryId);

        if (potentialLottery.isEmpty()) {
            throw new LotteryException("Lottery doesn't exists");
        }

        Lottery lottery = potentialLottery.get();

        if (!lottery.isActive()) {
            throw new LotteryException("Lottery is not active");
        }

        if (lottery.getUsers().size() >= lottery.getMaxLimit()) {
            throw new LotteryException("Lottery is full");
        }

        User user = new User();

        user.setLottery(lottery);
        user.setEmail(userDto.getEmail());
        user.setCode(userDto.getCode());
        user.setAge(userDto.getAge());
        userDao.save(user);

        return "saved user";
    }

    public String getWinnerStatus(Long id, String email, String code) {
        Optional<Lottery> possibleLottery = lotteryDao.findById(id);
        if (possibleLottery.isPresent()){
            Lottery lottery = possibleLottery.get();

            if(lottery.getWinnerId() == null) {
                return "PENDING";
            }

            Optional <User> possibleUser = userDao.findByEmailAndCode(email, code);
            if(possibleUser.isPresent()) {
                User user = possibleUser.get();
                if(user.getId().equals(lottery.getWinnerId())) {
                    return "WIN";
                } else {
                    return "LOSE";
                }
            }

        }
        return "ERROR";
    }
}
