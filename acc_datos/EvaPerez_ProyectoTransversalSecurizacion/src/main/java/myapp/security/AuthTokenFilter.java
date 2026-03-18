package myapp.security;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myapp.services.UsuarioService;
import myapp.utiles.JwtUtil;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LogManager.getLogger(AuthTokenFilter.class);

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioService usuarioService;
    private String parseJwt(HttpServletRequest request) {
        String resultado = null;
        String headerAuth = request.getHeader("Authorization");
        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            resultado = headerAuth.substring(7); // 7 caracteres: "Bearer "
        }
        return resultado;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            System.out.println(">>> JWT extraído: " + jwt);
            System.out.println(">>> Token válido: " + (jwt != null ? jwtUtil.validateJwtToken(jwt) : "null"));
            if (jwt != null && jwtUtil.validateJwtToken(jwt)) {
                String username = jwtUtil.getUsernameFromToken(jwt);
                UserDetails userDetails = usuarioService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: " + e);
        }
        filterChain.doFilter(request, response);
    }
}