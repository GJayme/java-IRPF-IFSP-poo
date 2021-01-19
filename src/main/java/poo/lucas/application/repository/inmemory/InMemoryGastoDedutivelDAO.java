package poo.lucas.application.repository.inmemory;

import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.usecases.gastoDedutivel.GastoDedutivelDAO;

import java.util.*;

public class InMemoryGastoDedutivelDAO implements GastoDedutivelDAO {

    private static final Map<String,GastoDedutivel> gastos = new LinkedHashMap<>();

    @Override
    public String create(GastoDedutivel gastoDedutivel) {
        gastos.put(gastoDedutivel.getCnpj(), gastoDedutivel);
        return gastoDedutivel.getCnpj();
    }

    @Override
    public boolean update(GastoDedutivel type) {
        return false;
    }

    @Override
    public List<GastoDedutivel> findAll() {
        return new ArrayList<>(gastos.values());
    }

    @Override
    public Optional<GastoDedutivel> findOne(String key) {
        if (gastos.containsKey(key)){
            return Optional.of(gastos.get(key)) ;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(GastoDedutivel type) {
        return false;
    }
}
