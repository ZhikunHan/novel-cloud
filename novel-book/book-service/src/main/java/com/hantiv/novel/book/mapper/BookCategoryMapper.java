package com.hantiv.novel.book.mapper;

import com.hantiv.novel.book.entity.BookCategory;
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
public interface BookCategoryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookCategory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookCategoryResult")
    BookCategory selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookCategoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="work_direction", property="workDirection", jdbcType=JdbcType.TINYINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BookCategory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(BookCategoryDynamicSqlSupport.bookCategory);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookCategoryDynamicSqlSupport.bookCategory);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookCategoryDynamicSqlSupport.bookCategory)
                .where(BookCategoryDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookCategory record) {
        return insert(SqlBuilder.insert(record)
                .into(BookCategoryDynamicSqlSupport.bookCategory)
                .map(BookCategoryDynamicSqlSupport.id).toProperty("id")
                .map(BookCategoryDynamicSqlSupport.workDirection).toProperty("workDirection")
                .map(BookCategoryDynamicSqlSupport.name).toProperty("name")
                .map(BookCategoryDynamicSqlSupport.sort).toProperty("sort")
                .map(BookCategoryDynamicSqlSupport.createUserId).toProperty("createUserId")
                .map(BookCategoryDynamicSqlSupport.createTime).toProperty("createTime")
                .map(BookCategoryDynamicSqlSupport.updateUserId).toProperty("updateUserId")
                .map(BookCategoryDynamicSqlSupport.updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookCategory record) {
        return insert(SqlBuilder.insert(record)
                .into(BookCategoryDynamicSqlSupport.bookCategory)
                .map(BookCategoryDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(BookCategoryDynamicSqlSupport.workDirection).toPropertyWhenPresent("workDirection", record::getWorkDirection)
                .map(BookCategoryDynamicSqlSupport.name).toPropertyWhenPresent("name", record::getName)
                .map(BookCategoryDynamicSqlSupport.sort).toPropertyWhenPresent("sort", record::getSort)
                .map(BookCategoryDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .map(BookCategoryDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(BookCategoryDynamicSqlSupport.updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
                .map(BookCategoryDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookCategory>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, BookCategoryDynamicSqlSupport.id, BookCategoryDynamicSqlSupport.workDirection, BookCategoryDynamicSqlSupport.name, BookCategoryDynamicSqlSupport.sort, BookCategoryDynamicSqlSupport.createUserId, BookCategoryDynamicSqlSupport.createTime, BookCategoryDynamicSqlSupport.updateUserId, BookCategoryDynamicSqlSupport.updateTime)
                .from(BookCategoryDynamicSqlSupport.bookCategory);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookCategory>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, BookCategoryDynamicSqlSupport.id, BookCategoryDynamicSqlSupport.workDirection, BookCategoryDynamicSqlSupport.name, BookCategoryDynamicSqlSupport.sort, BookCategoryDynamicSqlSupport.createUserId, BookCategoryDynamicSqlSupport.createTime, BookCategoryDynamicSqlSupport.updateUserId, BookCategoryDynamicSqlSupport.updateTime)
                .from(BookCategoryDynamicSqlSupport.bookCategory);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookCategory selectByPrimaryKey(Integer id_) {
        return SelectDSL.selectWithMapper(this::selectOne, BookCategoryDynamicSqlSupport.id, BookCategoryDynamicSqlSupport.workDirection, BookCategoryDynamicSqlSupport.name, BookCategoryDynamicSqlSupport.sort, BookCategoryDynamicSqlSupport.createUserId, BookCategoryDynamicSqlSupport.createTime, BookCategoryDynamicSqlSupport.updateUserId, BookCategoryDynamicSqlSupport.updateTime)
                .from(BookCategoryDynamicSqlSupport.bookCategory)
                .where(BookCategoryDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookCategory record) {
        return UpdateDSL.updateWithMapper(this::update, BookCategoryDynamicSqlSupport.bookCategory)
                .set(BookCategoryDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookCategoryDynamicSqlSupport.workDirection).equalTo(record::getWorkDirection)
                .set(BookCategoryDynamicSqlSupport.name).equalTo(record::getName)
                .set(BookCategoryDynamicSqlSupport.sort).equalTo(record::getSort)
                .set(BookCategoryDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .set(BookCategoryDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookCategoryDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
                .set(BookCategoryDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookCategory record) {
        return UpdateDSL.updateWithMapper(this::update, BookCategoryDynamicSqlSupport.bookCategory)
                .set(BookCategoryDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookCategoryDynamicSqlSupport.workDirection).equalToWhenPresent(record::getWorkDirection)
                .set(BookCategoryDynamicSqlSupport.name).equalToWhenPresent(record::getName)
                .set(BookCategoryDynamicSqlSupport.sort).equalToWhenPresent(record::getSort)
                .set(BookCategoryDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(BookCategoryDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookCategoryDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(BookCategoryDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookCategory record) {
        return UpdateDSL.updateWithMapper(this::update, BookCategoryDynamicSqlSupport.bookCategory)
                .set(BookCategoryDynamicSqlSupport.workDirection).equalTo(record::getWorkDirection)
                .set(BookCategoryDynamicSqlSupport.name).equalTo(record::getName)
                .set(BookCategoryDynamicSqlSupport.sort).equalTo(record::getSort)
                .set(BookCategoryDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .set(BookCategoryDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookCategoryDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
                .set(BookCategoryDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .where(BookCategoryDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookCategory record) {
        return UpdateDSL.updateWithMapper(this::update, BookCategoryDynamicSqlSupport.bookCategory)
                .set(BookCategoryDynamicSqlSupport.workDirection).equalToWhenPresent(record::getWorkDirection)
                .set(BookCategoryDynamicSqlSupport.name).equalToWhenPresent(record::getName)
                .set(BookCategoryDynamicSqlSupport.sort).equalToWhenPresent(record::getSort)
                .set(BookCategoryDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(BookCategoryDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookCategoryDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(BookCategoryDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(BookCategoryDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}