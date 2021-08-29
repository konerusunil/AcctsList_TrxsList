package accounts.model;

import java.sql.Date;

public class AccountDto {
    private Long accountNumber;
    private String accountName;
    private String accountType;
    private Date balanceDate;
    private String currency;
    private String openingBalanceData;

    public AccountDto() {
    }

    public AccountDto(Long accountNumber, String accountName, String accountType, Date balanceDate,
        String currency, String openingBalanceData) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.openingBalanceData = openingBalanceData;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOpeningBalanceData() {
        return openingBalanceData;
    }

    public void setOpeningBalanceData(String openingBalanceData) {
        this.openingBalanceData = openingBalanceData;
    }

}
