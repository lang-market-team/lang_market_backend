package lang_market.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Integer login(@RequestBody User user) {
        return userService.login(user);
    }
}
