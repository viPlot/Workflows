package spring.service.command;

import lombok.RequiredArgsConstructor;
import spring.db.DBService;
import spring.service.command.type.CommandType;

import java.sql.SQLException;

@RequiredArgsConstructor
public abstract class Command {
    private final DBService db;

    public abstract boolean checkCommand(String str);

    public abstract CommandType doCommand() throws SQLException;

    protected DBService getDBService() {
        return db;
    }
}
