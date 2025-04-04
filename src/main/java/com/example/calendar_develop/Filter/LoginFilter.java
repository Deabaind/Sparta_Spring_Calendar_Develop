package com.example.calendar_develop.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    // 로그인이 아니라도 통과할 수 있는 URL
    private static final String[] WHITE_LIST = {
            "/",
            "/users/sign",
            "/users/login",
            "/users/logout"
    };

    // 인터페이스로 인해 자동으로 오버라이드 된 메서드
    // 서버에 들어오는 모든 요청을 중간에서 가로체는 메서드
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        // 다양한 기능을 사용하기 위해 자식 클래스로 다운 캐스팅
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // HttpServletRequest 타입의 메서드 호출
        // URI(URL 경로)를 가져오는 메서드
        String requestURI = request.getRequestURI();

        // "요청을 가로챈 시점부터 로그인 체크를 시작한다" 로그를 남기는 코드
        log.info("로그인 필터 로직 실행");

        // 로그인이 필요한 URL 이 맞는지 검사
        if(!iswhiteList(requestURI)) {

            // 로그인 되었다면 session 이 저장되었을 것을 전제로 진행
            // 변수 session 의 값은 세션이 존재한다면 세션 데이터를 저장, 세션이 없다면 null 을 저장
            HttpSession session = request.getSession(false);

            // 로그인 하지 않은 사용자를 찾는 코드
            if (session == null || session.getAttribute("loginUser") == null) {
                throw new RuntimeException("로그인 해주세요.");
            }
        }

        // 필터에서 URL 검사를 마쳤기 때문에 request 와 response 를 클라이언트에 넘겨준다.
        filterChain.doFilter(request, response);
    }

    // 로그인이 필요한 URL이 맞는지 여부를 확인하는 메서드
    private boolean iswhiteList(String requestURI) {
        // 문자열 WHITE_LIST 와 문자열 requestURI(URL)을 비교해주는 코드
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
