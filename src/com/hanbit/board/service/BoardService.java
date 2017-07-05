package com.hanbit.board.service;

import com.hanbit.board.domain.BoardBean;

public interface BoardService {
	public void writeBoard(BoardBean board);
	public BoardBean[] getList();
	public BoardBean findBySeq(int seq);
	public BoardBean[] findByWriter(String writer);
	public int countBoard();
	public void updateContent(BoardBean board);
	public void delete(String content);
	
}
