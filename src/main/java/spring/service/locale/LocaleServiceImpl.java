package spring.service.locale;

import spring.service.locale.exception.LocaleNotSupportedException;

import java.util.Locale;
import java.util.Map;

public class LocaleServiceImpl implements LocaleService {
    final static Map<String, Locale> SUPPORTED = Map.of(
            "en", Locale.forLanguageTag("en"),
            "ru", Locale.forLanguageTag("ru")
    );

    private Locale current = SUPPORTED.get("en");

    @Override
    public void set(String locale) {
        var loc = SUPPORTED.get(locale);
        if (loc == null)
            throw new LocaleNotSupportedException("locale-not-supported", locale);
        current = loc;
    }

    @Override
    public Locale get() {
        return current;
    }
}
