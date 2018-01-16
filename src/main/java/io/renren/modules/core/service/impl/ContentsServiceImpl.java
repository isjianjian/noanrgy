package io.renren.modules.core.service.impl;

import com.aliyun.oss.common.utils.DateUtil;
import com.vdurmont.emoji.EmojiParser;
import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.common.utils.DateUtils;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.validator.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.core.dao.ContentsDao;
import io.renren.modules.core.entity.ContentsEntity;
import io.renren.modules.core.service.ContentsService;



@Service("contentsService")
public class ContentsServiceImpl implements ContentsService {
	@Autowired
	private ContentsDao contentsDao;
	
	@Override
	public ContentsEntity queryObject(Long cid){
		return contentsDao.queryObject(cid);
	}
	
	@Override
	public List<ContentsEntity> queryList(Map<String, Object> map){
		return contentsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return contentsDao.queryTotal(map);
	}
	
	@Override
	public void save(ContentsEntity contents){
		Assert.isNull(contents,"参数有误");
		Assert.isNull(contents.getTitle(),"标题不能为空");
		Assert.isBlank(contents.getTitle(),"标题不能为空");

		if (contents.getTitle().length() > Constant.MAX_TITLE_COUNT) {
			throw new RRException("文章标题最多可以输入" + Constant.MAX_TITLE_COUNT + "个字符");
		}
		Assert.isNull(contents.getContent(),"标题不能为空");
		Assert.isBlank(contents.getContent(),"标题不能为空");

		int len = contents.getContent().length();
		if (len > Constant.MAX_TEXT_COUNT) {
			throw new RRException("文章内容最多可以输入" + Constant.MAX_TEXT_COUNT + "个字符");
		}
		contents.setContent(EmojiParser.parseToAliases(contents.getContent()));
        int time = DateUtils.nowUnix();
        contents.setCreated(time);
        contents.setModified(time);
		contentsDao.save(contents);
	}
	
	@Override
	public void update(ContentsEntity contents){	Assert.isNull(contents,"参数有误");
        Assert.isNull(contents.getTitle(),"标题不能为空");
        Assert.isBlank(contents.getTitle(),"标题不能为空");

        if (contents.getTitle().length() > Constant.MAX_TITLE_COUNT) {
            throw new RRException("文章标题最多可以输入" + Constant.MAX_TITLE_COUNT + "个字符");
        }
        Assert.isNull(contents.getContent(),"标题不能为空");
        Assert.isBlank(contents.getContent(),"标题不能为空");

        int len = contents.getContent().length();
        if (len > Constant.MAX_TEXT_COUNT) {
            throw new RRException("文章内容最多可以输入" + Constant.MAX_TEXT_COUNT + "个字符");
        }
        contents.setContent(EmojiParser.parseToAliases(contents.getContent()));
        contents.setModified(DateUtils.nowUnix());
		contentsDao.update(contents);
	}
	
	@Override
	public void delete(Long cid){
		contentsDao.delete(cid);
	}
	
	@Override
	public void deleteBatch(Long[] cids){
		contentsDao.deleteBatch(cids);
	}
	//搜索文章
	@Override
	public List<ContentsEntity> search(Map<String, Object> map){
		return contentsDao.search(map);
	}

	@Override
	public int searchTotal(Map<String, Object> map){
		return contentsDao.searchTotal(map);
	}

}
