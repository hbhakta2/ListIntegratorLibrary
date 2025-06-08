/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

/**
 * Room class
 * 
 * @author Hardikkumar Bhakta
 */
public class Room {
    
    private Integer number;
    private String roomType;
    private RoomStatus status;
    private String notes;
    
    /**
     * optional enumerated RoomType
     */
    public enum RoomType {
        NK, NQ, NQQ, NQQ3, SQ, SQQ, SQQ3;
    }
    
    /**
     * enumerated Room status
     */
    public enum RoomStatus {
        CHECKED_OUT, STAY_OVER, VACANT_DIRTY, DIRTY, VACANT_CLEAN;
    }
    
    /**
     * Empty Room constructor
     */
    public Room() {
        
    }
    
    /**
     * Room constructor takes two parameters
     * @param number
     * @param roomType 
     * Assign default RoomStatus and calls Room constructor with three parameters
     */
    public Room(Integer number, String roomType) {
        this(number, roomType, RoomStatus.VACANT_CLEAN);
    }
    
    /**
     * Room Constructor with three parameters
     * @param number
     * @param roomType
     * @param roomStatus 
     * Sets room number, room type, and room status
     */
    public Room(Integer number, String roomType, RoomStatus roomStatus) {
        this.number = number;
        this.roomType = roomType;
        this.status = roomStatus;   
    }

    
    /**
     * Gets room number
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets room number
     * @param number 
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets room type
     * @return roomType
     */
    public String getType() {
        return this.roomType;
    }

    /**
     * Sets room type
     * @param type 
     */
    public void setType(String type) {
        this.roomType = type;
    }

    /**
     * Gets room status
     * @return status
     */
    public RoomStatus getStatus() {
        return status;
    }

    /**
     * Sets room status
     * @param status 
     */
    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    /**
     * Gets room notes
     * @return 
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets room notes
     * @param notes 
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    /**
     * toString() method
     * @return String formatted Room object
     */
    @Override
    public String toString() {
        return " " + number + " " + roomType + "\t";
    }
    
    
}
