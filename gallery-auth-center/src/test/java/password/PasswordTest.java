package password;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

    @Test
    public void test89() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
        // 加密
        String encodedPassword = passwordEncoder.encode("admin");
        System.out.println(encodedPassword);
    }
}
