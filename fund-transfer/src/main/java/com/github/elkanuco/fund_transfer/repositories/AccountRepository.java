package com.github.elkanuco.fund_transfer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.elkanuco.fund_transfer.entities.Account;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> { }
