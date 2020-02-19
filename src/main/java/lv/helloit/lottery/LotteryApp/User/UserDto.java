package lv.helloit.lottery.LotteryApp.User;


import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class UserDto {
    private Byte age;
    @Email(message = "Email is not valid")
    private String email;

    private String code;
    private Long lotteryId;
}
