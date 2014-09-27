/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.test;

import pe.unfv.fiei.sistemat.util.Util;

/**
 *
 * @author Arturo
 */
public class Ascii {

    public static void main(String[] args) {
//        String art = "Arturó ";
//        String result = Util.validaLetras(art);
//        if (result == null) {
//            System.out.println("Exito");
//        } else {
//            System.out.println("NO Exito");
//        }
        for (int i = 0; i < 256; i++) {
            System.out.println(i+"-*"+(char)i);
        }
    }
}
