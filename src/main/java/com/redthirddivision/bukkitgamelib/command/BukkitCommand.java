/*
 * Copyright 2014 RedThirdDivision.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redthirddivision.bukkitgamelib.command;

import java.util.Collections;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * <strong>Project:</strong> R3DBukkitGameLib <br>
 * <strong>File:</strong> BukkitCommand.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class BukkitCommand extends Command {

    private CommandExecutor exe = null;
    private final List<String> aliases;

    protected BukkitCommand(String name, List<String> aliases) {
        super(name);
        this.aliases = aliases;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (exe != null) {
            exe.onCommand(sender, this, commandLabel, args);
        }
        return false;
    }

    public void setExecutor(CommandExecutor exe) {
        this.exe = exe;
    }

    @Override
    public List<String> getAliases() {
        return Collections.unmodifiableList(aliases);
    }

}