package com.haogre.dp.command;

//命令接口
public interface Command {
    void execute(String name) throws Exception;
}
