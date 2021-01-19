package poo.lucas.domain.usecases.gastoDedutivel;

import poo.lucas.domain.entities.gasto.GastoDedutivel;

import java.util.List;
import java.util.Optional;

public class FindGastoDedutivelUseCase {
    private GastoDedutivelDAO gastoDedutivelDAO;

    public FindGastoDedutivelUseCase(GastoDedutivelDAO GastoDedutivelDAO) {
        this.gastoDedutivelDAO = GastoDedutivelDAO;
    }

    public Optional<GastoDedutivel> findOne(String cnpj) {
        if (cnpj == null) {
            throw new IllegalArgumentException("CNPJ can not br null.");
        }
        return gastoDedutivelDAO.findOne(cnpj);
    }

    public List<GastoDedutivel> findAll(){
        return gastoDedutivelDAO.findAll();
    }
}
