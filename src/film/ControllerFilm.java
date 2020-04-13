package film;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ControllerFilm 
{
    ViewFilm viewFilm;
    ModelFilm modelFilm;
    
    public ControllerFilm (ViewFilm viewFilm, ModelFilm modelFilm)
    {
        this.viewFilm = viewFilm;
        this.modelFilm = modelFilm;
    
    
        if(modelFilm.getBanyakData() != 0)
        {
         String dataFilm[][] = modelFilm.readFilm();
         viewFilm.tabel.setModel((new JTable(dataFilm, viewFilm.namaKolom)).getModel());
        }
        else 
        {
         JOptionPane.showMessageDialog(null, "Data Not Found");
        }
        
        viewFilm.btnCreate.addActionListener((ActionEvent e)->
        {
           
           String judul = viewFilm.getJudul();
           String tipe = viewFilm.getTipe();
           String episode = viewFilm.getEpisode();
           String genre = viewFilm.getGenre();
           String statusapa = viewFilm.getStatus();
           String rating = viewFilm.getRating();
           
           modelFilm.insertFilm(judul, tipe, episode, genre, statusapa, rating);
           viewFilm.tfjudul.setText("");
           viewFilm.tftipe.setText("");
           viewFilm.tfepisode.setText("");
           viewFilm.tfgenre.setText("");
        });
        
        viewFilm.btnRefresh.addActionListener((ActionEvent e)->
        {
           String dataFilm[][] = modelFilm.readFilm();
           viewFilm.tabel.setModel(new JTable(dataFilm, viewFilm.namaKolom).getModel());
        });
        
        viewFilm.tabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
            int baris = viewFilm.tabel.getSelectedRow();
            int kolom = viewFilm.tabel.getSelectedColumn();
                
            String dataterpilih = viewFilm.tabel.getValueAt(baris, 1).toString();
            String judulterpilih = viewFilm.tabel.getValueAt(baris, 2).toString();
            String tipeterpilih = viewFilm.tabel.getValueAt(baris, 3).toString();
            String episodeterpilih = viewFilm.tabel.getValueAt(baris, 4).toString();
            String genreterpilih = viewFilm.tabel.getValueAt(baris, 5).toString();
            String statusterpilih = viewFilm.tabel.getValueAt(baris, 6).toString();
            String ratingterpilih = viewFilm.tabel.getValueAt(baris, 7).toString();
            
            viewFilm.tfjudul.setText(judulterpilih);
            viewFilm.tftipe.setText(tipeterpilih);
            viewFilm.tfepisode.setText(episodeterpilih);
            viewFilm.tfgenre.setText(genreterpilih);
            viewFilm.cmbstatus.setSelectedItem(statusterpilih);
            viewFilm.tfrating.setText(ratingterpilih);          
            
            viewFilm.btnDelete.addActionListener((ActionEvent x)->
            {
                modelFilm.deleteFilm(dataterpilih);
            });
            
            viewFilm.btnUpdate.addActionListener(new ActionListener()
            {
                
                @Override
                public void actionPerformed(ActionEvent q)
                {
                    
                    String id = dataterpilih;
                    String judul = viewFilm.getJudul();
                    String tipe = viewFilm.getTipe();
                    String episode = viewFilm.getEpisode();
                    String genre = viewFilm.getGenre();
                    String status = viewFilm.getStatus();
                    String rating = viewFilm.getRating();

                    modelFilm.updateFilm(id, judul, tipe, episode, genre, status, rating);
                }
            });
        }
        });
        
        viewFilm.btnSearch.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String search = viewFilm.getSearch();
                String dataFilm[][] = modelFilm.readsearchedFilm(search);
                viewFilm.tabel.setModel(new JTable (dataFilm, viewFilm.namaKolom).getModel());
            }
        });
        
        viewFilm.btnExit.addActionListener((ActionEvent e)->
        {
            System.exit(0);
        });
        
    
}
}
