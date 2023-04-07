package Models;

import Enums.TableStatus;

import java.security.cert.TrustAnchor;
import java.util.UUID;

public class Table {
    private UUID Id;
    private TableStatus Status;
    private int Number;

    public Table() {
    }

    public Table(TableStatus status, int number) {
        Status = status;
        Number = number;
    }

    public Table updateBy(Table table) {
        this.setId(table.getId());
        return this;
    }
    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public TableStatus getStatus() {
        return Status;
    }

    public void setStatus(TableStatus status) {
        Status = status;
    }

}
