package myapp.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import myapp.models.Usuario;
import myapp.services.UsuarioService;
import myapp.utiles.JwtUtil;

@RestController
@RequestMapping("/myapp/auth")
public class AuthController {

    private static final Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtil;

    /**
     * POST /myapp/auth/login
     * Autentica al usuario y devuelve el JWT si las credenciales son correctas.
     * Si son incorrectas, Spring Security devuelve 401 automáticamente.
     */
    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        usuario.getUsuario(), usuario.getClave());

        Authentication authentication = authenticationManager.authenticate(token);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return jwtUtil.generateToken(userDetails.getUsername());
    }

    /**
     * POST /myapp/auth/nuevousuario
     * Registra un nuevo usuario cifrando la clave con BCrypt.
     * Si el usuario ya existe devuelve un mensaje de error.
     */
    @PostMapping("/nuevousuario")
    public String registerUser(@RequestBody Usuario user) {
        if (usuarioService.existsByUsuario(user.getUsuario())) {
            return "Error: El nombre de usuario ya está en uso.";
        }
        Usuario newUser = new Usuario(null, user.getUsuario(), encoder.encode(user.getClave()));
        usuarioService.saveUsuario(newUser);
        return "Usuario registrado correctamente.";
    }
}