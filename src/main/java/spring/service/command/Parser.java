package spring.service.command;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;

@RequiredArgsConstructor
public class Parser {
    private final HashSet<Command> commandSet;

    public Command parseCommand(String cmd) {
        return commandSet.stream()
                .filter(command -> command.checkCommand(cmd))
                .findFirst()
                .get();
    }
}
