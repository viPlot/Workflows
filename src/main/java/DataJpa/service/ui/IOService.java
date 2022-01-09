package DataJpa.service.ui;

public interface IOService {
    String readLine();
    void print(Object o);
    void println(Object o);
    String inter(String code, Object ... params);
    void interPrintln(String code, Object ... params);
    void interPrint(String code, Object ... params);
}
