package com.example.persistence.repository;

import com.example.persistence.entity.Account;

import java.util.Optional;

public interface AccountRepository {

    /**
     * Eメールアドレスに該当するユーザー情報を返します。
     * @param email ユーザーのEメールアドレス
     * @return Eメールアドレスに該当するユーザー情報のOptional。該当するものがない場合は空のOptional。
     */
    Optional<Account> findByEmail(String email);
}
