/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

/**
 * HouseKeepingReportCreator class
 * 
 * @author Hardikkumar Bhakta
 */
public class HouseKeepingReportCreator {
    
    private String houseKeepingReport;
    
    /**
     * Constructor with three string parameters
     * @param employee
     * @param date
     * @param formattedList 
     */
    public HouseKeepingReportCreator(String employee, String date, String formattedList) {
        this.createReport(employee, date, formattedList);
    }
    
    /**
     * createReport() method takes three parameters
     * @param name
     * @param date
     * @param formattedList 
     * and creates housekeeping report in string format
     */
    private void createReport(String name, String date, String formattedList) {
        StringBuilder sb = new StringBuilder();
        sb.append(date).append(" | ").append(name).append("\n\n");
        sb.append(formattedList);
        this.houseKeepingReport = sb.toString();
    }

    /**
     * Gets string formatted Housekeeping report
     * @return houseKeepingReport
     */
    public String getReport() {
        return houseKeepingReport;
    }

    public void appendOptionalContent(String optionalContent) {
        StringBuilder sb = new StringBuilder(houseKeepingReport);
        sb.append(optionalContent);
        this.houseKeepingReport = sb.toString();
    }
    
}
