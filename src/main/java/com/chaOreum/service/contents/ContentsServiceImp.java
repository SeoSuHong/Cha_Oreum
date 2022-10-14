package com.chaOreum.service.contents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.contents.ContentsDao;
import com.chaOreum.entity.Comment;
import com.chaOreum.entity.Post;
import com.chaOreum.entity.PostView;
import com.chaOreum.entity.Reply;

@Service
public class ContentsServiceImp implements ContentsService {

	@Autowired
	ContentsDao contentsDao;
	
	@Override
	public Post getView(int no) {
		
		Post post = contentsDao.getView(no);
		
		return post;
	}
	
	@Override
	public List<PostView> getViewList(int category_no, String nickname, String title, String sort, int page) {
		int size = 10;
		int offset = 0+(page-1)*size;  // page 1->0, 2->10, 3->20 an=a1+(n-1)d -> 0+(page-1)*10
		
		List<PostView> list = contentsDao.getViewList(category_no, nickname, title, sort, offset, size);
		
		return list;
	}
	
	@Override
	public int likeIsChecked(int no, String id) {

		int likeIsChecked = contentsDao.likeCount(no, id);
		
		return likeIsChecked;
	}
	
	@Override
	public int likePost(int no, String id) {
		return contentsDao.insertHot(no, id);
	}
	
	@Override
	public int unlikePost(int no, String id) {
		return contentsDao.deleteHot(no, id);
	}
	
	@Override
	public List<Comment> getComments(int no) {
		
		List<Comment> comments = contentsDao.getComments(no);
		
		return comments;
	}
	
	@Override
	public List<Reply> getReplies(int no) {
		
		List<Reply> replies = contentsDao.getReplies(no);
		
		return replies;
	}
	
	@Override
	public int sendComment(int no, String nickname, String contents) {
		return contentsDao.insertComment(no, nickname, contents);
	}
	
	@Override
	public int sendReply(int no, String nickname, String contents) {
		return contentsDao.insertReply(no, nickname, contents);
	}
	
	@Override
	public int getEndPage(int category_no, String nickname, String title) {
		return contentsDao.getEndPage(category_no, nickname, title);
	}
}