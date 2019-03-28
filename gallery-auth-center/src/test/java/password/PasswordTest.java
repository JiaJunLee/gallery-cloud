package password;

import com.oocl.ita.gallery.auth.center.SecurityConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

    @Test
    public void test89() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
        // 加密
        String encodedPassword = passwordEncoder.encode("admin");
        System.out.println(encodedPassword);

        SecurityConfig  securityConfig = new SecurityConfig();

    }
}
