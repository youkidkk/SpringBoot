package springboot.ajax.sample.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

/**
 * フィーチャーエンティティ
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Feature {

    /** ID */
    @Id
    @GeneratedValue
    protected Integer id;

    /** ステータス */
    @NotBlank
    protected String status;

    /** ポイントリスト */
    @OneToMany
    @JoinColumn(name = "feature_id")
    @JsonManagedReference
    protected List<Point> points;

}
