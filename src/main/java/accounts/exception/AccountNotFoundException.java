package accounts.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long accountNumber) {
        super("Could not find this account " + accountNumber +", Please try with valid account");
    }
}