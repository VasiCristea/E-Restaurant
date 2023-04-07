package DataAccess;
import Models.Receipt;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ReceiptsDAO implements IReceiptsDAO {
    private final String receiptFilePath = "receipt.json";
    private ArrayList<Receipt> _receipt;
    public ReceiptsDAO() {
        _receipt = new ArrayList();
        ReadFromFile();
    }

    public List<Receipt> get_receipts() {
        return _receipt;
    }

    @Override
    public Optional<Receipt> GetReceiptById(UUID receiptId) {
        return this._receipt.stream().filter(x -> x.getId() == receiptId).findFirst();
    }

    @Override
    public UUID SaveReceipt(Receipt receipt) {
        receipt.prepareForSaving();
        if(null == receipt.getId()) {
            receipt.setId(UUID.randomUUID());
            this._receipt.add(receipt);
        }else {
            this._receipt.stream().filter(x -> x.getId().equals(receipt.getId())).findAny().map(x -> x.updateBy(receipt));
        }
        SaveToFile();
        return receipt.getId();
    }


    @Override
    public boolean ReadFromFile() {
        ObjectMapper receiptsMapper = new ObjectMapper();
        try {
            _receipt = receiptsMapper.readValue(new File(receiptFilePath), _receipt.getClass());
        } catch (IOException e) {
            System.out.println("Error on reading the receipts from file.");
            return false;
        }
        return true;
    }

    @Override
    public boolean SaveToFile() {
        ObjectMapper receiptsMapper = new ObjectMapper();
        try {
            receiptsMapper.writeValue(new File(receiptFilePath), _receipt);
        } catch (IOException e) {
            System.out.println("Error on saving receipts to file.");
            return false;
        }
        return true;
    }

    @Override
    public void DeleteReceipt(Receipt receipt) {
        this._receipt.removeIf(x -> x.getId() == receipt.getId());
        SaveToFile();
    }
}
