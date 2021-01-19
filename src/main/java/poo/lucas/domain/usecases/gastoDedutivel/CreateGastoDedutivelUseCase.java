package poo.lucas.domain.usecases.gastoDedutivel;

import poo.lucas.domain.entities.gasto.GastoDedutivel;

public class CreateGastoDedutivelUseCase {

    private GastoDedutivelDAO gastoDedutivelDAO;

    public CreateGastoDedutivelUseCase(GastoDedutivelDAO gastoDedutivelDAO) {
        this.gastoDedutivelDAO = gastoDedutivelDAO;
    }

    public String create(GastoDedutivel gastoDedutivel){

        String cnpj = gastoDedutivel.getCnpj();

        if (gastoDedutivelDAO.findOne(cnpj).isPresent()){
            throw new IllegalArgumentException("This cnpj is already in use.");
        }

        return gastoDedutivelDAO.create(gastoDedutivel);
    }
}
