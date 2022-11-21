package com.hantiv.novel.user.mapper;

import com.hantiv.novel.user.entity.UserFeedback;
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
public interface UserFeedbackMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserFeedback> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserFeedbackResult")
    UserFeedback selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserFeedbackResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserFeedback> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(UserFeedbackDynamicSqlSupport.userFeedback);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, UserFeedbackDynamicSqlSupport.userFeedback);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, UserFeedbackDynamicSqlSupport.userFeedback)
                .where(UserFeedbackDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UserFeedback record) {
        return insert(SqlBuilder.insert(record)
                .into(UserFeedbackDynamicSqlSupport.userFeedback)
                .map(UserFeedbackDynamicSqlSupport.id).toProperty("id")
                .map(UserFeedbackDynamicSqlSupport.userId).toProperty("userId")
                .map(UserFeedbackDynamicSqlSupport.content).toProperty("content")
                .map(UserFeedbackDynamicSqlSupport.createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UserFeedback record) {
        return insert(SqlBuilder.insert(record)
                .into(UserFeedbackDynamicSqlSupport.userFeedback)
                .map(UserFeedbackDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(UserFeedbackDynamicSqlSupport.userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(UserFeedbackDynamicSqlSupport.content).toPropertyWhenPresent("content", record::getContent)
                .map(UserFeedbackDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserFeedback>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, UserFeedbackDynamicSqlSupport.id, UserFeedbackDynamicSqlSupport.userId, UserFeedbackDynamicSqlSupport.content, UserFeedbackDynamicSqlSupport.createTime)
                .from(UserFeedbackDynamicSqlSupport.userFeedback);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserFeedback>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, UserFeedbackDynamicSqlSupport.id, UserFeedbackDynamicSqlSupport.userId, UserFeedbackDynamicSqlSupport.content, UserFeedbackDynamicSqlSupport.createTime)
                .from(UserFeedbackDynamicSqlSupport.userFeedback);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UserFeedback selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, UserFeedbackDynamicSqlSupport.id, UserFeedbackDynamicSqlSupport.userId, UserFeedbackDynamicSqlSupport.content, UserFeedbackDynamicSqlSupport.createTime)
                .from(UserFeedbackDynamicSqlSupport.userFeedback)
                .where(UserFeedbackDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(UserFeedback record) {
        return UpdateDSL.updateWithMapper(this::update, UserFeedbackDynamicSqlSupport.userFeedback)
                .set(UserFeedbackDynamicSqlSupport.id).equalTo(record::getId)
                .set(UserFeedbackDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(UserFeedbackDynamicSqlSupport.content).equalTo(record::getContent)
                .set(UserFeedbackDynamicSqlSupport.createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(UserFeedback record) {
        return UpdateDSL.updateWithMapper(this::update, UserFeedbackDynamicSqlSupport.userFeedback)
                .set(UserFeedbackDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(UserFeedbackDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(UserFeedbackDynamicSqlSupport.content).equalToWhenPresent(record::getContent)
                .set(UserFeedbackDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UserFeedback record) {
        return UpdateDSL.updateWithMapper(this::update, UserFeedbackDynamicSqlSupport.userFeedback)
                .set(UserFeedbackDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(UserFeedbackDynamicSqlSupport.content).equalTo(record::getContent)
                .set(UserFeedbackDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .where(UserFeedbackDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UserFeedback record) {
        return UpdateDSL.updateWithMapper(this::update, UserFeedbackDynamicSqlSupport.userFeedback)
                .set(UserFeedbackDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(UserFeedbackDynamicSqlSupport.content).equalToWhenPresent(record::getContent)
                .set(UserFeedbackDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .where(UserFeedbackDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}