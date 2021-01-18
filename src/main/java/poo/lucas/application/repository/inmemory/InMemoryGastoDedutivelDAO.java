package poo.lucas.application.repository.inmemory;

import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.usecases.gastoDedutivel.GastoDedutivelDAO;

import java.util.ArrayList;
import java.util.List;

public class InMemoryGastoDedutivelDAO implements GastoDedutivelDAO {

    private static final List<GastoDedutivel> gastos = new ArrayList<>();

    @Override
    public String create(GastoDedutivel gastoDedutivel) {
        gastos.add(gastoDedutivel);
        return gastoDedutivel.toString();
    }

    @Override
    public boolean update(GastoDedutivel type) {
        return false;
    }

    @Override
    public List<GastoDedutivel> findAll() {
        return new ArrayList<>(gastos);
    }

    @Override
    public GastoDedutivel findOne(String key) {
        return null;
    }

    @Override
    public boolean delete(GastoDedutivel type) {
        return false;
    }
}
