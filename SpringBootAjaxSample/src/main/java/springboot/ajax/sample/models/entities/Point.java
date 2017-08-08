package springboot.ajax.sample.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * ポイントエンティティ
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Point {

    /** ID */
    @Id
    @GeneratedValue
    protected Integer id;

    /** フィーチャーID */
    @ManyToOne
    @JoinColumn(name = "feature_id")
    @JsonBackReference
    protected Feature feature;

    /** 緯度 */
    @NotNull
    protected Double lat;

    /** 経度 */
    @NotNull
    protected Double lon;

}
