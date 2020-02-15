package lv.helloit.lottery.LotteryApp.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "participants")
public class User {
    @Column
    private Long lotteryId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;//try changing int
    @Column
    private String email;
    @Column
    private String code;

}
