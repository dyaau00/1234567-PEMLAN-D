public class Probstat extends MataKuliah {
    public Probstat() {
        super("Probstat"); }

    @Override
    public void hitungNilaiAkhir() {
        nilaiAkhir = (int) (0.15 * nilaiTugas + 0.1 * nilaiKuis + 0.25 * nilaiUts + 0.5 * nilaiUas); }   
}