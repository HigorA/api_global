package br.com.fiap.globalapi.service;

import br.com.fiap.globalapi.entities.Permission;
import br.com.fiap.globalapi.entities.User;
import br.com.fiap.globalapi.entities.vo.security.AccountCredentialsVO;
import br.com.fiap.globalapi.entities.vo.security.TokenVO;
import br.com.fiap.globalapi.entities.vo.security.UserRegisterVO;
import br.com.fiap.globalapi.repository.PermissionRepository;
import br.com.fiap.globalapi.repository.UserRepository;
import br.com.fiap.globalapi.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AuthServices {

    private final Logger logger = Logger.getLogger(AuthServices.class.getName());

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;


    public ResponseEntity<TokenVO> signIn(AccountCredentialsVO data) {
        String username = data.login();
        String password = data.password();
        logger.info("Sign IN " + password);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        logger.info("Chegou aqui 3" + authenticationManager);
        Optional<User> user = userRepository.findByLogin(username);
        TokenVO tokenResponse;
        if (user.isPresent()) {
            tokenResponse = tokenProvider.createAcessToken(username, user.get().getRoles(), user.get().getId());
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
        return ResponseEntity.ok(tokenResponse);
    }

    public User signUp(UserRegisterVO data) {
        if (userRepository.findByLogin(data.login()).isPresent()) {
            System.out.println("Error");
            logger.info("email " + data.login() + " already exists!");
        }
        User user = convertVoToEntity(data);
        logger.info("Sign Up method" + data.password());
        return userRepository.save(user);
    }

    public void deleteUser(AccountCredentialsVO data) {
        User user = userRepository.findByLogin(data.login()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        user.deleteUser();
        userRepository.save(user);
    }

    public String passwordEncoder(String password) {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
		Pbkdf2PasswordEncoder pbkdf2Encoder = new Pbkdf2PasswordEncoder("", 8, 18500, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
		encoders.put("pbkdf2", pbkdf2Encoder);
		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
		passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
        logger.info("password encoder method " + password);
		String encoded = passwordEncoder.encode(password);
        logger.info("after encoded: " + encoded);
        return encoded;
    }

    private User convertVoToEntity(UserRegisterVO vo) {
        User user = new User();
        user.setLogin(vo.login());
        logger.info("Convert method before: " + vo.password());
        user.setPassword(passwordEncoder(vo.password()).substring("{pbkdf2}".length()));
        logger.info("Convert method after: " + user.getPassword());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        List<Permission> permissions = permissionRepository.findById(1L).stream().toList();
        user.setPermissions(permissions);
        return user;
    }
}
