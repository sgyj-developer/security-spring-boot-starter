package com.yeseung.sgyjsecurityspringbootstarter.jwt;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * 로그인 시 인증 객체를 Authentication 에 담아주는 클래스
 *
 * @author seunggu.lee
 * @see AuthenticationProvider#authenticate(Authentication)
 */
@Component
public interface JwtAuthenticationProvider extends AuthenticationProvider {

    @Override
    default Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken)authentication;
        return processUserAuthentication((JwtAuthentication)authenticationToken.getPrincipal(), authenticationToken.getCredentials());
    }

    Authentication processUserAuthentication(JwtAuthentication principal, CredentialInfo credential);

    @Override
    default boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(JwtAuthenticationToken.class);
    }

}