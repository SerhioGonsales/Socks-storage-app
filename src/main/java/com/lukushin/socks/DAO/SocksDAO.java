package com.lukushin.socks.DAO;

import com.lukushin.socks.entity.Socks;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SocksDAO {
    Socks getSocks(Socks socks);
    List<Socks> getSetOfSocks(String colour, String operation, int cottonPart);
    void save(Socks socks);
    void update(Socks socks);
    void delete(Socks socks);
}
