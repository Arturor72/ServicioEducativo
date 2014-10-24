/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Arturo
 */
public class Util {
    /* This method support only lowercase and uppercase  letter 
     and ñ or Ñ and á,é,í,ó, ú 
     LowerCase Letter 97-122
     UpperCase Letter  65-90
     ñ 209 y 241
     á 225
     é 233
     í 237
     ó 243
     ú 250*/

    public static String validaLetras(String cadena) {
        String result = null;
        for (int i = 0; i < cadena.length(); i++) {
            char t = cadena.charAt(i);
            if (!((t >= 97 && t <= 122) || (t >= 65 && t <= 90) || (t == 209 || t == 241) || (t == 225) || (t == 233) || (t == 237) || (t == 243) || (t == 250) || (t == ' '))) {
                result = "error";
            }
        }

        return result;

    }

    /* This method support only numbers
     0-9 ascii 48-57*/
    public static String validaNum(String cadena) {
        String result = null;
        for (int i = 0; i < cadena.length(); i++) {
            char t = cadena.charAt(i);
            if (!(t >= 48 && t <= 57)) {
                result = "error";
            }
        }
        return result;
    }
    /* This method support only lowercase and uppercase  letter 
     and ñ or Ñ and á,é,í,ó, ú 
     LowerCase Letter 97-122
     UpperCase Letter  65-90
     ñ 209 y 241
     á 225
     é 233
     í 237
     ó 243
     ú 250
     numbers 0-9 ascii 48-57*/

    public static String validaLetrasyNumeros(String cadena) {
        String result = null;
        for (int i = 0; i < cadena.length(); i++) {
            char t = cadena.charAt(i);
            if (!( (t==' ') || (t >= 97 && t <= 122) || (t >= 65 && t <= 90) || (t == 209 || t == 241) || (t == 225) || (t == 233) || (t == 237) || (t == 243) || (t == 250) || (t >= 48 && t <= 57) )) {
                result = "error";
            }
        }

        return result;

    }

    private static List<Integer> idsToList(String ids) {
        List<Integer> lst = new LinkedList();
        String[] id = ids.split(",");
        for (String x : id) {
            try {
                Integer ix = Integer.valueOf(x);
                lst.add(ix);
            } catch (NumberFormatException e) {
                lst = null;
                break;
            }
        }
        return lst;
    }

    public static List<Integer> toids(String ids) {
        List<Integer> lst = new LinkedList();
        String[] id = ids.split(",");
        for (String x : id) {
            try {
                Integer ix = Integer.valueOf(x);
                lst.add(ix);
            } catch (NumberFormatException e) {
                lst = null;
                break;
            }
        }
        return lst;
    }

    public static String getAnyNull(HashMap hm) {
        String result = null;
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            if (me.getValue() == null) {
                if (result != null) {
                    result += me.getKey() + " es nulo\n";
                } else {
                    result = me.getKey() + " es nulo\n";
                }

            }
        }
        return result;
    }
}
