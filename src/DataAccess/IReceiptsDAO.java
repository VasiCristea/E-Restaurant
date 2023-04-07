package DataAccess;

import Models.Receipt;

import java.util.Optional;
import java.util.UUID;

public interface IReceiptsDAO {
    Optional<Receipt> GetReceiptById(UUID receiptId);

    UUID SaveReceipt(Receipt receipt);

    boolean ReadFromFile();

    boolean SaveToFile();

    void DeleteReceipt(Receipt receipt);
}
