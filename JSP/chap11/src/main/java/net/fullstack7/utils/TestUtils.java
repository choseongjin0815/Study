package net.fullstack7.utils;

import org.apache.tomcat.jakartaee.commons.lang3.StringUtils;  // StringUtils 클래스를 사용하기 위한 import

public class TestUtils {

    // 주어진 문자열이 숫자인지 확인하는 메서드
    public static boolean isNumeric(String param) {
        return StringUtils.isNumeric(param);  // StringUtils의 isNumeric 메서드를 사용
    }
    
    // 문자열을 정수로 변환하는 메서드
    public static int getStringToInt(String param) {
        if (isNumeric(param)) {
            return Integer.parseInt(param);  // 문자열을 숫자로 변환
        } else {
            throw new NumberFormatException("입력된 값이 숫자가 아닙니다: " + param);
        }
    }
}
