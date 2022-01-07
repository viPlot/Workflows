package BootAndShell.service.locale;

import java.util.Locale;

public interface LocaleService {
    void set(String locale);
    Locale get();
}
