package com.ticker.service;

import org.springframework.security.core.AuthenticationException;

import com.ticker.DTo.AuthRequest;
import com.ticker.DTo.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest) throws AuthenticationException;
}
