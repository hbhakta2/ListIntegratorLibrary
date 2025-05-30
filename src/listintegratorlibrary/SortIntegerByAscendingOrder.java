/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

import java.util.Comparator;

/**
 * SortIntegerByAscendingOrder class
 * implements Comparator class and overrides compare method
 * Compares Room objects by number and sorts them in ascending order
 * 
 * @author Hardikkumar Bhakta
 */
public class SortIntegerByAscendingOrder implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Room room1 = (Room) o1;
        Room room2 = (Room) o2;
        Integer a = room1.getNumber();
        Integer b = room2.getNumber();
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
