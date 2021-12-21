package spring.service.command.type;

import java.util.TreeMap;

public interface CommandType {
    TreeMap findAll();
    String findById(long id);

}
