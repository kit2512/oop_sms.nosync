package dev.kit2512.oop_sms.services.FileService;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractExcelFileModel {
    abstract public String getTitle();

    abstract public String getSubTitle();

    abstract public Class<?>[] getColumnTypes();

    abstract public HashMap<Integer, ArrayList<Object>> getData();

    abstract public String getSheetName();

    abstract public String[] getColumnNames();
    
    abstract public String getPath();
}
