package accounts.service;

import java.util.List;
import java.util.stream.Collectors;

import accounts.model.AccountDto;
import accounts.model.Accounts;
import accounts.model.TransactionDetailDto;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDto toDto(Accounts accounts) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(accounts.getAccountNumber());
        accountDto.setAccountName(accounts.getAccountName());
        accountDto.setAccountType(accounts.getAccountType());
        accountDto.setBalanceDate(accounts.getBalanceDate());
        accountDto.setCurrency(accounts.getCurrency());
        accountDto.setOpeningBalanceData(accounts.getOpeningBalanceData());
        return accountDto;
    }

    public List<TransactionDetailDto> toDetailDto(Accounts accounts) {
        String accountName = accounts.getAccountName();
        return accounts.getTransactionDetails().stream().map(det -> new TransactionDetailDto(det.getId(),
            det.getAccountNumber(), accountName, det.getValueDate(), det.getDebitAmount(), det.getCreditAmount(),
            det.getDebitCredit(), det.getTransactionNarrative()))
            .collect(Collectors.toList());
    }
}
