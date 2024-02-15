package models;

import java.awt.Color;

public enum Tile {

    FLOOR((char)176, Color.white),
    WALL((char)178, Color.lightGray),
    BOUNDS('x', Color.BLACK);

    private char symbol;
    private Color color;

    Tile(char symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    // checks if something is a floor tile
    public boolean isFloor() {
        if (this != WALL && this != BOUNDS) {
            return true;
        }
        return false;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}