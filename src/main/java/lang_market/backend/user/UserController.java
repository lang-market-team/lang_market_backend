package lang_market.backend.user;

import lang_market.backend.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("signup")
    @PostMapping
    public Integer signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @RequestMapping("login")
    @PostMapping
    public User login(@RequestBody User user) {
        return userService.login(user);
    }
}
