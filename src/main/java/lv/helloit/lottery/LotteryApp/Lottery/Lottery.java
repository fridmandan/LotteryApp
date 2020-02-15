package lv.helloit.lottery.LotteryApp.Lottery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.helloit.lottery.LotteryApp.User.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "lotteries")
public class Lottery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private Integer maxLimit;
    @Column
    private LocalDateTime startDate;
    @Column
    private LocalDateTime endDate;
    @Column
    private boolean active;
    @Column
    private Long winnerId;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "lottery")
    private Set<User> users = new HashSet<>();
}
