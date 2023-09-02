package pers.tony.bo;

import pers.tony.vo.Point;

public abstract class Shape implements IShape {
    public static final String INVALID_PARAM_MSG = "Parameters do not meet condition";
    // for child access
    protected Point p1;
    protected Point p2;
}
