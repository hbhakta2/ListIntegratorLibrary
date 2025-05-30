/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

import java.util.*;

/**
 * ListIntegrator class
 * 
 * @author Hardikkumar Bhakta
 */
public class ListIntegrator {
    
    private List<Room> integratedUniqueList;
    private Integer startsFrom;
    private Integer endsTo;
    
    /**
     * ListIntegrator Constructor
     * creates new arraylist
     * assign starting value
     * and ending value
     */
    public ListIntegrator() {
        integratedUniqueList = new ArrayList<>();
        startsFrom = 0;
        endsTo = Integer.MAX_VALUE;
    }
    
    /**
     * Sets starting value
     * @param minimum 
     */
    public void setMinimumNumber(Integer minimum) {
        this.startsFrom = minimum;
    }
    
    /**
     * Sets ending value
     * @param maximum 
     */
    public void setMaximumNumber(Integer maximum) {
        this.endsTo = maximum;
    }
    
    /**
     * Adds Room and sorts list in ascending order by room number
     * @param room 
     */
    public void buildSortedList(Room room) {
        Integer number = room.getNumber();
        if (number >= this.startsFrom && number <= this.endsTo) {
            if (!integratedUniqueListContains(number)) {
                this.integratedUniqueList.add(room);
            }
        }
        Comparator sortIntegerByAscendingOrder = new SortIntegerByAscendingOrder();
        Collections.sort(this.integratedUniqueList, sortIntegerByAscendingOrder);
    }
    
    
    /**
     * Adds Room to the list
     * @param list 
     */
    private void add(List<Room> list) {
        for (Room room : list) {
            buildSortedList(room);
        }
    }
    
    /**
     * Removes Room from the list
     * @param number
     * @param roomType
     * @return 
     */
    public Room remove(Integer number, String roomType) {
        for (int i = 0; i < integratedUniqueList.size(); i++) {
            if (integratedUniqueList.get(i).getNumber() == number && 
                    (integratedUniqueList.get(i).getType().equals(roomType) ||
                    integratedUniqueList.get(i).getType().equals(""))) {
                return integratedUniqueList.remove(i);        
            }
        }
        return null;
    }

    /**
     * Gets Room list
     * @return List<Integer>
     */
    public List<Room> getIntegratedUniuqeList() {
        return this.integratedUniqueList;
    }

    /**
     * Validates if room number exists in list
     * @param number
     * @return true or false
     */
    private boolean integratedUniqueListContains(Integer number) {
        for (Room room : integratedUniqueList) {
            if (room.getNumber() == number) {
                return true;
            }
        }
        return false;
    }
}
