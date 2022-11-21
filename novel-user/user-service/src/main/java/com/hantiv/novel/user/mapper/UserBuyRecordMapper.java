package com.hantiv.novel.user.mapper;

import com.hantiv.novel.user.entity.UserBuyRecord;
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
public interface UserBuyRecordMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserBuyRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserBuyRecordResult")
    UserBuyRecord selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserBuyRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_index_id", property="bookIndexId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_index_name", property="bookIndexName", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_amount", property="buyAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserBuyRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(UserBuyRecordDynamicSqlSupport.userBuyRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, UserBuyRecordDynamicSqlSupport.userBuyRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, UserBuyRecordDynamicSqlSupport.userBuyRecord)
                .where(UserBuyRecordDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UserBuyRecord record) {
        return insert(SqlBuilder.insert(record)
                .into(UserBuyRecordDynamicSqlSupport.userBuyRecord)
                .map(UserBuyRecordDynamicSqlSupport.id).toProperty("id")
                .map(UserBuyRecordDynamicSqlSupport.userId).toProperty("userId")
                .map(UserBuyRecordDynamicSqlSupport.bookId).toProperty("bookId")
                .map(UserBuyRecordDynamicSqlSupport.bookName).toProperty("bookName")
                .map(UserBuyRecordDynamicSqlSupport.bookIndexId).toProperty("bookIndexId")
                .map(UserBuyRecordDynamicSqlSupport.bookIndexName).toProperty("bookIndexName")
                .map(UserBuyRecordDynamicSqlSupport.buyAmount).toProperty("buyAmount")
                .map(UserBuyRecordDynamicSqlSupport.createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UserBuyRecord record) {
        return insert(SqlBuilder.insert(record)
                .into(UserBuyRecordDynamicSqlSupport.userBuyRecord)
                .map(UserBuyRecordDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(UserBuyRecordDynamicSqlSupport.userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(UserBuyRecordDynamicSqlSupport.bookId).toPropertyWhenPresent("bookId", record::getBookId)
                .map(UserBuyRecordDynamicSqlSupport.bookName).toPropertyWhenPresent("bookName", record::getBookName)
                .map(UserBuyRecordDynamicSqlSupport.bookIndexId).toPropertyWhenPresent("bookIndexId", record::getBookIndexId)
                .map(UserBuyRecordDynamicSqlSupport.bookIndexName).toPropertyWhenPresent("bookIndexName", record::getBookIndexName)
                .map(UserBuyRecordDynamicSqlSupport.buyAmount).toPropertyWhenPresent("buyAmount", record::getBuyAmount)
                .map(UserBuyRecordDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserBuyRecord>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, UserBuyRecordDynamicSqlSupport.id, UserBuyRecordDynamicSqlSupport.userId, UserBuyRecordDynamicSqlSupport.bookId, UserBuyRecordDynamicSqlSupport.bookName, UserBuyRecordDynamicSqlSupport.bookIndexId, UserBuyRecordDynamicSqlSupport.bookIndexName, UserBuyRecordDynamicSqlSupport.buyAmount, UserBuyRecordDynamicSqlSupport.createTime)
                .from(UserBuyRecordDynamicSqlSupport.userBuyRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserBuyRecord>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, UserBuyRecordDynamicSqlSupport.id, UserBuyRecordDynamicSqlSupport.userId, UserBuyRecordDynamicSqlSupport.bookId, UserBuyRecordDynamicSqlSupport.bookName, UserBuyRecordDynamicSqlSupport.bookIndexId, UserBuyRecordDynamicSqlSupport.bookIndexName, UserBuyRecordDynamicSqlSupport.buyAmount, UserBuyRecordDynamicSqlSupport.createTime)
                .from(UserBuyRecordDynamicSqlSupport.userBuyRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UserBuyRecord selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, UserBuyRecordDynamicSqlSupport.id, UserBuyRecordDynamicSqlSupport.userId, UserBuyRecordDynamicSqlSupport.bookId, UserBuyRecordDynamicSqlSupport.bookName, UserBuyRecordDynamicSqlSupport.bookIndexId, UserBuyRecordDynamicSqlSupport.bookIndexName, UserBuyRecordDynamicSqlSupport.buyAmount, UserBuyRecordDynamicSqlSupport.createTime)
                .from(UserBuyRecordDynamicSqlSupport.userBuyRecord)
                .where(UserBuyRecordDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(UserBuyRecord record) {
        return UpdateDSL.updateWithMapper(this::update, UserBuyRecordDynamicSqlSupport.userBuyRecord)
                .set(UserBuyRecordDynamicSqlSupport.id).equalTo(record::getId)
                .set(UserBuyRecordDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(UserBuyRecordDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(UserBuyRecordDynamicSqlSupport.bookName).equalTo(record::getBookName)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexId).equalTo(record::getBookIndexId)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexName).equalTo(record::getBookIndexName)
                .set(UserBuyRecordDynamicSqlSupport.buyAmount).equalTo(record::getBuyAmount)
                .set(UserBuyRecordDynamicSqlSupport.createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(UserBuyRecord record) {
        return UpdateDSL.updateWithMapper(this::update, UserBuyRecordDynamicSqlSupport.userBuyRecord)
                .set(UserBuyRecordDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(UserBuyRecordDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(UserBuyRecordDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(UserBuyRecordDynamicSqlSupport.bookName).equalToWhenPresent(record::getBookName)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexId).equalToWhenPresent(record::getBookIndexId)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexName).equalToWhenPresent(record::getBookIndexName)
                .set(UserBuyRecordDynamicSqlSupport.buyAmount).equalToWhenPresent(record::getBuyAmount)
                .set(UserBuyRecordDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UserBuyRecord record) {
        return UpdateDSL.updateWithMapper(this::update, UserBuyRecordDynamicSqlSupport.userBuyRecord)
                .set(UserBuyRecordDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(UserBuyRecordDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(UserBuyRecordDynamicSqlSupport.bookName).equalTo(record::getBookName)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexId).equalTo(record::getBookIndexId)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexName).equalTo(record::getBookIndexName)
                .set(UserBuyRecordDynamicSqlSupport.buyAmount).equalTo(record::getBuyAmount)
                .set(UserBuyRecordDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .where(UserBuyRecordDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UserBuyRecord record) {
        return UpdateDSL.updateWithMapper(this::update, UserBuyRecordDynamicSqlSupport.userBuyRecord)
                .set(UserBuyRecordDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(UserBuyRecordDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(UserBuyRecordDynamicSqlSupport.bookName).equalToWhenPresent(record::getBookName)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexId).equalToWhenPresent(record::getBookIndexId)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexName).equalToWhenPresent(record::getBookIndexName)
                .set(UserBuyRecordDynamicSqlSupport.buyAmount).equalToWhenPresent(record::getBuyAmount)
                .set(UserBuyRecordDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .where(UserBuyRecordDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}