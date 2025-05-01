package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class Singletontest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean = context.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        System.out.println("singletonBean : " + singletonBean);
        System.out.println("singletonBean2 : " + singletonBean2);
        assertThat(singletonBean).isSameAs(singletonBean2);

        context.close();
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("singletonBean init ");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("singletonBean destroy");
        }
    }
}
