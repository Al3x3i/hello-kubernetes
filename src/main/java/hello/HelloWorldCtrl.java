package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldCtrl {

    @GetMapping
    public String index() {
        return "Greeting from `Hello Kubernetes`";
    }
}
