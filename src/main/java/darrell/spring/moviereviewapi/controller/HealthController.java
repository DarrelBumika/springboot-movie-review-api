package darrell.spring.moviereviewapi.controller;

import darrell.spring.moviereviewapi.dto.HealthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<HealthResponse> healthCheck() {
        return ResponseEntity.ok(new HealthResponse(
                "OK"
        ));
    }

}
