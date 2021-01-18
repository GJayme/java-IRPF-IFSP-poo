package poo.lucas.domain.usecases.gastoDedutivel;

import poo.lucas.domain.entities.gasto.GastoDedutivel;

public class CreateGastoDedutivelUseCase {

    private GastoDedutivelDAO gastoDedutivelDAO;

    public CreateGastoDedutivelUseCase(GastoDedutivelDAO gastoDedutivelDAO) {
        this.gastoDedutivelDAO = gastoDedutivelDAO;
    }

    public String create(GastoDedutivel gastoDedutivel){
        GastoDedutivel isGastoExiste = gastoDedutivelDAO.findOne(gastoDedutivel.getCnpj());

        if (isGastoExiste == null){
            return gastoDedutivelDAO.create(gastoDedutivel);
        }

        return null;
    }
}
