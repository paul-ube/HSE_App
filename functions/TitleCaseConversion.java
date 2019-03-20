/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hse_application.functions;

import java.util.stream.Stream;
//import org.apache.commons.lang.StringUtils
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author OPTIPLEX
 */
public class TitleCaseConversion {
    
    public static String TitleCaseConversion(String inputString)
    {
        if (StringUtils.isBlank(inputString)) {
            return "";
        }
 
        if (StringUtils.length(inputString) == 1) {
            return inputString.toUpperCase();
        }
 
        StringBuffer resultPlaceHolder = new StringBuffer(inputString.length());
 
        Stream.of(inputString.split(" ")).forEach(stringPart ->
        {
            if (stringPart.length() > 1)
                resultPlaceHolder.append(stringPart.substring(0, 1)
                                    .toUpperCase())
                                    .append(stringPart.substring(1)
                                    .toLowerCase());
            else
                resultPlaceHolder.append(stringPart.toUpperCase());
 
            resultPlaceHolder.append(" ");
        });
        return StringUtils.trim(resultPlaceHolder.toString());
    }
}
