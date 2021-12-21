package spring.service.command;

import spring.db.DBService;
import spring.service.command.type.CommandType;

import java.sql.SQLException;

public class FindAll extends Command {
    public FindAll(DBService db) {
        super(db);
    }

    @Override
    public boolean checkCommand(String str) {
        return str.toLowerCase().contains("find-all");
    }

    @Override
    public CommandType doCommand() throws SQLException {
        return super.getDBService().findAll();
    }
}
