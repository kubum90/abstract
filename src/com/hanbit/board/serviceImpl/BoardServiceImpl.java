package com.hanbit.board.serviceImpl;
import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
public class BoardServiceImpl implements BoardService{
	BoardBean board;
	BoardBean[] list;
	int seq;
	public BoardServiceImpl(){
		seq =0;
		board = new BoardBean();
		list = new BoardBean[seq];
	}
	@Override
	public void writeBoard(BoardBean board) {
		if(seq==list.length){
			BoardBean[] temp = new BoardBean[seq+1];
			System.arraycopy(list, 0, temp, 0, seq);
			list = temp;
		}
		list[seq++]=board;
	}
	
	@Override
	public BoardBean[] getList(){
		if(seq!=list.length){
			BoardBean[] temp = new BoardBean[seq-1];
			System.arraycopy(list, 0, temp, 0, seq-1);
			list = temp;
		}
		return list;
	}

	@Override
	public BoardBean findBySeq(int param) {
		board = new BoardBean();
		for(int i=0; i<list.length; i++){
			if(param==list[i].getSeq()){
				board = list[i];
			}
		}
		
		return board;
	}

	@Override
	public BoardBean[] findByWriter(String writer) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void updateContent(BoardBean board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String content) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return seq;
	}

}
