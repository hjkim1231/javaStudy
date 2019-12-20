package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public void setName(String name) {
        this.name = name;
    }


}
