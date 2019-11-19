package negocio.entidades;

public class PetPetshop{
    private String idade;
    private double peso;
    private double tamanho;
    private double preco;
    private String especie;
    private String sexo;

    public PetPetshop(String especie, String sexo, String idade, double peso, double tamanho, double preco){
        this.especie = especie;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    //--------------------------GETTERS--------------------------
    public String getIdade(){
        return this.idade;
    }

    public double getPeso(){
        return this.peso;
    }

    public double getTamanho(){
        return this.tamanho;
    }

    public double getPreco(){
        return this.preco;
    }

    public String getEspecie(){
        return this.especie;
    }

    public String getSexo(){
        return this.sexo;
    }

//---------------------------SETTERS--------------------------

    public void setIdade(String idade){
        this.idade = idade;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setTamanho(double tamanho){
        this.tamanho = tamanho;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

//-----------------------------------------------------------

    @Override
    public String toString(){
        return" idade:"+this.idade+"."+"Peso:"+this.peso+"."+"Tamanho:"+this.tamanho+"."+"Preco:"+this.preco+"."+"Especie:"+this.especie+"."+"Sexo"+this.sexo+".";
    }
}