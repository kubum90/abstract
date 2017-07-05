package com.hanbit.board.controller;
import javax.swing.JOptionPane;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
import com.hanbit.board.serviceImpl.BoardServiceImpl;
public class BoardController {
	public static void main(String[] args) {
		BoardBean board = null;
		BoardService service = new BoardServiceImpl();
		while(true){
			switch (JOptionPane.showInputDialog("0.exit 1.게시글 추가 2.게시글 수 3.게시글 목록 4.글번호 검색 5.글쓴이로 검색  6.게시글 내용 수정 7.게시글 삭제")) {
			case "0":
				return;
			case "1":
				String [] arr = JOptionPane.showInputDialog("seq/writer/title/content/regdate").split("/");
				board = new BoardBean();
				board.setSeq(Integer.parseInt(arr[0]));
				board.setWriter(arr[1]);
				board.setTitle(arr[2]);
				board.setContent(arr[3]);
				board.setRegDate(arr[4]);
				service.writeBoard(board);
				JOptionPane.showMessageDialog(null, "추가하였습니다.");
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.countBoard());
				break;
			case "3":
				String sList="";
				BoardBean[] list = service.getList();
				for(int i=0; i<service.countBoard(); i++){
					sList+=list[i].toString()+"\n";
				}
				
				JOptionPane.showMessageDialog(null,sList);
				break;
			case "4":
				int seqCount= Integer.parseInt(JOptionPane.showInputDialog("seq?"));
				
				JOptionPane.showMessageDialog(null, service.findBySeq(seqCount).toString());
				break;
			case "5":
				String findName = JOptionPane.showInputDialog("name?");
				BoardBean[] list1=service.findByWriter(findName);
				String result="";
				if(findName.length()==0){
					result="찾고자 하는 게시자가 없습니다.";
				}else{
					for(int i=0; i<list1.length;i++){
						result+=list1[i].toString();
					}
				}
				JOptionPane.showMessageDialog(null, result);
				break;
			
			case "6":
				String[] update = JOptionPane.showInputDialog("title/content").split("/");
				board = new BoardBean();
				board.setTitle(update[0]);
				board.setContent(update[1]);
				board.setWriter(update[2]);
				service.updateContent(board);
				JOptionPane.showMessageDialog(null, "update success!!");
				break;
			case "7":
				String deleteContent = JOptionPane.showInputDialog("삭제할 아이디를 입력하세요");
				service.delete(deleteContent);
				JOptionPane.showMessageDialog(null, "삭제완료하였습니다.");
				break;
			default:
				break;
			}
		}
	}
}