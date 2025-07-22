package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController // controller는 뷰 restcontroller는 문자열이 반환되어버림
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name: " + name);
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        log.info("name: " + name);

        return "ok";
    }
}
