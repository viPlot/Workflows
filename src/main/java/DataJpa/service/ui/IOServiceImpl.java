package DataJpa.service.ui;

import DataJpa.service.message.MessageService;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

@Component
public class IOServiceImpl implements IOService{
    private final Scanner scanner;
    private final PrintWriter writer;
    private final MessageService messageService;

    public IOServiceImpl(InputStream is, OutputStream os, MessageService messageService) {
        this.writer = new PrintWriter(os);
        this.scanner = new Scanner(is);
        this.messageService = messageService;
    }

    @Override
    public String readLine() {
        return scanner.nextLine().strip();
    }

    @Override
    public void print(Object o) {
        writer.print(o);
        writer.flush();
    }

    @Override
    public void println(Object o) {
        writer.println(o);
        writer.flush();
    }

    @Override
    public String inter(String code, Object ... params) {
        return messageService.localize(code, params);
    }

    @Override
    public void interPrintln(String code, Object ... params) {
        var msg = messageService.localize(code, params);
        println(msg);
    }

    @Override
    public void interPrint(String code, Object ... params) {
        var msg = messageService.localize(code, params);
        print(msg);
    }
}