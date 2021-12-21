package spring.service.command;

import spring.db.DBService;
import spring.service.command.type.CommandType;

import java.sql.SQLException;

public class FindById extends Command {
    public FindById(DBService db) {
        super(db);
    }

    @Override
    public boolean checkCommand(String str) {
        return str.equalsIgnoreCase("find");
    }

    @Override
    public CommandType doCommand() throws SQLException {
        return super.getDBService().findAll();
    }
}
