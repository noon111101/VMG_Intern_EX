package com.vmg.tr.service;

import com.vmg.tr.payload.request.LoginRequest;
import com.vmg.tr.payload.request.SignupRequest;
import com.vmg.tr.payload.response.JwtResponse;
import com.vmg.tr.payload.response.MessageResponse;

public interface IUserService {
    JwtResponse authenticateUser(LoginRequest loginRequest);
    MessageResponse registerUser(SignupRequest signUpRequest);
}
