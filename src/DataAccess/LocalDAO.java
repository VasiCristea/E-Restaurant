package DataAccess;

import Models.Local;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class LocalDAO implements ILocalDAO {
    private final String localFilePath = "locals.json";
    private ArrayList<Local> _locals;
    public LocalDAO() {
        _locals = new ArrayList();
        ReadFromFile();
    }

    public ArrayList<Local> get_locals() {
        return _locals;
    }

    @Override
    public Optional<Local> GetLocalById(UUID localId) {
        return this._locals.stream().filter(x -> x.getId() == localId).findFirst();
    }

    @Override
    public UUID SaveLocal(Local local) {
        if(null == local.getId()) {
            local.setId(UUID.randomUUID());
            this._locals.add(local);
        }else {
            this._locals.stream().filter(x -> x.getId().equals(local.getId())).findAny().map(x -> x.updateBy(local));
        }
        SaveToFile();
        return local.getId();
    }


    @Override
    public boolean ReadFromFile() {
        ObjectMapper localsMapper = new ObjectMapper();
        try {
            _locals = localsMapper.readValue(new File(localFilePath), _locals.getClass());
        } catch (IOException e) {
            System.out.println("Error on reading the locals from file.");
            return false;
        }
        return true;
    }

    @Override
    public boolean SaveToFile() {
        ObjectMapper localsMapper = new ObjectMapper();
        try {
            localsMapper.writeValue(new File(localFilePath), _locals);
        } catch (IOException e) {
            System.out.println("Error on saving locals to file.");
            return false;
        }
        return true;
    }

    @Override
    public void DeleteLocal(Local local) {
        this._locals.removeIf(x -> x.getId() == local.getId());
        SaveToFile();
    }
}
