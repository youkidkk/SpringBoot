package springboot.sample.models.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.sample.validate.constraints.Birthday;

/**
 * ユーザーモデル
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

	/** ID */
	@Id
	@GeneratedValue
	protected Integer id;

	/** アカウントID */
	@NotBlank
	protected String accountId;

	/** パスワード */
	@NotBlank
	protected String password;

	/** 名前 */
	@NotBlank
	protected String name;

	/** 性別 */
	@NotBlank
	protected String sex;

	/** 生年月日 */
	@Birthday
	@NotNull
	@Temporal(TemporalType.DATE)
	protected Date birthday;

	/** メール */
	@Email
	protected String mail;

	/** 電話 */
	@Pattern(regexp = "(^$)|(^0\\d{1,4}-\\d{1,4}-\\d{4}$)")
	protected String tel;

	/** 作成日時 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = true, updatable = false)
	private Date created;

	/** 更新日時 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = true, updatable = true)
	private Date updated;

	/** 更新ユーザーID */
	@Column(insertable = true, updatable = true)
	private Integer updateUserId;

	/** バージョン（排他制御用） */
	@Version
	private Integer version;

	/**
	 * 追加時処理
	 */
	@PrePersist
	protected void onCreate() {
		this.created = new Date();
		this.updated = new Date();
	}

	/**
	 * 更新時処理
	 */
	@PreUpdate
	protected void onUpdate() {
		this.updated = new Date();
	}

	/**
	 * 年齢を取得
	 * @return 年齢
	 */
	public Integer getAge() {
		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.setTime(this.birthday);
		int age = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
		if (now.get(Calendar.MONTH) < birthday.get(Calendar.MONTH)) {
			age--;
		} else if (now.get(Calendar.MONTH) == birthday.get(Calendar.MONTH)) {
			if (now.get(Calendar.DAY_OF_MONTH) < birthday.get(Calendar.DAY_OF_MONTH)) {
				age--;
			}
		}

		return age;
	}
}