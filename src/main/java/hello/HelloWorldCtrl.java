package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldCtrl {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public String index() {
        return "Greeting from `Hello Kubernetes`";
    }

    @GetMapping("/requests")
    public Long getRequestsCount() {
        return counter.incrementAndGet();
    }
}
