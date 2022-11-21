package com.hantiv.novel.home.mapper;

import com.hantiv.novel.home.entity.HomeFriendLink;
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
public interface HomeFriendLinkMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<HomeFriendLink> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("HomeFriendLinkResult")
    HomeFriendLink selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="HomeFriendLinkResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="link_name", property="linkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="link_url", property="linkUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="is_open", property="isOpen", jdbcType=JdbcType.TINYINT),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<HomeFriendLink> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(HomeFriendLinkDynamicSqlSupport.homeFriendLink);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, HomeFriendLinkDynamicSqlSupport.homeFriendLink);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                .where(HomeFriendLinkDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(HomeFriendLink record) {
        return insert(SqlBuilder.insert(record)
                .into(HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                .map(HomeFriendLinkDynamicSqlSupport.id).toProperty("id")
                .map(HomeFriendLinkDynamicSqlSupport.linkName).toProperty("linkName")
                .map(HomeFriendLinkDynamicSqlSupport.linkUrl).toProperty("linkUrl")
                .map(HomeFriendLinkDynamicSqlSupport.sort).toProperty("sort")
                .map(HomeFriendLinkDynamicSqlSupport.isOpen).toProperty("isOpen")
                .map(HomeFriendLinkDynamicSqlSupport.createUserId).toProperty("createUserId")
                .map(HomeFriendLinkDynamicSqlSupport.createTime).toProperty("createTime")
                .map(HomeFriendLinkDynamicSqlSupport.updateUserId).toProperty("updateUserId")
                .map(HomeFriendLinkDynamicSqlSupport.updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(HomeFriendLink record) {
        return insert(SqlBuilder.insert(record)
                .into(HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                .map(HomeFriendLinkDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                .map(HomeFriendLinkDynamicSqlSupport.linkName).toPropertyWhenPresent("linkName", record::getLinkName)
                .map(HomeFriendLinkDynamicSqlSupport.linkUrl).toPropertyWhenPresent("linkUrl", record::getLinkUrl)
                .map(HomeFriendLinkDynamicSqlSupport.sort).toPropertyWhenPresent("sort", record::getSort)
                .map(HomeFriendLinkDynamicSqlSupport.isOpen).toPropertyWhenPresent("isOpen", record::getIsOpen)
                .map(HomeFriendLinkDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .map(HomeFriendLinkDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(HomeFriendLinkDynamicSqlSupport.updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
                .map(HomeFriendLinkDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<HomeFriendLink>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, HomeFriendLinkDynamicSqlSupport.id, HomeFriendLinkDynamicSqlSupport.linkName, HomeFriendLinkDynamicSqlSupport.linkUrl, HomeFriendLinkDynamicSqlSupport.sort, HomeFriendLinkDynamicSqlSupport.isOpen, HomeFriendLinkDynamicSqlSupport.createUserId, HomeFriendLinkDynamicSqlSupport.createTime, HomeFriendLinkDynamicSqlSupport.updateUserId, HomeFriendLinkDynamicSqlSupport.updateTime)
                .from(HomeFriendLinkDynamicSqlSupport.homeFriendLink);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<HomeFriendLink>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, HomeFriendLinkDynamicSqlSupport.id, HomeFriendLinkDynamicSqlSupport.linkName, HomeFriendLinkDynamicSqlSupport.linkUrl, HomeFriendLinkDynamicSqlSupport.sort, HomeFriendLinkDynamicSqlSupport.isOpen, HomeFriendLinkDynamicSqlSupport.createUserId, HomeFriendLinkDynamicSqlSupport.createTime, HomeFriendLinkDynamicSqlSupport.updateUserId, HomeFriendLinkDynamicSqlSupport.updateTime)
                .from(HomeFriendLinkDynamicSqlSupport.homeFriendLink);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default HomeFriendLink selectByPrimaryKey(Integer id_) {
        return SelectDSL.selectWithMapper(this::selectOne, HomeFriendLinkDynamicSqlSupport.id, HomeFriendLinkDynamicSqlSupport.linkName, HomeFriendLinkDynamicSqlSupport.linkUrl, HomeFriendLinkDynamicSqlSupport.sort, HomeFriendLinkDynamicSqlSupport.isOpen, HomeFriendLinkDynamicSqlSupport.createUserId, HomeFriendLinkDynamicSqlSupport.createTime, HomeFriendLinkDynamicSqlSupport.updateUserId, HomeFriendLinkDynamicSqlSupport.updateTime)
                .from(HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                .where(HomeFriendLinkDynamicSqlSupport.id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(HomeFriendLink record) {
        return UpdateDSL.updateWithMapper(this::update, HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                .set(HomeFriendLinkDynamicSqlSupport.id).equalTo(record::getId)
                .set(HomeFriendLinkDynamicSqlSupport.linkName).equalTo(record::getLinkName)
                .set(HomeFriendLinkDynamicSqlSupport.linkUrl).equalTo(record::getLinkUrl)
                .set(HomeFriendLinkDynamicSqlSupport.sort).equalTo(record::getSort)
                .set(HomeFriendLinkDynamicSqlSupport.isOpen).equalTo(record::getIsOpen)
                .set(HomeFriendLinkDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .set(HomeFriendLinkDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(HomeFriendLinkDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
                .set(HomeFriendLinkDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(HomeFriendLink record) {
        return UpdateDSL.updateWithMapper(this::update, HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                .set(HomeFriendLinkDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(HomeFriendLinkDynamicSqlSupport.linkName).equalToWhenPresent(record::getLinkName)
                .set(HomeFriendLinkDynamicSqlSupport.linkUrl).equalToWhenPresent(record::getLinkUrl)
                .set(HomeFriendLinkDynamicSqlSupport.sort).equalToWhenPresent(record::getSort)
                .set(HomeFriendLinkDynamicSqlSupport.isOpen).equalToWhenPresent(record::getIsOpen)
                .set(HomeFriendLinkDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(HomeFriendLinkDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(HomeFriendLinkDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(HomeFriendLinkDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(HomeFriendLink record) {
        return UpdateDSL.updateWithMapper(this::update, HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                .set(HomeFriendLinkDynamicSqlSupport.linkName).equalTo(record::getLinkName)
                .set(HomeFriendLinkDynamicSqlSupport.linkUrl).equalTo(record::getLinkUrl)
                .set(HomeFriendLinkDynamicSqlSupport.sort).equalTo(record::getSort)
                .set(HomeFriendLinkDynamicSqlSupport.isOpen).equalTo(record::getIsOpen)
                .set(HomeFriendLinkDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .set(HomeFriendLinkDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(HomeFriendLinkDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
                .set(HomeFriendLinkDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .where(HomeFriendLinkDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(HomeFriendLink record) {
        return UpdateDSL.updateWithMapper(this::update, HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                .set(HomeFriendLinkDynamicSqlSupport.linkName).equalToWhenPresent(record::getLinkName)
                .set(HomeFriendLinkDynamicSqlSupport.linkUrl).equalToWhenPresent(record::getLinkUrl)
                .set(HomeFriendLinkDynamicSqlSupport.sort).equalToWhenPresent(record::getSort)
                .set(HomeFriendLinkDynamicSqlSupport.isOpen).equalToWhenPresent(record::getIsOpen)
                .set(HomeFriendLinkDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(HomeFriendLinkDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(HomeFriendLinkDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(HomeFriendLinkDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(HomeFriendLinkDynamicSqlSupport.id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}