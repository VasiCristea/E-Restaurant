package DataAccess;

import Models.Table;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TablesDAO implements ITablesDAO {
    private final String tableFilePath = "tables.json";
    private ArrayList<Table> _tables;
    public TablesDAO() {
        _tables = new ArrayList();
        ReadFromFile();
    }

    public List<Table> get_tables() {
        return _tables;
    }

    @Override
    public Optional<Table> GetTableById(UUID tableId) {
        return this._tables.stream().filter(x -> x.getId() == tableId).findFirst();
    }

    @Override
    public UUID SaveTable(Table table) {
        if(null == table.getId()) {
            table.setId(UUID.randomUUID());
            this._tables.add(table);
        }else {
            this._tables.stream().filter(x -> x.getId().equals(table.getId())).findAny().map(x -> x.updateBy(table));
        }
        SaveToFile();
        return table.getId();
    }


    @Override
    public boolean ReadFromFile() {
        ObjectMapper tablesMapper = new ObjectMapper();
        try {
            _tables = tablesMapper.readValue(new File(tableFilePath), _tables.getClass());
        } catch (IOException e) {
            System.out.println("Error on reading the tables from file.");
            return false;
        }
        return true;
    }

    @Override
    public boolean SaveToFile() {
        ObjectMapper tablesMapper = new ObjectMapper();
        try {
            tablesMapper.writeValue(new File(tableFilePath), _tables);
        } catch (IOException e) {
            System.out.println("Error on saving tables to file.");
            return false;
        }
        return true;
    }

    @Override
    public void DeleteTable(Table table) {
        this._tables.removeIf(x -> x.getId() == table.getId());
        SaveToFile();
    }
}
