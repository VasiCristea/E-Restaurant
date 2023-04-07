package DataAccess;

import Models.Local;

import java.util.Optional;
import java.util.UUID;

public interface ILocalDAO {
    Optional<Local> GetLocalById(UUID localId);
    UUID SaveLocal(Local local);
    boolean ReadFromFile();
    boolean SaveToFile();
    void DeleteLocal(Local local);
}
