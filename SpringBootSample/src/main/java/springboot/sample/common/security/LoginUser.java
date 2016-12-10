package springboot.sample.common.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * ログインユーザー
 */
public class LoginUser extends User {

	/** シリアルバージョンUID */
	private static final long serialVersionUID = -7112638762300781798L;

	/** ID */
	private Integer id;

	/** ユーザー名 */
	private String username;

	/** パスワード */
	private String password;

	/** 名前 */
	private String name;

	/**
	 * コンストラクタ
	 * @param username ユーザー名（アカウントID）
	 * @param password パスワード
	 * @param authorities 権限
	 * @param id ID
	 * @param name 名前
	 */
	public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer id, String name) {
		super(username, password, authorities);
		this.username = username;
		this.password = password;
		this.id = id;
		this.name = name;
	}

	/**
	 * IDを取得
	 * @return ID
	 */
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	/**
	 * 名前を取得
	 * @return 名前
	 */
	public String getName() {
		return this.name;
	}

}
