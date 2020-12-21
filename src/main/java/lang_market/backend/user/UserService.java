package lang_market.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final  UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Integer getMaxID() {
        return userRepository.getMaxID();
    }

    Integer signup(User user) {
        return userRepository.signup(
                getMaxID(),
                user.getUsername(),
                user.getPass(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getStreet(),
                user.getTown(),
                user.getDistrict(),
                user.getProvince(),
                user.getPhonenumber(),
                user.getEmail()
        );
    }

    Integer login(User user) {
        return userRepository.login(user.getUsername(), user.getPass());
    }
}
