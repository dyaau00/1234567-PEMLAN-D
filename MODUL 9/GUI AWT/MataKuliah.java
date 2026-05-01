public abstract class MataKuliah {
    protected String nama;
    protected int nilaiTugas, nilaiKuis, nilaiUts, nilaiUas, nilaiAkhir;
    
    public String getNama() {
        return nama; }

    public MataKuliah(String nama) {
        this.nama = nama; }

    public void setNilaiTugas(int nilaiTugas) {
        this.nilaiTugas = nilaiTugas; }

    public void setNilaiKuis(int nilaiKuis) {
        this.nilaiKuis = nilaiKuis; }

    public void setNilaiUts(int nilaiUts) {
        this.nilaiUts = nilaiUts; }

    public void setNilaiUas(int nilaiUas) {
        this.nilaiUas = nilaiUas; }

    public abstract void hitungNilaiAkhir();
}