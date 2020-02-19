package lv.helloit.lottery.LotteryApp.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationDto {
    String code;
    Long lotteryId;
    String email;
}
