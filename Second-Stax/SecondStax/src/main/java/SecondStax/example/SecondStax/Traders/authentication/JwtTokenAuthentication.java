package SecondStax.example.SecondStax.traders.authentication;

import SecondStax.example.SecondStax.traders.service.TraderCustomServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtTokenAuthentication extends OncePerRequestFilter {
    @Autowired private JwtUtil jwtUtil;
    @Autowired private TraderCustomServise traderCustomServise;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestHeader = request.getHeader("Authorization");
        String token=null;
        String email=null;

        if(requestHeader != null && requestHeader.startsWith("Bearer")){
            token = requestHeader.substring(7);
            email = jwtUtil.extractUsername(token);
        }

        if(email!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = traderCustomServise.loadUserByUsername(email);

            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
