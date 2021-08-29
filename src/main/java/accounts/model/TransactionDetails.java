package accounts.model;

import accounts.service.TransactionDetailId;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TransactionDetailId.class)
public class TransactionDetails implements Serializable {
    private static  final long serialVersionUID = -2278378980274128894L;
    @Id
    private Long id;
    @Id
    private Long accountNumber;
    private Date valueDate;
    private String debitAmount;
    private String creditAmount;
    private String debitCredit;
    private String transactionNarrative;

    public TransactionDetails(Long id, Long accountNumber, Date valueDate, String debitAmount, String creditAmount, String debitCredit, String transactionNarrative) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.valueDate = valueDate;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.debitCredit = debitCredit;
        this.transactionNarrative = transactionNarrative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getDebitCredit() {
        return debitCredit;
    }

    public void setDebitCredit(String debitCredit) {
        this.debitCredit = debitCredit;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    public void setTransactionNarrative(String transactionNarrative) {
        this.transactionNarrative = transactionNarrative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDetails that = (TransactionDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(valueDate, that.valueDate) && Objects.equals(debitAmount, that.debitAmount) && Objects.equals(creditAmount, that.creditAmount) && Objects.equals(debitCredit, that.debitCredit) && Objects.equals(transactionNarrative, that.transactionNarrative);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, valueDate, debitAmount, creditAmount, debitCredit, transactionNarrative);
    }

    public TransactionDetails() {
    }
}
