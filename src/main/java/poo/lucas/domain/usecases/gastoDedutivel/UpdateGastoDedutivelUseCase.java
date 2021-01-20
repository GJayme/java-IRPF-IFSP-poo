package poo.lucas.domain.usecases.gastoDedutivel;

import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.usecases.utils.EntityNotFoundException;

public class UpdateGastoDedutivelUseCase {
    private GastoDedutivelDAO gastoDedutivelDAO;

    public UpdateGastoDedutivelUseCase(GastoDedutivelDAO gastoDedutivelDAO) {
        this.gastoDedutivelDAO = gastoDedutivelDAO;
    }

    public boolean update(GastoDedutivel gastoDedutivel){

        String cnpj = gastoDedutivel.getCnpj();

        if(gastoDedutivelDAO.findOne(cnpj).isEmpty()){
            throw new EntityNotFoundException("Gasto não encontrado.");
        }

        return gastoDedutivelDAO.update(gastoDedutivel);
    }
}
