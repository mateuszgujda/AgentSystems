package Model.Highway;

import Model.Vehicles.Vehicle;

public class Cell {

    public enum CellType {
        EXIT, ENTRY, NORMAL, DISABLED
    }

    public static double measure = 7.5;
    
    /// Indicates if cell is occupied by vehicle
    public boolean occupied;
    
    /// Occuping vehicle
    public Vehicle vehicle;
    
    /// Indicates what type of cell is it - EXIT, ENTRY, NORMAL, DISABLED
    public CellType cellType;

    public Cell() {
        setOccupied(false);
    }

    public Cell(CellType type) {
        setOccupied(false);
        cellType = type;
    }

    public boolean getOccupied() {
        return occupied;
    }

    void setOccupied(boolean cellState) {
        occupied = cellState;
    }

    public CellType getCellType() {
        return cellType;
    }

    void setCellType(CellType type) {
        cellType = type;
    }

    public void occupyCell(Vehicle vehicleToSet) {
        occupied = true;
        vehicle = vehicleToSet;
    }

    public void freeCell() {
        occupied = false;
        vehicle = null;
    }
}

