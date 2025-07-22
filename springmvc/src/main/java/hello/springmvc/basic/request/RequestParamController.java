package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username= request.getParameter("username");
        int age = Integer.valueOf(request.getParameter("age"));
        log.info("username={}", username);
        log.info("age={}", age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("memberName={}", memberName);
        log.info("memberAge={}", memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("memberName={}", username);
        log.info("memberAge={}", age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String username,
            int age) {
        log.info("memberName={}", username);
        log.info("memberAge={}", age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        log.info("memberName={}", username);
        log.info("memberAge={}", age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-default") //빈문자도 처리해줌
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age) {
        log.info("memberName={}", username);
        log.info("memberAge={}", age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map") //빈문자도 처리해줌
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap) {
        log.info("memberName={}", paramMap.get("username"));
        log.info("memberAge={}", paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        log.info("helloData={}", helloData);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {

        log.info("helloData={}", helloData);
        return "ok";
    }

}
