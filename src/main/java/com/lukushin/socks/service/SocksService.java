package com.lukushin.socks.service;

import com.lukushin.socks.entity.Socks;

public interface SocksService {
    void saveOrUpdate(Socks socks);
    void delete(Socks socks);
    int getCountOfSocksByParam(String colour, String operation, int cottonPart);
}
