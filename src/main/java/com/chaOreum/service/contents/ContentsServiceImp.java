package com.chaOreum.service.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.contents.ContentsDao;

@Service
public class ContentsServiceImp implements ContentsService {

	@Autowired
	ContentsDao contentsDao;
	
	
}
