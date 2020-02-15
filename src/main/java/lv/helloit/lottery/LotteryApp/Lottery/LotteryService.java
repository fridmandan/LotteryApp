package lv.helloit.lottery.LotteryApp.Lottery;

import lombok.RequiredArgsConstructor;
import lv.helloit.lottery.LotteryApp.User.User;
import lv.helloit.lottery.LotteryApp.User.UserDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LotteryService {
    LotteryDao lotteryDao;
    UserDao userDao;
    public String startLottery(LotteryDto lotteryDto) {
        Lottery lottery = new Lottery();
        lottery.setLimit(1000L); //lotteryDto.getLimit()
        lottery.setTitle("Christmas Lottery 1");//lotteryDto.getTitle()
        lottery.setStartDate(LocalDateTime.now());
        lottery.setActive(true);
        lotteryDao.save(lottery);
        return "yahoooo";
    }

    public String stopLottery(Long id) {
        Optional<Lottery> lottery = lotteryDao.findById(id);
        lottery.ifPresent(value -> value.setActive(false));
        return "Sorry Lottery doesn't exist";

    }

    public String getWinnerStatus(lotteryWinnerStatusDTO lotteryWinnerStatusDTO) {
        Optional<Lottery> possibleLottery = lotteryDao.findById(lotteryWinnerStatusDTO.getId());
        if (possibleLottery.isPresent()){
            Lottery lottery = possibleLottery.get();
            Optional<User> possibleUser = userDao.findById(lotteryWinnerStatusDTO.getId());
            if(lottery.getWinnerId() == null) {
                return "Pending";
            }
            if(possibleUser.isPresent()) {
                User user = possibleUser.get();
                if(user.getCode().equals(lotteryWinnerStatusDTO.getCode())) {
                    return "Great job you are a millionaire now!";
                } else {
                    return "Too bad you are a loser";
                }
            }

        }
        return "Sorry im a bad programmer";
    }
}

