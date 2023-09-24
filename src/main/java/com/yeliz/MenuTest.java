package com.yeliz;

import com.yeliz.repository.CalisanRepository;
import com.yeliz.repository.entity.Calisan;

import java.util.Scanner;

public class MenuTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CalisanRepository calisanRepository = new CalisanRepository();
        int secim;

        do {
            secim = menuGoster(sc);

            switch (secim) {
                case 1 -> calisanEkle(sc, calisanRepository);
                case 2 -> calisanSil(sc, calisanRepository);
                case 3 -> System.out.println("Çıkış yapılıyor...");
                default -> System.out.println("Geçersiz seçim.");
            }
        } while (secim != 3);

        sc.close();
    }

    public static int menuGoster(Scanner sc) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$ Yapılacak İşlemi Seçiniz :$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("1. Çalışan Kişi Ekle");
        System.out.println("2. Çalışan Kişi Sil");
        System.out.println("3. Çıkış");
        System.out.print("Seçiminizi yapınız: ");

        return sc.nextInt();
    }

    public static void calisanEkle(Scanner sc, CalisanRepository calisanRepository) {
        sc.nextLine();
        System.out.print("Çalışan adı: ");
        String ad = sc.nextLine();
        System.out.print("Çalışan soyadı: ");
        String soyad = sc.nextLine();
        Calisan yeniCalisan = new Calisan(ad, soyad);

        if (calisanRepository.save(yeniCalisan)) {
            System.out.println("Çalışan başarıyla eklendi.");
        } else {
            System.out.println("Çalışan eklenirken bir hata oluştu.");
        }
    }

    public static void calisanSil(Scanner sc, CalisanRepository calisanRepository) {
        System.out.print("Silmek istediğiniz çalışanın ID'sini girin: ");
        int silinecekId = sc.nextInt();

        if (calisanRepository.delete(silinecekId)) {
            System.out.println("Çalışan başarıyla silindi.");
        } else {
            System.out.println("Çalışan silinirken bir hata oluştu.");
        }
    }
}