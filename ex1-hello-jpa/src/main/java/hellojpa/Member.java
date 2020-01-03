package hellojpa;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
 //       pkColumnValue = "MEMBER_SEQ",  allocationSize = 50)
//@SequenceGenerator(name ="member_seq_generator", sequenceName = "member_seq")
public class Member {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
   // @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    @GeneratedValue
    @Column(name ="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

   // @Column(name = "TEAM_ID")
   // private Long teamId;

    @OneToOne
    @JoinColumn(name ="LOCKER_ID")
    private Locker locker;

    @OneToMany
    @JoinTable(name ="MEMBER_PRODUCT")
    private List<MemberProduct> memberProducts = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name ="TEAM_ID", insertable = false,  updatable = false)
    private Team team;
   // @Column (unique = true, length = 10)
   // @Column(name = "name" ,nullable = false)
   // private String name;
   // private int age;
   /*
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate createDate2;
    private LocalDateTime lastModifiedDate2;

    @Lob
    private String description;
    */


    public Member() {}

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
