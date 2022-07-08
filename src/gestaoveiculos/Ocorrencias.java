/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoveiculos;

import java.util.Calendar;

/**
 *
 * @author Rafael
 */
public class Ocorrencias {

    private int numero;
    private String descricao;
    private String estado;
    private Funcionarios funcionario;
    private Calendar dataOcorr;
    private Veiculos veic;

    public Ocorrencias(Veiculos veic, String estado, String descricao, Funcionarios funcionario, Calendar dataOcorr) {
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.veic = veic;
        this.dataOcorr = dataOcorr;
        this.estado = estado;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
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
     * @return the funcionario
     */
    public Funcionarios getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the dataOcorr
     */
    public Calendar getDataOcorr() {
        return dataOcorr;
    }

    /**
     * @param dataOcorr the dataOcorr to set
     */
    public void setDataOcorr(Calendar dataOcorr) {
        this.dataOcorr = dataOcorr;
    }

    /**
     * @return the veic
     */
    public Veiculos getVeic() {
        return veic;
    }

    /**
     * @param veic the veic to set
     */
    public void setVeic(Veiculos veic) {
        this.veic = veic;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nOcorrencia: ");
        str.append(numero).append(" Descrição:");
        str.append(descricao).append(" Estado:");
         str.append(estado).append(" Data de ocorrência:");
        str.append(dataOcorr.get(Calendar.DATE)).append("/");
        str.append((dataOcorr.get(Calendar.MONTH) + 1)).append("/");
        str.append(dataOcorr.get(Calendar.YEAR)).append("\nNumero do chassi:");

        str.append(veic.getNumchassi()).append("\nNome do funcionario:");
        str.append(funcionario.getNome());

        return str.toString();
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
