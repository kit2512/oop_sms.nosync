package dev.kit2512.oop_sms.services.FileService;

import java.util.ArrayList;
import java.util.HashMap;

public class ExcelFileModel extends  AbstractExcelFileModel{
    private String path;
    private String title;
    private String subTitle;
    private Class<?>[] columnTypes;

    private String[] columnNames;
    private HashMap<Integer, ArrayList<Object>> data;

    private String sheetName;

    public ExcelFileModel() {

    }

    public ExcelFileModel(String path, String title, String subTitle, Class<?>[] columnTypes, HashMap<Integer, ArrayList<Object>> data) {
        this.title = title;
        this.subTitle = subTitle;
        this.columnTypes = columnTypes;
        this.data = data;
        this.path = path;
                
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public Class<?>[] getColumnTypes() {
        return columnTypes;
    }

    public void setColumnTypes(Class<?>[] columnTypes) {
        this.columnTypes = columnTypes;
    }

    @Override
    public HashMap<Integer, ArrayList<Object>> getData() {
        return data;
    }

    public void setData(HashMap<Integer, ArrayList<Object>> data) {
        this.data = data;
    }

    @Override
    public String getSheetName() {
        return sheetName;
    }

    @Override
    public String[] getColumnNames() {
        return columnNames;
    }
    
    @Override
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
}
