package poo.lucas.application.main;

import poo.lucas.application.repository.inmemory.InMemoryGastoDedutivelDAO;
import poo.lucas.application.view.WindowPrincipal;
import poo.lucas.domain.usecases.gastoDedutivel.CreateGastoDedutivelUseCase;
import poo.lucas.domain.usecases.gastoDedutivel.FindGastoDedutivelUseCase;
import poo.lucas.domain.usecases.gastoDedutivel.GastoDedutivelDAO;

public class Main {

    public static CreateGastoDedutivelUseCase createGastoDedutivelUseCase;
    public static FindGastoDedutivelUseCase findGastoDedutivelUseCase;

    public static void main(String[] args) {
        configureInjection();
        setupDatabase();
        WindowPrincipal.main(args);
    }

    private static void setupDatabase() {
    }

    private static void configureInjection() {
        GastoDedutivelDAO gastoDAO = new InMemoryGastoDedutivelDAO();
        createGastoDedutivelUseCase = new CreateGastoDedutivelUseCase(gastoDAO);
        findGastoDedutivelUseCase = new FindGastoDedutivelUseCase(gastoDAO);
    }
}
