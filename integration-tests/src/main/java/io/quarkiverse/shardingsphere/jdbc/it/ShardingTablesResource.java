package io.quarkiverse.shardingsphere.jdbc.it;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/shardingsphere-jdbc")
@ApplicationScoped
public class ShardingTablesResource {
    //    @Inject
    //    DataSource dataSource;

    //    @PostConstruct
    //    void onStart() throws Exception {
    //        createAccountTable();
    //    }
    //
    //    @PreDestroy
    //    void onStop() throws Exception {
    //        dropAccountTable();
    //    }

    //    private void createAccountTable() throws SQLException {
    //        String sql = "CREATE TABLE t_account (account_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (account_id))";
    //
    //        try (Connection connection = dataSource.getConnection();
    //                Statement statement = connection.createStatement()) {
    //            statement.executeUpdate(sql);
    //        }
    //    }
    //
    //    private void dropAccountTable() throws SQLException {
    //        String sql = "DROP TABLE t_account";
    //        try (Connection connection = dataSource.getConnection();
    //                Statement statement = connection.createStatement()) {
    //            statement.executeUpdate(sql);
    //        }
    //    }

    @POST
    @Path("/account")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public Integer createAccount(Account account) throws Exception {
        account.persistAndFlush();
        //        String sql = "INSERT INTO t_account (account_id, user_id, status) VALUES (?, ?, ?)";
        //        try (Connection connection = dataSource.getConnection();
        //                PreparedStatement statement = connection.prepareStatement(sql)) {
        //            statement.setInt(1, account.getAccountId());
        //            statement.setInt(2, account.getUserId());
        //            statement.setString(3, account.getStatus());
        //            result = statement.executeUpdate();
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        return Objects.isNull(account.getAccountId()) ? 0 : 1;
    }

    @POST
    @Path("/accounts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public Long createAccount() throws Exception {
        List<Account> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Account(i, i, String.valueOf(i)));
        }
        Account.persist(list);
        //        String sql = "INSERT INTO t_account (account_id, user_id, status) VALUES (?, ?, ?)";
        //        try (Connection connection = dataSource.getConnection();
        //                PreparedStatement statement = connection.prepareStatement(sql)) {
        //            statement.setInt(1, account.getAccountId());
        //            statement.setInt(2, account.getUserId());
        //            statement.setString(3, account.getStatus());
        //            result = statement.executeUpdate();
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        return Account.count();
    }

    @GET
    @Path("/account/{ds}/{tbl}")
    public Long count(@PathParam("ds") String ds, @PathParam("tbl") String table) throws Exception {
        return Account.count();
        //        DataSource dataSource = Arc.container().instance(DataSource.class, NamedLiteral.of(ds)).get();
        //
        //        String sql = "SELECT COUNT(*) from " + table;
        //        try (Connection connection = dataSource.getConnection();
        //             Statement statement = connection.createStatement()) {
        //            ResultSet result = statement.executeQuery(sql);
        //            if (result.next()) {
        //                return result.getInt(1);
        //            } else {
        //                return -1;
        //            }
        //        }
    }
}
