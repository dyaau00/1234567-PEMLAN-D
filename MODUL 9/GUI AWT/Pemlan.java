public class Pemlan extends MataKuliah {
    public Pemlan() {
        super("Pemlan"); }

    @Override
    public void hitungNilaiAkhir() {
        nilaiAkhir = (int) (0.2 * nilaiTugas + 0.1 * nilaiKuis + 0.3 * nilaiUts + 0.4 * nilaiUas); }
    
}