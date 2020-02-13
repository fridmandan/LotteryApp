package lv.helloit.lottery.LotteryApp.User;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
public class User {
    @Column
    private Long lotteryId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String email;
    @Column
    private String code;
}
