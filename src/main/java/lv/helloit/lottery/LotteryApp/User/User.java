package lv.helloit.lottery.LotteryApp.User;


import lombok.Data;

@Data
public class User {
    private Long LotteryId;
    private Long id;
    private String email;
    private String code;
}
