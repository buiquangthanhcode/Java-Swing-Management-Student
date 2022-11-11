package program;

import students.Student;
import students.Students;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException ;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.awt.event.ActionEvent;


public class StudentProgram extends JPanel {
    private JPanel changecontent;
    private JTextField input_id;
    private JTextField input_name;
    private JTextField input_add;
    private JTextField input_image;
    private JTextField input_gpa;
    private JTextField input_notes;
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModel2;
    private Students studentList = new Students();
    private Student input_data = new Student();
    final private String[] header_table = { "ID", "Fullname", "GPA", "Address", "Image", "Notes" };
    private ArrayList<String> check_view = new ArrayList<>();
    private ArrayList<String> check_gpa = new ArrayList<>();

    public JPanel introduction() {

        JPanel header_introduction = new JPanel();
        header_introduction.setLayout(new BoxLayout(header_introduction,
                BoxLayout.PAGE_AXIS));
        JLabel lable_intro = new JLabel("Student Management App");
        lable_intro.setFont(new Font("SERIF", Font.BOLD, 22));
        lable_intro.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lable_intro.setBorder(new EmptyBorder(0, 0, 50, 0));

        header_introduction.add(lable_intro);

        BufferedImage myPicture;
        try {
            Path current = Paths.get("school.jpeg");
            String s = current.toAbsolutePath().toString();
         ;
            myPicture = ImageIO.read(new File(s);
            final JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            picLabel.setBorder(new EmptyBorder(0, 0, 50, 0)); // create space between 2 label
            header_introduction.add(picLabel);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JButton starButton = new JButton("Start");
        starButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        starButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) (changecontent.getLayout());
                cardLayout.show(changecontent, "window");
            }
        });
        header_introduction.add(starButton);

        return header_introduction;
    }

    public JPanel addStudent() {

        JPanel input_name_panel = new JPanel();

        input_name_panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel input_label_id = new JLabel("Enter your ID:");
        input_id = new JTextField(10);
        JPanel panel_id = new JPanel();
        panel_id.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel_id.add(input_label_id);
        panel_id.add(input_id);

        JLabel input_label_name = new JLabel("Enter your name:");
        input_name = new JTextField(10);
        JPanel panel_name = new JPanel();
        panel_name.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel_name.add(input_label_name);
        panel_name.add(input_name);

        JLabel input_label_add = new JLabel("Enter your address:");
        input_add = new JTextField(10);

        JPanel panel_add = new JPanel();
        panel_add.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel_add.add(input_label_add);
        panel_add.add(input_add);

        JLabel input_label_gpa = new JLabel("Enter your GPA:");
        input_gpa = new JTextField(10);

        JPanel panel_gpa = new JPanel();
        panel_gpa.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel_gpa.add(input_label_gpa);
        panel_gpa.add(input_gpa);

        JLabel input_label_image = new JLabel("Enter your image:");
        input_image = new JTextField(10);

        JPanel panel_image = new JPanel();
        panel_image.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel_image.add(input_label_image);
        panel_image.add(input_image);

        JLabel input_label_notes = new JLabel("Enter your notes:");
        input_notes = new JTextField(10);

        JPanel panel_notes = new JPanel();
        panel_notes.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel_notes.add(input_label_notes);
        panel_notes.add(input_notes);

        gbc.ipadx = 10;
        gbc.ipady = 20;

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        input_name_panel.add(panel_id, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        input_name_panel.add(panel_name, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        input_name_panel.add(panel_add, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        input_name_panel.add(panel_gpa, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 0;
        input_name_panel.add(panel_image, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        input_name_panel.add(panel_notes, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton addbtnStudent = new JButton("Submit information");
        input_name_panel.add(addbtnStudent, gbc);
        addbtnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String getCmd = e.getActionCommand();
                System.out.println(getCmd);

                System.out.println(input_id.getText());
                System.out.println(input_name.getText());
                System.out.println(input_add.getText());
                System.out.println(input_gpa.getText());
                System.out.println(input_notes.getText());
                Double gpa = Double.valueOf(input_gpa.getText());

                input_data = new Student(input_id.getText(), input_name.getText(), gpa, input_image.getText(),
                        input_add.getText(), input_notes.getText());
                ArrayList<String> ids = studentList.getListID();
                if (!ids.contains(input_id.getText())) {
                    studentList.add(input_data);
                    studentList.output();
                } else {
                    System.out.println("Same ID");
                }

            }

        });
        return input_name_panel;
    }

    public JPanel updateStudent() {
        JPanel update_student = new JPanel();
        update_student.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel label_delete = new JLabel("Enter your ID who you want to update: ");
        JTextField jTextField_delete = new JTextField(15);

        JLabel label_target = new JLabel("Enter your target who you want to update: ");
        JTextField jTextField_target = new JTextField(15);

        JLabel label_NewInfor = new JLabel("Enter your new information who you want to update: ");
        JTextField jTextField_NewInfor = new JTextField(15);

        JButton btnUpdate=new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID_UPATE=jTextField_delete.getText();
                String target_Update=jTextField_target.getText();
                String newInfor_Update=jTextField_NewInfor.getText();

                studentList.update(ID_UPATE, target_Update, newInfor_Update);
                int row_Length=tableModel2.getRowCount();
                for (int i=0; i<row_Length; i++) {
                    if(ID_UPATE.equals(tableModel2.getValueAt(i, 0))){

                        for(int j=0;j<6;j++){
                            if(tableModel2.getColumnName(j).equals(target_Update)){
                                tableModel2.setValueAt(newInfor_Update, i, j);
                                break;
                            }

                        }

                    }

                }

            }});


        update_student.add(label_delete);
        update_student.add(jTextField_delete);

        update_student.add(label_target);
        update_student.add(jTextField_target);

        update_student.add(label_NewInfor);
        update_student.add(jTextField_NewInfor);

        update_student.add(btnUpdate);

        return update_student;
    }

    public JPanel viewIdOrder() {
        JPanel panel_view = new JPanel();
        panel_view.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel lale_list = new JLabel("List of Student");

        tableModel2 = new DefaultTableModel();
        JTable table_student = new JTable(tableModel2);
        tableModel2.addColumn("ID");
        tableModel2.addColumn("Fullname");
        tableModel2.addColumn("GPA");
        tableModel2.addColumn("Address");
        tableModel2.addColumn("Image");
        tableModel2.addColumn("Notes");

        table_student.setRowHeight(25);
        table_student.getColumnModel().getColumn(0).setPreferredWidth(130);
        table_student.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_student.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_student.getColumnModel().getColumn(3).setPreferredWidth(130);
        table_student.getColumnModel().getColumn(4).setPreferredWidth(50);
        table_student.getColumnModel().getColumn(5).setPreferredWidth(80);

        panel_view.add(lale_list);
        panel_view.add(table_student);
        JButton reloadBtn = new JButton("Reload");
        panel_view.add(reloadBtn);
        reloadBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<ArrayList<String>> list = studentList.convertToStringDimesion();


                for (int i = 0; i < studentList.getSize(); i++) {
                    if (!check_view.contains(studentList.convertToStringDimesion().get(i).toArray(new String[i])[0])) {
                        tableModel2.addRow(studentList.convertToStringDimesion().get(i).toArray(new String[i]));
                        check_view.add(studentList.convertToStringDimesion().get(i).toArray(new String[i])[0]);
                    }

                }

            }
        });

        return panel_view;
    }

    public JPanel viewGPA() {
        JPanel panel_view_GPA = new JPanel();
        panel_view_GPA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel lale_list = new JLabel("List of Student By GPA");

        tableModel = new DefaultTableModel();
        JTable table_student = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Fullname");
        tableModel.addColumn("GPA");
        tableModel.addColumn("Address");
        tableModel.addColumn("Image");
        tableModel.addColumn("Notes");

        table_student.setRowHeight(25);
        table_student.getColumnModel().getColumn(0).setPreferredWidth(130);
        table_student.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_student.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_student.getColumnModel().getColumn(3).setPreferredWidth(130);
        table_student.getColumnModel().getColumn(4).setPreferredWidth(50);
        table_student.getColumnModel().getColumn(5).setPreferredWidth(80);

        panel_view_GPA.add(lale_list);
        panel_view_GPA.add(table_student);
        JButton reloadBtn = new JButton("Reload");
        panel_view_GPA.add(reloadBtn);
        reloadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < studentList.getSize(); i++) {
                    System.out.println(studentList.convertToStringDimesion().get(i).toArray(new String[i])[0]);
                    if (!check_gpa.contains(studentList.convertToStringDimesion().get(i).toArray(new String[i])[0])) {
                        tableModel.addRow(studentList.convertToStringDimesion().get(i).toArray(new String[i]));
                        check_gpa.add(studentList.convertToStringDimesion().get(i).toArray(new String[i])[0]);
                    }

                }

            }
        });

        return panel_view_GPA;
    }

    public JPanel deleteStudent() {
        JPanel delete_panel = new JPanel();
        delete_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel label_delete = new JLabel("Enter your ID who you want to delete: ");
        JTextField jTextField_delete = new JTextField(15);
        delete_panel.add(label_delete);
        delete_panel.add(jTextField_delete);
        JButton deteButton=new JButton("Delete");
        delete_panel.add(deteButton);
        deteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID_DE= jTextField_delete.getText();
                int row_Length=tableModel2.getRowCount();
                for (int i = 0; i < row_Length; i++) {
                    if(tableModel2.getValueAt(i, 0).equals(ID_DE)){
                        tableModel2.removeRow(i);
                        tableModel2.fireTableDataChanged();
                        tableModel.removeRow(i);
                        tableModel.fireTableDataChanged();
                        break;

                    }
                }
            };
        });

        return delete_panel;
    }
    public JPanel saveFilePanel(){

        JPanel panel_save=new JPanel();
        panel_save.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel namefile=new JLabel("Enter name of file to save");
        JTextField jTextField_name=new JTextField(15);
        JButton saveBtn=new JButton("Save");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name_file=jTextField_name.getText();
                try {
                    boolean state=studentList.saveFile(name_file);
                    if(state){
                        JOptionPane.showMessageDialog(null, "File saved successfully");
                        JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
                        int option = fileChooser.showOpenDialog(null);

                    }else{
                        JOptionPane.showMessageDialog(null, "File failed to be saved successfully");
                    }
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


            } });
        panel_save.add(namefile);
        panel_save.add(jTextField_name);
        panel_save.add(saveBtn);

        return panel_save;
    }
    public JPanel winDowPanel() {

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel header = new JPanel();
        JLabel lable_window = new JLabel("USER INTERFACE");
        lable_window.setHorizontalAlignment(JLabel.CENTER);
        JButton bntBackIntro = new JButton("Back");
        bntBackIntro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = (CardLayout) (changecontent.getLayout());
                cardLayout.show(changecontent, "intro");
            }
        });
        header.add(lable_window);
        header.add(bntBackIntro);
        header.setBorder(new EmptyBorder(10, 0, 30, 0)); // create space between 2 label

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        JPanel wrapper_menu = new JPanel();
        GridLayout layout = new GridLayout(4, 8);
        wrapper_menu.setLayout(layout);
        wrapper_menu.setPreferredSize(new Dimension(600, 120));

        JPanel wrapper_2 = new JPanel();
        wrapper_2.setLayout(new CardLayout());

        JButton btnAdd = new JButton("Add student");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) (wrapper_2.getLayout());
                cardLayout.show(wrapper_2, "add");
            }
        });
        btnAdd.setActionCommand("Add");
        JButton btnUpdate = new JButton("Update student");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) (wrapper_2.getLayout());
                cardLayout.show(wrapper_2, "update");

            }
        });
        JButton btnDetele = new JButton("Delete student");
        btnDetele.setActionCommand("delete");
        btnDetele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) (wrapper_2.getLayout());
                cardLayout.show(wrapper_2, "delete");

            }
        });
        JButton btnViewID = new JButton("View ID student");
        btnViewID.setActionCommand("viewID");
        btnViewID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
                CardLayout cardLayout = (CardLayout) (wrapper_2.getLayout());
                cardLayout.show(wrapper_2, "viewID");

            }
        });
        JButton btnViewGPA = new JButton("View GPA student");
        btnViewGPA.setActionCommand("viewGPA");
        btnViewGPA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) (wrapper_2.getLayout());
                cardLayout.show(wrapper_2, "viewGPA");

            }
        });
        JButton btnSaveFile = new JButton("Save file student");
        btnSaveFile.setActionCommand("savefile");
        btnSaveFile.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              CardLayout cardLayout = (CardLayout) (wrapper_2.getLayout());
                                              cardLayout.show(wrapper_2, "savefile");

                                          }
                                      }
        );

        JButton btnExport = new JButton("Export file student");
        btnExport.setActionCommand("export");

        JButton btnImport = new JButton("Import File student");
        btnImport.setActionCommand("import");

        wrapper_menu.add(btnAdd);
        wrapper_menu.add(btnUpdate);
        wrapper_menu.add(btnDetele);
        wrapper_menu.add(btnViewID);
        wrapper_menu.add(btnViewGPA);
        wrapper_menu.add(btnSaveFile);
        wrapper_menu.add(btnExport);
        wrapper_menu.add(btnImport);

        wrapper_2.add("add", addStudent());
        wrapper_2.add("delete", deleteStudent());
        wrapper_2.add("update", updateStudent());
        wrapper_2.add("viewID", viewIdOrder());
        wrapper_2.add("viewGPA", viewGPA());
        wrapper_2.add("savefile", saveFilePanel());

        wrapper_menu.setBackground(Color.lightGray);
        content.add(wrapper_menu);

        content.add(wrapper_2);

        main.add(header, BorderLayout.NORTH);
        main.add(content, BorderLayout.CENTER);
        return main;
    }

    public void updateData() {

    }

    public void prepareGUI() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        changecontent = new JPanel();
        changecontent.setLayout(new CardLayout());

        changecontent.add("intro", introduction());
        changecontent.add("window", winDowPanel());

        frame.add(changecontent, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }


}
