package com.example.framework.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.framework.DAO.BoardDAO;
import com.example.framework.DTO.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public String create(BoardDTO boardDTO) {
		int affectRowCount = boardDAO.insert(boardDTO);
		
		if(affectRowCount == 1) {
			return boardDTO.getBoard_id().toString();
		}
		return null;
	}

	@Override
	public BoardDTO selectDetail(BoardDTO boardDTO) {
		BoardDTO detailDTO = boardDAO.detail(boardDTO);
		detailDTO.setContent(detailDTO.getContent() + " 12345");
		
		return detailDTO;
	}

	@Override
	public int deleteById(BoardDTO boardDTO) {
		
		return  boardDAO.delete(boardDTO);
	}

	@Override
	public int updateById(BoardDTO boardDTO) {
		
		return  boardDAO.update(boardDTO);
	}

	@Override
	public List<BoardDTO> selectBoards() {
		
		return boardDAO.selectList();
	}

	@Override
	public List<BoardDTO> searchByContent(String content) {
		
		return boardDAO.search(content);
	}

	
	

}
