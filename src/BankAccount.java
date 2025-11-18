import java.util.Random;

public class BankAccount {
    private String namaPengguna;
    private int saldo;

    private final int MIN_WITHDRAW = 50_000;
    private final int MAX_WITHDRAW = 10_000_000;

    private final int MIN_DEPOSIT = 50_000;
    private final int MAX_DEPOSIT = 10_000_000;

    private final int kelipatan = 50_000;

    private final int biayaAdmin = 2_000;

    BankAccount(String namaPengguna){
        this.namaPengguna = namaPengguna;
        this.saldo = saldo;

        Random random = new Random();
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public void deposit(int uang){
        if (uang < MIN_DEPOSIT){
            System.out.println("Minimal deposit Rp" + MIN_DEPOSIT);
        } else if(uang > MAX_DEPOSIT){
            System.out.println("Maximal deposit Rp" + MAX_DEPOSIT);
        } else if(uang%kelipatan != 0){
            System.out.println("Deposit harus kelipatan Rp" + kelipatan);
        } else{
            saldo += uang;
            System.out.println("Deposit berhasil");
            System.out.println("Saldo anda: Rp" + saldo);
        }
    }

    public void withdraw(int uang){
        if (uang < MIN_WITHDRAW){
            System.out.println("Minimal withdraw Rp" + MIN_WITHDRAW);
        } else if(uang > MAX_WITHDRAW){
            System.out.println("Maximal withdraw Rp" + MAX_WITHDRAW);
        } else if(uang%kelipatan != 0){
            System.out.println("withdraw harus kelipatan Rp" + kelipatan);
        } else if(saldo-biayaAdmin < uang){
            System.out.println("Saldo anda tidak cukup");
            System.out.println("Saldo anda: Rp" + saldo);
            System.out.println("Terdapat biaya admin Rp" + biayaAdmin);
        } else{
            saldo -= (uang + biayaAdmin);
            System.out.println("withdraw berhasil");
            System.out.println("Saldo anda: Rp" + saldo);
        }
    }

}
