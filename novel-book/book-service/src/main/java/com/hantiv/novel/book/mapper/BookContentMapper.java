package com.hantiv.novel.book.mapper;

import com.hantiv.novel.book.entity.BookContent;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
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
public interface BookContentMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookContent> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<BookContent> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookContentResult")
    BookContent selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookContentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="index_id", property="indexId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR)
    })
    List<BookContent> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(BookContentDynamicSqlSupport.bookContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookContentDynamicSqlSupport.bookContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookContentDynamicSqlSupport.bookContent)
                .where(BookContentDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookContent record) {
        return insert(SqlBuilder.insert(record)
                .into(BookContentDynamicSqlSupport.bookContent)
                .map(BookContentDynamicSqlSupport.id).toProperty("id")
                .map(BookContentDynamicSqlSupport.indexId).toProperty("indexId")
                .map(BookContentDynamicSqlSupport.content).toProperty("content")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookContent record) {
        return insert(SqlBuilder.insert(record)
                .into(BookContentDynamicSqlSupport.bookContent)
                .map(BookContentDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(BookContentDynamicSqlSupport.indexId).toPropertyWhenPresent("indexId", record::getIndexId)
                .map(BookContentDynamicSqlSupport.content).toPropertyWhenPresent("content", record::getContent)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookContent>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, BookContentDynamicSqlSupport.id, BookContentDynamicSqlSupport.indexId, BookContentDynamicSqlSupport.content)
                .from(BookContentDynamicSqlSupport.bookContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookContent>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, BookContentDynamicSqlSupport.id, BookContentDynamicSqlSupport.indexId, BookContentDynamicSqlSupport.content)
                .from(BookContentDynamicSqlSupport.bookContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookContent selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, BookContentDynamicSqlSupport.id, BookContentDynamicSqlSupport.indexId, BookContentDynamicSqlSupport.content)
                .from(BookContentDynamicSqlSupport.bookContent)
                .where(BookContentDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookContent record) {
        return UpdateDSL.updateWithMapper(this::update, BookContentDynamicSqlSupport.bookContent)
                .set(BookContentDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookContentDynamicSqlSupport.indexId).equalTo(record::getIndexId)
                .set(BookContentDynamicSqlSupport.content).equalTo(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookContent record) {
        return UpdateDSL.updateWithMapper(this::update, BookContentDynamicSqlSupport.bookContent)
                .set(BookContentDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookContentDynamicSqlSupport.indexId).equalToWhenPresent(record::getIndexId)
                .set(BookContentDynamicSqlSupport.content).equalToWhenPresent(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookContent record) {
        return UpdateDSL.updateWithMapper(this::update, BookContentDynamicSqlSupport.bookContent)
                .set(BookContentDynamicSqlSupport.indexId).equalTo(record::getIndexId)
                .set(BookContentDynamicSqlSupport.content).equalTo(record::getContent)
                .where(BookContentDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookContent record) {
        return UpdateDSL.updateWithMapper(this::update, BookContentDynamicSqlSupport.bookContent)
                .set(BookContentDynamicSqlSupport.indexId).equalToWhenPresent(record::getIndexId)
                .set(BookContentDynamicSqlSupport.content).equalToWhenPresent(record::getContent)
                .where(BookContentDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

}