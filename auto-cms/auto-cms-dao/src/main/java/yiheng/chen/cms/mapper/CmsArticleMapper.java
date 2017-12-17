package yiheng.chen.cms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yiheng.chen.cms.model.CmsArticle;
import yiheng.chen.cms.model.CmsArticleExample;

public interface CmsArticleMapper {
    int countByExample(CmsArticleExample example);

    int deleteByExample(CmsArticleExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(CmsArticle record);

    int insertSelective(CmsArticle record);

    List<CmsArticle> selectByExample(CmsArticleExample example);

    int updateByExampleSelective(@Param("record") CmsArticle record, @Param("example") CmsArticleExample example);

    int updateByExample(@Param("record") CmsArticle record, @Param("example") CmsArticleExample example);
}