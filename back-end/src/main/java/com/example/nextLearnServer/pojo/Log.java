package com.example.nextLearnServer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    /**
     * 主键
     */
    private Long id;
    /**
     * 操作者
     */
    private String operator;
    /**
     * 操作
     */
    private String operate;
    /**
     * 类型（0位管理端操作，1位可统计点击量的用户端操作）
     */
    private String type;
    /**
     * 创建时间
     */
    private String createTime;

}
