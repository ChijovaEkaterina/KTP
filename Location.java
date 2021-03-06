package com.company;

import java.util.Objects;

/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }
    public boolean equals(Object o) {
        Location l = (Location) o;
        return xCoord == l.xCoord && yCoord == l.yCoord;
    }
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}
