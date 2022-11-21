package com.hantiv.novel.user.mapper;

import com.hantiv.novel.user.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import javax.annotation.Generated;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface UserMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    User selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_photo", property="userPhoto", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.TINYINT),
        @Result(column="account_balance", property="accountBalance", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(UserDynamicSqlSupport.user);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, UserDynamicSqlSupport.user);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, UserDynamicSqlSupport.user)
                .where(UserDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(User record) {
        return insert(SqlBuilder.insert(record)
                .into(UserDynamicSqlSupport.user)
                .map(UserDynamicSqlSupport.id).toProperty("id")
                .map(UserDynamicSqlSupport.username).toProperty("username")
                .map(UserDynamicSqlSupport.password).toProperty("password")
                .map(UserDynamicSqlSupport.nickName).toProperty("nickName")
                .map(UserDynamicSqlSupport.userPhoto).toProperty("userPhoto")
                .map(UserDynamicSqlSupport.userSex).toProperty("userSex")
                .map(UserDynamicSqlSupport.accountBalance).toProperty("accountBalance")
                .map(UserDynamicSqlSupport.status).toProperty("status")
                .map(UserDynamicSqlSupport.createTime).toProperty("createTime")
                .map(UserDynamicSqlSupport.updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(User record) {
        return insert(SqlBuilder.insert(record)
                .into(UserDynamicSqlSupport.user)
                .map(UserDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(UserDynamicSqlSupport.username).toPropertyWhenPresent("username", record::getUsername)
                .map(UserDynamicSqlSupport.password).toPropertyWhenPresent("password", record::getPassword)
                .map(UserDynamicSqlSupport.nickName).toPropertyWhenPresent("nickName", record::getNickName)
                .map(UserDynamicSqlSupport.userPhoto).toPropertyWhenPresent("userPhoto", record::getUserPhoto)
                .map(UserDynamicSqlSupport.userSex).toPropertyWhenPresent("userSex", record::getUserSex)
                .map(UserDynamicSqlSupport.accountBalance).toPropertyWhenPresent("accountBalance", record::getAccountBalance)
                .map(UserDynamicSqlSupport.status).toPropertyWhenPresent("status", record::getStatus)
                .map(UserDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(UserDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<User>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, UserDynamicSqlSupport.id, UserDynamicSqlSupport.username, UserDynamicSqlSupport.password, UserDynamicSqlSupport.nickName, UserDynamicSqlSupport.userPhoto, UserDynamicSqlSupport.userSex, UserDynamicSqlSupport.accountBalance, UserDynamicSqlSupport.status, UserDynamicSqlSupport.createTime, UserDynamicSqlSupport.updateTime)
                .from(UserDynamicSqlSupport.user);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<User>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, UserDynamicSqlSupport.id, UserDynamicSqlSupport.username, UserDynamicSqlSupport.password, UserDynamicSqlSupport.nickName, UserDynamicSqlSupport.userPhoto, UserDynamicSqlSupport.userSex, UserDynamicSqlSupport.accountBalance, UserDynamicSqlSupport.status, UserDynamicSqlSupport.createTime, UserDynamicSqlSupport.updateTime)
                .from(UserDynamicSqlSupport.user);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default User selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, UserDynamicSqlSupport.id, UserDynamicSqlSupport.username, UserDynamicSqlSupport.password, UserDynamicSqlSupport.nickName, UserDynamicSqlSupport.userPhoto, UserDynamicSqlSupport.userSex, UserDynamicSqlSupport.accountBalance, UserDynamicSqlSupport.status, UserDynamicSqlSupport.createTime, UserDynamicSqlSupport.updateTime)
                .from(UserDynamicSqlSupport.user)
                .where(UserDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(User record) {
        return UpdateDSL.updateWithMapper(this::update, UserDynamicSqlSupport.user)
                .set(UserDynamicSqlSupport.id).equalTo(record::getId)
                .set(UserDynamicSqlSupport.username).equalTo(record::getUsername)
                .set(UserDynamicSqlSupport.password).equalTo(record::getPassword)
                .set(UserDynamicSqlSupport.nickName).equalTo(record::getNickName)
                .set(UserDynamicSqlSupport.userPhoto).equalTo(record::getUserPhoto)
                .set(UserDynamicSqlSupport.userSex).equalTo(record::getUserSex)
                .set(UserDynamicSqlSupport.accountBalance).equalTo(record::getAccountBalance)
                .set(UserDynamicSqlSupport.status).equalTo(record::getStatus)
                .set(UserDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(UserDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(User record) {
        return UpdateDSL.updateWithMapper(this::update, UserDynamicSqlSupport.user)
                .set(UserDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(UserDynamicSqlSupport.username).equalToWhenPresent(record::getUsername)
                .set(UserDynamicSqlSupport.password).equalToWhenPresent(record::getPassword)
                .set(UserDynamicSqlSupport.nickName).equalToWhenPresent(record::getNickName)
                .set(UserDynamicSqlSupport.userPhoto).equalToWhenPresent(record::getUserPhoto)
                .set(UserDynamicSqlSupport.userSex).equalToWhenPresent(record::getUserSex)
                .set(UserDynamicSqlSupport.accountBalance).equalToWhenPresent(record::getAccountBalance)
                .set(UserDynamicSqlSupport.status).equalToWhenPresent(record::getStatus)
                .set(UserDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(UserDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(User record) {
        return UpdateDSL.updateWithMapper(this::update, UserDynamicSqlSupport.user)
                .set(UserDynamicSqlSupport.username).equalTo(record::getUsername)
                .set(UserDynamicSqlSupport.password).equalTo(record::getPassword)
                .set(UserDynamicSqlSupport.nickName).equalTo(record::getNickName)
                .set(UserDynamicSqlSupport.userPhoto).equalTo(record::getUserPhoto)
                .set(UserDynamicSqlSupport.userSex).equalTo(record::getUserSex)
                .set(UserDynamicSqlSupport.accountBalance).equalTo(record::getAccountBalance)
                .set(UserDynamicSqlSupport.status).equalTo(record::getStatus)
                .set(UserDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(UserDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .where(UserDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(User record) {
        return UpdateDSL.updateWithMapper(this::update, UserDynamicSqlSupport.user)
                .set(UserDynamicSqlSupport.username).equalToWhenPresent(record::getUsername)
                .set(UserDynamicSqlSupport.password).equalToWhenPresent(record::getPassword)
                .set(UserDynamicSqlSupport.nickName).equalToWhenPresent(record::getNickName)
                .set(UserDynamicSqlSupport.userPhoto).equalToWhenPresent(record::getUserPhoto)
                .set(UserDynamicSqlSupport.userSex).equalToWhenPresent(record::getUserSex)
                .set(UserDynamicSqlSupport.accountBalance).equalToWhenPresent(record::getAccountBalance)
                .set(UserDynamicSqlSupport.status).equalToWhenPresent(record::getStatus)
                .set(UserDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(UserDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(UserDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}