package com.hantiv.novel.author.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.hantiv.novel.author.entity.AuthorCode;
import com.hantiv.novel.author.entity.AuthorIncome;
import com.hantiv.novel.author.entity.AuthorIncomeDetail;
import com.hantiv.novel.author.mapper.AuthorIncomeDetailMapper;
import com.hantiv.novel.author.mapper.AuthorIncomeMapper;
import com.hantiv.novel.author.service.AuthorService;
import com.hantiv.novel.author.entity.Author;
import com.hantiv.novel.author.mapper.AuthorCodeMapper;
import com.hantiv.novel.author.mapper.AuthorMapper;
import com.hantiv.novel.common.bean.PageBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author Zhikun Han
 * @Date Created in 20:37 2022/11/12
 * @Description: 作家服务接口实现
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;

    private final AuthorCodeMapper authorCodeMapper;

    private final AuthorIncomeDetailMapper authorIncomeDetailMapper;

    private final AuthorIncomeMapper authorIncomeMapper;

    @Override
    public Boolean checkPenName(String penName) {
        LambdaQueryWrapper<Author> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Author::getPenName, penName);
        return authorMapper.selectCount(queryWrapper) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String register(Long userId, Author author) {
        Date currentDate = new Date();
        LambdaQueryWrapper<AuthorCode> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AuthorCode::getInviteCode, author.getInviteCode()).eq(AuthorCode::getIsUsed, 0)
                .gt(AuthorCode::getValidityTime, currentDate);
        AuthorCode authorCode = authorCodeMapper.selectOne(queryWrapper);
        if (Objects.nonNull(authorCode)){
            //邀请码有效 保存作家信息
            author.setUserId(userId);
            author.setCreateTime(currentDate);
            authorMapper.insert(author);
            authorCode.setIsUsed(1);
            authorCodeMapper.update(authorCode, queryWrapper);
            return "";
        } else {
            return "邀请码失效！";
        }
    }

    @Override
    public Boolean isAuthor(Long userId) {
        LambdaQueryWrapper<Author> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Author::getUserId, userId);
        return authorMapper.selectCount(queryWrapper) > 0;
    }

    @Override
    public Author queryAuthor(Long userId) {
        LambdaQueryWrapper<Author> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Author::getUserId, userId);
        return authorMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Author> queryAuthorList(int limit, Date maxAuthorCreateTime) {
        IPage<Author> page = new Page<>(0, limit);
        LambdaQueryWrapper<Author> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.lt(Author::getCreateTime, maxAuthorCreateTime)
                .orderByDesc(Author::getCreateTime);
        IPage<Author> authorIPage = authorMapper.selectPage(page, queryWrapper);
        return authorIPage.getRecords();
    }

    @Override
    public boolean queryIsStatisticsDaily(Long bookId, Date date) {
        LambdaQueryWrapper<AuthorIncomeDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AuthorIncomeDetail::getBookId, bookId)
                .eq(AuthorIncomeDetail::getIncomeDate, date);
        return authorIncomeDetailMapper.selectCount(queryWrapper)>0;
    }

    @Override
    public void saveDailyIncomeSta(AuthorIncomeDetail authorIncomeDetail) {
        authorIncomeDetailMapper.insert(authorIncomeDetail);
    }

    @Override
    public boolean queryIsStatisticsMonth(Long bookId, Date incomeDate) {
        LambdaQueryWrapper<AuthorIncome> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AuthorIncome::getBookId, bookId)
                .eq(AuthorIncome::getIncomeMonth, incomeDate);
        return authorIncomeMapper.selectCount(queryWrapper)>0;
    }

    @Override
    public Long queryTotalAccount(Long userId, Long bookId, Date startTime, Date endTime) {
        LambdaQueryWrapper<AuthorIncomeDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AuthorIncomeDetail::getUserId, userId)
                .eq(AuthorIncomeDetail::getBookId, bookId)
                .ge(AuthorIncomeDetail::getIncomeDate, startTime)
                .le(AuthorIncomeDetail::getIncomeDate, endTime);
        return authorIncomeDetailMapper.selectCount(queryWrapper);
    }

    @Override
    public void saveAuthorIncomeSta(AuthorIncome authorIncome) {
        authorIncomeMapper.insert(authorIncome);
    }

    @Override
    public boolean queryIsStatisticsDaily(Long authorId, Long bookId, Date date) {
        QueryWrapper<AuthorIncomeDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("authorId", authorId)
                .eq("bookId", bookId)
                .eq("incomeDate", date);
        return authorIncomeDetailMapper.selectCount(queryWrapper)>0;
    }

    @Override
    public PageBean<AuthorIncomeDetail> listIncomeDailyByPage(int page, int pageSize, Long userId, Long bookId, Date startTime, Date endTime) {
        IPage<AuthorIncomeDetail> page1 = new Page<>(page, pageSize);
        QueryWrapper<AuthorIncomeDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId)
                .eq("bookId", bookId)
                .ge("incomeDate", startTime)
                .le("incomeDate", endTime)
                .orderByDesc("incomeDate");
        IPage<AuthorIncomeDetail> authorIncomeDetailIPage = authorIncomeDetailMapper.selectPage(page1, queryWrapper);
        return new PageBean(page, pageSize, page1.getTotal(),
                authorIncomeDetailIPage.getRecords().stream().collect(Collectors.toList()));
    }

    @Override
    public PageBean<AuthorIncome> listIncomeMonthByPage(int page, int pageSize, Long userId, Long bookId) {
        IPage<AuthorIncome> page1 = new Page<>();
        page1.setCurrent(page);
        page1.setSize(pageSize);
        QueryWrapper<AuthorIncome> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId).eq("bookId", bookId)
                .orderByDesc("incomeMonth");
        IPage<AuthorIncome> authorIncomeIPage = authorIncomeMapper.selectPage(page1, queryWrapper);
        return new PageBean(page, pageSize, page1.getTotal(),
                authorIncomeIPage.getRecords().stream().collect(Collectors.toList()));
    }
}
