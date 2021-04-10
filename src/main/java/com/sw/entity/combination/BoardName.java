package com.sw.entity.combination;

import java.io.Serializable;

public class BoardName implements Serializable {
    // 版块名
    private String boardName;
    // 父版块名
    private String parentBoardName;

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getParentBoardName() {
        return parentBoardName;
    }

    public void setParentBoardName(String parentBoardName) {
        this.parentBoardName = parentBoardName;
    }

    @Override
    public String toString() {
        return "BoardName{" +
                "boardName='" + boardName + '\'' +
                ", parentBoardName='" + parentBoardName + '\'' +
                '}';
    }
}
