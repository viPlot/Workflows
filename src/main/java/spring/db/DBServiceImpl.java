package spring.db;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import spring.service.command.type.CommandType;

import javax.sql.DataSource;
import java.sql.SQLException;

@RequiredArgsConstructor
public class DBServiceImpl implements DBService{
    private final DataSource src;
    private final DBRepository dbRep;

    @SneakyThrows
    @Override
    public CommandType findAll() throws SQLException {
        var conn = src.getConnection();
        return dbRep.findAll(conn);
    }

    @SneakyThrows
    @Override
    public CommandType find(String param) {
        var conn = src.getConnection();
        return dbRep.find(conn, param);
    }
}
