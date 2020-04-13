package film;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ViewFilm extends JFrame 
{
    String status;
    //tampilan
    JLabel ljudul = new JLabel ("Judul");
    JTextField tfjudul = new JTextField();
    JLabel ltipe = new JLabel ("Tipe");
    JTextField tftipe = new JTextField();
    JLabel lstatus = new JLabel ("Status");
    String[] namaStatus = 
            {"Selesai", "Belum"};
    JComboBox cmbstatus = new JComboBox(namaStatus);
    JLabel lepisode = new JLabel ("Episode");
    JTextField tfepisode = new JTextField();
    JLabel lrating = new JLabel ("Rating");
    JTextField tfrating = new JTextField();
    JLabel lgenre = new JLabel ("Genre");
    JTextField tfgenre = new JTextField();
    JTextField tfsearch = new JTextField();
    
    JButton btnSearch = new JButton ("Search");
    JButton btnRefresh = new JButton ("Refresh");
    JButton btnCreate = new JButton ("Create");
    JButton btnUpdate = new JButton ("Update");
    JButton btnDelete = new JButton ("Delete");
    JButton btnExit = new JButton ("Exit");
    
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"#","ID","Judul","Tipe","Episode","Genre","Status","Rating"};
    
    public ViewFilm()
    {
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        
        add(scrollPane);
        scrollPane.setBounds(30, 20, 830, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(ljudul);
        ljudul.setBounds(30, 280, 120, 20);
        add(tfjudul);
        tfjudul.setBounds(30, 300, 300, 20);
        add(ltipe);
        ltipe.setBounds(30, 330, 120, 20);
        add(tftipe);
        tftipe.setBounds(30, 350, 120, 20);
        add(lstatus);
        lstatus.setBounds(210, 330, 120, 20);
        add(cmbstatus);
        cmbstatus.setBounds(210, 350, 120, 20);
        add(lepisode);
        lepisode.setBounds(30, 380, 120, 20);
        add(tfepisode);
        tfepisode.setBounds(30, 400, 120, 20);
        add(lrating);
        lrating.setBounds(210, 380, 120, 20);
        add(tfrating);
        tfrating.setBounds(210, 400, 120, 20);
        add(lgenre);
        lgenre.setBounds(30, 430, 120, 20);
        add(tfgenre);
        tfgenre.setBounds(30, 450, 300, 20);
        add(tfsearch);
        tfsearch.setBounds(460, 300, 160, 20);
        add(btnSearch);
        btnSearch.setBounds(640, 300, 75, 25);
        add(btnRefresh);
        btnRefresh.setBounds(375, 450, 80, 25);
        add(btnCreate);
        btnCreate.setBounds(475, 450, 80, 25);
        add(btnUpdate);
        btnUpdate.setBounds(575, 450, 80, 25);
        add(btnDelete);
        btnDelete.setBounds(675, 450, 80, 25);
        add(btnExit);
        btnExit.setBounds(775, 450, 80, 25);
    }
    
    public void updateForm()
    {
//        JLabel ljudulLama = new JLabel("Judul : ");
//        JLabel ljudulAwal = new JLabel();
//        JLabel ltipeLama = new JLabel ("Tipe : ");
//        JLabel ltipeAwal = new JLabel();
//        JLabel lepisodeLama = new JLabel("Episode : ");
//        JLabel lepisodeAwal = new JLabel();
//        JLabel lgenreLama = new JLabel("Genre : ");
//        JLabel lgenreAwal = new JLabel();
//        JLabel lstatusLama = new JLabel("Status : ");
//        JLabel lstatusAwal = new JLabel();
//        JLabel lratingLama = new JLabel("Rating : ");
//        JLabel lratingAwal = new JLabel();
//        
//        JLabel lupdate = new JLabel("Update Data");
//        JLabel lepisodeBaru = new JLabel("Episode : ");
//        JLabel lstatusBaru = new JLabel("Status : ");
//        String[] namaStatus = 
//        {"Selesai", "Belum"};
//        JComboBox cmbstatusBaru = new JComboBox(namaStatus);
//        JTextField tfepisodeBaru = new JTextField();
//        JLabel lratingBaru = new JLabel("Rating : ");
//        JTextField tfratingBaru = new JTextField();
//        
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setVisible(true);
//        setLayout(null);
//        setSize(500, 600);
//        
//        add(ljudulLama);
//        ljudulLama.setBounds(20, 30, 120, 20);
//        add(ljudulAwal);
//        ljudulAwal.setBounds(150, 30, 120, 20);
//        add(ltipeLama);
//        ltipeLama.setBounds(20, 65, 120, 20);
//        add(ltipeAwal);
//        ltipeAwal.setBounds(150, 30, 120, 20);
//            namalengkap.setBounds(10,10,120,20);
//    akhirNama.setBounds(130,10,150,20);
//    jkelamin.setBounds(10,35,120,20);
//    akhirJk.setBounds(130,35,120,20);
//    agamanya.setBounds(10,60,120,20);
//    akhirAgama.setBounds(130,60,120,20);
//    hobinya.setBounds(10,85,120,20);
//    akhirHobi.setBounds(130,85,120,20);
        
    }
    
    public String getJudul()
    {
        return tfjudul.getText();
    }
    public String getTipe()
    {
        return tftipe.getText();
    }
    public String getStatus()
    {
        status = (String)cmbstatus.getSelectedItem();
        return status;
    }
    public String getEpisode()
    {
        return tfepisode.getText();
    }
    public String getRating()
    {
        return tfrating.getText();
    }
    public String getGenre()
    {
        return tfgenre.getText();
    }
    public String getSearch()
    {
        return tfsearch.getText();
    }
}