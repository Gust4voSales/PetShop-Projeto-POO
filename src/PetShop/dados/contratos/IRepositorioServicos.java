package PetShop.dados.contratos;

import PetShop.negocio.contratos.ServicoAbstrato;

import java.util.ArrayList;

public interface IRepositorioServicos {
    void adicionarServico(ServicoAbstrato servico);
    void removerServico(ServicoAbstrato servico);
    void atualizarServico(ServicoAbstrato servico);
    ArrayList<ServicoAbstrato> consultarServicosCliente(String cpf);
    ArrayList<ServicoAbstrato> consultarServicosNaoConcluidos(String data);
    ArrayList<ServicoAbstrato> consultarServicosPorData(String data);
    ArrayList<ServicoAbstrato> consultarServicos();
}