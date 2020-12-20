package lang_market.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//test
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Just2Test {
    @GetMapping
    Integer login(){
        return 1;
    }
}
