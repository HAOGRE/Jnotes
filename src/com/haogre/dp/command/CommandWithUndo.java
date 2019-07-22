package com.haogre.dp.command;

//命令接口
public interface CommandWithUndo extends Command {
    void undo();
}
