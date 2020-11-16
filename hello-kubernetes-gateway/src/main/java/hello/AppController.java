package hello;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final BackendAdapter backendAdapter;

    @Value("${gateway.instance.id}")
    private int instanceId;

    @Value("${gateway.secret}")
    private String secret;

    @GetMapping("/")
    public String getRequestsCount() {
        return String.format("Number of requests %s (gateway %d, secret %s)", backendAdapter.getRequests(), instanceId, secret);
    }
}