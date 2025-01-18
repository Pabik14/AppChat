package com.appchat.authclient.client;

import com.appchat.authclient.domain.UserAuthentication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("auth-service")
public interface AuthClient {
    @GetMapping(value = "/sessions/authentication", consumes = "application/json", produces = "application/json")
    UserAuthentication getUserAuthentication(@RequestHeader("User-Authorization") String userAuthorizationHeader);
}
