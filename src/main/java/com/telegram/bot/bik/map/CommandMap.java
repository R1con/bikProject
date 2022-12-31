package com.telegram.bot.bik.map;

import com.telegram.bot.bik.api.telegram.commands.HandleCommand;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandMap {
    private static final Map<String, HandleCommand> COMMAND_MAP = new HashMap<>();

    public CommandMap(List<HandleCommand> commands) {
        commands.forEach(c -> c.getSupportedCommand()
                .forEach(c1 -> COMMAND_MAP.put(c1.name(), c)));
    }

    public HandleCommand getCommand(String keyCommand) {
        return COMMAND_MAP.get(keyCommand);
    }
}
