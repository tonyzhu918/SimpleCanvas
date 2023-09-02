package pers.tony;

import pers.tony.bo.Canvas;
import pers.tony.bo.IShape;
import pers.tony.bo.ShapeFactory;
import pers.tony.util.ParseUtil;
import pers.tony.vo.LineCommand;
import pers.tony.vo.Point;

import java.util.Scanner;

public class SimpleCanvas implements Constants {
    public static final String ENTER_COMMAND_MSG = "enter command: ";

    private volatile boolean quit = false;
    protected Canvas canvas;

    public void start() {
        System.out.print(SimpleCanvas.getUsage());
        Scanner in = new Scanner(System.in);
        do {
            System.out.print(ENTER_COMMAND_MSG);
            String lineCommand = in.nextLine();
            try {
                LineCommand command = ParseUtil.parseLineCommand(lineCommand);
                processCommand(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!quit);
    }

    protected void processCommand(LineCommand command) {
        if (CREATE_CANVAS_FLAG.equals(command.getCommand())) {
            canvas = Canvas.createCanvas(command.getParam(0), command.getParam(1));
            canvas.draw();
        }
        if (LINE_FLAG.equals(command.getCommand())) {
            if (canvas == null) {
                throw new IllegalArgumentException("please create canvas first");
            }
            IShape line = ShapeFactory.createShape(LINE_FLAG, new Point(command.getParam(0), command.getParam(1)), new Point(command.getParam(2), command.getParam(3)));
            line.fill(canvas);
            canvas.draw();
        }
        if (RECTANGLE_FLAG.equals(command.getCommand())) {
            if (canvas == null) {
                throw new IllegalArgumentException("please create canvas first");
            }
            IShape rectangle = ShapeFactory.createShape(RECTANGLE_FLAG, new Point(command.getParam(0), command.getParam(1)), new Point(command.getParam(2), command.getParam(3)));
            rectangle.fill(canvas);
            canvas.draw();
        }
        if (QUIT_FLAG.equals(command.getCommand())) {
            quit = true;
        }
    }

    public static String getUsage() {
        StringBuilder strBuilder = new StringBuilder();
        String newline = System.getProperty("line.separator");
        strBuilder.append("Below commands are supported:");
        strBuilder.append(newline);
        strBuilder.append("C w h to create a new canvas of width w and height h, e.g. C 20 4");
        strBuilder.append(newline);
        strBuilder.append("L x1 y1 x2 y2 to create a new line from (x1, y1) to (x2, y2). Currently only horizontal or vertical lines are supported, e.g. L 1 2 6 2");
        strBuilder.append(newline);
        strBuilder.append("R x1 y1 x2 y2 to create a new rectangle whose upper left corner is (x1, y1) and lower right corner is (x2, y2), e.g. R 16 1 20 3");
        strBuilder.append(newline);
        strBuilder.append("Q to quit the program");
        strBuilder.append(newline);
        return strBuilder.toString();
    }
}
