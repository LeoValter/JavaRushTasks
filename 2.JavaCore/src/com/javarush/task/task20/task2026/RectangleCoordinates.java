package com.javarush.task.task20.task2026;

import java.util.Objects;

public class RectangleCoordinates {

    private int startRow, startCol, endRow, endCol;

    public RectangleCoordinates() {
    }

    public RectangleCoordinates(int startRow, int startCol, int endRow, int endCol) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getEndCol() {
        return endCol;
    }

    public void setEndCol(int endCol) {
        this.endCol = endCol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectangleCoordinates rectangleCoordinates = (RectangleCoordinates) o;
        return startRow == rectangleCoordinates.startRow && startCol == rectangleCoordinates.startCol && endRow == rectangleCoordinates.endRow && endCol == rectangleCoordinates.endCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startRow, startCol, endRow, endCol);
    }

}
