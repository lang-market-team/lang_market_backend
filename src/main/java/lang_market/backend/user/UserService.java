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

    public Integer howManyUser() {
        return userRepository.howManyUser();
    }

    public Integer signup(User user) {
        return userRepository.signup(
                user.getUsername(),
                user.getPass(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getStreet(),
                user.getTown(),
                user.getDistrict(),
                user.getProvince(),
                user.getPhonenumber(),
                user.getEmail(),
                user.getType_account(),
                user.getShop_name(),
                user.getShop_describe()
        );
    }

    public User login(User user) {
        return userRepository.login(user.getUsername(), user.getPass());
    }

    public User getInformationOfUserById(Integer id_user) {
        return userRepository.getInformationOfUserById(id_user);
    }

    public User blockUser(Integer id_user) {
        return userRepository.blockUser(id_user);
    }

    public User unblockUser(Integer id_user) {
        return userRepository.unblockUser(id_user);
    }
}
