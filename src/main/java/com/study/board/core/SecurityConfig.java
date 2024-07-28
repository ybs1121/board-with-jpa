package com.study.board.core;

import com.study.board.core.jwt.JwtRequestFilter;
import com.study.board.core.jwt.JwtUtil;
import com.study.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtUtil jwtUtil;
    private final MemberService memberService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
                .authorizeRequests(authorize -> authorize
//                        .requestMatchers("/v1/api/member/**","/v1/mav/member/**").permitAll() // 인증 없이 접근 가능
                        .requestMatchers("**").permitAll() // SSR에서 JWT 쓰기가 쉽지 않다.. 해결방안이 있을까
                        .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless 세션 관리
                );

        // JWT 필터 추가
        http.addFilterBefore(new JwtRequestFilter(jwtUtil,memberService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}