package LB4;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import static LB4.Serialize.Download;
import static LB4.Serialize.Save;
public class LB9 extends JFrame implements ActionListener {
    JButton button1 = new JButton("Новый");
    JButton button2 = new JButton("Открыть");
    JButton button3 = new JButton("Сохранить");
    private JFileChooser fileChooser = null;
    private final String[][] FILTERS = {{"dat", "Файлы dat (*.dat)"},
            {"xml" , "Adobe Reader(*.pdf)"}};
    Bank bank = null;
    public LB9() throws SnyatSoSchetaException{
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Да! Новый!");
        setSize(420,420);
        setVisible(true);

    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("Файл");
        JMenuItem make = new JMenuItem("Создать");
        JMenuItem open = new JMenuItem("Открыть");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem exit = new JMenuItem();
        file.add(make);
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        make.addActionListener(e ->
        {
            String name = JOptionPane.showInputDialog("Введите название банка:");
            Bank bank1 = new Bank(name);
            try {
                TabbedPane tp = new TabbedPane(bank1);

            } catch (SnyatSoSchetaException ex) {
                throw new RuntimeException(ex);
            }
            bank = bank1;
        });
        open.addActionListener(e ->{
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file1 = fileopen.getSelectedFile();
                String pathname = file1.getAbsolutePath();
                try {
                    TabbedPane tp = new TabbedPane(Download(pathname));
                } catch (SnyatSoSchetaException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }


        });
        save.addActionListener(e ->{
            try {
                Save(bank);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        return file;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        }
}




