package com.lukushin.socks.DAO;

import com.lukushin.socks.entity.Socks;
import com.lukushin.socks.exception_handling.NotEnoughSocksForDeleteException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SocksDAOImpl implements SocksDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Socks getSocks(Socks socks){
        Query query = entityManager.createQuery("from Socks where colour =:socksColour " +
                "and cotton =:socksCotton");
        query.setParameter("socksColour", socks.getColour());
        query.setParameter("socksCotton", socks.getCotton());
        List<Socks> list = query.getResultList();
        if(!list.isEmpty()){
            return list.get(0);
        } else {return null;}
    }

    @Override
    public List<Socks> getSetOfSocks(String colour, String operation, int cottonPart) {
        Query query;
        if(operation.startsWith("more")){
            query = entityManager.createQuery("from Socks where colour =:socksColour " +
                    "and cotton >:socksCotton");
        } else {query = entityManager.createQuery("from Socks where colour =:socksColour " +
                "and cotton <:socksCotton");}
        query.setParameter("socksColour", colour);
        query.setParameter("socksCotton", cottonPart);

        return query.getResultList();
    }

//    @Transactional
//    public List<Socks> getSocksList(){
//        return entityManager.createQuery("from Socks", Socks.class).getResultList();
//    }

    @Override
    @Transactional
    public void save(Socks socks) {
        entityManager.merge(socks);
    }

    @Override
    @Transactional
    public void update(Socks socks) {
        Query query = entityManager.createQuery("update Socks set quantity =:socksQuantity" +
                " where colour =:socksColour and cotton =:socksCotton");
        int newQuantity = getSocks(socks).getQuantity() + socks.getQuantity();
        query.setParameter("socksQuantity", newQuantity);
        query.setParameter("socksColour", socks.getColour());
        query.setParameter("socksCotton", socks.getCotton());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Socks socks) {
        Query query = entityManager.createQuery("update Socks set quantity =:socksQuantity" +
                " where colour =:socksColour and cotton =:socksCotton");
        int currentQuantity = getSocks(socks).getQuantity();
        int quantityForDelete = socks.getQuantity();
        if(currentQuantity<quantityForDelete){
            throw new NotEnoughSocksForDeleteException("Введенное количество носков для удаления " +
                    "превышает актуальное количество носков на складе");
        }
        int newQuantity = currentQuantity - quantityForDelete;
        query.setParameter("socksQuantity", newQuantity);
        query.setParameter("socksColour", socks.getColour());
        query.setParameter("socksCotton", socks.getCotton());
        query.executeUpdate();
    }
}
