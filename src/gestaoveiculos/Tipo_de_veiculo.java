/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoveiculos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class Tipo_de_veiculo implements Serializable {

    private int numero;
    private String designacao;
    private int numVeiculos;
    private int custo=0;
    private ArrayList<Veiculos> veiculos = new ArrayList<>();

    public Tipo_de_veiculo(String designacao) {

        this.designacao = designacao;

    }

    public void adicionarVeiculo(Veiculos v) {

        veiculos.add(v);
    }

    public String mostrarVeiculos() {
        StringBuilder str = new StringBuilder();
        if (veiculos.isEmpty()) {
            str.append("Não há veiculos inseridos!");
        } else {
            for (int i = 0; i < veiculos.size(); i++) {
                str.append(veiculos.get(i)).append("\n");
            }
        }
        return str.toString();
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
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * @param designacao the designacao to set
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * @return the numVeiculos
     */
    public int getNumVeiculos() {
        return numVeiculos;
    }

    /**
     * @param numVeiculos the numVeiculos to set
     */
    public void setNumVeiculos(int numVeiculos) {
        this.numVeiculos = numVeiculos;
    }

    @Override
    public String toString() {
        return "Número:"+numero + " Tipo: " + designacao + " Número de veiculos: " + numVeiculos;
    }

    /**
     * @return the custo
     */
    public int getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(int custo) {
        this.custo = custo;
    }

    /**
     * @return the veiculo
     */


}
