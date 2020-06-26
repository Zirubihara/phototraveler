package com.phototraveler.phototraveler.Service;

import com.phototraveler.phototraveler.Dto.AuthenticationResponse;
import com.phototraveler.phototraveler.Dto.LoginRequest;
import com.phototraveler.phototraveler.Dto.RegisterRequest;
import com.phototraveler.phototraveler.Exception.SpringPhotoTravellerException;
import com.phototraveler.phototraveler.Model.NotificationEmail;
import com.phototraveler.phototraveler.Model.User;
import com.phototraveler.phototraveler.Model.VerificationToken;
import com.phototraveler.phototraveler.Repository.UserRepository;
import com.phototraveler.phototraveler.Repository.VerificationTokenRepository;
import com.phototraveler.phototraveler.Security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setLogin(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);


        String token = generateVerificationToken(user);

        mailService.sendMail(new NotificationEmail("Please Activve your account", user.getEmail(),"XD"+"http://localhost:8080/api/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        fetchUserAndEnable(verificationToken.orElseThrow(() -> new SpringPhotoTravellerException("Invalid Token")));

    }


    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getLogin();
        User user = userRepository.findByLogin(username).orElseThrow(()->new SpringPhotoTravellerException("USer not found with name - "+username));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(token,loginRequest.getUsername());
    }

}
