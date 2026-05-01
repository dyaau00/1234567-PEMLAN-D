public class ASD extends MataKuliah {
    public ASD() {
        super("ASD"); }

    @Override
    public void hitungNilaiAkhir() {
        nilaiAkhir = (int) (0.3 * nilaiTugas + 0.2 * nilaiKuis + 0.2 * nilaiUts + 0.3 * nilaiUas); }
}