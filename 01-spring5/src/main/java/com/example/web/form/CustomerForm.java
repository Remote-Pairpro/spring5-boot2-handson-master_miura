package com.example.web.form;

import com.example.persistence.entity.Customer;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CustomerForm {

    @NotBlank
    @Length(min = 1, max = 32)
    private String firstName;

    @NotBlank
    @Length(min = 1, max = 32)
    private String lastName;

    @NotBlank
    @Length(min = 1, max = 128)
    @Email
    private String email;

    // TODO 3-04 検証アノテーションを確認する（変更不要）
    @NotNull
    // TODO 3-05 アノテーションで日付フォーマットを「yyyy-MM-dd」に指定する

    private LocalDate birthday;

    public CustomerForm(String firstName,
                        String lastName,
                        String email,
                        // TODO 3-06 コンストラクタの引数にも日付フォーマットが必要（変更不要）
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    /**
     * フィールドがすべて空（null）のCustomerFormインスタンスを生成するメソッド
     */
    public static CustomerForm createEmptyForm() {
        return new CustomerForm(null, null, null, null);
    }

    /**
     * エンティティのCustomerに変換するメソッド
     */
    public Customer convertToEntity() {
        return new Customer(firstName, lastName, email, birthday);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
