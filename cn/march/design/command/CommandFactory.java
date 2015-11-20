package cn.march.design.command;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by antsmarch on 15-11-20.
 */
public enum CommandFactory {

    _COMMANDINSTANCE(){
        private final Logger logger = LoggerFactory.getLogger(CommandFactory.class);

        @Override public void processCommand(String name) {
            if(StringUtils.isNotBlank(name)) {
                if(CommandContainer.existCommand(name)) {
                    Command command = CommandContainer.getCommad(name);
                    if(command != null)
                        command.execute();
                } else {
                    CommandContainer.storeNewCommad(name, lookupCommand(name));
                }
            } else {
                logger.info(name + " can't be null or ''");
            }
        }

        private Command lookupCommand(String name) {
            //可以通过指定command实现类所在包名，通过反射实例化对应name的Command
            //具体细节忽略
            return null;
        }

    };
    //定义一个实例抽象方法
    public abstract void processCommand(String name);
}
