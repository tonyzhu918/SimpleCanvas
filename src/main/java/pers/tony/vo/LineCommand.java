package pers.tony.vo;

import java.util.ArrayList;
import java.util.List;

public class LineCommand {
    final String command;
    final List<Integer> params = new ArrayList<>();

    public LineCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void addParam(int value) {
        params.add(value);
    }

    public int getParam(int index) {
        try {
            return params.get(index);
        } catch (Exception e) {
            throw new IllegalArgumentException("index illegal: " + index);
        }
    }
}
