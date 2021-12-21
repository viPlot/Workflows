package spring.db;

import spring.configuration.Properties;

public class DBServiceFactory {
    private static DBService service = null;

    public static synchronized DBService getInstance(Properties prop) {
        if (service == null) {
            service = new DBServiceImpl(
                    new PGDataSource(prop.getLogin(), prop.getPassword(), prop.getUrl()), new DBRepository());

        }
        return service;
    }
}
