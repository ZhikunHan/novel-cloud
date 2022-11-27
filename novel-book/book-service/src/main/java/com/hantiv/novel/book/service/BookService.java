package com.hantiv.novel.book.service;

import com.hantiv
.novel.book.entity.*;
import com.hantiv.novel.common.bean.PageBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 小说服务接口
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
public interface BookService {

    /**
     * 根据最小更新时间分页查询书籍列表
     * @param minDate 最小时间，包括该时间
     * @param limit 查询数量
     * @return 书籍数据集合
     * */
    List<Book> queryBookByMinUpdateTime(Date minDate, int limit);

    /**
     * 根据小说ID集合查询书籍列表
     * @param ids 小说ID集合
     * @return 书籍数据集合
     * */
    List<Book> queryBookByIds(List<Long> ids);

    /**
     * 小说排行数据查询列表
     * @param type 排行类型，0:点击排行，1：更新排行，2：新书排行，3评论排行
     * @param limit 查询数量
     * @return 书籍数据集合
     * */
    List<Book> listRank(Byte type, Integer limit);

    /**
     * 小说分类列表查询
     * @return 分类数据集合
     * */
    List<BookCategory> listBookCategory();

    /**
     * 小说详情信息查询
     * @param id 小说ID
     * @return 小说数据对象
     * */
    Book queryBookDetail(Long id);

    /**
     * 增加小说点击量
     * @param bookId 小说ID
     * @param addCount 新增的数量
     * */
    void addVisitCount(Long bookId, int addCount);

    /**
     * 查询章节数
     * @param bookId 书籍ID
     * @return 章节数量
     * */
    long queryIndexCount(Long bookId);

    /**
     * 查询章节内容
     * @param bookIndexId 目录ID
     * @return 书籍内容
     * */
    BookContent queryBookContent(Long bookIndexId);

    /**
     * 根据分类id查询同类推荐书籍
     * @param catId 分类id
     * @return 书籍集合
     * */
    List<Book> listRecBookByCatId(Integer catId);

    /**
     *分页查询书籍评论列表
     * @param bookId 书籍ID
     * @param page 页码
     * @param pageSize 分页大小
     * @return 评论集合分页数据
     * */
    PageBean<BookComment> listBookCommentByPage(Long bookId, int page, int pageSize);

    /**
     * 查询目录列表
     * @param bookId 书籍ID
     * @param orderBy 排序
     *@param limit 查询条数
     *@return 目录集合
     * */
    List<BookIndex> listNewIndex(Long bookId, String orderBy, Integer limit);

    /**
     * 查询首章目录ID
     * @param bookId 书籍ID
     * @return 首章目录ID
     * */
    Long queryFirstBookIndexId(Long bookId);


    /**
     * 查询目录
     * @param bookIndexId 目录ID
     * @return 目录信息
     * */
    BookIndex queryBookIndex(Long bookIndexId);


    /**
     * 上一章节和下一章节目录ID查询接口
     * @param bookId 书籍ID
     * @param indexNum 目录号
     * @return  上一章节和下一章节目录ID数据
     * */
    Map<String,Long> queryPreAndNextBookIndexId(Long bookId, Integer indexNum);

    /**
     * 新增评价
     * @param userId 用户ID
     * @param comment 评论内容
     * */
    void addBookComment(Long userId, BookComment comment);

    /**
     * 分页查询用户评论
     * @param userId 用户ID
     * @param page 查询页码
     * @param pageSize 分页大小
     * @return 评论数据
     * */
    PageBean<BookComment> listUserCommentByPage(Long userId, int page, int pageSize);

    /**
     * 查询网络图片的小说
     *
     * @param localPicPrefix
     * @param limit 查询条数
     * @return 返回小说集合
     * */
    List<Book> queryNetworkPicBooks(String localPicPrefix, Integer limit);


    /**
     * 更新图片路径
     * @param picUrl 图片路径
     * @param bookId 小说ID
     */
    void updateBookPic(String picUrl, Long bookId);

    /**
     * 根据小说名和作者名查询是否存在
     * @param bookName 小说名
     * @param authorName 作者名
     * @return 是否存在该小说名和作者名的小说
     */
    boolean queryIsExistByBookNameAndAuthorName(String bookName, String authorName);

    /**
     * 更新书籍的爬虫属性
     * @param id 本站小说ID
     * @param sourceId 爬虫源ID
     * @param bookId 源站小说ID  */
    void updateCrawlProperties(Long id, Integer sourceId, String bookId);

    /**
     * 通过分类ID查询分类名
     * @param catId 分类ID
     * @return 分类名
     * */
    String queryCatNameByCatId(int catId);

    /**
     * 保存小说表，目录表，内容表数据
     * @param book 小说数据
     * @param bookIndexList 目录集合
     * @param bookContentList 内容集合
     * */
    void saveBookAndIndexAndContent(Book book, List<BookIndex> bookIndexList, List<BookContent> bookContentList);

    /**
     * 查询需要更新的小说数据
     *
     * @param startDate 最新更新时间的起始时间
     * @param limit 查询条数
     * @return 小说集合
     * */
    List<Book> queryNeedUpdateBook(Date startDate, int limit);

    /**
     * 查询已存在的章节
     * @param bookId 小说ID
     * @return 章节号和章节数据对映射map
     * */
    Map<Integer,BookIndex> queryExistBookIndexMap(Long bookId);

    /**
     * 更新小说表，目录表，内容表数据
     * @param book 小说数据
     * @param bookIndexList 目录集合
     * @param bookContentList 内容集合
     * @param existBookIndexMap  已存在的章节Map   */
    void updateBookAndIndexAndContent(Book book,  List<BookIndex> bookIndexList, List<BookContent> bookContentList, Map<Integer, BookIndex> existBookIndexMap);

    /**
     * 更新一下最后一次的抓取时间
     * @param bookId 小说ID
     * */
    @Deprecated
    void updateCrawlLastTime(Long bookId);

    /**
     * 通过小说名和作者名查询已存在的书籍
     * @param bookName 小说名
     * @param authorName 作者名
     * @return 小说对象
     * */
    Book queryBookByBookNameAndAuthorName(String bookName, String authorName);
}
