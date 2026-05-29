package gr.devready;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletRequest;

@RestController

public class Controller {

    @GetMapping("/calls")
    public List<models.Call> getCalls(){
        return DevreadyApplication.service.getAllCalls();
    }

    @GetMapping("/error")
    public ResponseEntity<?> getError(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "error", "endpoint not found",
                            "code", 404
                    ));
    }

    @GetMapping("/calls/{id}")
    public ResponseEntity<?> getCall(@PathVariable String id){
        
        models.Call call=DevreadyApplication.service.getCallById(id);
        if (call==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "error", "call not found",
                            "code", 404
                    ));
        }

        return ResponseEntity.ok(call);
        
    }

    @GetMapping("/calls/{id}/archive")
    public ResponseEntity<?> archiveCall(@PathVariable String id){
        
        models.Call call=DevreadyApplication.service.archiveCall(id);
        if (call==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "error", "call not found",
                            "code", 404
                    ));
        }

        return ResponseEntity.ok(call);
        
    }
    
}
