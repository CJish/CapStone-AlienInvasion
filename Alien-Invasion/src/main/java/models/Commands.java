package models;

import java.util.ArrayList;
import java.util.List;

public class Commands {
    private List<String> commands = new ArrayList<>();

    public Commands() {
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}