package JPAHibernate.service.message;

import JPAHibernate.service.locale.LocaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{
    private final MessageSource messageSource;
    private final LocaleService currentLocaleService;

    @Override
    public String localize(String code, Object... params) {
        return messageSource.getMessage(code, params, currentLocaleService.get());
    }
}
