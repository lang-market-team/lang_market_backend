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
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping(path = "user/get_information/id_user={id_user}")
    @GetMapping
    public User getInformationOfUserById(@PathVariable("id_user") Integer id_user) {
        return userService.getInformationOfUserById(id_user);
    }

    @RequestMapping(path = "user/block/id_user={id_user}")
    @GetMapping
    public User blockUser(@PathVariable("id_user") Integer id_user) {
        return userService.blockUser(id_user);
    }

    @RequestMapping(path = "user/unblock/id_user={id_user}")
    @GetMapping
    public User unblockUser(@PathVariable("id_user") Integer id_user) {
        return userService.unblockUser(id_user);
    }
}
