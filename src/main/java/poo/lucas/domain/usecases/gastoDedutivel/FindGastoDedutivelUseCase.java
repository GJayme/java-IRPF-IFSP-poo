package poo.lucas.domain.usecases.gastoDedutivel;

import poo.lucas.domain.entities.gasto.GastoDedutivel;

import java.util.List;
import java.util.Optional;

public class FindGastoDedutivelUseCase {
    private GastoDedutivelDAO GastoDedutivelDAO;

    public FindGastoDedutivelUseCase(GastoDedutivelDAO GastoDedutivelDAO) {
        this.GastoDedutivelDAO = GastoDedutivelDAO;
    }

    public List<GastoDedutivel> findAll(){
        return GastoDedutivelDAO.findAll();
    }
}
