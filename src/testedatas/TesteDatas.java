/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedatas;

import java.util.Calendar;

/**
 *
 * @author Anabela
 */
public class TesteDatas {

    public static long diferencaDias(Calendar dataIni, Calendar dataFim) {
        long difDias = (dataFim.getTimeInMillis() - dataIni.getTimeInMillis()) / (24 * 60 * 60 * 1000);

        return difDias;
    }

    public static int diferencaMeses(Calendar dataIni, Calendar dataFim) {
        int difMes = dataFim.get(Calendar.MONTH) - dataIni.get(Calendar.MONTH);
        int difMesAno = ((dataFim.get(Calendar.YEAR) - dataIni.get(Calendar.YEAR)) * 12);
        int total = difMesAno + difMes;
        if (dataFim.get(Calendar.DATE) < dataIni.get(Calendar.DATE)) {
            total--;
        }
        System.out.println("Diferença meses: " + total);
        return total;
    }

    public static int diferencaAnos(Calendar dataIni, Calendar dataFim) {
        int difAnos = dataFim.get(Calendar.YEAR) - dataIni.get(Calendar.YEAR);
        if (dataFim.get(Calendar.DAY_OF_YEAR) < dataIni.get(Calendar.DAY_OF_YEAR)) {
            difAnos--;
        }

        return difAnos;
    }
}
