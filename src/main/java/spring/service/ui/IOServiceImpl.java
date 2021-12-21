package spring.service.ui;

import lombok.RequiredArgsConstructor;

import javax.annotation.PreDestroy;
import java.io.PrintWriter;
import java.util.Scanner;

@RequiredArgsConstructor
public class IOServiceImpl implements IOService{
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    @Override
    public String readLine() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    @Override
    public void print(String str) {
        writer.print(str);
        writer.flush();
    }

    @Override
    public void println(String str) {
        writer.println(str);
        writer.flush();
    }
}
