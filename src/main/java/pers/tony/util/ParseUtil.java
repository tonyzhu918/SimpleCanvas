package pers.tony.util;

import pers.tony.Constants;
import pers.tony.vo.LineCommand;

public class ParseUtil implements Constants {
    public static final String ILLEGAL_COMMAND = "illegal command";

    public static LineCommand parseLineCommand(String lineCommand) {
        if (lineCommand == null || lineCommand.trim().isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_COMMAND);
        }

        String[] commandAndParams = lineCommand.split(" ");
        String command = commandAndParams[0].toLowerCase();
        switch (command) {
            case CREATE_CANVAS_FLAG:
                return createCLineCommand(commandAndParams);
            case LINE_FLAG:
                return createLLineCommand(commandAndParams);
            case RECTANGLE_FLAG:
                return createRLineCommand(commandAndParams);
            case QUIT_FLAG:
                return createQLineCommand();
            default:
                throw new IllegalArgumentException(ILLEGAL_COMMAND);
        }
    }

    private static LineCommand createCLineCommand(String[] commandAndParams) {
        LineCommand lineCommand = new LineCommand("c");
        try {
            for (int i = 1; i < 3; i++) {
                lineCommand.addParam(Integer.parseInt(commandAndParams[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ILLEGAL_COMMAND);
        }
        return lineCommand;
    }

    private static LineCommand createLLineCommand(String[] commandAndParams) {
        LineCommand lineCommand = new LineCommand("l");
        try {
            for (int i = 1; i < 5; i++) {
                lineCommand.addParam(Integer.parseInt(commandAndParams[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ILLEGAL_COMMAND);
        }
        return lineCommand;
    }

    private static LineCommand createRLineCommand(String[] commandAndParams) {
        LineCommand lineCommand = new LineCommand("r");
        try {
            for (int i = 1; i < 5; i++) {
                lineCommand.addParam(Integer.parseInt(commandAndParams[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ILLEGAL_COMMAND);
        }
        return lineCommand;
    }

    private static LineCommand createQLineCommand() {
        return new LineCommand("q");
    }
}
