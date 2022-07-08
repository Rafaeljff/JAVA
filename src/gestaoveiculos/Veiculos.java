/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoveiculos;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Rafael
 */
public class Veiculos implements Serializable {

    private String descricao;
    private int numchassi;
    private Tipo_de_veiculo tipo;

    private Calendar dataUltimaManutencao;
    private int numcandidatura = 0;
    private String aluger_veic = "disponivel";
    private int avaria = 0;

    public Veiculos(String descricao, int numchassi, Tipo_de_veiculo tipo) {
        this.descricao = descricao;
        this.numchassi = numchassi;
        this.tipo = tipo;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Veiculo: ");
        str.append(getDescricao()).append(" Numero de chassi: ");
        str.append(getNumchassi()).append(" Tipo de veiculo:  ");
        str.append(getTipo().getDesignacao()).append(" Numero de candidaturas: ");
        str.append(getNumcandidatura()).append(" Estado: ");
        str.append(getAluger_veic());

        if (dataUltimaManutencao != null) {
            str.append(" Ultima manutenção:");
            str.append(dataUltimaManutencao.get(Calendar.DATE)).append("/");
            str.append(dataUltimaManutencao.get(Calendar.MONTH) + 1).append("/");
            str.append(dataUltimaManutencao.get(Calendar.YEAR));
        }
        return str.toString();

    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the numchassi
     */
    public int getNumchassi() {
        return numchassi;
    }

    /**
     * @param numchassi the numchassi to set
     */
    public void setNumchassi(int numchassi) {
        this.numchassi = numchassi;
    }

    /**
     * @return the tipo
     */
    public Tipo_de_veiculo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo_de_veiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the dataUltimaManutencao
     */
    public Calendar getDataUltimaManutencao() {
        return dataUltimaManutencao;
    }

    /**
     * @param dataUltimaManutencao the dataUltimaManutencao to set
     */
    public void setDataUltimaManutencao(Calendar dataUltimaManutencao) {
        this.dataUltimaManutencao = dataUltimaManutencao;
    }

    /**
     * @return the numcandidatura
     */
    public int getNumcandidatura() {
        return numcandidatura;
    }

    /**
     * @param numcandidatura the numcandidatura to set
     */
    public void setNumcandidatura(int numcandidatura) {
        this.numcandidatura = numcandidatura;
    }

    /**
     * @return the aluger_veic
     */
    public String getAluger_veic() {
        return aluger_veic;
    }

    /**
     * @param aluger_veic the aluger_veic to set
     */
    public void setAluger_veic(String aluger_veic) {
        this.aluger_veic = aluger_veic;
    }

    /**
     * @return the avaria
     */
    public int getAvaria() {
        return avaria;
    }

    /**
     * @param avaria the avaria to set
     */
    public void setAvaria(int avaria) {
        this.avaria = avaria;
    }
}
