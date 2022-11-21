package com.hantiv.novel.user.mapper;

import com.hantiv.novel.user.entity.UserPayRecord;
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
public interface UserPayRecordMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserPayRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserPayRecordResult")
    UserPayRecord selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserPayRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.TINYINT),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.BIGINT),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="wu_amount", property="wuAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserPayRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(UserPayRecordDynamicSqlSupport.userPayRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, UserPayRecordDynamicSqlSupport.userPayRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, UserPayRecordDynamicSqlSupport.userPayRecord)
                .where(UserPayRecordDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UserPayRecord record) {
        return insert(SqlBuilder.insert(record)
                .into(UserPayRecordDynamicSqlSupport.userPayRecord)
                .map(UserPayRecordDynamicSqlSupport.id).toProperty("id")
                .map(UserPayRecordDynamicSqlSupport.userId).toProperty("userId")
                .map(UserPayRecordDynamicSqlSupport.payChannel).toProperty("payChannel")
                .map(UserPayRecordDynamicSqlSupport.outTradeNo).toProperty("outTradeNo")
                .map(UserPayRecordDynamicSqlSupport.totalAmount).toProperty("totalAmount")
                .map(UserPayRecordDynamicSqlSupport.wuAmount).toProperty("wuAmount")
                .map(UserPayRecordDynamicSqlSupport.payTime).toProperty("payTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UserPayRecord record) {
        return insert(SqlBuilder.insert(record)
                .into(UserPayRecordDynamicSqlSupport.userPayRecord)
                .map(UserPayRecordDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(UserPayRecordDynamicSqlSupport.userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(UserPayRecordDynamicSqlSupport.payChannel).toPropertyWhenPresent("payChannel", record::getPayChannel)
                .map(UserPayRecordDynamicSqlSupport.outTradeNo).toPropertyWhenPresent("outTradeNo", record::getOutTradeNo)
                .map(UserPayRecordDynamicSqlSupport.totalAmount).toPropertyWhenPresent("totalAmount", record::getTotalAmount)
                .map(UserPayRecordDynamicSqlSupport.wuAmount).toPropertyWhenPresent("wuAmount", record::getWuAmount)
                .map(UserPayRecordDynamicSqlSupport.payTime).toPropertyWhenPresent("payTime", record::getPayTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserPayRecord>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, UserPayRecordDynamicSqlSupport.id, UserPayRecordDynamicSqlSupport.userId, UserPayRecordDynamicSqlSupport.payChannel, UserPayRecordDynamicSqlSupport.outTradeNo, UserPayRecordDynamicSqlSupport.totalAmount, UserPayRecordDynamicSqlSupport.wuAmount, UserPayRecordDynamicSqlSupport.payTime)
                .from(UserPayRecordDynamicSqlSupport.userPayRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserPayRecord>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, UserPayRecordDynamicSqlSupport.id, UserPayRecordDynamicSqlSupport.userId, UserPayRecordDynamicSqlSupport.payChannel, UserPayRecordDynamicSqlSupport.outTradeNo, UserPayRecordDynamicSqlSupport.totalAmount, UserPayRecordDynamicSqlSupport.wuAmount, UserPayRecordDynamicSqlSupport.payTime)
                .from(UserPayRecordDynamicSqlSupport.userPayRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UserPayRecord selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, UserPayRecordDynamicSqlSupport.id, UserPayRecordDynamicSqlSupport.userId, UserPayRecordDynamicSqlSupport.payChannel, UserPayRecordDynamicSqlSupport.outTradeNo, UserPayRecordDynamicSqlSupport.totalAmount, UserPayRecordDynamicSqlSupport.wuAmount, UserPayRecordDynamicSqlSupport.payTime)
                .from(UserPayRecordDynamicSqlSupport.userPayRecord)
                .where(UserPayRecordDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(UserPayRecord record) {
        return UpdateDSL.updateWithMapper(this::update, UserPayRecordDynamicSqlSupport.userPayRecord)
                .set(UserPayRecordDynamicSqlSupport.id).equalTo(record::getId)
                .set(UserPayRecordDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(UserPayRecordDynamicSqlSupport.payChannel).equalTo(record::getPayChannel)
                .set(UserPayRecordDynamicSqlSupport.outTradeNo).equalTo(record::getOutTradeNo)
                .set(UserPayRecordDynamicSqlSupport.totalAmount).equalTo(record::getTotalAmount)
                .set(UserPayRecordDynamicSqlSupport.wuAmount).equalTo(record::getWuAmount)
                .set(UserPayRecordDynamicSqlSupport.payTime).equalTo(record::getPayTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(UserPayRecord record) {
        return UpdateDSL.updateWithMapper(this::update, UserPayRecordDynamicSqlSupport.userPayRecord)
                .set(UserPayRecordDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(UserPayRecordDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(UserPayRecordDynamicSqlSupport.payChannel).equalToWhenPresent(record::getPayChannel)
                .set(UserPayRecordDynamicSqlSupport.outTradeNo).equalToWhenPresent(record::getOutTradeNo)
                .set(UserPayRecordDynamicSqlSupport.totalAmount).equalToWhenPresent(record::getTotalAmount)
                .set(UserPayRecordDynamicSqlSupport.wuAmount).equalToWhenPresent(record::getWuAmount)
                .set(UserPayRecordDynamicSqlSupport.payTime).equalToWhenPresent(record::getPayTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UserPayRecord record) {
        return UpdateDSL.updateWithMapper(this::update, UserPayRecordDynamicSqlSupport.userPayRecord)
                .set(UserPayRecordDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(UserPayRecordDynamicSqlSupport.payChannel).equalTo(record::getPayChannel)
                .set(UserPayRecordDynamicSqlSupport.outTradeNo).equalTo(record::getOutTradeNo)
                .set(UserPayRecordDynamicSqlSupport.totalAmount).equalTo(record::getTotalAmount)
                .set(UserPayRecordDynamicSqlSupport.wuAmount).equalTo(record::getWuAmount)
                .set(UserPayRecordDynamicSqlSupport.payTime).equalTo(record::getPayTime)
                .where(UserPayRecordDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UserPayRecord record) {
        return UpdateDSL.updateWithMapper(this::update, UserPayRecordDynamicSqlSupport.userPayRecord)
                .set(UserPayRecordDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(UserPayRecordDynamicSqlSupport.payChannel).equalToWhenPresent(record::getPayChannel)
                .set(UserPayRecordDynamicSqlSupport.outTradeNo).equalToWhenPresent(record::getOutTradeNo)
                .set(UserPayRecordDynamicSqlSupport.totalAmount).equalToWhenPresent(record::getTotalAmount)
                .set(UserPayRecordDynamicSqlSupport.wuAmount).equalToWhenPresent(record::getWuAmount)
                .set(UserPayRecordDynamicSqlSupport.payTime).equalToWhenPresent(record::getPayTime)
                .where(UserPayRecordDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}