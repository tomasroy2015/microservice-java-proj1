package jp.co.linkstaff.iis.utils;

import org.springframework.util.StringUtils;

/**
 * 
 * @author Roy
 *
 */
public class QueryHelper {

    public static String CreateQuery(String column,int queryType, String[] qArray) {
    	String result = "";
    	switch(queryType) {
    	   case OperationType.LIKE:
    		   //result =" OR (";
    		   for(String st:qArray) {
    			   if(st != null)
   				   result +=  st ;
    		   }
    		   //result = result.substring(0, result.length()-3);
    		   //result += ")";
    		   break;
           case OperationType.IN:
        	   //result = " (";
        	   for(String st:qArray) {
        		   if(st != null)
        			   result += "'"+ st +"'" + ",";
    		   }
        	   result = result.substring(0, result.length()-1);
        	   //result += ")";
    		   break;
           case OperationType.EQUALS:
        	   result =" OR "+ column+ " =";
        	   for(String st:qArray) {
    			   result += st;
    		   }
//        	   result = result.substring(0, result.length()-1);
//        	   result += ")";
    		   break;
           case OperationType.TSVECTOR:
        	   for(String st:qArray) {
        		   if(StringUtils.isEmpty(st) == false)
        			   result += st +" | ";
    		   }
        	   result = result.substring(0, result.length()-3);
    		   break;
    	}
    	return result;
    }
}
