package PetShop.dados;

import PetShop.dados.contratos.IRepositorioServicos;
import PetShop.negocio.contratos.ServicoAbstrato;

import java.util.ArrayList;
/**
 * Essa classe é reponsável por armazenar, e gerenciar a recuperação dos Serviços
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class Agenda implements IRepositorioServicos {
    private ArrayList<ServicoAbstrato> agenda;

    public Agenda(){
        this.agenda = new ArrayList<>();
    }

    @Override
    public void adicionarServico(ServicoAbstrato servico){
        this.agenda.add(servico);
    }

    @Override
    public void removerServico(ServicoAbstrato servico){
        this.agenda.remove(servico);
    }

    @Override
    public void atualizarServico(ServicoAbstrato servico){
        int index = this.agenda.indexOf(servico);

        this.agenda.set(index, servico);
    }

    @Override
    public ArrayList<ServicoAbstrato> consultarServicosCliente(String cpf) {
        ArrayList<ServicoAbstrato> servicosDoCliente = new ArrayList<>();

        for (ServicoAbstrato s: this.agenda){
            if (s.getCliente().getCpf().equals(cpf)){
                servicosDoCliente.add(s);
            }
        }
        return servicosDoCliente;
    }

    @Override
    public ArrayList<ServicoAbstrato> consultarServicosNaoConcluidos(String data){
        ArrayList<ServicoAbstrato> servicosNaoConcluidos = new ArrayList<>();

        for (ServicoAbstrato s: this.agenda){
            if(!s.getStatus().equals("Concluído") && s.getData().equals(data)){
                servicosNaoConcluidos.add(s);
            }
        }

        return servicosNaoConcluidos;
    }

    @Override
    public ArrayList<ServicoAbstrato> consultarServicosPorData(String data){
        ArrayList<ServicoAbstrato> servicos = new ArrayList<>();

        for (ServicoAbstrato s: this.agenda){

            if(data.equals(s.getData())){
                servicos.add(s);
            }
        }
        return servicos;
    }

    @Override
    public ArrayList<ServicoAbstrato> consultarServicos(){
        return this.agenda;
    }
}
