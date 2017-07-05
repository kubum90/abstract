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
				String [] arr = JOptionPane.showInputDialog("writer/title/content/regdate").split("/");
				board = new BoardBean();
				board.setWriter(arr[0]);
				board.setTitle(arr[1]);
				board.setContent(arr[2]);
				board.setRegDate(arr[3]);
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
                       sList+=list[i].toString();
                 }
                 JOptionPane.showMessageDialog(null,sList);
				break;
			case "4":
				int seqCount= Integer.parseInt(JOptionPane.showInputDialog("seq?"));
				JOptionPane.showMessageDialog(null, service.findBySeq(seqCount));
				break;
			case "5":
				String findName = JOptionPane.showInputDialog("name?");
				BoardBean[] findWriter=service.findByWriter(findName);
				String result="";
				if(findName.length()==0){
					result="찾고자 하는 게시자가 없습니다.";
				}else{
					for(int i=0; i<findWriter.length;i++){
						result+=findWriter[i].toString();
					}
				}
				JOptionPane.showMessageDialog(null, result);
				break;
			case "6":
				board = new BoardBean();
				String seqContent = JOptionPane.showInputDialog("seq/content");
				String[] seqC=seqContent.split("/");
				board.setSeq(Integer.parseInt(seqC[0]));
				board.setContent(seqC[1]);
				service.updateContent(board);
				break;
			case "7":
				int deleteContent = Integer.parseInt(JOptionPane.showInputDialog("삭제할 seq 입력하세요"));
				service.delete(deleteContent);
				JOptionPane.showMessageDialog(null, "삭제완료하였습니다.");
				break;
			default:
				break;
			}
		}
	}
}