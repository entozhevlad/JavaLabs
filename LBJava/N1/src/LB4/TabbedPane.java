package LB4;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TabbedPane extends JFrame implements ActionListener   {
    JButton button1 = new JButton("Снять");
    JButton button2 = new JButton("Зарегистрировать аккаунт");
    JButton button3 = new JButton("Добавить банкомат");
    JTextField text1 = new JTextField();
    JLabel label6 = new JLabel();
    JLabel label7 = new JLabel();
    JTable table1 = new JTable();
    JTable table2 = new JTable();
    String[][] array = {null};
    String[][] tableData = {null};
    public TabbedPane(Bank bank) throws SnyatSoSchetaException {

        String name = bank.getName();
        int size = bank.getSize();
        System.out.println(size);
        int atms = bank.getATMs();
        String[] columnsHeader = new String[]{"ID", "Адрес"};
        array = new String[bank.getATMs()][bank.getATMs()];
        for (int i = 0; i < atms; i += 1) {
            String id = String.valueOf(((ATM) bank.getATM().get(i)).getId());
            String adress = ((ATM) bank.getATM().get(i)).getAddress();
            array[i][0] = id;
            array[i][1] = adress;
        }
        table1 = new JTable(array, columnsHeader);
        table1.setPreferredScrollableViewportSize(new Dimension(400, 200));

        String[] columnsHeaderAcc = new String[]{"Номер счёта:", "Тип счёта", "PIN", "Баланс:"};
        tableData = new String[size][4];
        for (int i = 0; i < size; i += 1) {
            String type = ((Account) bank.getAccounts().get(i)).getType();
            String numb = String.valueOf(((Account) bank.getAccounts().get(i)).getNumb());
            String pin = String.valueOf(((Account) bank.getAccounts().get(i)).getPin());
            String balance = String.valueOf(((Account) bank.getAccounts().get(i)).getBalance());
            tableData[i][0] = numb;
            tableData[i][1] = type;
            tableData[i][2] = pin;
            tableData[i][3] = balance;
        }
        table2 = new JTable(tableData, columnsHeaderAcc);
        table2.setPreferredScrollableViewportSize(new Dimension(400, 200));
        JTabbedPane jtp = new JTabbedPane();
        JPanel jp1 = new JPanel(null);
        JPanel jp2 = new JPanel(null);
        JPanel jp3 = new JPanel(null);
        setTitle(name);
        getContentPane().add(jtp);
        button1.setBounds(0, 160, 100, 50);
        button2.setBounds(0, 40, 300, 50);
        button3.setBounds(0, 100, 300, 50);
        label6.setText("Количество Аккаунтов в банке: " + size);
        label7.setText("Количество банкоматов: " + atms);
        jp1.add(text1);
        jp1.add(button1);
        jp1.add(table2.getTableHeader());
        jp1.add(table2);
        jp2.add(table1.getTableHeader());
        jp2.add(table1);
        jp3.add(label6);
        jp3.add(label7);
        jp3.add(button2);
        jp3.add(button3);
        jtp.addTab("Информация о счёте", jp1);
        jtp.addTab("Банкоматы", jp2);
        jtp.addTab("Админ.Панель", jp3);
        jp1.setLayout(null);
        jp2.setLayout(null);


        label6.setLocation(0, 0);
        label7.setLocation(0, 20);
        table2.getTableHeader().setLocation(0, 0);
        table2.setLocation(0, 40);
        table1.getTableHeader().setLocation(0, 0);
        table1.setLocation(0, 40);

        label6.setSize(3000, 14);
        label7.setSize(3000, 14);
        table2.getTableHeader().setSize(3000, 40);
        table2.setSize(300, 100);
        table1.getTableHeader().setSize(3000, 40);
        table1.setSize(300, 100);

        button1.addActionListener(e -> {
            jp1.remove(table2);
            int a = Integer.parseInt(JOptionPane.showInputDialog("Введите номер счёта"));
            int x = Integer.parseInt(JOptionPane.showInputDialog("Введите сумму для снятия"));
            for (int i = 0; i < size; i += 1) {
                if (a == Integer.parseInt(tableData[i][0])) {
                    try {
                        ((Account) bank.getAccounts().get(i)).withdraw(x);
                    } catch (SnyatSoSchetaException ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка: Недостаточно средств", "Снятие", JOptionPane.ERROR_MESSAGE);
                        x=0;
                        System.exit(0);
                    }

                }
            }
            String[][] tableData1 = new String[bank.getSize()][4];
            for (int i = 0; i < bank.getSize(); i += 1) {
                String type = ((Account) bank.getAccounts().get(i)).getType();
                String numb = String.valueOf(((Account) bank.getAccounts().get(i)).getNumb());
                String pin = String.valueOf(((Account) bank.getAccounts().get(i)).getPin());
                String balance = String.valueOf(((Account) bank.getAccounts().get(i)).getBalance());
                tableData1[i][0] = numb;
                tableData1[i][1] = type;
                tableData1[i][2] = pin;
                tableData1[i][3] = balance;
            }
            table2 = new JTable(tableData1, columnsHeaderAcc);
            jp1.add(table2);
            table2.setLocation(0, 40);
            table2.getTableHeader().setSize(3000, 40);
            table2.setSize(300, 100);
            table2.setPreferredScrollableViewportSize(new Dimension(400, 200));



        });
        button2.addActionListener(e -> {
            jp1.remove(table2);
            int pin_reg = 0000;
            String type1 = "";
            String[] responses1 = {"Стандартный", "Льготный", "Отмена"};
            int a = JOptionPane.showOptionDialog(null, "Выберите тип счёта:", "Регистрация", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses1, 0);
            if (a == 0) {
                System.out.println("Стандартный");
                type1 = "standart";
                pin_reg = Integer.parseInt(JOptionPane.showInputDialog("Введите пин-код:"));
            } else if (a == 1) {
                System.out.println("Льготный");
                type1 = "preferential";
                pin_reg = Integer.parseInt(JOptionPane.showInputDialog("Введите пин-код:"));

            }
            if (type1 == "standart") {
                int num_acc = bank.getSize()+1;
                int b = 0;
                Standart standart1 = new Standart(num_acc, pin_reg, b);
                bank.addAccount(standart1);
                int size1 = bank.getSize();
                label6.setText("Количество Аккаунтов в банке: " + size1);

            } else if (type1 == "preferential") {
                int num_acc = bank.getSize()+1;
                int b = 0;
                Preferential preferential1 = new Preferential(num_acc, pin_reg, b);
                bank.addAccount(preferential1);
                int size1 = bank.getSize();
                label6.setText("Количество Аккаунтов в банке: " + size1);
            }
            String[][] tableData1 = new String[bank.getSize()][4];
            for (int i = 0; i < bank.getSize(); i += 1) {
                String type = ((Account) bank.getAccounts().get(i)).getType();
                String numb = String.valueOf(((Account) bank.getAccounts().get(i)).getNumb());
                String pin = String.valueOf(((Account) bank.getAccounts().get(i)).getPin());
                String balance = String.valueOf(((Account) bank.getAccounts().get(i)).getBalance());
                tableData1[i][0] = numb;
                tableData1[i][1] = type;
                tableData1[i][2] = pin;
                tableData1[i][3] = balance;
            }
            table2 = new JTable(tableData1, columnsHeaderAcc);
            jp1.add(table2);
            table2.setLocation(0, 40);
            table2.getTableHeader().setSize(3000, 40);
            table2.setSize(300, 100);
            table2.setPreferredScrollableViewportSize(new Dimension(400, 200));

        });
        button3.addActionListener(e -> {
            jp2.remove(table1);
            int id_reg = Integer.parseInt(JOptionPane.showInputDialog("Введите ID:"));
            String adress_reg = JOptionPane.showInputDialog("Введите адрес:");
            ATM atm1 = new ATM(id_reg, adress_reg);
            bank.addATM(atm1);
            String[][] array1 = new String[bank.getATMs()][bank.getATMs()];
            for (int i = 0; i < bank.getATMs(); i += 1) {
                String id = String.valueOf(((ATM) bank.getATM().get(i)).getId());
                String adress = ((ATM) bank.getATM().get(i)).getAddress();
                array1[i][0] = id;
                array1[i][1] = adress;
            }
            table1 = new JTable(array1, columnsHeader);
            jp2.add(table1);
            table1.setLocation(0, 40);
            table1.getTableHeader().setSize(3000, 40);
            table1.setSize(300, 100);
            table1.setPreferredScrollableViewportSize(new Dimension(400, 200));
            label7.setText("Количество банкоматов: " + bank.getATMs());
        });
        setSize(420, 420);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}


