/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doisoat.utils;

/**
 *
 * @author lucnt
 */
public class StringUtils {
    public static boolean isEmpty(Object obj){
        return (obj == null || "".equals(obj));
    }
}
