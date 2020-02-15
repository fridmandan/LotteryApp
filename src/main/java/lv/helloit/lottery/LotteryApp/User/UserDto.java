package lv.helloit.lottery.LotteryApp.User;


import lombok.Data;

@Data
public class UserDto {
    private Byte age;
    private String email;
    private String code;
    private Long lotteryId;

}
