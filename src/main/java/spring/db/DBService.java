package spring.db;

import spring.service.command.type.CommandType;

import java.sql.SQLException;

public interface DBService {
    CommandType findAll() throws SQLException;
    CommandType find(String param);
}
