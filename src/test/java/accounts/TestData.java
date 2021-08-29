package accounts;

import org.springframework.boot.web.server.LocalServerPort;

public class TestData {

    @LocalServerPort
    private Integer port;


    public static String getExpectedDataForTrxns() {
        return "[{\"id\":1,\"accountNumber\":585309209,\"accountName\":\"SGSavings726\",\"valueDate\":\"2017-08-19\",\"debitAmount\":null,\"creditAmount\":\"11,600.50\",\"debitCredit\":\"Credit\",\"transactionNarrative\":null},{\"id\":2,\"accountNumber\":585309209,\"accountName\":\"SGSavings726\",\"valueDate\":\"2018-04-23\",\"debitAmount\":null,\"creditAmount\":\"20,322.89\",\"debitCredit\":\"Credit\",\"transactionNarrative\":null},{\"id\":3,\"accountNumber\":585309209,\"accountName\":\"SGSavings726\",\"valueDate\":\"2018-06-14\",\"debitAmount\":null,\"creditAmount\":\"09,700.54\",\"debitCredit\":\"Credit\",\"transactionNarrative\":null},{\"id\":4,\"accountNumber\":585309209,\"accountName\":\"SGSavings726\",\"valueDate\":\"2018-08-14\",\"debitAmount\":null,\"creditAmount\":\"06,399.80\",\"debitCredit\":\"Credit\",\"transactionNarrative\":null}]";
    }
}
