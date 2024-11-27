public class BancoModel {
    private double saldo;

    public BancoModel() {
        this.saldo = 500.00; // Saldo inicial
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean realizarSaque(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean realizarDeposito(double valor) {
        if (valor > 0 && valor <= 1000) {
            saldo += valor;
            return true;
        }
        return false;
    }
}

