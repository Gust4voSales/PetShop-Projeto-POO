package PetShop.negocio.entidades;
/**
 * Essa classe representa os produtos do Petshop
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class Produto {
    private String nome, id, marca;
    private double preco;
    private int quantidade;

    public Produto(String nome, String marca, double preco, String id, int quantidade){
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.id = id;
        this.quantidade = quantidade;
    }
//------------------------ GETTERS -------------------------
    public String getNome(){
        return this.nome;
    }

    public String getMarca(){
        return this.marca;
    }

    public double getPreco(){
        return this.preco;
    }

    public String getId(){
        return this.id;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

//--------------------------SETTERS-----------------------------
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
// ---------

}
