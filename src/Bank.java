import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    static Scanner input = new Scanner(System.in);
    static ArrayList<BankAccount> akun = new ArrayList<>();

    public static void main(String[] args) {
        loop:
        while (true){
            menu();
            int pilihanMenu = input.nextInt();
            input.nextLine();

            switch(pilihanMenu){
                case 1: //BUAT AKUN
                    buatAkun();
                    break;
                case 2: //DEPOSIT
                    depositAkun();
                    break;
                case 3: //WITHDRAW
                    withdrawAkun();
                    break;
                case 4:
                    break loop;
                default:
                    System.out.println("\nPilihan tidak valid");
                    pause();
            }
        }

        System.out.println("\nTerima kasih. Sampai jumpa");
    }

    static void menu(){
        System.out.print(
                """
                        \n=====MENU=====
                        1. Buat Akun
                        2. Setor Tunai
                        3. Tarik Tunai
                        4. Keluar
                        """
        );
        System.out.print("\nPilih menu: ");
    }

    static void tampilkanAkun(){
        for (int i = 0;i<akun.size();i++){
            System.out.println("\nAkun index ke- " + i);
            System.out.println("Nama: " + akun.get(i).getNamaPengguna());
        }
    }

    static void buatAkun(){
        System.out.print("\nMasukan nama pengguna: ");
        String namaPengguna = input.nextLine();

        akun.add(new BankAccount(namaPengguna));
        System.out.println("\nAkun berhasil dibuat");
        System.out.println("Selamat datang " + akun.get(akun.size()-1).getNamaPengguna());
        pause();
    }

    static void depositAkun(){
        if(akun.isEmpty()){
            System.out.println("\nBelum ada akun terdaftar");
        } else{
            tampilkanAkun();
            System.out.print("\nPilih index akun untuk deposit: ");
            int pilihanAkun = input.nextInt();
            input.nextLine();

            if (pilihanAkun >= akun.size() || pilihanAkun < 0){
                System.out.println("\nAkun tidak tersedia");
            } else {
                System.out.print("Masukan jumlah uang yang ingin di deposit di akun " + akun.get(pilihanAkun).getNamaPengguna() + ": ");
                int uang = input.nextInt();
                input.nextLine();
                akun.get(pilihanAkun).deposit(uang);
            }
        }
        pause();
    }

    static void withdrawAkun(){
        if(akun.isEmpty()){
            System.out.println("\nBelum ada akun terdaftar");
        } else{
            tampilkanAkun();
            System.out.print("\nPilih index akun untuk withdraw: ");
            int pilihanAkun = input.nextInt();

            if (pilihanAkun >= akun.size() || pilihanAkun < 0){
                    System.out.println("Akun tidak tersedia");
            } else {
                System.out.print("Masukan jumlah uang yang ingin di withdraw: ");
                int uang = input.nextInt();
                input.nextLine();
                akun.get(pilihanAkun).withdraw(uang);
            }
        }
        pause();
    }

    static void pause(){
        System.out.print("\nTekan enter untuk melanjutkan");
        input.nextLine();
    }
}