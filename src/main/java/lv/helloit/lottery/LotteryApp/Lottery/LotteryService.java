package lv.helloit.lottery.LotteryApp.Lottery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.helloit.lottery.LotteryApp.User.User;
import lv.helloit.lottery.LotteryApp.User.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class LotteryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LotteryService.class);
    @Autowired
    LotteryDao lotteryDao;
    @Autowired
    UserDao userDao;
    public Lottery startLottery(StartLotteryDto startLotteryDto) throws LotteryException {
        if (lotteryDao.findByTitle(startLotteryDto.getTitle()).isPresent()) {
            LOGGER.info("Lottery with title" + startLotteryDto.getTitle() + "already exist");
            throw new LotteryException("Lottery already exists");
        }

        Lottery lottery = new Lottery();
        lottery.setMaxLimit(startLotteryDto.getLimit());
        lottery.setTitle(startLotteryDto.getTitle());
        lottery.setStartDate(LocalDateTime.now());

        lottery.setActive(true);
        lotteryDao.save(lottery);
        return lottery;
    }

    public String stopLottery(Long id) throws LotteryException {
        Optional<Lottery> lottery = lotteryDao.findById(id);
        if (lottery.isPresent()) {
            Lottery myLottery = lottery.get();
            myLottery.setActive(false);
            lotteryDao.save(myLottery);
            return "OK";
        } else {
            LOGGER.info("Lottery with id" + lotteryDao.findById(id) + "doesn't exist");
            throw new LotteryException("Lottery doesn't exist");
        }
    }

    public User chooseWinner(Long id) throws LotteryException {
        Optional <Lottery> potentialLottery = lotteryDao.findById(id);

        if (potentialLottery.isEmpty()) {
            LOGGER.info("Lottery with id" + lotteryDao.findById(id) + "doesn't exist");
            throw new LotteryException("Lottery doesn't exists");
        }

        Lottery lottery = potentialLottery.get();

        if (lottery.getWinnerId() != null) {
            LOGGER.info("Winner with id" + lottery.getWinnerId() + "has already been chosen");
            throw new LotteryException("Winner already has been chosen");
        }

        List<User> users = userDao.findAllByLotteryId(id);

        if (users.isEmpty()) {
            LOGGER.info("No users in lottery with id" + lotteryDao.findById(id));
            throw new LotteryException("No users in lottery");
        }

        Random rand = new Random();
        User randomUser = users.get(rand.nextInt(users.size()));

        lottery.setWinnerId(randomUser.getId());
        lottery.setEndDate(LocalDateTime.now());
        lotteryDao.save(lottery);
        return randomUser;
    }

    public List<Lottery> getLotteries() {
        return lotteryDao.findAll();
    }
}

