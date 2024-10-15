package net.fullstack7.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommonUtils {
	public void setCookieInfo(HttpServletResponse response, HttpServletRequest request, String name, String value, int maxAge) {
        // 쿠키 객체 생성
        Cookie cookie = new Cookie(name, value);
        
        // 쿠키의 유효 시간 설정 (초 단위)
        cookie.setMaxAge(maxAge);
        
        // 쿠키의 경로 설정 (루트로 설정하여 모든 경로에서 쿠키 접근 가능하게 함)
        cookie.setPath(request.getContextPath());

        // 응답 객체에 쿠키 추가
        response.addCookie(cookie);
    }
}
