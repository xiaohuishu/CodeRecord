package cn.march.design.command;

/**
 * Created by antsmarch on 15-11-20.
 */
public class Client {
    public static void main(String[] args) {
        CommandFactory._COMMANDINSTANCE.processCommand("transType");
    }
}
