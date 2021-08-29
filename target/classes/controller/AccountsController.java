package accounts.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import accounts.exception.AccountNotFoundException;
import accounts.model.AccountDto;
import accounts.model.Accounts;
import accounts.repository.AccountsRepository;
import accounts.model.TransactionDetailDto;
import accounts.repository.TransactionDetailRepository;
import accounts.service.AccountMapper;
import accounts.service.AccountsModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public
class AccountsController {

    private final AccountsRepository repository;

    private final TransactionDetailRepository transactionDetailRepository;

    private final AccountsModelAssembler assembler;

    private final AccountMapper mapper;

    AccountsController(AccountsRepository repository, TransactionDetailRepository transactionDetailRepository,
        AccountsModelAssembler assembler, AccountMapper mapper) {

        this.repository = repository;
        this.transactionDetailRepository = transactionDetailRepository;
        this.assembler = assembler;
        this.mapper = mapper;
    }

    // Account List
    @GetMapping("/accounts")
    public CollectionModel<EntityModel<AccountDto>> all() {

        List<EntityModel<AccountDto>> accounts = repository.findAll().stream() //
                .map(mapper::toDto)
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(accounts, linkTo(methodOn(AccountsController.class).all()).withSelfRel());
    }

    // Transaction details
    @GetMapping("/accounts/{accountNumber}")
    public List<TransactionDetailDto> one(@PathVariable Long accountNumber) {

        Accounts accounts = repository.findById(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));

        return mapper.toDetailDto(accounts);
    }

}