/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoveiculos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import testedatas.TesteDatas;

import util.Consola;

/**
 *
 * @author 2172044
 */
public class Gestao2 {

    /**
     * @param candidatura the candidatura to set
     */
    public void setCandidatura(ArrayList<Candidaturas> candidatura) {
        this.candidatura = candidatura;
    }

    private ArrayList<Tipo_de_veiculo> tipos = new ArrayList<>();
    private ArrayList<Veiculos> veiculos = new ArrayList<>();
    private ArrayList<Funcionarios> funcionario = new ArrayList<>();
    private ArrayList<Candidaturas> candidatura = new ArrayList<>();
    private ArrayList<Ocorrencias> ocorrencia = new ArrayList<>();
    private ArrayList<Manutencoes> manutencao = new ArrayList<>();

    public void adicionarTipoVeiculo(Tipo_de_veiculo t) {
        t.setNumero(tipos.size() + 1);

        tipos.add(t);
    }

    public String mostrarTipos() {
        StringBuilder str = new StringBuilder();
        if (tipos.isEmpty()) {
            str.append("Não há tipos inseridos!");
        } else {

            str.append("Tipos de veiculos registados: ");
            for (int i = 0; i < tipos.size(); i++) {
                str.append(tipos.get(i)).append("\n");
            }
        }
        return str.toString();
    }

    public int pesquisarTipoVeiculo(int numero) {

        if (tipos.isEmpty()) {

            return -1;
        }

        for (int i = 0; i < tipos.size(); i++) {

            if (tipos.get(i).getNumero() == numero) {
                return i;
            }

        }
        return -1;

    }

    public Tipo_de_veiculo obterTipoVeiculo(int pos) {

        return tipos.get(pos);

    }

    public void adicionarVeiculo(Veiculos v) {

        veiculos.add(v);
    }

    public void adicionarFuncionario(Funcionarios f) {

        funcionario.add(f);

    }

    public int pesquisarNif(int nif) {

        for (int i = 0; i < funcionario.size(); i++) {

            if (funcionario.get(i).getNif() == nif) {
                return i;
            }

        }
        return -1;

    }

    public int pesquisarNum_chassi(int numero) {
        for (int i = 0; i < veiculos.size(); i++) {

            if (veiculos.get(i).getNumchassi() == numero) {
                return -1;
            }

        }
        return 0;
    }

    public String mostrarNif() {
        StringBuilder str = new StringBuilder();

        if (!funcionario.isEmpty()) {
            System.out.println("Nifs dos funcionários inseridos: ");
            for (int i = 0; i < funcionario.size(); i++) {

                str.append(funcionario.get(i).getNif()).append("\n");

            }

        } else {
            str.append("Nao existem funcionarios registados ");

        }
        return str.toString();
    }

    public String pesquisarFuncionario() {
        StringBuilder str = new StringBuilder();
        int numero;
        int i;

        if (!funcionario.isEmpty()) {
            do {
                numero = Consola.lerInt("Insira o NIF do funcionário que pretende pesquisar: ", 0, 100000);
                for (i = 0; i < funcionario.size(); i++) {
                    if (numero == funcionario.get(i).getNif()) {

                        str.append("Funcionário: ").append(funcionario.get(i)).append("\n");

                        for (int j = 0; j < candidatura.size(); j++) {
                            if (numero == candidatura.get(j).getFuncionario().getNif()) {

                                str.append(candidatura.get(j));

                            }

                        }
                    }
                }

            } while (pesquisarNif(numero) == -1);
        }

        return str.toString();
    }

    public void adicionarCandidatura(Candidaturas c) {
        c.setNumero(candidatura.size() + 1);
        candidatura.add(c);

    }

    public String MostarFuncionariosMaiores18() {
        StringBuilder str = new StringBuilder();
        if (!funcionario.isEmpty()) {
            str.append("\nFuncionarios registados: ");
            for (int i = 0; i < funcionario.size(); i++) {
                if (funcionario.get(i).getIdade() >= 18) {
                    str.append(funcionario.get(i).getNif()).append("\n");
                }
            }
        }

        return str.toString();
    }

    public Funcionarios obterFuncionario(int nif) {

        if (!funcionario.isEmpty()) {

            for (int i = 0; i < funcionario.size(); i++) {

                if ((nif == funcionario.get(i).getNif())) {

                    return funcionario.get(i);

                }

            }
        }

        return null;
    }
public Funcionarios obterFuncionarioTecncico(int nif) {

        if (!funcionario.isEmpty()) {

            for (int i = 0; i < funcionario.size(); i++) {

                if ((nif == funcionario.get(i).getNif()&&"tecnico".equals(funcionario.get(i).getFuncao()))) {

                    return funcionario.get(i);

                }

            }
        }

        return null;
    }
    public String mostrarCandidaturas() {

        System.out.println("Candidaturas por aprovar: ");
        for (int i = 0; i < candidatura.size(); i++) {

            System.out.println(candidatura.get(i));

        }
        return toString();
    }

    public String mostrarDatasCandidaturas() {
        StringBuilder str = new StringBuilder();
        System.out.println("Datas das candidaturas registadas: ");
        for (int i = 0; i < candidatura.size(); i++) {

            str.append(candidatura.get(i).getDataCand().get(Calendar.DATE)).append("/");
            str.append(candidatura.get(i).getDataCand().get(Calendar.MONTH) + 1).append("/");
            str.append(candidatura.get(i).getDataCand().get(Calendar.YEAR)).append("\n");
        }
        return str.toString();
    }

    public String mostrar_candidaturas_disponiveis() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < candidatura.size(); i++) {
            if (candidatura.get(i).getAprovacao() == null && "Valida".equals(candidatura.get(i).getValidacao())) {
                str.append(candidatura.get(i));
            }
        }

        return str.toString();
    }

    public String mostrar_veiculos_candidatura() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < veiculos.size(); i++) {
            if ("disponivel".equals(veiculos.get(i).getAluger_veic())) {
                str.append(veiculos.get(i));
            }
        }

        return str.toString();
    }

    public int verificarDisponivilidadeCandidatura(int a) {

        for (int i = 0; i < candidatura.size(); i++) {

            if (a == candidatura.get(i).getNumero() && "Valida".equals(candidatura.get(i).getValidacao()) && (candidatura.get(i).getAprovacao() == null)) {

                return i;
            }

        }

        return -1;
    }

    public int verificarTodasCandidaturasEliminar(int numero) {

        for (int i = 0; i < candidatura.size(); i++) {

            if (numero == candidatura.get(i).getNumero() && !"Aprovado".equals(candidatura.get(i).getAprovacao())) {

                return i;
            }

        }

        return -1;
    }

    public int verificarTipos() {
        if (tipos.isEmpty()) {

            return 0;

        }

        return 1;

    }

    public int verificarCandidaturasT() {
        if (candidatura.isEmpty()) {

            return 0;

        }

        return 1;

    }

    public int verificarFuncionariosT() {
        if (funcionario.isEmpty()) {

            return 0;

        }

        return 1;

    }

    public int verificarFuncionariosTecnicos() {

        for (int i = 0; i < funcionario.size(); i++) {
            if ("tecnico".equals(funcionario.get(i).getFuncao())) {

                return 1;

            }

        }

        return 0;

    }

    public int verificarCandidaturasRemover() {
        if (candidatura.isEmpty()) {

            for (int i = 0; i < candidatura.size(); i++) {
                if (!"Aprovado".equals(candidatura.get(i).getAprovacao())) {
                    return 1;
                }

            }

        }

        return -1;

    }

    public int verificarVeiculosT() {
        if (veiculos.isEmpty()) {

            return 0;

        }

        return 1;

    }

    public int verificarCandidaturas() {
        for (int i = 0; i < candidatura.size(); i++) {

            if (candidatura.get(i).getAprovacao() == null && "Valida".equals(candidatura.get(i).getValidacao())) {

                return 1;
            }

        }

        return 0;

    }

    public int verificarDisponivilidadeVeiculos() {
        for (int i = 0; i < veiculos.size(); i++) {

            if ("disponivel".equals(veiculos.get(i).getAluger_veic())) {

                return 1;
            }

        }

        return 0;

    }

    public String mostrar_veiculos_disponiveis() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < veiculos.size(); i++) {
            if ("disponivel".equals(veiculos.get(i).getAluger_veic())) {
                str.append(candidatura.get(i));
            }
        }

        return str.toString();
    }

    public int verificarDisponivilidadeVeiculo(int numchassi) {

        for (int i = 0; i < veiculos.size(); i++) {

            if (numchassi == veiculos.get(i).getNumchassi() && "disponivel".equals(veiculos.get(i).getAluger_veic())) {

                return i;
            }

        }

        return -1;
    }

    public int verificarVeiculo(int numchassi) {

        for (int i = 0; i < veiculos.size(); i++) {

            if (numchassi == veiculos.get(i).getNumchassi()) {

                return i;
            }

        }

        return -1;
    }

    public int verificarFuncionario() {
        for (int i = 0; i < funcionario.size(); i++) {

            if (funcionario.isEmpty()) {
                return -1;
            }

            if (funcionario.get(i).getIdade() >= 18) {

                return 1;
            }

        }

        return 0;

    }

    /**
     * @return the Aprovar_candidatura
     */
    int requisitos_para_aprovar() {
        int i;
        if (!candidatura.isEmpty() && !veiculos.isEmpty()) {

        } else {
            System.out.println("Nao existem candidaturas/veiculos inseridos");
        }

        return 0;

    }

    public Candidaturas obterCandidaturaPos(int pos) {
        return candidatura.get(pos);
    }

    public Veiculos obterVeiculoPos(int pos) {

        return veiculos.get(pos);
    }

    /**
     * @return the ocurrencia
     */
    public ArrayList<Ocorrencias> getOcurrencia() {
        return ocorrencia;
    }

    /**
     * @param ocurrencia the ocurrencia to set
     */
    public void setOcurrencia(ArrayList<Ocorrencias> ocurrencia) {
        this.ocorrencia = ocurrencia;
    }

    public void adicionarOcorrencia(Ocorrencias o) {
        o.setNumero(ocorrencia.size() + 1);

        ocorrencia.add(o);
    }

    public String mostrar_Veiculos() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < veiculos.size(); i++) {
            str.append(veiculos.get(i)).append("\n");
        }

        return str.toString();
    }

    public String MostarFuncionariosTecnicos() {
        StringBuilder str = new StringBuilder();

        str.append("\nFuncionarios técnicos: ");
        for (int i = 0; i < funcionario.size(); i++) {
            if ("tecnico".equals(funcionario.get(i).getFuncao())) {
                str.append(funcionario.get(i)).append("\n");
            }
        }

        return str.toString();
    }

    public String MostarFuncionarios() {
        StringBuilder str = new StringBuilder();
        if (!funcionario.isEmpty()) {
            str.append("\nFuncionarios: ");
            for (int i = 0; i < funcionario.size(); i++) {

                str.append(funcionario.get(i)).append("\n");

            }
        }
        return str.toString();
    }

    public int verificarOcorrencias() {
        if (!ocorrencia.isEmpty()) {

            return 0;

        }

        return 1;

    }

    public String mostrar_Ocorrencias() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < ocorrencia.size(); i++) {
            str.append(ocorrencia.get(i));
        }

        return str.toString();
    }

    public int obterOcorrenciaPos(int numero) {
        for (int i = 0; i < ocorrencia.size(); i++) {

            if (numero == ocorrencia.get(i).getNumero()) {

                return i;

            }

        }
        return -1;
    }

    public Ocorrencias obterOcorrencia(int pos) {
        return ocorrencia.get(pos);
    }

    public int verificarTodosFuncionarios() {
        for (int i = 0; i < funcionario.size(); i++) {

            if (funcionario.isEmpty()) {
                return 0;
            }

        }

        return 1;

    }

    public int consultarOcorrenciasVeiculoPos(int num_chassi) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ocorrencia.size(); i++) {

            if (ocorrencia.get(i).getVeic().getNumchassi() == num_chassi) {
                return i;
            }
        }

        return -1;

    }

    public String consultarOcorrenciasVeiculo(int pos) {
        StringBuilder str = new StringBuilder();

        str.append(ocorrencia.get(pos));

        return str.toString();

    }

    public String mostrarVeiculosOcorrencias() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < ocorrencia.size(); i++) {
            str.append(ocorrencia.get(i).getVeic());
        }

        return str.toString();
    }

    public int verificarTodasOcorrencias() {

        if (ocorrencia.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public int DataCandPos(Calendar data) {

        for (int i = 0; i < candidatura.size(); i++) {

            if (TesteDatas.diferencaDias(data, candidatura.get(i).getDataCand()) == 0) {
                return i;
            }

        }
        return -1;

    }

    public String DataCand(int pos) {
        StringBuilder str = new StringBuilder();
        str.append(candidatura.get(pos));

        return str.toString();
    }

    public Candidaturas obterCandidatura(int pos) {

        return candidatura.get(pos);

    }

    public void removerCandidatura(int pos) {

        candidatura.remove(pos);

    }

    public String mostrarCandidaturasEliminar() {
        StringBuilder str = new StringBuilder();
        str.append("Candidaturas : ");
        for (int i = 0; i < candidatura.size(); i++) {
            if ((candidatura.get(i).getAprovacao() == null)) {
                str.append(candidatura.get(i));
            }
        }
        return str.toString();
    }

    public int verificarEliminar() {

        for (int i = 0; i < candidatura.size(); i++) {
            if (!"Aprovado".equals(candidatura.get(i).getAprovacao())) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * @return the manutencao
     */
    public ArrayList<Manutencoes> getManutencao() {
        return manutencao;
    }

    /**
     * @param manutencao the manutencao to set
     */
    public void setManutencao(ArrayList<Manutencoes> manutencao) {
        this.manutencao = manutencao;
    }

    public void adicionarManutencao(Manutencoes m) {
        m.setNumero(manutencao.size() + 1);
        manutencao.add(m);

    }

    public String mostrarManutencoes() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < manutencao.size(); i++) {

            str.append(manutencao.get(i).getVeic());

        }

        return str.toString();
    }

    public int verificarManutencoesT() {
        if (!manutencao.isEmpty()) {
            return 1;
        }

        return 0;
    }

    public String pesquisarManutencao(int numchassi) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < manutencao.size(); i++) {

            if (numchassi == manutencao.get(i).getVeic().getNumchassi()) {

                str.append(manutencao.get(i)).append("\n\n");
            }

        }

        return str.toString();
    }

    public int verificarManutencao(int numchassi) {

        for (int i = 0; i < manutencao.size(); i++) {

            if (numchassi == manutencao.get(i).getVeic().getNumchassi()) {

                return 1;
            }

        }

        return -1;
    }

    public int estatisticaAvaria() {

        int contador = 0, percentagem;

        for (int i = 0; i < veiculos.size(); i++) {

            if (veiculos.get(i).getAvaria() == 1) {

                contador++;
            }

        }
        if (contador != 0) {
            percentagem = (contador / veiculos.size()) * 100;

            return percentagem;
        }

        return 0;
    }

    public void gravarFicheiro() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Gestao2.dat"));
            out.writeObject(tipos);
            out.writeObject(veiculos);
            out.writeObject(funcionario);
            out.writeObject(candidatura);
            out.writeObject(ocorrencia);
            out.writeObject(manutencao);

            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void lerFicheiro() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Gestao2.dat"));
            tipos = (ArrayList<Tipo_de_veiculo>) in.readObject();
            veiculos = (ArrayList<Veiculos>) in.readObject();
            funcionario = (ArrayList<Funcionarios>) in.readObject();
            candidatura = (ArrayList<Candidaturas>) in.readObject();
            ocorrencia = (ArrayList<Ocorrencias>) in.readObject();
            manutencao = (ArrayList<Manutencoes>) in.readObject();

            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int manutencoes_atraso() {

        int contador = 0;
        for (int i = 0; i < veiculos.size(); i++) {

            if (TesteDatas.diferencaAnos(veiculos.get(i).getDataUltimaManutencao(), Calendar.getInstance(Locale.ROOT)) > 1) {
                contador++;

            }

        }

        return contador;
    }

    public String custo_por_tipo() {
        StringBuilder str = new StringBuilder();
        if (!manutencao.isEmpty()) {

            for (int i = 0; i < tipos.size(); i++) {

                str.append("\nTipo").append(tipos.get(i).getDesignacao()).append(" Custo:").append(tipos.get(i).getCusto()).append("€\n");

            }

        } else {
            System.out.println("0");
        }
        return str.toString();
    }

    public Calendar compararDatasReturn(Calendar data1, Calendar data2) {

        if (data1.compareTo(data2) > 0) {
            return data1;
        } else if (data1.compareTo(data2) < 0) {
            return data2;
        } else if (data1.compareTo(data2) == 0) {
            return data2;

        }
        return null;
    }

}
