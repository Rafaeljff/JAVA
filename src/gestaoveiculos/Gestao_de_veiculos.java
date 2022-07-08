/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoveiculos;

import testedatas.TesteDatas;
import static gestaoveiculos.Gestao_de_veiculos.gv;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import util.Consola;

/**
 *
 * @author Rafael
 */
public class Gestao_de_veiculos {

    public static Gestao2 gv = new Gestao2();

    public static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    //** Formato da data, copiado do projeto PHerança */

    public static void main(String[] args) {

        gv.lerFicheiro();
        int op, op1, op2, op3, op4, op5, op6, op7, veiculo = 0;

        do {
            op = menu();
            switch (op) {
                case 1:
                    op1 = menu_tipo_de_veiculos();
                    switch (op1) {
                        case 1:
                            adicionarTipoVeiculos();
                            break;

                        case 2:
                            System.out.println(gv.mostrarTipos());
                            break;

                    }

                    break;
                case 2:
                    op2 = menu_veiculos();
                    switch (op2) {
                        case 1:
                            adicionarVeiculo();

                            break;
                        case 2:

                            ConsultarVeiculosTipo();

                            break;

                    }

                    break;
                case 3:
                    op3 = menu_funcionarios();
                    switch (op3) {
                        case 1:
                            adicionarFuncionario();

                            break;
                        case 2:
                            System.out.println(gv.mostrarNif());
                            System.out.println(gv.pesquisarFuncionario());

                            break;

                    }
                    break;

                case 4:
                    op4 = menu_candidaturas();

                    switch (op4) {
                        case 1:

                            switch (gv.verificarFuncionario()) {
                                case 1:
                                    System.out.println(gv.MostarFuncionariosMaiores18());
                                    registarCandidatura();
                                    break;
                                case -1:
                                    System.out.println("Nao existem funcionarios inseridos ");
                                    break;
                                case 0:
                                    System.out.println("Nao existem funcionarios maiores de idade registados!");
                                    break;
                                default:
                                    break;
                            }

                            break;
                        case 2:
                            System.out.println(consultarCandidaturasData());
                            break;
                        case 3:
                            aprovarCandidatura();
                            break;
                        case 4:

                            removerCandidatura();
                            break;
                    }

                    break;
                case 5:
                    op5 = menu_ocorrencias();
                    switch (op5) {
                        case 1:
                            registarOcorrencia();
                            break;
                        case 2:
                            mudarEstadoOcorrencia();
                            break;
                        case 3:

                            ConsultarOcorrencias();
                            break;

                    }

                    break;
                case 6:
                    op6 = menu_manutencoes();

                    switch (op6) {
                        case 1:
                            registarManutencao();
                            break;
                        case 2:
                            pesquisarManutencaoVeic();

                            break;

                    }
                    break;
                case 7:

                    System.out.println("\nPercentagem de veículos que já tiveram pelo menos uma avaria:" + gv.estatisticaAvaria() + "%");

                    System.out.println("Total de veículos com manutenção em atraso: " + gv.manutencoes_atraso());

                    System.out.println("Custo total em manutenções por cada tipo de veículo: " + gv.custo_por_tipo());

                    break;
                default:
                    break;
            }
        } while (op != 0);
        gv.gravarFicheiro();
    }

    private static int menu() {
        int opcao;
        do {
            System.out.println("1 - Gestao do tipo de veiculos");
            System.out.println("2 - Gestao de veiculos");
            System.out.println("3 - Gestao de funcionarios");
            System.out.println("4 - Gestao de candidaturas");
            System.out.println("5 - Gestao de ocorrencias");

            System.out.println("6 - Gestao de manutencoes");
            System.out.println("7 - Estatisticas");
            System.out.println("0 - Sair");

            opcao = Consola.lerInt("Indique uma opção: ", 0, 7);
            return opcao;
        } while (opcao != 0);
    }

    private static int menu_tipo_de_veiculos() {
        int op;
        do {
            System.out.println("1 - Registar tipo de veículo");
            System.out.println("2 - Consultar todos os tipos de veículos");
            System.out.println("0 - Voltar ao menú principal");
            op = Consola.lerInt("Indique uma opção: ", 0, 2);
            return op;
        } while (op != 0);
    }

    private static int menu_veiculos() {

        int op;
        do {
            System.out.println("1 - Registar  veículo");
            System.out.println("2 - Consultar veículos por tipo de veículo");
            System.out.println("0 - Voltar ao menú principal");
            op = Consola.lerInt("Indique uma opção: ", 0, 2);
            return op;
        } while (op != 0);
    }

    private static int menu_funcionarios() {
        int op;

        do {
            System.out.println("1 - Registar  funcionário");
            System.out.println("2 - Consultar funcionário(por NIF)");
            System.out.println("0 - Voltar ao menú principal");
            op = Consola.lerInt("Indique uma opção: ", 0, 2);
            return op;
        } while (op != 0);
    }

    private static int menu_manutencoes() {
        int op;

        do {
            System.out.println("1 - Registar  manutenção");
            System.out.println("2 - Consultar manutenção por veículo");
            System.out.println("0 - Voltar ao menú principal");
            op = Consola.lerInt("Indique uma opção: ", 0, 2);
            return op;
        } while (op != 0);
    }

    private static int menu_candidaturas() {

        int op;
        do {

            System.out.println("1 - Registar  candidatura");
            System.out.println("2 - Consultar candidaturas por data");
            System.out.println("3 - Aprovar candidatura");
            System.out.println("4 - Eliminar candidatura");
            System.out.println("0 - Voltar ao menú principal");

            op = Consola.lerInt("Indique uma opção: ", 0, 4);
            return op;
        } while (op != 0);
    }

    private static int menu_ocorrencias() {

        int op;
        do {

            System.out.println("1 - Registar  ocorrência");
            System.out.println("2 - Alterar estado da ocorrência");
            System.out.println("3 - Consultar ocorrências por veículo");
            System.out.println("0 - Voltar ao menú principal");
            op = Consola.lerInt("Indique uma opção: ", 0, 3);
            return op;

        } while (op != 0);
    }

    private static void adicionarTipoVeiculos() {

        String designacao;

        designacao = Consola.lerString("Indique a designação do tipo de veiculo: ");

        Tipo_de_veiculo tipo_v = new Tipo_de_veiculo(designacao);

        gv.adicionarTipoVeiculo(tipo_v);
        System.out.println("Tipo inserido com sucesso!");
    }

    private static void adicionarVeiculo() {

        String descricao;
        int numchassi, pos, nif;

        pos = gv.verificarTipos();
        if (pos != 0 && gv.verificarFuncionariosTecnicos() == 1) {
            System.out.println(gv.MostarFuncionariosTecnicos());
            do {

                nif = Consola.lerInt("Nif do técnico:", 1, 1000000000);
                gv.obterFuncionarioTecncico(nif);
            } while (gv.obterFuncionarioTecncico(nif) == null);

            descricao = Consola.lerString("Indique a designação do veiculo: ");

            do {

                numchassi = Consola.lerInt("Indique o número do chassi: ", 1, 1000000);
            } while (gv.pesquisarNum_chassi(numchassi) == -1);

            do {
                System.out.println(gv.mostrarTipos());
                int numero_do_tipo = Consola.lerInt("Indique o número do tipo: ", 1, 1000000);

                pos = gv.pesquisarTipoVeiculo(numero_do_tipo);
                if (pos == -1) {
                    System.out.println("Não existe esse tipo");
                }
            } while (pos == -1);

            Tipo_de_veiculo tipo = gv.obterTipoVeiculo(pos);

            Veiculos veic = new Veiculos(descricao, numchassi, tipo);

            gv.adicionarVeiculo(veic);
            tipo.adicionarVeiculo(veic);
            tipo.setNumVeiculos(tipo.getNumVeiculos() + 1);
            System.out.println("Veiculo registado com sucesso");
        } else if (pos == 0) {
            System.out.println("Não existem tipos inseridos");
        } else if (gv.verificarFuncionariosTecnicos() != 1) {
            System.out.println("Não existem técnicos para inventariar os veículos");
        }

    }

    private static void adicionarFuncionario() {
        int nif;
        int pos;

        int telefone;

        String nome;
        String morada;
        String funcao;

        String dataN;
        int idade = 0;
        int errodn = 0, errode = 0;
        Calendar dataNasc = new GregorianCalendar();

        do {
            nif = Consola.lerInt("Inserir Nif: ", 0, 999999999);

            pos = gv.pesquisarNif(nif);

            if (pos != -1) {

                System.out.println("Nif já existente! ");

            }

        } while (pos != -1);

        telefone = Consola.lerInt("Inserir telefone: ", 0, 999999999);
        nome = Consola.lerString("Inserir nome:");
        morada = Consola.lerString("Indique a morada: ");
        funcao = Consola.lerString("Indique a função do funcionário:");

        do {
            do {
                errodn = 0;
                try {
                    dataN = Consola.lerString("Indique a data de nascimento do funcionario (dd-mm-yyyy): ");
                    dataNasc.setTime(formato.parse(dataN));
                } catch (ParseException e) {
                    errodn = 1;

                    System.err.println("Data de nascimento com formato inválido!");
                }
            } while (errodn == 1);
            idade = TesteDatas.diferencaAnos(dataNasc, Calendar.getInstance(Locale.ENGLISH));
            if (idade < 16) {
                System.out.println("O funcionario tem de ter pelo menos 16 anos");
            }

        } while (idade < 16);

        Funcionarios func = new Funcionarios(nif, nome, morada, telefone, funcao, dataNasc, idade);
        gv.adicionarFuncionario(func);
        System.out.println("Funcionario registado com sucesso!");
    }

    private static void registarCandidatura() {

        String descricao, validacao, dataC;

        Funcionarios func;

        Calendar dataCandidatura = new GregorianCalendar();
        int errodn, nif = 0;

        do {
            nif = Consola.lerInt("Nif:", 1, 100000000);
            func = gv.obterFuncionario(nif);
        } while (func == null);

        descricao = Consola.lerString("Descrição de candidatura: ");

        do {
            errodn = 0;
            try {
                dataC = Consola.lerString("Indique a data de candidatura (dd-mm-yyyy): ");
                dataCandidatura.setTime(formato.parse(dataC));
            } catch (ParseException e) {
                errodn = 1;
                System.err.println("Data de nascimento com formato inválido!");
            }
        } while (errodn == 1);

        do {
            validacao = Consola.lerString("Carta de condução válida 1-Sim 0-Não: ");

            if (!"1".equals(validacao) && !"0".equals(validacao)) {

                System.out.println("Inválido! Insira os números 0 ou 1 ");
            }

        } while (!"1".equals(validacao) && !"0".equals(validacao));
        if ("1".equals(validacao)) {
            System.out.println("Valida");
            validacao = "Valida";
        }

        if ("0".equals(validacao)) {

            validacao = "invalida";
        }

        Candidaturas cand = new Candidaturas(descricao, func, validacao, dataCandidatura);
        Funcionarios f = gv.obterFuncionario(nif);
        f.setCandidaturas(cand);

        gv.adicionarCandidatura(cand);
        System.out.println("Candidatura submetida com sucesso!");

    }

    private static void aprovarCandidatura() {
        int a, b, errodn, cand;
        String dataIni, dataFin;
        Calendar dataInicial = new GregorianCalendar();
        Calendar dataFinal = new GregorianCalendar();
        StringBuilder str = new StringBuilder();
        int tempo_aluger;
        a = gv.verificarCandidaturas();
        b = gv.verificarDisponivilidadeVeiculos();
        if (gv.verificarCandidaturasT() == 1 && gv.verificarVeiculosT() == 1 && a == 1 && b == 1) {

            System.out.println(gv.mostrar_candidaturas_disponiveis());

            do {
                cand = Consola.lerInt("Numero da candidatura a aprovar: ", 0, 100000);
                a = gv.verificarDisponivilidadeCandidatura(cand);
            } while (a == -1);
            System.out.println(gv.mostrar_veiculos_candidatura());
            do {
                int veic = Consola.lerInt("Inserir o nº de chassi do veiculo a alugar: ", 0, 100000);
                b = gv.verificarDisponivilidadeVeiculo(veic);
            } while (b == -1);
            do {
                do {
                    errodn = 0;
                    try {
                        dataIni = Consola.lerString("Indique a data inicial de aluger (dd-mm-yyyy): ");
                        dataInicial.setTime(formato.parse(dataIni));
                    } catch (ParseException e) {
                        errodn = 1;
                        System.err.println("Data inválida!");
                    }
                } while (errodn == 1);

                do {
                    errodn = 0;
                    try {
                        dataFin = Consola.lerString("Indique a data final de aluger (dd-mm-yyyy): ");
                        dataFinal.setTime(formato.parse(dataFin));
                    } catch (ParseException e) {
                        errodn = 1;
                        System.err.println("Data inválida!");
                    }
                } while (errodn == 1);

                tempo_aluger = TesteDatas.diferencaMeses(dataInicial, dataFinal);

                if (tempo_aluger > 6) {

                    System.out.println("O tempo de aluger nao pode ultrapassar os 6 meses!");
                }

            } while (tempo_aluger > 6 && gv.compararDatasReturn(dataFinal, dataFinal) == dataInicial);

            Candidaturas candidatura = gv.obterCandidaturaPos(a);

            candidatura.setAprovacao("Aprovado");
            candidatura.setDataInic(dataInicial);
            candidatura.setDataFin(dataFinal);

            Veiculos veiculo = gv.obterVeiculoPos(b);
            veiculo.setAluger_veic("Alugado");
            veiculo.setNumcandidatura(veiculo.getNumcandidatura() + 1);
            candidatura.setVeiculo(veiculo);
            System.out.println("Candidatura aprovada com sucesso!");
        } else if (a != 1) {
            System.out.println("Não existem candidaturas a ser aprovadas!");
        } else if (b != 1) {
            System.out.println("Nao existem veiculos disponiveis para alugar!");
        } else if (gv.verificarCandidaturasT() != 1) {
            System.out.println("Nao existem Candidaturas registadas!");
        } else if (gv.verificarVeiculosT() != 1) {
            System.out.println("Nao existem veiculos registados!");
        }
    }

    private static void registarOcorrencia() {

        String descricao, estado;
        Veiculos veic;
        Funcionarios func;
        String dataOcor;
        int nif;
        Calendar dataOcorrencia = new GregorianCalendar();
        int errodn, a;
        if (gv.verificarFuncionariosT() == 1 && gv.verificarVeiculosT() == 1) {

            System.out.println(gv.mostrar_Veiculos());
            do {
                int num_chassi = Consola.lerInt("num do chassi:", 0, 10000000);
                a = gv.verificarVeiculo(num_chassi);
            } while (a == -1);

            do {
                estado = Consola.lerString("Estado do veículo(1-por reparar 2-irreparável) ");
            } while (!"1".equals(estado) && !"2".equals(estado));
            switch (estado) {
                case "1":
                    estado = "por reparar";
                    break;
                case "2":
                    estado = "irreparavél";
                    break;

            }

            descricao = Consola.lerString("Descrição da ocorrencia:");

            System.out.println(gv.MostarFuncionarios());

            do {
                nif = Consola.lerInt("Nif do funcionario:", 1, 100000000);
                func = gv.obterFuncionario(nif);
            } while (func == null);

            do {
                errodn = 0;
                try {
                    dataOcor = Consola.lerString("Indique a data de ocorrência (dd-mm-yyyy): ");
                    dataOcorrencia.setTime(formato.parse(dataOcor));
                } catch (ParseException e) {
                    errodn = 1;
                    System.err.println("Data de ocorrência com formato inválido!");
                }
            } while (errodn == 1);

            veic = gv.obterVeiculoPos(a);
            veic.setAvaria(1);

            Ocorrencias ocorr = new Ocorrencias(veic, estado, descricao, func, dataOcorrencia);

            gv.adicionarOcorrencia(ocorr);
            System.out.println("Ocorrência registada com sucesso!");
        } else {
            System.out.println("Não existem funcionários ou veiculos registados!");
        }
    }

    private static void mudarEstadoOcorrencia() {
        int a, custo, errodn;
        String estado, descricaoMan, dataMan;
        Calendar dataManutencao = new GregorianCalendar();
        if (gv.verificarOcorrencias() == 0) {

            System.out.println(gv.mostrar_Ocorrencias());
            do {
                int num = Consola.lerInt("Número da ocorrência a alterar estado:", 0, 100000);
                a = gv.obterOcorrenciaPos(num);
            } while (a == -1);

            do {
                estado = Consola.lerString("Estado do veículo( 1-reparado");
            } while (!"1".equals(estado));
            switch (estado) {
                case "1":
                    estado = "reparado";
                    break;

            }

            Ocorrencias ocorrencia = gv.obterOcorrencia(a);
            if ("reparado".equals(estado)) {

                System.out.println("Registar manutencao");
                custo = Consola.lerInt("Custo da manutenção", 0, 10000);
                descricaoMan = Consola.lerString("Descrição da manutenção:");

                do {
                    errodn = 0;
                    try {
                        dataMan = Consola.lerString("Indique a data de manutenção (dd-mm-yyyy): ");
                        dataManutencao.setTime(formato.parse(dataMan));
                    } catch (ParseException e) {
                        errodn = 1;
                        System.err.println("Data  com formato inválido!");
                    }
                } while (errodn == 1);

                Manutencoes man = new Manutencoes(ocorrencia.getVeic(), custo, descricaoMan, ocorrencia.getFuncionario(), dataManutencao);
                gv.adicionarManutencao(man);
            }

            ocorrencia.setEstado(estado);

        }

    }

    private static void ConsultarOcorrencias() {
        int pos;
        if (gv.verificarTodasOcorrencias() == 1) {

            System.out.println(gv.mostrarVeiculosOcorrencias());
            do {
                int num_chassi = Consola.lerInt("Número de chassi:", 0, 10000000);

                pos = gv.consultarOcorrenciasVeiculoPos(num_chassi);
            } while (pos == -1);
            System.out.println(gv.consultarOcorrenciasVeiculo(pos));

        } else {
            System.out.println("Não existem ocorrências registadas!");
        }
    }

    private static String consultarCandidaturasData() {
        StringBuilder str = new StringBuilder();
        String dataCand;

        Calendar dataCandidatura = new GregorianCalendar();
        int errodn, pos, comparador;
        if (gv.verificarCandidaturasT() == 1) {

            System.out.println(gv.mostrarDatasCandidaturas());
            do {
                do {

                    errodn = 0;
                    try {
                        dataCand = Consola.lerString("Indique a data de Candidatura (dd-mm-yyyy): ");
                        dataCandidatura.setTime(formato.parse(dataCand));
                    } catch (ParseException e) {
                        errodn = 1;
                        System.err.println("Data de Candidatura com formato inválido!");
                    }
                } while (errodn == 1);

                pos = gv.DataCandPos(dataCandidatura);
            } while (pos == -1);

            System.out.println(gv.DataCand(pos));

        } else {
            System.out.println("Não existem candidaturas registadas!");
        }
        return str.toString();
    }

    private static void removerCandidatura() {
        int numero, pos;
        if (gv.verificarEliminar() == 1) {
            do {
                System.out.println(gv.mostrarCandidaturasEliminar());
                numero = Consola.lerInt("Indique o número da candidatura:",
                        1, 1000);
                pos = gv.verificarTodasCandidaturasEliminar(numero);

            } while (pos == -1);

            gv.removerCandidatura(pos);

            System.out.println("Candidatura removida com sucesso!");

        } else {
            System.out.println("Não existem candidaturas para eliminar!");
        }
    }

    private static void registarManutencao() {

        String descricao, dataMan;
        Veiculos veic;
        Funcionarios func;
        int custo;

        Calendar dataManutencao = new GregorianCalendar();
        int errodn, nif, a;
        if (gv.verificarFuncionariosT() == 1 && gv.verificarVeiculosT() == 1 && gv.verificarFuncionariosTecnicos() == 1) {

            System.out.println(gv.mostrar_Veiculos());
            do {
                int num_chassi = Consola.lerInt("num do chassi:", 0, 10000000);
                a = gv.verificarVeiculo(num_chassi);
            } while (a == -1);

            System.out.println(gv.MostarFuncionariosTecnicos());

            do {
                nif = Consola.lerInt("Nif do funcionario tecnico : ", 1, 100000000);
                func = gv.obterFuncionario(nif);
            } while (func == null);

            custo = Consola.lerInt("Custo da manutenção:", 0, 100000);

            descricao = Consola.lerString("Descrição da manutenção:");

            do {
                errodn = 0;
                try {
                    dataMan = Consola.lerString("Indique a data de manutencao (dd-mm-yyyy): ");
                    dataManutencao.setTime(formato.parse(dataMan));
                } catch (ParseException e) {
                    errodn = 1;
                    System.err.println("Data  com formato inválido!");
                }
            } while (errodn == 1);

            veic = gv.obterVeiculoPos(a);
            veic.getTipo().setCusto(veic.getTipo().getCusto() + custo);
            if (veic.getDataUltimaManutencao() != null) {
                veic.setDataUltimaManutencao(gv.compararDatasReturn(veic.getDataUltimaManutencao(), dataManutencao));
            } else {
                veic.setDataUltimaManutencao(dataManutencao);
            }
            Manutencoes man = new Manutencoes(veic, custo, descricao, func, dataManutencao);

            gv.adicionarManutencao(man);
            System.out.println("Manutenção registada com sucesso!");
        } else if (gv.verificarFuncionariosTecnicos() == 0 && gv.verificarFuncionariosT() == 1) {
            System.out.println("Não existem funcionários com a funcão tecnico registados!");
        } else if (gv.verificarFuncionariosT() == 0) {
            System.out.println("Não existem funcionários registados!");
        } else if (gv.verificarVeiculosT() == 0) {
            System.out.println("Não existem veiculos registados!");
        }
    }

    public static void pesquisarManutencaoVeic() {

        int num;

        if (gv.verificarManutencoesT() == 1) {

            System.out.println("Veiculos registados em manutenções:");
            System.out.println(gv.mostrarManutencoes());

            do {
                num = Consola.lerInt("\nNum chassi do veiculo a pesquisar manutenções:", 0, 10000);
                gv.verificarManutencao(num);
            } while (gv.verificarManutencao(num) == -1);
            System.out.println(gv.pesquisarManutencao(num));

        } else {
            System.out.println("Não existem manutenções!");
        }

    }

    private static void ConsultarVeiculosTipo() {

        int tipo, pos;
        if (gv.verificarVeiculosT() == 0) {
            System.out.println("Não há veiculos inseridos!");
        } else {
            System.out.println(gv.mostrarTipos());

            do {
                tipo = Consola.lerInt("Inserir o número do tipo de veiculo: ", 0, 1000);

                pos = gv.pesquisarTipoVeiculo(tipo);

                if (pos == -1) {
                    System.out.println("Não existe esse tipo");
                }
            } while (pos == -1);
            Tipo_de_veiculo tv = gv.obterTipoVeiculo(pos);
            System.out.println(tv.mostrarVeiculos());
        }
    }
}
