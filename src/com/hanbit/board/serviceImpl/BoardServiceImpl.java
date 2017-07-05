package com.hanbit.board.serviceImpl;
import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
public class BoardServiceImpl implements BoardService{
	BoardBean board;
	BoardBean[] list;
	int count,seq;
	public BoardServiceImpl(){
		count =0;
		board = new BoardBean();
		list = new BoardBean[count];
	}
	@Override
	public void writeBoard(BoardBean board) {
		seq++;
		if(count==list.length){
			BoardBean[] temp = new BoardBean[count+1];
			System.arraycopy(list, 0, temp, 0, count);
			list = temp;
		board.setSeq(seq);
		}
		list[count++]=board;
	}
	@Override
	public BoardBean[] getList(){
		if(count!=list.length){
			BoardBean[] temp = new BoardBean[count-1];
			System.arraycopy(list, 0, temp, 0, count-1);
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
		int x=0;
		for(int i=0; i<list.length; i++){
			if(writer.equals(list[i].getWriter())){
				x++;
			}
		}
			BoardBean[] bords = new BoardBean[x];
			int j=0;
			for(int i=0; i<list.length; i++){
				if(writer.equals(list[i].getWriter())){
					bords[j]=list[i];
					j++;
				}
				if(x==j){
					break;
				}
			}
			return bords;
		}
	@Override
	public void updateContent(BoardBean bean) {
		board = findBySeq(bean.getSeq());
		board.setContent(bean.getContent());
	}
	@Override
	public void delete(int seq) {
		for(int i=0; i<list.length; i++){
			if(seq==list[i].getSeq()){
				list[i]=list[count-1];
			}
		}
		list[count-1]=null;
		count--;
	}
	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return count;
	}
}
