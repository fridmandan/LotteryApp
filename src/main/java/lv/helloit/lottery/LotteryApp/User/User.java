package lv.helloit.lottery.LotteryApp.User;


import lombok.*;
import lv.helloit.lottery.LotteryApp.Lottery.Lottery;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "participants")
public class User {
    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinColumn(name = "lottery_id", nullable = false)
    private Lottery lottery;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;//try changing int
    @Column
    private String email;
    @Column
    private String code;
    @Column
    private Byte age;
}
