public class Matkomlan extends MataKuliah {
    public Matkomlan() {
        super("Matkomlan"); }

    @Override
    public void hitungNilaiAkhir() {
        nilaiAkhir = (int) (0.25 * nilaiTugas + 0.15 * nilaiKuis + 0.25 * nilaiUts + 0.35 * nilaiUas); }   
}