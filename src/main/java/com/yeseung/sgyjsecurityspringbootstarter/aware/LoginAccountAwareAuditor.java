package com.yeseung.sgyjsecurityspringbootstarter.aware;

import com.yeseung.sgyjsecurityspringbootstarter.jwt.JwtAuthentication;
import com.yeseung.sgyjsecurityspringbootstarter.jwt.JwtAuthenticationToken;
import com.yeseung.sgyjspringbootstarter.aware.LoginAuditorAware;
import jakarta.annotation.Nonnull;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginAccountAwareAuditor implements LoginAuditorAware<String> {

    @Nonnull
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        if (authentication instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }
        JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken)authentication;
        JwtAuthentication jwtAuthentication = (JwtAuthentication)authenticationToken.getPrincipal();
        return Optional.of(jwtAuthentication.accountId());
    }

}
