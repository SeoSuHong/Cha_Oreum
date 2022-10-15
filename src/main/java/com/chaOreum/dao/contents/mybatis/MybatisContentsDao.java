package com.chaOreum.dao.contents.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.contents.ContentsDao;
import com.chaOreum.entity.Comment;
import com.chaOreum.entity.Post;
import com.chaOreum.entity.PostView;
import com.chaOreum.entity.Reply;

@Repository
public class MybatisContentsDao implements ContentsDao {
	
	ContentsDao mapper;
	
	@Autowired
	public MybatisContentsDao(SqlSession session) {
		mapper = session.getMapper(ContentsDao.class);
	}
	
	@Override
	public Post getView(int no) {
		return mapper.getView(no);
	}

	@Override
	public List<PostView> getViewList(int category_no, String nickname, String title, String sort, int offset, int size) {
		return mapper.getViewList(category_no, nickname, title, sort, offset, size);
	}
	
	@Override
	public int likeCount(int no, String id) {
		return mapper.likeCount(no, id);
	}
	
	@Override
	public int insertHot(int no, String id) {
		return mapper.insertHot(no, id);
	}
	
	@Override
	public int deleteHot(int no, String id) {
		return mapper.deleteHot(no, id);
	}
	
	@Override
	public List<Comment> getComments(int no) {
		return mapper.getComments(no);
	}
	
	@Override
	public List<Reply> getReplies(int no) {
		return mapper.getReplies(no);
	}
	
	@Override
	public int insertComment(int no, String nickname, String contents) {
		return mapper.insertComment(no, nickname, contents);
	}
	
	@Override
	public int insertReply(int no, String nickname, String contents) {
		return mapper.insertReply(no, nickname, contents);
	}
	
	@Override
	public int getEndPage(int category_no, String nickname, String title) {
		return mapper.getEndPage(category_no, nickname, title);
	}
}