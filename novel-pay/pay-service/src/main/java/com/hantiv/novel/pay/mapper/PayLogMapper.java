package com.hantiv.novel.pay.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hantiv.novel.pay.entity.PayLog;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

@Mapper
public interface PayLogMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PayLog> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PayLogResult")
    PayLog selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PayLogResult", value = {
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.BIGINT),
            @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.TINYINT),
            @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.TINYINT),
            @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.INTEGER),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
            @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PayLog> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(PayLogDynamicSqlSupport.payLog);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, PayLogDynamicSqlSupport.payLog);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, PayLogDynamicSqlSupport.payLog)
                .where(PayLogDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PayLog record) {
        return insert(SqlBuilder.insert(record)
                .into(PayLogDynamicSqlSupport.payLog)
                .map(PayLogDynamicSqlSupport.id).toProperty("id")
                .map(PayLogDynamicSqlSupport.outTradeNo).toProperty("outTradeNo")
                .map(PayLogDynamicSqlSupport.tradeType).toProperty("tradeType")
                .map(PayLogDynamicSqlSupport.tradeNo).toProperty("tradeNo")
                .map(PayLogDynamicSqlSupport.payChannel).toProperty("payChannel")
                .map(PayLogDynamicSqlSupport.totalAmount).toProperty("totalAmount")
                .map(PayLogDynamicSqlSupport.userId).toProperty("userId")
                .map(PayLogDynamicSqlSupport.payStatus).toProperty("payStatus")
                .map(PayLogDynamicSqlSupport.createTime).toProperty("createTime")
                .map(PayLogDynamicSqlSupport.updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PayLog record) {
        return insert(SqlBuilder.insert(record)
                .into(PayLogDynamicSqlSupport.payLog)
                .map(PayLogDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(PayLogDynamicSqlSupport.outTradeNo).toPropertyWhenPresent("outTradeNo", record::getOutTradeNo)
                .map(PayLogDynamicSqlSupport.tradeType).toPropertyWhenPresent("tradeType", record::getTradeType)
                .map(PayLogDynamicSqlSupport.tradeNo).toPropertyWhenPresent("tradeNo", record::getTradeNo)
                .map(PayLogDynamicSqlSupport.payChannel).toPropertyWhenPresent("payChannel", record::getPayChannel)
                .map(PayLogDynamicSqlSupport.totalAmount).toPropertyWhenPresent("totalAmount", record::getTotalAmount)
                .map(PayLogDynamicSqlSupport.userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(PayLogDynamicSqlSupport.payStatus).toPropertyWhenPresent("payStatus", record::getPayStatus)
                .map(PayLogDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(PayLogDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<PayLog>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, PayLogDynamicSqlSupport.id, PayLogDynamicSqlSupport.outTradeNo, PayLogDynamicSqlSupport.tradeType, PayLogDynamicSqlSupport.tradeNo, PayLogDynamicSqlSupport.payChannel, PayLogDynamicSqlSupport.totalAmount, PayLogDynamicSqlSupport.userId, PayLogDynamicSqlSupport.payStatus, PayLogDynamicSqlSupport.createTime, PayLogDynamicSqlSupport.updateTime)
                .from(PayLogDynamicSqlSupport.payLog);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<PayLog>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, PayLogDynamicSqlSupport.id, PayLogDynamicSqlSupport.outTradeNo, PayLogDynamicSqlSupport.tradeType, PayLogDynamicSqlSupport.tradeNo, PayLogDynamicSqlSupport.payChannel, PayLogDynamicSqlSupport.totalAmount, PayLogDynamicSqlSupport.userId, PayLogDynamicSqlSupport.payStatus, PayLogDynamicSqlSupport.createTime, PayLogDynamicSqlSupport.updateTime)
                .from(PayLogDynamicSqlSupport.payLog);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default PayLog selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, PayLogDynamicSqlSupport.id, PayLogDynamicSqlSupport.outTradeNo, PayLogDynamicSqlSupport.tradeType, PayLogDynamicSqlSupport.tradeNo, PayLogDynamicSqlSupport.payChannel, PayLogDynamicSqlSupport.totalAmount, PayLogDynamicSqlSupport.userId, PayLogDynamicSqlSupport.payStatus, PayLogDynamicSqlSupport.createTime, PayLogDynamicSqlSupport.updateTime)
                .from(PayLogDynamicSqlSupport.payLog)
                .where(PayLogDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(PayLog record) {
        return UpdateDSL.updateWithMapper(this::update, PayLogDynamicSqlSupport.payLog)
                .set(PayLogDynamicSqlSupport.id).equalTo(record::getId)
                .set(PayLogDynamicSqlSupport.outTradeNo).equalTo(record::getOutTradeNo)
                .set(PayLogDynamicSqlSupport.tradeType).equalTo(record::getTradeType)
                .set(PayLogDynamicSqlSupport.tradeNo).equalTo(record::getTradeNo)
                .set(PayLogDynamicSqlSupport.payChannel).equalTo(record::getPayChannel)
                .set(PayLogDynamicSqlSupport.totalAmount).equalTo(record::getTotalAmount)
                .set(PayLogDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(PayLogDynamicSqlSupport.payStatus).equalTo(record::getPayStatus)
                .set(PayLogDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(PayLogDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(PayLog record) {
        return UpdateDSL.updateWithMapper(this::update, PayLogDynamicSqlSupport.payLog)
                .set(PayLogDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(PayLogDynamicSqlSupport.outTradeNo).equalToWhenPresent(record::getOutTradeNo)
                .set(PayLogDynamicSqlSupport.tradeType).equalToWhenPresent(record::getTradeType)
                .set(PayLogDynamicSqlSupport.tradeNo).equalToWhenPresent(record::getTradeNo)
                .set(PayLogDynamicSqlSupport.payChannel).equalToWhenPresent(record::getPayChannel)
                .set(PayLogDynamicSqlSupport.totalAmount).equalToWhenPresent(record::getTotalAmount)
                .set(PayLogDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(PayLogDynamicSqlSupport.payStatus).equalToWhenPresent(record::getPayStatus)
                .set(PayLogDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(PayLogDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PayLog record) {
        return UpdateDSL.updateWithMapper(this::update, PayLogDynamicSqlSupport.payLog)
                .set(PayLogDynamicSqlSupport.outTradeNo).equalTo(record::getOutTradeNo)
                .set(PayLogDynamicSqlSupport.tradeType).equalTo(record::getTradeType)
                .set(PayLogDynamicSqlSupport.tradeNo).equalTo(record::getTradeNo)
                .set(PayLogDynamicSqlSupport.payChannel).equalTo(record::getPayChannel)
                .set(PayLogDynamicSqlSupport.totalAmount).equalTo(record::getTotalAmount)
                .set(PayLogDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(PayLogDynamicSqlSupport.payStatus).equalTo(record::getPayStatus)
                .set(PayLogDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(PayLogDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .where(PayLogDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PayLog record) {
        return UpdateDSL.updateWithMapper(this::update, PayLogDynamicSqlSupport.payLog)
                .set(PayLogDynamicSqlSupport.outTradeNo).equalToWhenPresent(record::getOutTradeNo)
                .set(PayLogDynamicSqlSupport.tradeType).equalToWhenPresent(record::getTradeType)
                .set(PayLogDynamicSqlSupport.tradeNo).equalToWhenPresent(record::getTradeNo)
                .set(PayLogDynamicSqlSupport.payChannel).equalToWhenPresent(record::getPayChannel)
                .set(PayLogDynamicSqlSupport.totalAmount).equalToWhenPresent(record::getTotalAmount)
                .set(PayLogDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(PayLogDynamicSqlSupport.payStatus).equalToWhenPresent(record::getPayStatus)
                .set(PayLogDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(PayLogDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(PayLogDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}