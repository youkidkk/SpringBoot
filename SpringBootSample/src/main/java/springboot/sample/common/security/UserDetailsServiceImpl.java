package springboot.sample.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.sample.models.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * ユーザーディテールサービス実装クラス
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /** パスワードエンコーダー */
    @Autowired
    PasswordEncoder passwordEncoder;

    /** ユーザーリポジトリー */
    @Autowired
    UserRepository repository;

    /**
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new LoginUser(username, this.passwordEncoder.encode("admin"), authorities, 0,
                    "管理者");
        } else {
            try {
                List<springboot.sample.models.entities.User> userList = this.repository
                        .findByAccountId(username);
                springboot.sample.models.entities.User user = userList.get(0);
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                return new LoginUser(username, user.getPassword(), authorities, user.getId(),
                        user.getName());
            } catch (Exception e) {
                throw new UsernameNotFoundException(username);
            }
        }
    }

}