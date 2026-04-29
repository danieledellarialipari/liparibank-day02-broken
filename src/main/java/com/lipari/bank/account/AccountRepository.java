package com.lipari.bank.account;

import com.lipari.bank.account.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByIban(String iban);

    Page<Account> findByBalanceGreaterThanEqual(BigDecimal minBalance, Pageable pageable);

    Page<Account> findByBalanceLessThanEqual(BigDecimal maxBalance, Pageable pageable);

    Page<Account> findByBalanceBetween(BigDecimal minBalance, BigDecimal maxBalance, Pageable pageable);
}
