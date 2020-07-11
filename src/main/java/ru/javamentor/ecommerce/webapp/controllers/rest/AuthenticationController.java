//package ru.javamentor.ecommerce.webapp.controllers.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import ru.javamentor.ecommerce.config.util.JwtUtil;
//import ru.javamentor.ecommerce.models.AuthenticationRequest;
//import ru.javamentor.ecommerce.models.AuthenticationResponse;
//import ru.javamentor.ecommerce.service.abstracts.modelService.UserService;
//
//@RestController
//public class AuthenticationController {
//
//    private final AuthenticationManager authenticationManager;
//    private final UserService userService;
//    private final JwtUtil jwtTokenUtil;
//
//    @Autowired
//    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtTokenUtil) {
//        this.authenticationManager = authenticationManager;
//        this.userService = userService;
//        this.jwtTokenUtil = jwtTokenUtil;
//    }
//
//    @PostMapping("/api/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            authenticationRequest.getUserName(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException bce) {
//            throw new Exception("Incorrect userName or password");
//        }
//
//        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUserName());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
//}
