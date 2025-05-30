/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

import java.io.*;

/**
 * ListWriter class
 * 
 * @author Hardikkumar Bhakta
 */
public class ListWriter {
    
    private final String roomConfigurationTextFile;
    private final String houseKeepingListTextFile;
    
    /**
     * ListWriter() constructor
     * assign path to roomConfigurationTextFile and houseKeepingListTextFile
     */
    public ListWriter() {
        roomConfigurationTextFile = "C:\\HousekeepingReportCreatorAppFiles\\RoomConfiguration\\room_list_configuration_file.txt";
        houseKeepingListTextFile = "C:\\HousekeepingReportCreatorAppFiles\\HousekeepingReport\\housekeeping_list.txt";
    }
    
    /**
     * Writes content to houseKeepingListTextFile
     * @param content 
     */
    public void writeToHouseKeepingListTextFile(String content) {
        writeToTextFile(this.houseKeepingListTextFile, content);
    }
    
    /**
     * Writes content to roomConfigurationTextFile
     * @param content 
     */
    public void writeToConfigurationTextFile(String content) {
        writeToTextFile(this.roomConfigurationTextFile, content);
    }
    
    /**
     * Writes content to text file
     * @param fileName
     * @param content 
     */
    private void writeToTextFile(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write(content);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public String getsHousekeepingReportTextFilePath() {
        return this.houseKeepingListTextFile;
    }
}
