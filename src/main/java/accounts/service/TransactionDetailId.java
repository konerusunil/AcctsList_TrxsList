package accounts.service;

import java.io.Serializable;
import java.util.Objects;

public class TransactionDetailId implements Serializable {
    private static final long serialVersionUID = 5745322582042020233L;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionDetailId() {
    }

    public TransactionDetailId(Long id, Long accountNumber) {
        this.id = id;
        this.accountNumber = accountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    private Long accountNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDetailId that = (TransactionDetailId) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber);
    }
}
