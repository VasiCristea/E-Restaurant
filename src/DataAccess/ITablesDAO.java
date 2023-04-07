package DataAccess;

import Models.Table;

import java.util.Optional;
import java.util.UUID;

public interface ITablesDAO {
    Optional<Table> GetTableById(UUID tableId);
    UUID SaveTable(Table table);
    boolean ReadFromFile();
    boolean SaveToFile();
    void DeleteTable(Table table);
}
