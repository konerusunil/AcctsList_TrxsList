package accounts;

import accounts.model.Accounts;
import accounts.model.TransactionDetails;
import accounts.repository.AccountsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountsRepository repository) {

        return args -> {


            log.info("Preloading " + repository.save(new Accounts(585309209, "SGSavings726", "Savings", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2018").getTime()),"SGD","84,327.51",
                    List.of(getTransactionDetails(1,585309209L, "19/08/2017", "11,600.50", "Credit"), getTransactionDetails(2,585309209L, "23/04/2018", "20,322.89", "Credit"),
                            getTransactionDetails(3,585309209L, "14/06/2018", "09,700.54", "Credit"), getTransactionDetails(4,585309209L, "14/08/2018", "06,399.80", "Credit")))));
            log.info("Preloading " + repository.save(new Accounts(685309209, "SGSavings726", "Savings", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2018").getTime()),"SGD","84,327.51", null)));
            log.info("Preloading " + repository.save(new Accounts(791066619, "AUSavings933", "Savings", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2018").getTime()),"AUD","88,005.93", null)));
            log.info("Preloading " + repository.save(new Accounts(321143048, "AUCurrent433", "Current", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2018").getTime()),"AUD","38,010.62", null)));
            log.info("Preloading " + repository.save(new Accounts(347786244, "SGCurrent166", "Current", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2018").getTime()),"SGD","50,644.65", null)));
            log.info("Preloading " + repository.save(new Accounts(680168913, "AUCurrent374", "Current", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2018").getTime()),"AUD","41,327.28", null)));
            log.info("Preloading " + repository.save(new Accounts(136056165, "AUSavings938", "Savings", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2018").getTime()),"AUD","48,928.79", null)));
            log.info("Preloading " + repository.save(new Accounts(453963528, "SGSavings842", "Savings", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2018").getTime()),"AUD","72,117.53", null)));

        };
    }

    private TransactionDetails getTransactionDetails(long l, long l1, String date, String creditAmount, String creditDebit) throws ParseException {
      return new TransactionDetails(l, l1, new Date(new SimpleDateFormat("dd/MM/yyyy").parse(date).getTime()), null,creditAmount , creditDebit, null);
    }
}