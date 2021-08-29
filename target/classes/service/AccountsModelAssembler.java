package accounts.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import accounts.controller.AccountsController;
import accounts.model.AccountDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public
class AccountsModelAssembler implements RepresentationModelAssembler<AccountDto, EntityModel<AccountDto>> {

    @Override
    public EntityModel<AccountDto> toModel(AccountDto account) {

        return EntityModel.of(account, //
                linkTo(methodOn(AccountsController.class).one(account.getAccountNumber())).withSelfRel(),
                linkTo(methodOn(AccountsController.class).all()).withRel("accounts"));
    }
}