package com.javarush.task.task20.task2026;

public final class RectangleUtil {

    public static boolean isPresentRectangle(byte[][] a, RectangleCoordinates coordinates) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    coordinates.setStartRow(i);
                    coordinates.setStartCol(j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void findEndCoordinateOfRectangle(byte[][] tmp, RectangleCoordinates coordinates) {

        coordinates.setEndCol(findRightLimit(tmp, coordinates.getStartRow(), coordinates.getStartCol()));
        coordinates.setEndRow(findDownLimit(tmp, coordinates.getStartRow(), coordinates.getStartCol()));

    }

    private static int findDownLimit(byte[][] tmp, int startRow, int startCol) {
        int downEndPoint = 0;

        for (int i = startRow; i < tmp.length; i++) {
            if (tmp[i][startCol] == 0) {
                downEndPoint = i;
                break;
            }
        }

        if (downEndPoint == 0) {
            downEndPoint = tmp.length;
        }

        return downEndPoint;
    }

    private static int findRightLimit(byte[][] tmp, int startRow, int startCol) {
        int rightEndPoint = 0;
        for (int i = startCol; i < tmp[startRow].length; i++) {
            if (tmp[startRow][i] == 0) {
                rightEndPoint = i;
                break;
            }

        }

        if (rightEndPoint == 0) {
            rightEndPoint = tmp[startRow].length;
        }

        return rightEndPoint;
    }

    public static void deleteRectangle(byte[][] tmp, RectangleCoordinates coordinates) {
        for (int i = coordinates.getStartRow(); i < coordinates.getEndRow(); i++) {
            for (int j = coordinates.getStartCol(); j < coordinates.getEndCol(); j++) {
                tmp[i][j] = 0;
            }
        }
    }

}
