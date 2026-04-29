package com.yo.day1.controllers;

import com.yo.day1.common.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {
    @GetMapping("/api/health")
    public ApiResponse<String> health(){
        return ApiResponse.success("success");
    }
    @PostMapping("/api/health/echo")
    public ApiResponse<String> echo(@Valid @RequestBody EchoRequest request){
        return ApiResponse.success(request.message());
    }
    public record EchoRequest(@NotBlank(message = "message must not be blank")
                              String message){

    }
}
