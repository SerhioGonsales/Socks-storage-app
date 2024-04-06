package com.lukushin.socks.service;

import com.lukushin.socks.DAO.SocksDAO;
import com.lukushin.socks.entity.Socks;
import com.lukushin.socks.exception_handling.NoSuchSocksException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocksServiceImpl implements SocksService{

    @Autowired
    private SocksDAO socksDAO;

    @Override
    public void saveOrUpdate(Socks socks) {
        if (socksDAO.getSocks(socks)==null){
            socksDAO.save(socks);
        } else {
            socksDAO.update(socks);}
    }

    @Override
    public void delete(Socks socks) {
        if (socksDAO.getSocks(socks)==null){
            throw new NoSuchSocksException("Такой пары носков не существует");
        } else {
            socksDAO.delete(socks);}
    }

    @Override
    public int getCountOfSocksByParam(String colour, String operation, int cottonPart) {
        List<Socks> list = socksDAO.getSetOfSocks(colour, operation, cottonPart);
        int count = 0;
        for (Socks s : list){
            count += s.getQuantity();
        }
        return count;
    }
}
