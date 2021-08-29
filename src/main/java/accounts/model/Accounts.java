package accounts.model;


import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.domain.Persistable;

@Entity
public
class Accounts implements Persistable<Long> {
    private @Id Long accountNumber;
    private String accountName;
    private String accountType;
    private Date balanceDate;
    private String currency;
    private String openingBalanceData;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "accountNumber", nullable = false, updatable = false, insertable = false)
    private List<TransactionDetails>transactionDetails;


    Accounts() {}


    public Accounts(long accountNumber, String accountName, String accountType, Date balanceDate, String currency, String openingBalanceData, List<TransactionDetails> transactionDetails) {

        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.openingBalanceData = openingBalanceData;
        this.transactionDetails = transactionDetails;
    }

    public Long getAccountNumber() {
        return this.accountNumber;
    }
    public String getAccountName() {
        return this.accountName;
    }
    public String getAccountType() {
        return this.accountType;
    }
    public Date getBalanceDate() {
        return this.balanceDate;
    }
    public String getCurrency() {
        return this.currency;
    }
    public String getOpeningBalanceData() {
        return this.openingBalanceData;
    }

    public List<TransactionDetails> getTransactionDetails() {
        return transactionDetails;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Accounts))
            return false;

        Accounts account = (Accounts) o;
        return  Objects.equals(this.accountNumber, account.accountNumber)
                && Objects.equals(this.accountName, account.accountName) && Objects.equals(this.accountType, account.accountType)
                && Objects.equals(this.balanceDate, account.balanceDate) && Objects.equals(this.currency, account.currency)
                && Objects.equals(this.openingBalanceData, account.openingBalanceData);
    }

    @Override

    public int hashCode() {
        return Objects.hash(this.accountNumber, this.accountName, this.accountType, this.balanceDate, this.currency, this.openingBalanceData);
    }

    @Override

    public String toString() {
        return "Accounts{" + "accountNumber='" + this.accountNumber + '\'' + ", accountName='" + this.accountName
                + '\'' + ", accountType='" + this.accountType + '\'' + ", balanceData='" + this.balanceDate + '\'' + ", currency='" + this.currency + '\'' + ", openingBalanceData='" + this.openingBalanceData + '\'' +'}';
    }

    @Override
    public Long getId() {
        return accountNumber;
    }

    @Override
    public boolean isNew() {
        return true;
    }

}