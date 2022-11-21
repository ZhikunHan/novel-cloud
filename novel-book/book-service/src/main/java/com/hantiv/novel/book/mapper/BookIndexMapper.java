package com.hantiv.novel.book.mapper;

import com.hantiv.novel.book.entity.BookIndex;
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
public interface BookIndexMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookIndex> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookIndexResult")
    BookIndex selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookIndexResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="index_num", property="indexNum", jdbcType=JdbcType.INTEGER),
        @Result(column="index_name", property="indexName", jdbcType=JdbcType.VARCHAR),
        @Result(column="word_count", property="wordCount", jdbcType=JdbcType.INTEGER),
        @Result(column="is_vip", property="isVip", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BookIndex> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(BookIndexDynamicSqlSupport.bookIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookIndexDynamicSqlSupport.bookIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookIndex record) {
        return insert(SqlBuilder.insert(record)
                .into(BookIndexDynamicSqlSupport.bookIndex)
                .map(BookIndexDynamicSqlSupport.id).toProperty("id")
                .map(BookIndexDynamicSqlSupport.bookId).toProperty("bookId")
                .map(BookIndexDynamicSqlSupport.indexNum).toProperty("indexNum")
                .map(BookIndexDynamicSqlSupport.indexName).toProperty("indexName")
                .map(BookIndexDynamicSqlSupport.wordCount).toProperty("wordCount")
                .map(BookIndexDynamicSqlSupport.isVip).toProperty("isVip")
                .map(BookIndexDynamicSqlSupport.createTime).toProperty("createTime")
                .map(BookIndexDynamicSqlSupport.updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookIndex record) {
        return insert(SqlBuilder.insert(record)
                .into(BookIndexDynamicSqlSupport.bookIndex)
                .map(BookIndexDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(BookIndexDynamicSqlSupport.bookId).toPropertyWhenPresent("bookId", record::getBookId)
                .map(BookIndexDynamicSqlSupport.indexNum).toPropertyWhenPresent("indexNum", record::getIndexNum)
                .map(BookIndexDynamicSqlSupport.indexName).toPropertyWhenPresent("indexName", record::getIndexName)
                .map(BookIndexDynamicSqlSupport.wordCount).toPropertyWhenPresent("wordCount", record::getWordCount)
                .map(BookIndexDynamicSqlSupport.isVip).toPropertyWhenPresent("isVip", record::getIsVip)
                .map(BookIndexDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(BookIndexDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookIndex>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, BookIndexDynamicSqlSupport.id, BookIndexDynamicSqlSupport.bookId, BookIndexDynamicSqlSupport.indexNum, BookIndexDynamicSqlSupport.indexName, BookIndexDynamicSqlSupport.wordCount, BookIndexDynamicSqlSupport.isVip, BookIndexDynamicSqlSupport.createTime, BookIndexDynamicSqlSupport.updateTime)
                .from(BookIndexDynamicSqlSupport.bookIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookIndex>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, BookIndexDynamicSqlSupport.id, BookIndexDynamicSqlSupport.bookId, BookIndexDynamicSqlSupport.indexNum, BookIndexDynamicSqlSupport.indexName, BookIndexDynamicSqlSupport.wordCount, BookIndexDynamicSqlSupport.isVip, BookIndexDynamicSqlSupport.createTime, BookIndexDynamicSqlSupport.updateTime)
                .from(BookIndexDynamicSqlSupport.bookIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookIndex selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, BookIndexDynamicSqlSupport.id, BookIndexDynamicSqlSupport.bookId, BookIndexDynamicSqlSupport.indexNum, BookIndexDynamicSqlSupport.indexName, BookIndexDynamicSqlSupport.wordCount, BookIndexDynamicSqlSupport.isVip, BookIndexDynamicSqlSupport.createTime, BookIndexDynamicSqlSupport.updateTime)
                .from(BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookIndex record) {
        return UpdateDSL.updateWithMapper(this::update, BookIndexDynamicSqlSupport.bookIndex)
                .set(BookIndexDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookIndexDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(BookIndexDynamicSqlSupport.indexNum).equalTo(record::getIndexNum)
                .set(BookIndexDynamicSqlSupport.indexName).equalTo(record::getIndexName)
                .set(BookIndexDynamicSqlSupport.wordCount).equalTo(record::getWordCount)
                .set(BookIndexDynamicSqlSupport.isVip).equalTo(record::getIsVip)
                .set(BookIndexDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookIndexDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookIndex record) {
        return UpdateDSL.updateWithMapper(this::update, BookIndexDynamicSqlSupport.bookIndex)
                .set(BookIndexDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookIndexDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(BookIndexDynamicSqlSupport.indexNum).equalToWhenPresent(record::getIndexNum)
                .set(BookIndexDynamicSqlSupport.indexName).equalToWhenPresent(record::getIndexName)
                .set(BookIndexDynamicSqlSupport.wordCount).equalToWhenPresent(record::getWordCount)
                .set(BookIndexDynamicSqlSupport.isVip).equalToWhenPresent(record::getIsVip)
                .set(BookIndexDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookIndexDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookIndex record) {
        return UpdateDSL.updateWithMapper(this::update, BookIndexDynamicSqlSupport.bookIndex)
                .set(BookIndexDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(BookIndexDynamicSqlSupport.indexNum).equalTo(record::getIndexNum)
                .set(BookIndexDynamicSqlSupport.indexName).equalTo(record::getIndexName)
                .set(BookIndexDynamicSqlSupport.wordCount).equalTo(record::getWordCount)
                .set(BookIndexDynamicSqlSupport.isVip).equalTo(record::getIsVip)
                .set(BookIndexDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookIndexDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .where(BookIndexDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookIndex record) {
        return UpdateDSL.updateWithMapper(this::update, BookIndexDynamicSqlSupport.bookIndex)
                .set(BookIndexDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(BookIndexDynamicSqlSupport.indexNum).equalToWhenPresent(record::getIndexNum)
                .set(BookIndexDynamicSqlSupport.indexName).equalToWhenPresent(record::getIndexName)
                .set(BookIndexDynamicSqlSupport.wordCount).equalToWhenPresent(record::getWordCount)
                .set(BookIndexDynamicSqlSupport.isVip).equalToWhenPresent(record::getIsVip)
                .set(BookIndexDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookIndexDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(BookIndexDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}