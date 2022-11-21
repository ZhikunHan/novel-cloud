package com.hantiv.novel.book.mapper;

import com.hantiv.novel.book.entity.BookCommentReply;
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
public interface BookCommentReplyMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookCommentReply> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookCommentReplyResult")
    BookCommentReply selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookCommentReplyResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_content", property="replyContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT)
    })
    List<BookCommentReply> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(BookCommentReplyDynamicSqlSupport.bookCommentReply);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookCommentReplyDynamicSqlSupport.bookCommentReply);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, BookCommentReplyDynamicSqlSupport.bookCommentReply)
                .where(BookCommentReplyDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookCommentReply record) {
        return insert(SqlBuilder.insert(record)
                .into(BookCommentReplyDynamicSqlSupport.bookCommentReply)
                .map(BookCommentReplyDynamicSqlSupport.id).toProperty("id")
                .map(BookCommentReplyDynamicSqlSupport.commentId).toProperty("commentId")
                .map(BookCommentReplyDynamicSqlSupport.replyContent).toProperty("replyContent")
                .map(BookCommentReplyDynamicSqlSupport.auditStatus).toProperty("auditStatus")
                .map(BookCommentReplyDynamicSqlSupport.createTime).toProperty("createTime")
                .map(BookCommentReplyDynamicSqlSupport.createUserId).toProperty("createUserId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookCommentReply record) {
        return insert(SqlBuilder.insert(record)
                .into(BookCommentReplyDynamicSqlSupport.bookCommentReply)
                .map(BookCommentReplyDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(BookCommentReplyDynamicSqlSupport.commentId).toPropertyWhenPresent("commentId", record::getCommentId)
                .map(BookCommentReplyDynamicSqlSupport.replyContent).toPropertyWhenPresent("replyContent", record::getReplyContent)
                .map(BookCommentReplyDynamicSqlSupport.auditStatus).toPropertyWhenPresent("auditStatus", record::getAuditStatus)
                .map(BookCommentReplyDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(BookCommentReplyDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookCommentReply>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, BookCommentReplyDynamicSqlSupport.id, BookCommentReplyDynamicSqlSupport.commentId, BookCommentReplyDynamicSqlSupport.replyContent, BookCommentReplyDynamicSqlSupport.auditStatus, BookCommentReplyDynamicSqlSupport.createTime, BookCommentReplyDynamicSqlSupport.createUserId)
                .from(BookCommentReplyDynamicSqlSupport.bookCommentReply);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookCommentReply>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, BookCommentReplyDynamicSqlSupport.id, BookCommentReplyDynamicSqlSupport.commentId, BookCommentReplyDynamicSqlSupport.replyContent, BookCommentReplyDynamicSqlSupport.auditStatus, BookCommentReplyDynamicSqlSupport.createTime, BookCommentReplyDynamicSqlSupport.createUserId)
                .from(BookCommentReplyDynamicSqlSupport.bookCommentReply);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookCommentReply selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, BookCommentReplyDynamicSqlSupport.id, BookCommentReplyDynamicSqlSupport.commentId, BookCommentReplyDynamicSqlSupport.replyContent, BookCommentReplyDynamicSqlSupport.auditStatus, BookCommentReplyDynamicSqlSupport.createTime, BookCommentReplyDynamicSqlSupport.createUserId)
                .from(BookCommentReplyDynamicSqlSupport.bookCommentReply)
                .where(BookCommentReplyDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookCommentReply record) {
        return UpdateDSL.updateWithMapper(this::update, BookCommentReplyDynamicSqlSupport.bookCommentReply)
                .set(BookCommentReplyDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookCommentReplyDynamicSqlSupport.commentId).equalTo(record::getCommentId)
                .set(BookCommentReplyDynamicSqlSupport.replyContent).equalTo(record::getReplyContent)
                .set(BookCommentReplyDynamicSqlSupport.auditStatus).equalTo(record::getAuditStatus)
                .set(BookCommentReplyDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookCommentReplyDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookCommentReply record) {
        return UpdateDSL.updateWithMapper(this::update, BookCommentReplyDynamicSqlSupport.bookCommentReply)
                .set(BookCommentReplyDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookCommentReplyDynamicSqlSupport.commentId).equalToWhenPresent(record::getCommentId)
                .set(BookCommentReplyDynamicSqlSupport.replyContent).equalToWhenPresent(record::getReplyContent)
                .set(BookCommentReplyDynamicSqlSupport.auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(BookCommentReplyDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookCommentReplyDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookCommentReply record) {
        return UpdateDSL.updateWithMapper(this::update, BookCommentReplyDynamicSqlSupport.bookCommentReply)
                .set(BookCommentReplyDynamicSqlSupport.commentId).equalTo(record::getCommentId)
                .set(BookCommentReplyDynamicSqlSupport.replyContent).equalTo(record::getReplyContent)
                .set(BookCommentReplyDynamicSqlSupport.auditStatus).equalTo(record::getAuditStatus)
                .set(BookCommentReplyDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookCommentReplyDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .where(BookCommentReplyDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookCommentReply record) {
        return UpdateDSL.updateWithMapper(this::update, BookCommentReplyDynamicSqlSupport.bookCommentReply)
                .set(BookCommentReplyDynamicSqlSupport.commentId).equalToWhenPresent(record::getCommentId)
                .set(BookCommentReplyDynamicSqlSupport.replyContent).equalToWhenPresent(record::getReplyContent)
                .set(BookCommentReplyDynamicSqlSupport.auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(BookCommentReplyDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookCommentReplyDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .where(BookCommentReplyDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}