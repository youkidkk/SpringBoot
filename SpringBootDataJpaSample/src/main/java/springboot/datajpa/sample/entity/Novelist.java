package springboot.datajpa.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuppressWarnings("javadoc")
public class Novelist {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            // select時に関連テーブルをまとめて取得する
            fetch = FetchType.EAGER,
            // Novel型の項目との関連付け
            mappedBy = "novelist")
    private List<Novel> novels;

    public Novelist(String name) {
        this.name = name;
    }

}
