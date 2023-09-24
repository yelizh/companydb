package com.yeliz.repository;

import com.yeliz.repository.entity.Calisan;
import com.yeliz.utility.ConnectionProvider;

import java.sql.Connection;

public class CalisanRepository implements ICrud<Calisan> {
    private ConnectionProvider connectionProvider;//referansım

    public CalisanRepository(){
        this.connectionProvider=new ConnectionProvider();

        //constructor çalıştırdıgında yeni bir connectionprovider nesnesi yaratılacak
    }
    @Override
    public boolean save(Calisan calisan) {
        //INSERT INTO tblcalisan(id, ad, soyad) VALUES ('Sevilay','Biçer Uçar');
        String sqlSaveQuery="INSERT INTO tblcalisan(ad, soyad) VALUES ('"
            +calisan.getAd()+"','"
            +calisan.getSoyad()+"')";
        return connectionProvider.executeUpdate(sqlSaveQuery);
    }

    @Override
    public boolean delete(int id) {
        String sqlDelete="DELETE FROM tblcalisan WHERE id="+id;
        return connectionProvider.executeUpdate(sqlDelete);
    }
}
