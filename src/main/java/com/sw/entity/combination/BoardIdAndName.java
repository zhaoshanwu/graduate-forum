package com.sw.entity.combination;

import java.io.Serializable;

public class BoardIdAndName implements Serializable {
    // 版块ID
    private String boardId;
    // 版块名
    private String boardName;

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
