package com.yeliz;


import com.yeliz.repository.CalisanRepository;
import com.yeliz.repository.entity.Calisan;

public class TestCalisanEkle {
    public static void main(String[] args)  {

        CalisanRepository calisanRepository = new CalisanRepository();
        System.out.println("----------------------------save--------------------------------------");
        System.out.println(calisanRepository.save(new Calisan("Sevilay", "Biçer Uçar")));
        System.out.println(calisanRepository.save(new Calisan("Alperen", "İkinci")));
        System.out.println(calisanRepository.save(new Calisan("Yeliz", "Hal")));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(calisanRepository.delete(15));



    }


}
