package poo.lucas.domain.usecases.gastoDedutivel;

import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.usecases.utils.EntityAlreadyExistisException;

public class CreateGastoDedutivelUseCase {

    private GastoDedutivelDAO gastoDedutivelDAO;

    public CreateGastoDedutivelUseCase(GastoDedutivelDAO gastoDedutivelDAO) {
        this.gastoDedutivelDAO = gastoDedutivelDAO;
    }

    public String create(GastoDedutivel gastoDedutivel){

        String cnpj = gastoDedutivel.getCnpj();

        if (gastoDedutivelDAO.findOne(cnpj).isPresent()){
            throw new EntityAlreadyExistisException("Esse CNPJ já foi cadastrado.");
        }

        return gastoDedutivelDAO.create(gastoDedutivel);
    }
}
