package com.example.boardgame.controller;

import com.example.boardgame.entity.Board;
//import com.example.boardgame.entity.file.FileInfo;
import com.example.boardgame.entity.file.FileInfo;
import com.example.boardgame.repository.BoardRepository;
import com.example.boardgame.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class BoardController {
    //자동연결(기존에 있는 걸로 사용)
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private FileRepository fileRepository;


    @PostMapping(value = "/newBoard")
    @ResponseBody
    public Board selectAllUser(Board newBoard, MultipartFile[] files){
        GregorianCalendar gc = new GregorianCalendar();
        String today = new SimpleDateFormat("yyyyMMddhhmmss").format(gc.getTime());

        Path currentPath = Paths.get("");
        //프로젝트경로
        String projectPath = currentPath.toAbsolutePath().toString();
        //저장경로
        String savePath=projectPath+"/src/main/resources/images";
        //파일유무 없으면 생성
        File folder = new File(savePath);
        if(!folder.exists()) folder.mkdirs();

        List<FileInfo> urls = new ArrayList<FileInfo>();
        if(files!=null) {
            for (MultipartFile file : files) {
                String originalFileName = file.getOriginalFilename();
                String saveFileName = today + originalFileName.substring(originalFileName.lastIndexOf('.'));
                if (!originalFileName.isEmpty()) {
                    try {
                        file.transferTo(new File(folder, saveFileName));
                        System.out.println("파일업로드");
                        FileInfo fi = new FileInfo();
                        fi.setUrl(folder + "/" + saveFileName);
                        System.out.println("파일저장 " + folder + "/" + saveFileName);
                        urls.add(fi);
                    } catch (Exception e) {
                        System.out.println("파일처리못함 " + e.toString());
                    }
                }
            }
        }
        System.out.println("파일정보 보드에 추가");
        newBoard.setFileInfo(urls);
        System.out.println("newBoard "+newBoard.toString());
        Board saveBoard = boardRepository.save(newBoard);

        return saveBoard;
    }
    @Transactional
    @Modifying
    @PostMapping(value = "/updateBoard")
    @ResponseBody
    public Optional<Board> UpdateBoard(
            @RequestParam("boardId") Long id,
            @RequestParam("name") String name,
            @RequestParam("distributor") String distributor,
            @RequestParam("min_person") int min_person,
            @RequestParam("max_person") int max_person
    ) {
        Optional<Board> oldBoard = boardRepository.findById(id);
        oldBoard.ifPresent(selectBoard ->{
            selectBoard.setName(name);
            selectBoard.setDistributor(distributor);
            selectBoard.setMin_person(min_person);
            selectBoard.setMax_person(max_person);
            Board updatedBoard = (Board) boardRepository.save(selectBoard);
        });
        return boardRepository.findById(id);
    }

    @Transactional
    @Modifying
    @PostMapping(value = "/deleteBoard")
    @ResponseBody
    public Boolean DeleteBoard(@RequestParam("board") Long id) {
        try{
            boardRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    @GetMapping(value = "/board")
    @ResponseBody
    public List<Board> allUser(@RequestParam(required = false) String name){
        Map<String, Object> response = new HashMap<>();
        //jpa에 있는 findAll사용

        List<Board> boardList = null;
        if (name != null) {
            boardList = boardRepository.findAllByName(name);
        } else {
            boardList = boardRepository.findAll();
        }

        System.out.println("findAll");
        return boardList;
    }
}