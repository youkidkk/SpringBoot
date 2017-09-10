package springboot.datajpa.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuppressWarnings("javadoc")
public class Novel {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    private Novelist novelist;

    public Novel(String name, Novelist novelist) {
        this.name = name;
        this.novelist = novelist;
    }

}
