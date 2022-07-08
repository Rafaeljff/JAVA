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
 * @author 2172044
 */
public class Candidaturas implements Serializable{

    private int numero;
    private String descricao;
    private Funcionarios funcionario;
    private Calendar dataCand;
    private String validacao;
    private String aprovacao;

    private Calendar dataInic;
    private Calendar dataFin;
    private Veiculos veiculo;

    public Candidaturas(String descricao, Funcionarios funcionario, String validacao, Calendar dataCand) {
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.dataCand = dataCand;
        this.validacao = validacao;

    }

    /**
     * @return the nif
     */
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
     * @return the dataCand
     */
    public Calendar getDataCand() {
        return dataCand;
    }

    /**
     * @param dataCand the dataCand to set
     */
    public void setDataCand(Calendar dataCand) {
        this.dataCand = dataCand;
    }

    /**
     * @return the validacao
     */
    public String getValidacao() {
        return validacao;
    }

    /**
     * @param validacao the validacao to set
     */
    public void setValidacao(String validacao) {
        this.validacao = validacao;
    }

    /**
     * @return the aprovacao
     */
    public String getAprovacao() {
        return aprovacao;
    }

    /**
     * @param aprovacao the aprovacao to set
     */
    public void setAprovacao(String aprovacao) {
        this.aprovacao = aprovacao;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("\nCandidatura nº: ");
        str.append(numero).append("\tDescricao:");
        str.append(descricao).append("\tFuncionario:");
        str.append(funcionario.getNif()).append("\tData de candidatura:");

        str.append(dataCand.get(Calendar.DATE)).append("/");
        str.append((dataCand.get(Calendar.MONTH) + 1)).append("/");
        str.append(dataCand.get(Calendar.YEAR)).append("\tValidação da carta:");

        str.append(validacao);

        if (aprovacao != null) {
            str.append("\tEstado da candidatura:");
            str.append(aprovacao).append("\n");
        }

        if (veiculo != null) {
            str.append(veiculo.getNumchassi());
        }

        if (dataInic != null) {
            str.append("\tData de inicio de aluger:");
            str.append(dataInic.get(Calendar.DATE)).append("/");
            str.append(dataInic.get(Calendar.DATE)).append("/");
            str.append(dataInic.get(Calendar.DATE)).append("Data de fim de aluger: ");
            str.append(dataFin.get(Calendar.DATE)).append("/");
            str.append(dataFin.get(Calendar.MONTH)).append("/");
            str.append(dataFin.get(Calendar.YEAR));
        }

        return str.toString();

    }


    /**
     * @return the dataInic
     */
    public Calendar getDataInic() {
        return dataInic;
    }

    /**
     * @param dataInic the dataInic to set
     */
    public void setDataInic(Calendar dataInic) {
        this.dataInic = dataInic;
    }

    /**
     * @return the dataFin
     */
    public Calendar getDataFin() {
        return dataFin;
    }

    /**
     * @param dataFin the dataFin to set
     */
    public void setDataFin(Calendar dataFin) {
        this.dataFin = dataFin;
    }

    /**
     * @return the num_chassi_veiculo
     */
    public Veiculos getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the num_chassi_veiculo to set
     */
    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the dataInic
     */
    /**
     * @return the tempo_aluger
     */
}
