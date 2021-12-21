package spring.service.ui;

import lombok.RequiredArgsConstructor;
import spring.service.command.Parser;
import spring.service.locale.LocaleService;
import spring.service.log.Logging;

import java.sql.SQLException;

@RequiredArgsConstructor
public class UserService {
    private final LocaleService locale;
    private final IOService ioService;
    private final Parser parser;

    @Logging
    public void start() throws SQLException {
        setLocale();
        while (true) {
            var com = parser.parseCommand(ioService.readLine());
            var type = com.doCommand();
            ioService.println(type.toString());
        }
    }

    private void setLocale() {
    ioService.println("Select locale: en/ru");
    var lang = ioService.readLine();
    locale.set(lang);
    }
}
