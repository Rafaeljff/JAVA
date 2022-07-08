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
public class Funcionarios implements Serializable {

    private int nif;
    private String nome;
    private String morada;
    private int telefone;
    private String funcao;
    private Calendar dataNasc;
    private Candidaturas candidaturas;
   private int idade;

    public Funcionarios(int nif, String nome, String morada, int telefone, String funcao, Calendar dataNasc,int idade) {
        this.nif = nif;
        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        this.funcao = funcao;
        this.dataNasc = dataNasc;
   this.idade=idade;
    }

    /**
     * @return the nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the dataNasc
     */
    public Calendar getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Funcionarios() {
    }

    @Override

    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append(" Nif: ");
        str.append(getNif()).append(" Nome: ");
        str.append(getNome()).append(" Morada: ");
        str.append(getMorada()).append(" Telefone: ");
        str.append(getTelefone()).append(" Função: ");
        str.append(getFuncao()).append(" Data de nascimento: ");
        str.append(getDataNasc().get(Calendar.DATE)).append("/");
        str.append((getDataNasc().get(Calendar.MONTH) + 1)).append("/");
        str.append(getDataNasc().get(Calendar.YEAR));
        return str.toString();

    }

    /**
     * @return the candidaturas
     */
    public Candidaturas getCandidaturas() {
        return candidaturas;
    }

    /**
     * @param candidaturas the candidaturas to set
     */
    public void setCandidaturas(Candidaturas candidaturas) {
        this.candidaturas = candidaturas;
    }
    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }
    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

}
