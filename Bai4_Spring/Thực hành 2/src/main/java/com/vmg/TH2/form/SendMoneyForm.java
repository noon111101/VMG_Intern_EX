package com.vmg.TH2.form;

import com.vmg.TH2.dao.BankAccountDAO;
import com.vmg.TH2.exception.BankTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class SendMoneyForm {

    @Autowired
    BankAccountDAO bankAccountDAO;
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;

    public SendMoneyForm() {

    }

    public SendMoneyForm(Long fromAccountId, Long toAccountId, Double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = BankTransactionException.class)
    public void sendMoney(Long fromAccountId, Long toAccountId,
                          double amount) throws BankTransactionException {

        bankAccountDAO.addAmount(toAccountId, amount);
        bankAccountDAO.addAmount(fromAccountId, -amount);
    }
}