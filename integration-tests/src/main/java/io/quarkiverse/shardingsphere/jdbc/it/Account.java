package io.quarkiverse.shardingsphere.jdbc.it;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_account")
public class Account extends PanacheEntityBase {

    @Id
    private int accountId;
    private int userId;
    private String status;

    public Account() {
    }

    public Account(int accountId, int userId, String status) {
        this.accountId = accountId;
        this.userId = userId;
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
