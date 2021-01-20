package poo.lucas.application.repository.inmemory;

import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.usecases.gastoDedutivel.GastoDedutivelDAO;

import java.util.*;

public class InMemoryGastoDedutivelDAO implements GastoDedutivelDAO {

    private static final Map<String,GastoDedutivel> gastosDB = new LinkedHashMap<>();

    @Override
    public String create(GastoDedutivel gastoDedutivel) {
        gastosDB.put(gastoDedutivel.getCnpj(), gastoDedutivel);
        return gastoDedutivel.getCnpj();
    }

    @Override
    public Optional<GastoDedutivel> findOne(String key) {
        if (gastosDB.containsKey(key)){
            return Optional.of(gastosDB.get(key)) ;
        }
        return Optional.empty();
    }

    @Override
    public List<GastoDedutivel> findAll() {
        return new ArrayList<>(gastosDB.values());
    }

    @Override
    public boolean update(GastoDedutivel gastoDedutivel) {
        String cnpj = gastoDedutivel.getCnpj();
        if (gastosDB.containsKey(cnpj)){
            gastosDB.replace(cnpj, gastoDedutivel);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(GastoDedutivel gastoDedutivel) {
        String cnpj = gastoDedutivel.getCnpj();
        if (gastosDB.containsKey(cnpj)){
            gastosDB.remove(cnpj);
            return true;
        }
        return false;
    }
}
