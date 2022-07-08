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
public class Manutencoes implements Serializable {

    private int numero;
    private String descricao;
    private int custo;
    private Funcionarios funcionario;
    private Calendar dataMan;
    private Veiculos veic;


    public Manutencoes(Veiculos veic, int custo, String descricao, Funcionarios funcionario, Calendar dataMan) {
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.veic = veic;
        this.dataMan = dataMan;
        this.custo = custo;
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
     * @return the custo
     */
    public int getCusto() {
        return custo;
    }

    /**
     * @return the funcionario
     */
    public Funcionarios getFuncionario() {
        return funcionario;
    }

    /**
     * @return the dataMan
     */
    public Calendar getDataMan() {
        return dataMan;
    }

    /**
     * @return the veic
     */
    public Veiculos getVeic() {
        return veic;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Manutenção nº: ");
        str.append(numero).append(" Descrição:");
        str.append(descricao).append(" Custo:");
        str.append(custo).append(" Data de manutenção:");
        str.append(dataMan.get(Calendar.DATE)).append("/");
        str.append((dataMan.get(Calendar.MONTH) + 1)).append("/");
        str.append(dataMan.get(Calendar.YEAR)).append("\nNúmero do chassi:");

        str.append(veic.getNumchassi()).append("\nNome do funcionário:");
        str.append(funcionario.getNome());

        return str.toString();
    }

    /**
     * @return the custo_tipo
     */
 

    /**
     * @param custo_tipo the custo_tipo to set
     */
    

}
