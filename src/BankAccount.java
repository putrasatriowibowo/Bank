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
            System.out.println("\nMinimal deposit Rp" + MIN_DEPOSIT);
        } else if(uang > MAX_DEPOSIT){
            System.out.println("\nMaximal deposit Rp" + MAX_DEPOSIT);
        } else if(uang%kelipatan != 0){
            System.out.println("\nDeposit harus kelipatan Rp" + kelipatan);
        } else{
            saldo += uang;
            System.out.println("\nDeposit berhasil");
            System.out.println("Saldo anda: Rp" + saldo);
        }
    }

    public void withdraw(int uang){
        if (uang < MIN_WITHDRAW){
            System.out.println("\nMinimal withdraw Rp" + MIN_WITHDRAW);
        } else if(uang > MAX_WITHDRAW){
            System.out.println("\nMaximal withdraw Rp" + MAX_WITHDRAW);
        } else if(uang%kelipatan != 0){
            System.out.println("\nWithdraw harus kelipatan Rp" + kelipatan);
        } else if(saldo-biayaAdmin < uang){
            System.out.println("\nSaldo anda tidak cukup");
            System.out.println("Saldo anda: Rp" + saldo);
            System.out.println("Terdapat biaya admin Rp" + biayaAdmin);
        } else{
            saldo -= (uang + biayaAdmin);
            System.out.println("\nWithdraw berhasil");
            System.out.println("Saldo anda: Rp" + saldo);
        }
    }

}
