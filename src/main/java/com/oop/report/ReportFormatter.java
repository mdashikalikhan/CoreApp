package com.oop.report;

public class ReportFormatter {

    private String formattedOutput ;

    public ReportFormatter(Object object, FormatType formatType) {
        switch (formatType){
            case CSV:
                    formattedOutput = convertObjToCSV(object);
                    break;
            case XML:
                    formattedOutput = convertObjectToXML(object);
                    break;

            default:
                    formattedOutput = "";
        }
    }




    private String convertObjectToXML(Object object) {
        return "XML: <title>" + object.getClass().getSimpleName() + "</title>";
    }

    private String convertObjToCSV(Object object) {
        return "CSV:,,," + object.toString() +",,";
    }

    protected String getFormattedValue() {
        return formattedOutput;
    }
}
