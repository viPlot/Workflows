package BootAndShell.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.io.OutputStream;

@Configuration
public class IOConfiguration {
    @Bean
    InputStream inputStream() {
        return System.in;
    }

    @Bean
    OutputStream outputStream() {
        return System.out;
    }
}
