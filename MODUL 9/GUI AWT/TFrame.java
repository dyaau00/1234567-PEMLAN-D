import java.awt.*;
import java.awt.event.*;

public class TFrame extends Frame {
        Label titleLabel, tugasLabel, kuisLabel, utsLabel, uasLabel, hasilLabel;
        TextField tugasField, kuisField, utsField, uasField, hasilField;
        Button hitungButton, tampilSemuaButton;
        TextArea displayArea;

        // radio buttons
        CheckboxGroup cbg;
        Checkbox rbAsd, rbPemlan, rbMatkomlan, rbProbstat;

        // array list untuk menyimpan data nilai
        MataKuliah[] matkulList = {new ASD(), new Pemlan(), new Matkomlan(), new Probstat()};
        // variabel bantu untuk menyimpan mata kuliah yang dipilih
        MataKuliah matkulTerpilih = matkulList[0];

    //PEMLAN = 20% Tugas, 10% Kuis, 30% UTS, 40% UAS
    //PROBSTAT = 15% Tugas, 10% Kuis, 25% UTS, 50% UAS
    //ASD = 30% Tugas, 20% Kuis, 20% UTS, 30% UAS
    //MATKOMLAN = 25% Tugas, 15% Kuis, 25% UTS, 35% UAS

    public TFrame() {
        // pake parameter flow layout center biar rapi, sesuai dengan ss an di modul
        setTitle("Hitung Nilai Akhir Mata Kuliah");
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(400,400);

        // PANEL JUDUL BIAR TERSTRUKTUR
        titleLabel = new Label("Hitung Nilai Akhir", Label.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        Panel pTitle = new Panel(new GridLayout(1, 1));
        pTitle.setPreferredSize(new Dimension(400, 30));
        pTitle.add(titleLabel);
        add(pTitle);

        // PANEL RADIO BUTTONS BIAR TERSTRUKTUR
        Panel radioPanel = new Panel();
        cbg = new CheckboxGroup();
        rbAsd = new Checkbox("ASD", cbg, true);
        rbPemlan = new Checkbox("Pemlan", cbg, false);
        rbMatkomlan = new Checkbox("Matkomlan", cbg, false);
        rbProbstat = new Checkbox("Probstat", cbg, false);
        radioPanel.add(rbAsd); radioPanel.add(rbPemlan);
        radioPanel.add(rbMatkomlan); radioPanel.add(rbProbstat);
        add(radioPanel);

        // PANEL INPUT NILAI BIAR TERSTRUKTUR
        Panel pInputContainer = new Panel(new FlowLayout(FlowLayout.CENTER));
        Panel pInput = new Panel(new GridLayout(5, 2, 5, 10));
        tugasField = new TextField(10);
        kuisField = new TextField(10);
        utsField = new TextField(10);
        uasField = new TextField(10);
        hasilField = new TextField(10);
        hasilField.setEditable(false); // biar tidak bisa diedit manual

        pInput.add(new Label("Tugas :")); pInput.add(tugasField);
        pInput.add(new Label("Kuis  :")); pInput.add(kuisField);
        pInput.add(new Label("UTS   :")); pInput.add(utsField);
        pInput.add(new Label("UAS   :")); pInput.add(uasField);
        pInput.add(new Label("Hasil :")); pInput.add(hasilField);
        pInputContainer.add(pInput);
        add(pInputContainer);

        // PANEL TOMBOL HITUNG
        Panel pHitung = new Panel(new FlowLayout(FlowLayout.CENTER));
        hitungButton = new Button("Hitung");
        pHitung.setPreferredSize(new Dimension(400, 40));
        pHitung.add(hitungButton);
        add(pHitung);
        
        // PANEL TEXT AREA
        Panel pArea = new Panel(new FlowLayout(FlowLayout.CENTER));
        displayArea = new TextArea(10, 45);
        pArea.add(displayArea);
        add(pArea);

        // PANEL TOMBOL TAMPIL SEMUA
        Panel pTampil = new Panel(new FlowLayout(FlowLayout.CENTER));
        tampilSemuaButton = new Button("Tampilkan nilai semua matkul");
        pTampil.add(tampilSemuaButton);
        add(pTampil);

        // logika
        ItemListener rbListener = e -> {
            tugasField.setText("");
            kuisField.setText("");
            utsField.setText("");
            uasField.setText("");
            hasilField.setText("");
            
            if (rbAsd.getState()) matkulTerpilih = matkulList[0];
            else if (rbPemlan.getState()) matkulTerpilih = matkulList[1];
            else if (rbMatkomlan.getState()) matkulTerpilih = matkulList[2];
            else if (rbProbstat.getState()) matkulTerpilih = matkulList[3];
        };
        rbAsd.addItemListener(rbListener);
        rbPemlan.addItemListener(rbListener);
        rbMatkomlan.addItemListener(rbListener);
        rbProbstat.addItemListener(rbListener);

        hitungButton.addActionListener(e -> {
            try {
                matkulTerpilih.setNilaiTugas(Integer.parseInt(tugasField.getText()));
                matkulTerpilih.setNilaiKuis(Integer.parseInt(kuisField.getText()));
                matkulTerpilih.setNilaiUts(Integer.parseInt(utsField.getText()));
                matkulTerpilih.setNilaiUas(Integer.parseInt(uasField.getText()));

                matkulTerpilih.hitungNilaiAkhir();
                hasilField.setText(String.valueOf(matkulTerpilih.nilaiAkhir));
            } catch (NumberFormatException ex) {
                hasilField.setText("Input tidak valid!");
            }
        });

        tampilSemuaButton.addActionListener(e -> {
            displayArea.setText("HASIL NILAI SEMUA MATA KULIAH\n\n");
            for (MataKuliah mk : matkulList) {
                displayArea.append(mk.getNama() + "\t\t: " + mk.nilaiAkhir + "\n");
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
    }
}