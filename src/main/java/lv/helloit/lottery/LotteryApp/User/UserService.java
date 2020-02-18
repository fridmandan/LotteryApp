package lv.helloit.lottery.LotteryApp.User;

import lombok.extern.slf4j.Slf4j;
import lv.helloit.lottery.LotteryApp.Lottery.Lottery;
import lv.helloit.lottery.LotteryApp.Lottery.LotteryDao;
import lv.helloit.lottery.LotteryApp.Lottery.LotteryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    LotteryDao lotteryDao;
    @Autowired
    UserDao userDao;


    public String registerUser(UserDto userDto) throws LotteryException {
        Long lotteryId = userDto.getLotteryId();
        Optional <Lottery> potentialLottery = lotteryDao.findById(lotteryId);
        if(userDto.getAge()<= 21) {
            LOGGER.info("User is not old enough" + userDto.getAge());
            throw new LotteryException("You can only from 21 years old");
        }

        if (potentialLottery.isEmpty()) {
            LOGGER.info("Lottery doesn't exist" + lotteryId);
            throw new LotteryException("Lottery doesn't exists");
        }

        Lottery lottery = potentialLottery.get();

        if (!lottery.isActive()) {
            LOGGER.info("Lottery is not active" + lottery);
            throw new LotteryException("Lottery is not active");
        }

        if (lottery.getUsers().size() >= lottery.getMaxLimit()) {
            LOGGER.info("Lottery is full" + lottery.getUsers().size());
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
                LOGGER.info("PENDING" + lottery.getId());
                return "PENDING";
            }

            Optional <User> possibleUser = userDao.findByEmailAndCode(email, code);
            if(possibleUser.isPresent()) {
                User user = possibleUser.get();
                if(user.getId().equals(lottery.getWinnerId())) {
                    LOGGER.info("WIN" + lottery.getWinnerId());
                    return "WIN";
                } else {
                    LOGGER.info("LOSE" + lottery.getWinnerId());
                    return "LOSE";
                }
            }

        }
        return "ERROR";
    }
}
