package poo.lucas.domain.usecases.gastoDedutivel;

import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.usecases.utils.EntityNotFoundException;

public class DeleteGastoDedutivelUseCase {

    private GastoDedutivelDAO gastoDedutivelDAO;

    public DeleteGastoDedutivelUseCase(GastoDedutivelDAO gastoDedutivelDAO) {
        this.gastoDedutivelDAO = gastoDedutivelDAO;
    }

    public boolean delete (GastoDedutivel gastoDedutivel){
        if (gastoDedutivel == null || gastoDedutivelDAO.findOne(gastoDedutivel.getCnpj()).isEmpty()){
            throw new EntityNotFoundException("Gasto não encontrado.");
        }
        return gastoDedutivelDAO.delete(gastoDedutivel);
    }
}
