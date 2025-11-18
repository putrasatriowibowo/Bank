import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    static Scanner input = new Scanner(System.in);
    static ArrayList<BankAccount> akun = new ArrayList<>();

    public static void main(String[] args) {
        while (true){

        menu();
        }
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
        System.out.print("Pilih menu: ");
        int pilihanMenu = input.nextInt();
        input.nextLine();

        switch(pilihanMenu){
            case 1: //BUAT AKUN
                System.out.print("\nMasukan nama pengguna: ");
                String namaPengguna = input.nextLine();

                akun.add(new BankAccount(namaPengguna));
                System.out.println("Halo " + akun.get(akun.size()-1).getNamaPengguna());
                break;
            case 2: //DEPOSIT
                if (tampilkanAkun()) break;
                System.out.print("\nPilih index akun untuk deposit: ");
                int pilihanAkun = input.nextInt();

                if (pilihanAkun >= akun.size() || pilihanAkun < 0){
                    System.out.println("Akun tidak tersedia");
                } else {
                    System.out.print("Masukan jumlah uang yang ingin di deposit: ");
                    int uang = input.nextInt();
                    akun.get(pilihanAkun).deposit(uang);
                }
                break;
            case 3: //WITHDRAW
                if (tampilkanAkun()) break;
                System.out.println("\nPilih index akun untuk withdraw: ");
                pilihanAkun = input.nextInt();

                if (pilihanAkun >= akun.size() || pilihanAkun < 0){
                    System.out.println("Akun tidak tersedia");
                } else {
                    System.out.print("Masukan jumlah uang yang ingin di withdraw: ");
                    int uang = input.nextInt();
                    akun.get(pilihanAkun).withdraw(uang);
                }
                break;
        }
    }

    static boolean tampilkanAkun(){
        if (akun.isEmpty()){
            System.out.println("\nTidak ada akun");
            return true;
        } else{
            for (int i = 0;i<akun.size();i++){
                System.out.println("\nAkun index ke- " + i);
                System.out.println("Nama: " + akun.get(i).getNamaPengguna());
            }
            return false;
        }
    }
}
