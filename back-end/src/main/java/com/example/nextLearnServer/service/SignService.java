package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Sign;

import java.util.List;

public interface SignService {
    public void saveSign(Sign sign);
    public List<Sign> queryAllSign();
}
