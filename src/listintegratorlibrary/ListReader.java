/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ListReader class
 * 
 * @author Hardikkumar Bhakta
 */
public class ListReader {
    
    private final String roomConfigurationTextFile;
    private final String houseKeepingListTextFile;
    private File configurationFile;
    
    /**
     * ListReader() constructor
     * assign path to roomConfigurationTextFile and houseKeepingListTextFile
     */
    public ListReader() {
        roomConfigurationTextFile = "C:\\HousekeepingReportCreatorAppFiles\\RoomConfiguration\\room_list_configuration_file.txt";
        houseKeepingListTextFile = "C:\\HousekeepingReportCreatorAppFiles\\HousekeepingReport\\housekeeping_list.txt";
        configurationFile = new File(roomConfigurationTextFile);
    }
    
    /**
     * Reads content from houseKeepingListTextFile
     */
    public void readFromHouseKeepingListTextFile() {
       readFromTextFile(this.houseKeepingListTextFile);
    }
    
    /**
     * Reads content from roomConfigurationTextFile
     * @return String
     */
    public String readFromConfigurationTextFile() {
        return readFromTextFile(this.roomConfigurationTextFile);
    }
    
    /**
     * Reads content from text file
     * readFromTextFile() method takes
     * @param fileName
     * @return String formatted data
     */
    private String readFromTextFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader bw = new BufferedReader(new FileReader(fileName))){
            while ((line = bw.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return sb.toString();
    }

    /**
     * Validates if configurationFile exists or not
     * @return true or false
     */
    public boolean configurationFileExists() {
        return configurationFile.exists();
    }

    /**
     * Validates if configurationFile is readable or not
     * @return true or false
     */
    public boolean configurationFileIsReadable() {
        return configurationFile.canRead();
    }

}
