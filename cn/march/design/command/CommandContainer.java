package cn.march.design.command;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by antsmarch on 15-11-20.
 */
public class CommandContainer {

    private static final Logger logger = LoggerFactory.getLogger(CommandContainer.class);
    private static Map<String, Command> commandMap = Maps.newHashMap();

    public static void storeNewCommad(String name, Command command) {
        if(command == null || !org.apache.commons.lang.StringUtils.isNotBlank(name))
            return ;
       /* Object o =
                commandMap.get(name) == null ? commandMap.put(name, command) : logger.info("command already exists!");*/
    }

    public static Command getCommad(String name) {
        if (commandMap != null)
            return commandMap.get(name);
        else
            throw new NullPointerException("command not exists!");
    }

    public static boolean existCommand(String name) {
        return commandMap != null && commandMap.get(name) == null;
    }
}
