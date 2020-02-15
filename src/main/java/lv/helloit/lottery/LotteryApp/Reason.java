package lv.helloit.lottery.LotteryApp;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reason {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reason;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String winnerCode;
}