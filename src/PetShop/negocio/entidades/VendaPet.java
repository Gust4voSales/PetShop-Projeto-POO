package PetShop.negocio.entidades;

import PetShop.negocio.contratos.VendaAbstrata;

public class VendaPet extends VendaAbstrata {
    private PetPetshop pet;

    public VendaPet(PetPetshop pet){
        super();
        this.pet = pet;
    }

    public PetPetshop getPet() {
        return this.pet;
    }
}