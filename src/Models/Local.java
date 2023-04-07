package Models;

import Enums.LocalTypes;

import java.util.UUID;

public class Local {
    private UUID Id;
    private LocalTypes Type;
    private String Name;
    private String Company;
    private String Address;

    public Local() {
    }

    public Local(LocalTypes type, String name, String company, String address) {
        Type = type;
        Name = name;
        Company = company;
        Address = address;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public LocalTypes getType() {
        return Type;
    }

    public void setType(LocalTypes type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Local updateBy(Local local) {
        this.Id = local.Id;
        return this;
    }
}
