package spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.db.DBService;
import spring.db.DBServiceFactory;
import spring.service.command.Command;
import spring.service.command.FindAll;
import spring.service.command.FindById;
import spring.service.command.Parser;
import spring.service.locale.LocaleServiceImpl;
import spring.service.log.LoggingAspect;
import spring.service.ui.IOServiceImpl;
import spring.service.ui.UserService;
import java.util.HashSet;


@Configuration
public class SpringConfig {
    @Bean
    public DBService dbService {
        return DBServiceFactory.getInstance(proper());
    }

    @Bean
    public Parser parser() {
        var list = new HashSet<Command>();
        list.add(new FindById(dbService));
        list.add(new FindAll(dbService));
        return new Parser(list);
    }

    @Bean
    public LocaleServiceImpl localeService() {
        return new LocaleServiceImpl();
    }

    @Bean
    public LoggingAspect logging() {
        return new LoggingAspect();
    }

    @Bean
    public IOServiceImpl ioService() {
        return new IOServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserService(localeService(), ioService(), parser());
    }

    public Properties proper() {
        var properties = new Properties();
        properties.setLogin("admin");
        properties.setPassword("123");
        properties.setUrl("jdbc:postgresql:Aeroclub");
        return properties;
    }
}
