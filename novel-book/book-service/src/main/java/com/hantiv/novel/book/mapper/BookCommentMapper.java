package com.hantiv.novel.book.mapper;

import com.hantiv.novel.book.entity.BookComment;
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
public interface BookCommentMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookComment> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookCommentResult")
    BookComment selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookCommentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_content", property="commentContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="reply_count", property="replyCount", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT)
    })
    List<BookComment> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(BookCommentDynamicSqlSupport.bookComment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookCommentDynamicSqlSupport.bookComment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookCommentDynamicSqlSupport.bookComment)
                .where(BookCommentDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookComment record) {
        return insert(SqlBuilder.insert(record)
                .into(BookCommentDynamicSqlSupport.bookComment)
                .map(BookCommentDynamicSqlSupport.id).toProperty("id")
                .map(BookCommentDynamicSqlSupport.bookId).toProperty("bookId")
                .map(BookCommentDynamicSqlSupport.commentContent).toProperty("commentContent")
                .map(BookCommentDynamicSqlSupport.replyCount).toProperty("replyCount")
                .map(BookCommentDynamicSqlSupport.auditStatus).toProperty("auditStatus")
                .map(BookCommentDynamicSqlSupport.createTime).toProperty("createTime")
                .map(BookCommentDynamicSqlSupport.createUserId).toProperty("createUserId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookComment record) {
        return insert(SqlBuilder.insert(record)
                .into(BookCommentDynamicSqlSupport.bookComment)
                .map(BookCommentDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(BookCommentDynamicSqlSupport.bookId).toPropertyWhenPresent("bookId", record::getBookId)
                .map(BookCommentDynamicSqlSupport.commentContent).toPropertyWhenPresent("commentContent", record::getCommentContent)
                .map(BookCommentDynamicSqlSupport.replyCount).toPropertyWhenPresent("replyCount", record::getReplyCount)
                .map(BookCommentDynamicSqlSupport.auditStatus).toPropertyWhenPresent("auditStatus", record::getAuditStatus)
                .map(BookCommentDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(BookCommentDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookComment>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, BookCommentDynamicSqlSupport.id, BookCommentDynamicSqlSupport.bookId, BookCommentDynamicSqlSupport.commentContent, BookCommentDynamicSqlSupport.replyCount, BookCommentDynamicSqlSupport.auditStatus, BookCommentDynamicSqlSupport.createTime, BookCommentDynamicSqlSupport.createUserId)
                .from(BookCommentDynamicSqlSupport.bookComment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookComment>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, BookCommentDynamicSqlSupport.id, BookCommentDynamicSqlSupport.bookId, BookCommentDynamicSqlSupport.commentContent, BookCommentDynamicSqlSupport.replyCount, BookCommentDynamicSqlSupport.auditStatus, BookCommentDynamicSqlSupport.createTime, BookCommentDynamicSqlSupport.createUserId)
                .from(BookCommentDynamicSqlSupport.bookComment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookComment selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, BookCommentDynamicSqlSupport.id, BookCommentDynamicSqlSupport.bookId, BookCommentDynamicSqlSupport.commentContent, BookCommentDynamicSqlSupport.replyCount, BookCommentDynamicSqlSupport.auditStatus, BookCommentDynamicSqlSupport.createTime, BookCommentDynamicSqlSupport.createUserId)
                .from(BookCommentDynamicSqlSupport.bookComment)
                .where(BookCommentDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookComment record) {
        return UpdateDSL.updateWithMapper(this::update, BookCommentDynamicSqlSupport.bookComment)
                .set(BookCommentDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookCommentDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(BookCommentDynamicSqlSupport.commentContent).equalTo(record::getCommentContent)
                .set(BookCommentDynamicSqlSupport.replyCount).equalTo(record::getReplyCount)
                .set(BookCommentDynamicSqlSupport.auditStatus).equalTo(record::getAuditStatus)
                .set(BookCommentDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookCommentDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookComment record) {
        return UpdateDSL.updateWithMapper(this::update, BookCommentDynamicSqlSupport.bookComment)
                .set(BookCommentDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookCommentDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(BookCommentDynamicSqlSupport.commentContent).equalToWhenPresent(record::getCommentContent)
                .set(BookCommentDynamicSqlSupport.replyCount).equalToWhenPresent(record::getReplyCount)
                .set(BookCommentDynamicSqlSupport.auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(BookCommentDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookCommentDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookComment record) {
        return UpdateDSL.updateWithMapper(this::update, BookCommentDynamicSqlSupport.bookComment)
                .set(BookCommentDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(BookCommentDynamicSqlSupport.commentContent).equalTo(record::getCommentContent)
                .set(BookCommentDynamicSqlSupport.replyCount).equalTo(record::getReplyCount)
                .set(BookCommentDynamicSqlSupport.auditStatus).equalTo(record::getAuditStatus)
                .set(BookCommentDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookCommentDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .where(BookCommentDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookComment record) {
        return UpdateDSL.updateWithMapper(this::update, BookCommentDynamicSqlSupport.bookComment)
                .set(BookCommentDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(BookCommentDynamicSqlSupport.commentContent).equalToWhenPresent(record::getCommentContent)
                .set(BookCommentDynamicSqlSupport.replyCount).equalToWhenPresent(record::getReplyCount)
                .set(BookCommentDynamicSqlSupport.auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(BookCommentDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookCommentDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .where(BookCommentDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

}