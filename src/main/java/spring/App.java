package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.configuration.SpringConfig;
import spring.service.ui.UserService;

public class App {
    public static void main(String[] args) {
        var startApp = new AnnotationConfigApplicationContext(App.class)
                .getBean("userService", UserService.class);
    }
}
