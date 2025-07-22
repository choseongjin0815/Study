package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("hello-basic");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mapping-path {}", data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mapping-path {}", userId);
        log.info("mapping-path {}", orderId);
        return "ok";
    }

    @GetMapping(value="mapping-header", headers="mode=debug")
    public String mappingHeader() {
        log.info("mapping-header");
        return "ok";
    }

    @PostMapping(value="mapping-consume", consumes = "application/json")
    public String mappingConsume() {
        log.info("mapping-consume");
        return "ok";
    }

}

