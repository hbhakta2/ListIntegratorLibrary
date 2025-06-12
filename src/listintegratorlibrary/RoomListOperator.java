/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * RoomListOperator class
 * 
 * @author Hardikkumar Bhakta
 */
public class RoomListOperator {
    
    private List<Room> combinedList;
    private List<Room> checkedOutList;
    private List<Room> stayOverList;
    private Double wagePerCheckedOutRoomCleaned;
    private Double wagePerStayOverRoomCleaned;
    
    /**
     * Constructor
     * creates three ArrayList
     * combinedList: holds both checked out & stay over list
     * checkedOutList: holds only checked out room list
     * stayOverList: holds only stay over room list
     */
    public RoomListOperator() {
        combinedList = new ArrayList<>();
        checkedOutList = new ArrayList<>();
        stayOverList = new ArrayList<>();
    }
    
    /**
     * add() method
     * If list does not contain room,
     *  Adds room to the checkedOutList or to the stayOverList based on room status,
     *  Adds room to the combinedList,
     * Else
     *  Manage duplicate room by updating its status 
     * Calls sortAllList() method
     * 
     * @param room 
     */
    public void add(Room room) {
        if (!isDuplicate(room.getNumber())) {
            if (room.getStatus() == Room.RoomStatus.CHECKED_OUT) {
                checkedOutList.add(room);
            } else if (room.getStatus() == Room.RoomStatus.STAY_OVER) {
                stayOverList.add(room);
            }
            combinedList.add(room);
        } else if (isDuplicate(room.getNumber())){
            for (int i = 0; i < combinedList.size(); i++) {
                if(combinedList.get(i).getNumber() == room.getNumber()) {
                    combinedList.get(i).setStatus(room.getStatus());
                    break;
                }
            }
            
        }
        sortAllList();
    }
    
    /**
     * Validates duplicates room before adding to the list
     * @param roomNumber
     * @return 
     */
    private boolean isDuplicate(Integer roomNumber) {
        for (Room room : combinedList) {
            if (roomNumber == room.getNumber()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts all list after adding
     */
    private void sortAllList() {
        Comparator sortIntegerByAscendingOrder = new SortIntegerByAscendingOrder();
        Collections.sort(combinedList, sortIntegerByAscendingOrder);
        Collections.sort(checkedOutList, sortIntegerByAscendingOrder);
        Collections.sort(stayOverList, sortIntegerByAscendingOrder);
    }

    /**
     * Gets list
     * @return combinedList
     */
    public List<Room> getCombinedList() {
        return combinedList;
    }

    /**
     * Gets list
     * @return checkedOutList
     */
    public List<Room> getCheckedOutList() {
        return checkedOutList;
    }

    /**
     * Gets list
     * @return stayOverList
     */
    public List<Room> getStayOverList() {
        return stayOverList;
    }
    
    /**
     * Gets String formatted checked out list
     * @return String
     */
    private String getFormattedCheckedOutList() {
        StringBuilder sb = new StringBuilder(); 
        sb.append("|===============================|\n");
        sb.append("| Checked Out (C/O)             |\n");
        sb.append("|===============================|\n");
        for (Room room : checkedOutList) {
            sb.append("|-------------------------------|\n");
            sb.append("|").append(room).append("\t\t|\n");
        }
        sb.append("|-------------------------------|\n");
        sb.append("|===============================|\n");
        sb.append("| COUNT: ").append(checkedOutList.size()).append("\t\t\t|\n");
        sb.append("|===============================|\n");
        sb.append("\n");
        return sb.toString();
    }
    
    /**
     * Gets String formatted checked out list
     * @return String
     */
    private String getFormattedStayOverList() {
        StringBuilder sb = new StringBuilder(); 
        sb.append("|===============================|\n");
        sb.append("| Stay Over (S/O)               |\n");
        sb.append("|===============================|\n");
        String sp = String.format("%" + 23 + "s", "|\n");
        for (Room room : stayOverList) {
            sb.append("|-------------------------------|\n");
            sb.append("|").append(room).append(sp);           
        }
        sb.append("|-------------------------------|\n");
        sb.append("|===============================|\n");
        if (stayOverList.size() > 9) {
            sb.append("| COUNT: ").append(stayOverList.size()).append(sp);
        } else {
            sb.append("| COUNT: ").append(stayOverList.size()).append(String.format("%" + 24 + "s", "|\n"));
        }
        sb.append("|===============================|\n");
        return sb.toString();
    }

    /**
     * Gets updated content
     * @return String
     */
    public String getUpdatedContent() {
        StringBuilder sb = new StringBuilder();
        
        String formattedCOList = getFormattedCheckedOutList();
        String formattedSOList = getFormattedStayOverList();
        
        String[] coutLines = formattedCOList.split("\n");
        String[] soverLines = formattedSOList.split("\n");
        
        if (coutLines.length >= soverLines.length) {
            for (int i = 0; i < coutLines.length; i++) {
                sb.append(coutLines[i]).append("    ");
                if (i < soverLines.length) {
                    sb.append(soverLines[i]);
                }
                sb.append("\n");
            }
        } else {
            for (int i = 0; i < soverLines.length; i++) {
                if (i < coutLines.length) {
                    sb.append(coutLines[i]).append("    ");
                } else {
                    sb.append("                                     ");
                }
                sb.append(soverLines[i]).append("\n");
            }
        }
        return sb.toString();
    }

    public double getWagePerCheckedOutRoomCleaned() {
        return wagePerCheckedOutRoomCleaned;
    }

    public void setWagePerCheckedOutRoomCleaned(Double wage) {
        this.wagePerCheckedOutRoomCleaned = wage;
    }

    public double getWagePerStayOverRoomCleaned() {
        return this.wagePerStayOverRoomCleaned;
    }

    public void setWagePerStayOverRoomCleaned(Double wage) {
        this.wagePerStayOverRoomCleaned = wage;
    }
    
    public String getOptionalContent(String date) {
        StringBuilder sb = new StringBuilder();
        Integer checkedOutCount = checkedOutList.size();
        Integer stayOverCount = stayOverList.size();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Double totalCheckedOutWage = checkedOutCount * wagePerCheckedOutRoomCleaned;
        Double totalStayOverWage = stayOverCount * wagePerStayOverRoomCleaned;
        Double totalDailyWage = totalCheckedOutWage + totalStayOverWage;
        
        currency.format(totalCheckedOutWage);
        currency.format(totalStayOverWage);
        currency.format(totalDailyWage);
        String formattedCheckedOutCount = String.format("%" + 4 + "d", checkedOutCount);
        String formattedStayOverCount = String.format("%" + 4 + "d", stayOverCount);
        String formattedCheckedOutWage = String.format("%-" + 6 + ".2f", wagePerCheckedOutRoomCleaned);
        String formattedStayOverWage = String.format("%-" + 6 + ".2f", wagePerStayOverRoomCleaned);
        String formattedTotalCheckedOutWage = String.format("%" + 7 + ".2f", totalCheckedOutWage);
        String formattedTotalStayOverWage = String.format("%" + 7 + ".2f", totalStayOverWage);
        String formattedGrandTotalPerDay = String.format("%" + 7 + ".2f", totalDailyWage);
        sb.append("\n");
        sb.append("|-------------------------------|\n");
        sb.append("|Wage Calculation | ").append(date).append("  |\n");
        sb.append("|-------------------------------|\n");
        sb.append("|  C/O: ").append(formattedCheckedOutCount).append(" x ").append(formattedCheckedOutWage).append(" = ").append(formattedTotalCheckedOutWage).append(" |\n");
        sb.append("|+ S/O: ").append(formattedStayOverCount).append(" x ").append(formattedStayOverWage).append(" = ").append(formattedTotalStayOverWage).append(" |\n");
        sb.append("|-------------------------------|\n");
        sb.append("|Total: \t\t").append(formattedGrandTotalPerDay).append(" |\n");
        sb.append("|-------------------------------|\n");
        return sb.toString();
    }
    
    public void clearAllList() {
        combinedList.clear();
        checkedOutList.clear();
        stayOverList.clear();
    }
    
}
