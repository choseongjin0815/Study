package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtoTypeTest {

    @Test
    void protoTypeBeanFind() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototype bean1");
        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        System.out.println("find prototype bean2");
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        System.out.println("prototype bean1: " + prototypeBean1);
        System.out.println("prototype bean2: " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        context.close();
    }


    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("prototypeBean init ");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("prototypeBean destroy");
        }
    }
}
