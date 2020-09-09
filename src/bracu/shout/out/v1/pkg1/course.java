/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bracu.shout.out.v1.pkg1;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Niloy
 */
public class course extends javax.swing.JFrame {

    /**
     * Creates new form course
     */
    String user;
    String backUser;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    String id1="", id2="", id3="", id4="", id5="", f1="", f2="", f3="", f4="", f5="";
    public course() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public course(String u, String u2) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        user=u;
        backUser=u2;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shout_out_v1_1";  
            Properties info = new Properties();
            info.put("user", "Niloy");
            info.put("password", "0246810");
            con = DriverManager.getConnection(url, info);
            st=con.createStatement();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: "+ex);
        }
        String str="";
        if(stdORfac(backUser))
        {
            if(getC1(backUser).length()==6)
            {
                String query = "select course_id, course_title, course_sec, course_instructor, schedule from courses inner join stdProfile on courses.course_id=stdProfile.course1 where stdProfile.sec1=courses.course_sec and stdProfile.course1=courses.course_id and stdProfile.user='"+backUser+"';";
                rs= st.executeQuery(query);
                while(rs.next())
                {
                    str= rs.getString("course_id");
                    id1=str;
                    courseLabel2.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel2.setText(str);
                    str= rs.getString("course_sec");
                    secLabel2.setText(str);
                    str= rs.getString("course_instructor");
                    f1=str;
                    facultyLabel2.setText(str);
                    str= rs.getString("schedule");
                    timeLabel2.setText(str);
                }
            }
            if(getC2(backUser).length()==6)
            {
                String query = "select course_id, course_title, course_sec, course_instructor, schedule from courses inner join stdProfile on courses.course_id=stdProfile.course2 where stdProfile.sec2=courses.course_sec and stdProfile.course2=courses.course_id and stdProfile.user='"+backUser+"';";
                rs= st.executeQuery(query);
                while(rs.next())
                {
                    str= rs.getString("course_id");
                    id2=str;
                    courseLabel3.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel3.setText(str);
                    str= rs.getString("course_sec");
                    secLabel3.setText(str);
                    str= rs.getString("course_instructor");
                    f2=str;
                    facultyLabel4.setText(str);
                    str= rs.getString("schedule");
                    timeLabel3.setText(str);
                }
            }
            if(getC3(backUser).length()==6)
            {
                String query = "select course_id, course_title, course_sec, course_instructor, schedule from courses inner join stdProfile on courses.course_id=stdProfile.course3 where stdProfile.sec3=courses.course_sec and stdProfile.course3=courses.course_id and stdProfile.user='"+backUser+"';";
                rs= st.executeQuery(query);
                while(rs.next())
                {
                    str= rs.getString("course_id");
                    id3=str;
                    courseLabel5.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel5.setText(str);
                    str= rs.getString("course_sec");
                    secLabel5.setText(str);
                    str= rs.getString("course_instructor");
                    f3=str;
                    facultyLabel6.setText(str);
                    str= rs.getString("schedule");
                    timeLabel5.setText(str);
                }
            }
            if(getC4(backUser).length()==6)
            {
                String query = "select course_id, course_title, course_sec, course_instructor, schedule from courses inner join stdProfile on courses.course_id=stdProfile.course4 where stdProfile.sec4=courses.course_sec and stdProfile.course4=courses.course_id and stdProfile.user='"+backUser+"';";
                rs= st.executeQuery(query);
                while(rs.next())
                {
                    str= rs.getString("course_id");
                    id4=str;
                    courseLabel7.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel7.setText(str);
                    str= rs.getString("course_sec");
                    secLabel7.setText(str);
                    str= rs.getString("course_instructor");
                    f4=str;
                    facultyLabel8.setText(str);
                    str= rs.getString("schedule");
                    timeLabel7.setText(str);
                }
            }
            if(getC5(backUser).length()==6)
            {
                String query = "select course_id, course_title, course_sec, course_instructor, schedule from courses inner join stdProfile on courses.course_id=stdProfile.course5 where stdProfile.sec5=courses.course_sec and stdProfile.course5=courses.course_id and stdProfile.user='"+backUser+"' order by course_id;";
                rs= st.executeQuery(query);
                while(rs.next())
                {
                    str= rs.getString("course_id");
                    id5=str;
                    courseLabel9.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel9.setText(str);
                    str= rs.getString("course_sec");
                    secLabel9.setText(str);
                    str= rs.getString("course_instructor");
                    f5=str;
                    facultyLabel10.setText(str);
                    str= rs.getString("schedule");
                    timeLabel9.setText(str);
                }
            }
        }
        else
        {
            int count=1;
            String query = "select course_id, course_title, course_sec, course_instructor, schedule from courses inner join facProfile on courses.course_instructor=facProfile.name where facProfile.user='"+backUser+"' order by course_id;";
            rs= st.executeQuery(query);
            while(rs.next())
            {
                if(count==1)
                {
                    str= rs.getString("course_id");
                    id1=str;
                    courseLabel2.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel2.setText(str);
                    str= rs.getString("course_sec");
                    secLabel2.setText(str);
                    str= rs.getString("course_instructor");
                    f1=str;
                    facultyLabel2.setText(str);
                    str= rs.getString("schedule");
                    timeLabel2.setText(str);
                }
                else if(count==2)
                {
                    str= rs.getString("course_id");
                    id2=str;
                    courseLabel3.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel3.setText(str);
                    str= rs.getString("course_sec");
                    secLabel3.setText(str);
                    str= rs.getString("course_instructor");
                    f2=str;
                    facultyLabel4.setText(str);
                    str= rs.getString("schedule");
                    timeLabel3.setText(str);
                }
                else if(count==3)
                {
                    str= rs.getString("course_id");
                    id3=str;
                    courseLabel5.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel5.setText(str);
                    str= rs.getString("course_sec");
                    secLabel5.setText(str);
                    str= rs.getString("course_instructor");
                    f3=str;
                    facultyLabel6.setText(str);
                    str= rs.getString("schedule");
                    timeLabel5.setText(str);
                }
                else if(count==4)
                {
                    str= rs.getString("course_id");
                    id4=str;
                    courseLabel7.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel7.setText(str);
                    str= rs.getString("course_sec");
                    secLabel7.setText(str);
                    str= rs.getString("course_instructor");
                    f4=str;
                    facultyLabel8.setText(str);
                    str= rs.getString("schedule");
                    timeLabel7.setText(str);
                }
                else if(count==5)
                {
                    str= rs.getString("course_id");
                    id5=str;
                    courseLabel9.setText(str);
                    str= rs.getString("course_title");
                    courseNameLabel9.setText(str);
                    str= rs.getString("course_sec");
                    secLabel9.setText(str);
                    str= rs.getString("course_instructor");
                    f5=str;
                    facultyLabel10.setText(str);
                    str= rs.getString("schedule");
                    timeLabel9.setText(str);
                }
                count++;
            }
        }
        String q = "select user, message, date from comment WHERE course='"+id1+"' and date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) order by date desc;"; 
        rs= st.executeQuery(q);
        String us="", message="", date="";
        while(rs.next())
        {
            us=rs.getString("user");
            message=rs.getString("message");
            date=rs.getString("date");
            if("admin".equals(us))
            {
                us=f1;
                shoutArea.append(date+" --> Faculty: --> "+us+": --> "+message+"\n");
            }
            else
            {
                shoutArea.append(date+" --> Student: --> "+us+": --> "+message+"\n");
            }
        }
        q = "select user, message, date from comment WHERE course='"+id2+"' and date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) order by date desc;"; 
        rs= st.executeQuery(q);
        us=""; 
        message="";
        date="";
        while(rs.next())
        {
            us=rs.getString("user");
            message=rs.getString("message");
            date=rs.getString("date");
            if("admin".equals(us))
            {
                us=f2;
                shoutArea1.append(date+" --> Faculty: --> "+us+": --> "+message+"\n");
            }
            else
            {
                shoutArea1.append(date+" --> Student: --> "+us+": --> "+message+"\n");
            }
        }
        q = "select user, message, date from comment WHERE course='"+id3+"' and date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) order by date desc;"; 
        rs= st.executeQuery(q);
        us=""; 
        message="";
        date="";
        while(rs.next())
        {
            us=rs.getString("user");
            message=rs.getString("message");
            date=rs.getString("date");
            if("admin".equals(us))
            {
                us=f3;
                shoutArea2.append(date+" --> Faculty: --> "+us+": --> "+message+"\n");
            }
            else
            {
                shoutArea2.append(date+" --> Student: --> "+us+": --> "+message+"\n");
            }
        }
        q = "select user, message, date from comment WHERE course='"+id4+"' and date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) order by date desc;"; 
        rs= st.executeQuery(q);
        us=""; 
        message="";
        date="";
        while(rs.next())
        {
            us=rs.getString("user");
            message=rs.getString("message");
            date=rs.getString("date");
            if("admin".equals(us))
            {
                us=f4;
                shoutArea3.append(date+" --> Faculty: --> "+us+": --> "+message+"\n");
            }
            else
            {
                shoutArea3.append(date+" --> Student: --> "+us+": --> "+message+"\n");
            }
        }
        q = "select user, message, date from comment WHERE course='"+id5+"' and date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) order by date desc;"; 
        rs= st.executeQuery(q);
        us=""; 
        message="";
        date="";
        while(rs.next())
        {
            us=rs.getString("user");
            message=rs.getString("message");
            date=rs.getString("date");
            if("admin".equals(us))
            {
                us=f5;
                shoutArea4.append(date+" --> Faculty: --> "+us+": --> "+message+"\n");
            }
            else
            {
                shoutArea4.append(date+" --> Student: --> "+us+": --> "+message+"\n");
            }
        }
    }
    public String getC1(String u) throws SQLException
    {
        String str=null;
        String query = "select course1 from stdprofile where user='"+u+"';";
        rs= st.executeQuery(query);
        while(rs.next())
        {
            str= rs.getString("course1");
        }
        if(str==null)
        {
            query = "select course1 from facprofile where user='"+u+"';";
            rs= st.executeQuery(query);
            while(rs.next())
            {
                str= rs.getString("course1");
            }
        }
        return str;
    }
    public String getC2(String u) throws SQLException
    {
        String str=null;
        String query = "select course2 from stdprofile where user='"+u+"';";
        rs= st.executeQuery(query);
        while(rs.next())
        {
            str= rs.getString("course2");
        }
        if(str==null)
        {
            query = "select course2 from facprofile where user='"+u+"';";
            rs= st.executeQuery(query);
            while(rs.next())
            {
                str= rs.getString("course2");
            }
        }
        return str;
    }
    public String getC3(String u) throws SQLException
    {
        String str=null;
        String query = "select course3 from stdprofile where user='"+u+"';";
        rs= st.executeQuery(query);
        while(rs.next())
        {
            str= rs.getString("course3");
        }
        if(str==null)
        {
            query = "select course3 from facprofile where user='"+u+"';";
            rs= st.executeQuery(query);
            while(rs.next())
            {
                str= rs.getString("course3");
            }
        }
        return str;
    }
    public String getC4(String u) throws SQLException
    {
        String str=null;
        String query = "select course4 from stdprofile where user='"+u+"';";
        rs= st.executeQuery(query);
        while(rs.next())
        {
            str= rs.getString("course4");
        }
        if(str==null)
        {
            query = "select course4 from facprofile where user='"+u+"';";
            rs= st.executeQuery(query);
            while(rs.next())
            {
                str= rs.getString("course4");
            }
        }
        return str;
    }
    public String getC5(String u) throws SQLException
    {
        String str=null;
        String query = "select course5 from stdprofile where user='"+u+"';";
        rs= st.executeQuery(query);
        while(rs.next())
        {
            str= rs.getString("course5");
        }
        if(str==null)
        {
            query = "select course5 from facprofile where user='"+u+"';";
            rs= st.executeQuery(query);
            while(rs.next())
            {
                str= rs.getString("course5");
            }
        }
        return str;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        profileLabel = new javax.swing.JLabel();
        minLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        courseButton4 = new javax.swing.JButton();
        courseButton1 = new javax.swing.JButton();
        courseButton2 = new javax.swing.JButton();
        courseButton3 = new javax.swing.JButton();
        courseButton5 = new javax.swing.JButton();
        layeredPane = new javax.swing.JLayeredPane();
        Panel1 = new javax.swing.JPanel();
        backButton1 = new javax.swing.JButton();
        courseTitleLabel = new javax.swing.JLabel();
        courseLabel = new javax.swing.JLabel();
        courseLabel2 = new javax.swing.JLabel();
        courseNameLabel = new javax.swing.JLabel();
        courseNameLabel2 = new javax.swing.JLabel();
        secLabel = new javax.swing.JLabel();
        secLabel2 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeLabel2 = new javax.swing.JLabel();
        commentLabel = new javax.swing.JLabel();
        postLabel = new javax.swing.JLabel();
        shoutField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        shoutArea = new javax.swing.JTextArea();
        postButton1 = new javax.swing.JButton();
        facultyLabel = new javax.swing.JLabel();
        facultyLabel2 = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        backButton6 = new javax.swing.JButton();
        courseTitleLabel1 = new javax.swing.JLabel();
        courseLabel1 = new javax.swing.JLabel();
        courseLabel3 = new javax.swing.JLabel();
        courseNameLabel1 = new javax.swing.JLabel();
        courseNameLabel3 = new javax.swing.JLabel();
        secLabel1 = new javax.swing.JLabel();
        secLabel3 = new javax.swing.JLabel();
        facultyLabel3 = new javax.swing.JLabel();
        facultyLabel4 = new javax.swing.JLabel();
        timeLabel1 = new javax.swing.JLabel();
        timeLabel3 = new javax.swing.JLabel();
        commentLabel1 = new javax.swing.JLabel();
        postLabel1 = new javax.swing.JLabel();
        shoutField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        shoutArea1 = new javax.swing.JTextArea();
        postButton2 = new javax.swing.JButton();
        Panel3 = new javax.swing.JPanel();
        backButton2 = new javax.swing.JButton();
        courseTitleLabel2 = new javax.swing.JLabel();
        courseLabel4 = new javax.swing.JLabel();
        courseLabel5 = new javax.swing.JLabel();
        courseNameLabel4 = new javax.swing.JLabel();
        courseNameLabel5 = new javax.swing.JLabel();
        secLabel4 = new javax.swing.JLabel();
        secLabel5 = new javax.swing.JLabel();
        facultyLabel5 = new javax.swing.JLabel();
        facultyLabel6 = new javax.swing.JLabel();
        timeLabel4 = new javax.swing.JLabel();
        timeLabel5 = new javax.swing.JLabel();
        commentLabel2 = new javax.swing.JLabel();
        postLabel2 = new javax.swing.JLabel();
        shoutField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        shoutArea2 = new javax.swing.JTextArea();
        postButton3 = new javax.swing.JButton();
        Panel4 = new javax.swing.JPanel();
        backButton3 = new javax.swing.JButton();
        courseTitleLabel3 = new javax.swing.JLabel();
        courseLabel6 = new javax.swing.JLabel();
        courseLabel7 = new javax.swing.JLabel();
        courseNameLabel6 = new javax.swing.JLabel();
        courseNameLabel7 = new javax.swing.JLabel();
        secLabel6 = new javax.swing.JLabel();
        secLabel7 = new javax.swing.JLabel();
        facultyLabel7 = new javax.swing.JLabel();
        facultyLabel8 = new javax.swing.JLabel();
        timeLabel6 = new javax.swing.JLabel();
        timeLabel7 = new javax.swing.JLabel();
        commentLabel3 = new javax.swing.JLabel();
        postLabel3 = new javax.swing.JLabel();
        shoutField3 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        shoutArea3 = new javax.swing.JTextArea();
        postButton4 = new javax.swing.JButton();
        Panel5 = new javax.swing.JPanel();
        backButton4 = new javax.swing.JButton();
        courseTitleLabel4 = new javax.swing.JLabel();
        courseLabel8 = new javax.swing.JLabel();
        courseLabel9 = new javax.swing.JLabel();
        courseNameLabel8 = new javax.swing.JLabel();
        courseNameLabel9 = new javax.swing.JLabel();
        secLabel8 = new javax.swing.JLabel();
        secLabel9 = new javax.swing.JLabel();
        facultyLabel9 = new javax.swing.JLabel();
        facultyLabel10 = new javax.swing.JLabel();
        timeLabel8 = new javax.swing.JLabel();
        timeLabel9 = new javax.swing.JLabel();
        commentLabel4 = new javax.swing.JLabel();
        postLabel4 = new javax.swing.JLabel();
        shoutField4 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        shoutArea4 = new javax.swing.JTextArea();
        postButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 229, 27));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 0), new java.awt.Color(51, 0, 51), null, null));
        jPanel1.setLayout(null);

        profileLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        profileLabel.setForeground(new java.awt.Color(0, 0, 0));
        profileLabel.setText("COURSE PANEL");
        jPanel1.add(profileLabel);
        profileLabel.setBounds(48, 29, 300, 47);

        minLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        minLabel.setForeground(new java.awt.Color(0, 0, 0));
        minLabel.setText("_");
        minLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minLabelMouseClicked(evt);
            }
        });
        jPanel1.add(minLabel);
        minLabel.setBounds(1128, 29, 20, 47);

        closeLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        closeLabel.setForeground(new java.awt.Color(0, 0, 0));
        closeLabel.setText("X");
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
        });
        jPanel1.add(closeLabel);
        closeLabel.setBounds(1190, 41, 26, 47);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 100));

        jPanel2.setBackground(new java.awt.Color(140, 20, 252));

        courseButton4.setBackground(new java.awt.Color(25, 181, 254));
        courseButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        courseButton4.setText("Course 4");
        courseButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseButton4ActionPerformed(evt);
            }
        });

        courseButton1.setBackground(new java.awt.Color(25, 181, 254));
        courseButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        courseButton1.setText("Course 1");
        courseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseButton1ActionPerformed(evt);
            }
        });

        courseButton2.setBackground(new java.awt.Color(25, 181, 254));
        courseButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        courseButton2.setText("Course 2");
        courseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseButton2ActionPerformed(evt);
            }
        });

        courseButton3.setBackground(new java.awt.Color(25, 181, 254));
        courseButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        courseButton3.setText("Course 3");
        courseButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseButton3ActionPerformed(evt);
            }
        });

        courseButton5.setBackground(new java.awt.Color(25, 181, 254));
        courseButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        courseButton5.setText("Course 5");
        courseButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(courseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(courseButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(courseButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(courseButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(courseButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(courseButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(courseButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(courseButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(courseButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1240, 100));

        layeredPane.setLayout(new java.awt.CardLayout());

        Panel1.setBackground(new java.awt.Color(52, 73, 94));

        backButton1.setBackground(new java.awt.Color(219, 10, 91));
        backButton1.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        backButton1.setText("BACK");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        courseTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseTitleLabel.setForeground(new java.awt.Color(0, 230, 64));
        courseTitleLabel.setText("Courses Details:");

        courseLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel.setForeground(new java.awt.Color(0, 230, 64));
        courseLabel.setText("Course Code:");

        courseLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel2.setForeground(new java.awt.Color(0, 230, 64));

        courseNameLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel.setForeground(new java.awt.Color(0, 230, 64));
        courseNameLabel.setText("Course Name:");

        courseNameLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel2.setForeground(new java.awt.Color(0, 230, 64));

        secLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel.setForeground(new java.awt.Color(0, 230, 64));
        secLabel.setText("Section:");

        secLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel2.setForeground(new java.awt.Color(0, 230, 64));

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(0, 230, 64));
        timeLabel.setText("Class Schedule:");

        timeLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel2.setForeground(new java.awt.Color(0, 230, 64));

        commentLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        commentLabel.setForeground(new java.awt.Color(0, 230, 64));
        commentLabel.setText("General Comment or Announcement:");

        postLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        postLabel.setForeground(new java.awt.Color(0, 230, 64));
        postLabel.setText("POST:");

        shoutArea.setColumns(20);
        shoutArea.setRows(5);
        jScrollPane1.setViewportView(shoutArea);

        postButton1.setBackground(new java.awt.Color(25, 181, 254));
        postButton1.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        postButton1.setText("POST");
        postButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButton1ActionPerformed(evt);
            }
        });

        facultyLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel.setForeground(new java.awt.Color(0, 230, 64));
        facultyLabel.setText("Instructor:");

        facultyLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel2.setForeground(new java.awt.Color(0, 230, 64));

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(postButton1)
                        .addGap(34, 34, 34)
                        .addComponent(backButton1)
                        .addGap(15, 15, 15))
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addComponent(commentLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addComponent(postLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                        .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shoutField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel1Layout.createSequentialGroup()
                                .addComponent(courseLabel)
                                .addGap(31, 31, 31)
                                .addComponent(courseLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(courseNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(courseNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel1Layout.createSequentialGroup()
                                .addComponent(courseTitleLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(Panel1Layout.createSequentialGroup()
                                .addComponent(secLabel)
                                .addGap(18, 18, 18)
                                .addComponent(secLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(facultyLabel)
                                .addGap(18, 18, 18)
                                .addComponent(facultyLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(timeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(timeLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(36, 36, 36))))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(courseTitleLabel)
                .addGap(18, 18, 18)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(facultyLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(commentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shoutField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backButton1)
                            .addComponent(postButton1))
                        .addGap(17, 17, 17))
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layeredPane.add(Panel1, "card2");

        Panel2.setBackground(new java.awt.Color(52, 73, 94));

        backButton6.setBackground(new java.awt.Color(219, 10, 91));
        backButton6.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        backButton6.setText("BACK");
        backButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton6ActionPerformed(evt);
            }
        });

        courseTitleLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseTitleLabel1.setForeground(new java.awt.Color(0, 230, 64));
        courseTitleLabel1.setText("Courses Details:");

        courseLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel1.setForeground(new java.awt.Color(0, 230, 64));
        courseLabel1.setText("Course Code:");

        courseLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel3.setForeground(new java.awt.Color(0, 230, 64));

        courseNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel1.setForeground(new java.awt.Color(0, 230, 64));
        courseNameLabel1.setText("Course Name:");

        courseNameLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel3.setForeground(new java.awt.Color(0, 230, 64));

        secLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel1.setForeground(new java.awt.Color(0, 230, 64));
        secLabel1.setText("Section:");

        secLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel3.setForeground(new java.awt.Color(0, 230, 64));

        facultyLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel3.setForeground(new java.awt.Color(0, 230, 64));
        facultyLabel3.setText("Instructor:");

        facultyLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel4.setForeground(new java.awt.Color(0, 230, 64));

        timeLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel1.setForeground(new java.awt.Color(0, 230, 64));
        timeLabel1.setText("Class Schedule:");

        timeLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel3.setForeground(new java.awt.Color(0, 230, 64));

        commentLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        commentLabel1.setForeground(new java.awt.Color(0, 230, 64));
        commentLabel1.setText("General Comment or Announcement:");

        postLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        postLabel1.setForeground(new java.awt.Color(0, 230, 64));
        postLabel1.setText("POST:");

        shoutArea1.setColumns(20);
        shoutArea1.setRows(5);
        jScrollPane2.setViewportView(shoutArea1);

        postButton2.setBackground(new java.awt.Color(25, 181, 254));
        postButton2.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        postButton2.setText("POST");
        postButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(postButton2)
                        .addGap(31, 31, 31)
                        .addComponent(backButton6)
                        .addGap(15, 15, 15))
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addComponent(commentLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addComponent(postLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shoutField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel2Layout.createSequentialGroup()
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel2Layout.createSequentialGroup()
                                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Panel2Layout.createSequentialGroup()
                                                .addComponent(courseLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                                .addComponent(courseLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(Panel2Layout.createSequentialGroup()
                                                .addComponent(courseTitleLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(33, 33, 33))
                                    .addGroup(Panel2Layout.createSequentialGroup()
                                        .addComponent(secLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(secLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(facultyLabel3)
                                        .addGap(21, 21, 21)))
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel2Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(courseNameLabel1)
                                        .addGap(40, 40, 40)
                                        .addComponent(courseNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                                        .addComponent(facultyLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(timeLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(timeLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(36, 36, 36))))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(courseTitleLabel1)
                .addGap(30, 30, 30)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(courseNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(courseNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(secLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(facultyLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(timeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(facultyLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(timeLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(commentLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoutField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton6)
                    .addComponent(postButton2))
                .addGap(17, 17, 17))
        );

        layeredPane.add(Panel2, "card2");

        Panel3.setBackground(new java.awt.Color(52, 73, 94));

        backButton2.setBackground(new java.awt.Color(219, 10, 91));
        backButton2.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        backButton2.setText("BACK");
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });

        courseTitleLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseTitleLabel2.setForeground(new java.awt.Color(0, 230, 64));
        courseTitleLabel2.setText("Courses Details:");

        courseLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel4.setForeground(new java.awt.Color(0, 230, 64));
        courseLabel4.setText("Course Code:");

        courseLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel5.setForeground(new java.awt.Color(0, 230, 64));

        courseNameLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel4.setForeground(new java.awt.Color(0, 230, 64));
        courseNameLabel4.setText("Course Name:");

        courseNameLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel5.setForeground(new java.awt.Color(0, 230, 64));

        secLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel4.setForeground(new java.awt.Color(0, 230, 64));
        secLabel4.setText("Section:");

        secLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel5.setForeground(new java.awt.Color(0, 230, 64));

        facultyLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel5.setForeground(new java.awt.Color(0, 230, 64));
        facultyLabel5.setText("Instructor:");

        facultyLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel6.setForeground(new java.awt.Color(0, 230, 64));

        timeLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel4.setForeground(new java.awt.Color(0, 230, 64));
        timeLabel4.setText("Class Schedule:");

        timeLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel5.setForeground(new java.awt.Color(0, 230, 64));

        commentLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        commentLabel2.setForeground(new java.awt.Color(0, 230, 64));
        commentLabel2.setText("General Comment or Announcement:");

        postLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        postLabel2.setForeground(new java.awt.Color(0, 230, 64));
        postLabel2.setText("POST:");

        shoutArea2.setColumns(20);
        shoutArea2.setRows(5);
        jScrollPane3.setViewportView(shoutArea2);

        postButton3.setBackground(new java.awt.Color(25, 181, 254));
        postButton3.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        postButton3.setText("POST");
        postButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(postButton3)
                        .addGap(38, 38, 38)
                        .addComponent(backButton2)
                        .addGap(15, 15, 15))
                    .addGroup(Panel3Layout.createSequentialGroup()
                        .addComponent(commentLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel3Layout.createSequentialGroup()
                        .addComponent(postLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel3Layout.createSequentialGroup()
                        .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shoutField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel3Layout.createSequentialGroup()
                                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel3Layout.createSequentialGroup()
                                        .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Panel3Layout.createSequentialGroup()
                                                .addComponent(courseLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                                .addComponent(courseLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(Panel3Layout.createSequentialGroup()
                                                .addComponent(courseTitleLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(37, 37, 37))
                                    .addGroup(Panel3Layout.createSequentialGroup()
                                        .addComponent(secLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(secLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(facultyLabel5)
                                        .addGap(9, 9, 9)))
                                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(Panel3Layout.createSequentialGroup()
                                        .addComponent(courseNameLabel4)
                                        .addGap(40, 40, 40)
                                        .addComponent(courseNameLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel3Layout.createSequentialGroup()
                                        .addComponent(facultyLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(timeLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(timeLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(36, 36, 36))))
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(courseTitleLabel2)
                .addGap(30, 30, 30)
                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel3Layout.createSequentialGroup()
                        .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(courseNameLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(courseNameLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(secLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(secLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(facultyLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timeLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timeLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(facultyLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(commentLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoutField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton2)
                    .addComponent(postButton3))
                .addGap(17, 17, 17))
        );

        layeredPane.add(Panel3, "card2");

        Panel4.setBackground(new java.awt.Color(52, 73, 94));

        backButton3.setBackground(new java.awt.Color(219, 10, 91));
        backButton3.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        backButton3.setText("BACK");
        backButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton3ActionPerformed(evt);
            }
        });

        courseTitleLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseTitleLabel3.setForeground(new java.awt.Color(0, 230, 64));
        courseTitleLabel3.setText("Courses Details:");

        courseLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel6.setForeground(new java.awt.Color(0, 230, 64));
        courseLabel6.setText("Course Code:");

        courseLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel7.setForeground(new java.awt.Color(0, 230, 64));

        courseNameLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel6.setForeground(new java.awt.Color(0, 230, 64));
        courseNameLabel6.setText("Course Name:");

        courseNameLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel7.setForeground(new java.awt.Color(0, 230, 64));

        secLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel6.setForeground(new java.awt.Color(0, 230, 64));
        secLabel6.setText("Section:");

        secLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel7.setForeground(new java.awt.Color(0, 230, 64));

        facultyLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel7.setForeground(new java.awt.Color(0, 230, 64));
        facultyLabel7.setText("Instructor:");

        facultyLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel8.setForeground(new java.awt.Color(0, 230, 64));

        timeLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel6.setForeground(new java.awt.Color(0, 230, 64));
        timeLabel6.setText("Class Schedule:");

        timeLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel7.setForeground(new java.awt.Color(0, 230, 64));

        commentLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        commentLabel3.setForeground(new java.awt.Color(0, 230, 64));
        commentLabel3.setText("General Comment or Announcement:");

        postLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        postLabel3.setForeground(new java.awt.Color(0, 230, 64));
        postLabel3.setText("POST:");

        shoutArea3.setColumns(20);
        shoutArea3.setRows(5);
        jScrollPane4.setViewportView(shoutArea3);

        postButton4.setBackground(new java.awt.Color(25, 181, 254));
        postButton4.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        postButton4.setText("POST");
        postButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel4Layout = new javax.swing.GroupLayout(Panel4);
        Panel4.setLayout(Panel4Layout);
        Panel4Layout.setHorizontalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(postButton4)
                        .addGap(40, 40, 40)
                        .addComponent(backButton3)
                        .addGap(15, 15, 15))
                    .addGroup(Panel4Layout.createSequentialGroup()
                        .addComponent(commentLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel4Layout.createSequentialGroup()
                        .addComponent(postLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel4Layout.createSequentialGroup()
                        .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shoutField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel4Layout.createSequentialGroup()
                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel4Layout.createSequentialGroup()
                                        .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Panel4Layout.createSequentialGroup()
                                                .addComponent(courseLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                                .addComponent(courseLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(Panel4Layout.createSequentialGroup()
                                                .addComponent(courseTitleLabel3)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(38, 38, 38))
                                    .addGroup(Panel4Layout.createSequentialGroup()
                                        .addComponent(secLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(secLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(facultyLabel7)
                                        .addGap(10, 10, 10)))
                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(Panel4Layout.createSequentialGroup()
                                        .addComponent(courseNameLabel6)
                                        .addGap(40, 40, 40)
                                        .addComponent(courseNameLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel4Layout.createSequentialGroup()
                                        .addComponent(facultyLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(timeLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(timeLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(36, 36, 36))))
        );
        Panel4Layout.setVerticalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(courseTitleLabel3)
                .addGap(30, 30, 30)
                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel4Layout.createSequentialGroup()
                        .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(courseNameLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(courseNameLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(secLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(secLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(facultyLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel4Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timeLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timeLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(facultyLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(commentLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoutField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton3)
                    .addComponent(postButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        layeredPane.add(Panel4, "card2");

        Panel5.setBackground(new java.awt.Color(52, 73, 94));

        backButton4.setBackground(new java.awt.Color(219, 10, 91));
        backButton4.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        backButton4.setText("BACK");
        backButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton4ActionPerformed(evt);
            }
        });

        courseTitleLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseTitleLabel4.setForeground(new java.awt.Color(0, 230, 64));
        courseTitleLabel4.setText("Courses Details:");

        courseLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel8.setForeground(new java.awt.Color(0, 230, 64));
        courseLabel8.setText("Course Code:");

        courseLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseLabel9.setForeground(new java.awt.Color(0, 230, 64));

        courseNameLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel8.setForeground(new java.awt.Color(0, 230, 64));
        courseNameLabel8.setText("Course Name:");

        courseNameLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        courseNameLabel9.setForeground(new java.awt.Color(0, 230, 64));

        secLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel8.setForeground(new java.awt.Color(0, 230, 64));
        secLabel8.setText("Section:");

        secLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        secLabel9.setForeground(new java.awt.Color(0, 230, 64));

        facultyLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel9.setForeground(new java.awt.Color(0, 230, 64));
        facultyLabel9.setText("Instructor:");

        facultyLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        facultyLabel10.setForeground(new java.awt.Color(0, 230, 64));

        timeLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel8.setForeground(new java.awt.Color(0, 230, 64));
        timeLabel8.setText("Class Schedule:");

        timeLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel9.setForeground(new java.awt.Color(0, 230, 64));

        commentLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        commentLabel4.setForeground(new java.awt.Color(0, 230, 64));
        commentLabel4.setText("General Comment or Announcement:");

        postLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        postLabel4.setForeground(new java.awt.Color(0, 230, 64));
        postLabel4.setText("POST:");

        shoutArea4.setColumns(20);
        shoutArea4.setRows(5);
        jScrollPane5.setViewportView(shoutArea4);

        postButton5.setBackground(new java.awt.Color(25, 181, 254));
        postButton5.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        postButton5.setText("POST");
        postButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel5Layout = new javax.swing.GroupLayout(Panel5);
        Panel5.setLayout(Panel5Layout);
        Panel5Layout.setHorizontalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(postButton5)
                        .addGap(34, 34, 34)
                        .addComponent(backButton4)
                        .addGap(15, 15, 15))
                    .addGroup(Panel5Layout.createSequentialGroup()
                        .addComponent(commentLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel5Layout.createSequentialGroup()
                        .addComponent(postLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel5Layout.createSequentialGroup()
                        .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shoutField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel5Layout.createSequentialGroup()
                                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel5Layout.createSequentialGroup()
                                        .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Panel5Layout.createSequentialGroup()
                                                .addComponent(courseLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                                .addComponent(courseLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(Panel5Layout.createSequentialGroup()
                                                .addComponent(courseTitleLabel4)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(0, 0, 0))
                                    .addGroup(Panel5Layout.createSequentialGroup()
                                        .addComponent(secLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(secLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(facultyLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(Panel5Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(courseNameLabel8)
                                        .addGap(52, 52, 52)
                                        .addComponent(courseNameLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel5Layout.createSequentialGroup()
                                        .addComponent(facultyLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(timeLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(timeLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(36, 36, 36))))
        );
        Panel5Layout.setVerticalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(courseTitleLabel4)
                .addGap(30, 30, 30)
                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(courseNameLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(courseNameLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(secLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(secLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(facultyLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                    .addGroup(Panel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(facultyLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(commentLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoutField4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton4)
                    .addComponent(postButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        layeredPane.add(Panel5, "card2");

        getContentPane().add(layeredPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1240, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minLabelMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minLabelMouseClicked

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void courseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseButton1ActionPerformed
        // TODO add your handling code here:
        switchPanels(Panel1);
    }//GEN-LAST:event_courseButton1ActionPerformed

    private void courseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseButton2ActionPerformed
        // TODO add your handling code here:
        switchPanels(Panel2);
    }//GEN-LAST:event_courseButton2ActionPerformed

    private void courseButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseButton3ActionPerformed
        // TODO add your handling code here:
        switchPanels(Panel3);
    }//GEN-LAST:event_courseButton3ActionPerformed

    private void courseButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseButton4ActionPerformed
        // TODO add your handling code here:
        switchPanels(Panel4);
    }//GEN-LAST:event_courseButton4ActionPerformed

    private void courseButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseButton5ActionPerformed
        // TODO add your handling code here:
        switchPanels(Panel5);
    }//GEN-LAST:event_courseButton5ActionPerformed
    public boolean stdORfac(String u) throws SQLException
    {
        String query = "select user from stdprofile;";
        rs= st.executeQuery(query);
        while(rs.next())
        {
            if(rs.getString("user").equals(u))
            {
                return true;
            }
        }
        return false;
    }
    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(stdORfac(backUser))
            {
                new stdHome(backUser).setVisible(true);
            }
            else
            {
                new facHome(backUser).setVisible(true);
            }
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(editProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButton1ActionPerformed

    private void backButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton4ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(stdORfac(user))
            {
                new stdHome(user).setVisible(true);
            }
            else
            {
                new facHome(user).setVisible(true);
            }
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(editProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButton4ActionPerformed

    private void backButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(stdORfac(user))
            {
                new stdHome(user).setVisible(true);
            }
            else
            {
                new facHome(user).setVisible(true);
            }
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(editProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButton3ActionPerformed

    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(stdORfac(user))
            {
                new stdHome(user).setVisible(true);
            }
            else
            {
                new facHome(user).setVisible(true);
            }
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(editProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButton2ActionPerformed

    private void backButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton6ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(stdORfac(user))
            {
                new stdHome(user).setVisible(true);
            }
            else
            {
                new facHome(user).setVisible(true);
            }
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(editProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButton6ActionPerformed

    private void postButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButton1ActionPerformed
        // TODO add your handling code here:
        String query="";
        try {
            if(stdORfac(backUser))
            {
                query = "insert into comment values ('"+courseLabel2.getText()+"', '"+secLabel2.getText()+"', '"+backUser+"', '"+facultyLabel2.getText()+"', '"+shoutField.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            else
            {
                query = "insert into comment values ('"+courseLabel2.getText()+"', '"+secLabel2.getText()+"', 'admin', '"+facultyLabel2.getText()+"', '"+shoutField.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            st.executeUpdate(query);
            this.close();
            course q = new course(backUser,backUser);
            q.setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_postButton1ActionPerformed

    private void postButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButton2ActionPerformed
        // TODO add your handling code here:
        String query="";
        try {
            if(stdORfac(backUser))
            {
                query = "insert into comment values ('"+courseLabel3.getText()+"', '"+secLabel3.getText()+"', '"+backUser+"', '"+facultyLabel4.getText()+"', '"+shoutField1.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            else
            {
                query = "insert into comment values ('"+courseLabel3.getText()+"', '"+secLabel3.getText()+"', 'admin', '"+facultyLabel4.getText()+"', '"+shoutField1.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            st.executeUpdate(query);
            this.close();
            course q = new course(backUser,backUser);
            q.setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_postButton2ActionPerformed

    private void postButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButton3ActionPerformed
        // TODO add your handling code here:
        String query="";
        try {
            if(stdORfac(backUser))
            {
                query = "insert into comment values ('"+courseLabel5.getText()+"', '"+secLabel5.getText()+"', '"+backUser+"', '"+facultyLabel6.getText()+"', '"+shoutField2.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            else
            {
                query = "insert into comment values ('"+courseLabel5.getText()+"', '"+secLabel5.getText()+"', 'admin', '"+facultyLabel6.getText()+"', '"+shoutField2.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            st.executeUpdate(query);
            this.close();
            course q = new course(backUser,backUser);
            q.setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_postButton3ActionPerformed

    private void postButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButton4ActionPerformed
        // TODO add your handling code here:
        String query="";
        try {
            if(stdORfac(backUser))
            {
                query = "insert into comment values ('"+courseLabel7.getText()+"', '"+secLabel7.getText()+"', '"+backUser+"', '"+facultyLabel8.getText()+"', '"+shoutField3.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            else
            {
                query = "insert into comment values ('"+courseLabel7.getText()+"', '"+secLabel7.getText()+"', 'admin', '"+facultyLabel8.getText()+"', '"+shoutField3.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            st.executeUpdate(query);
            this.close();
            course q = new course(backUser,backUser);
            q.setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_postButton4ActionPerformed

    private void postButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButton5ActionPerformed
        // TODO add your handling code here:
        String query="";
        try {
            if(stdORfac(backUser))
            {
                query = "insert into comment values ('"+courseLabel9.getText()+"', '"+secLabel9.getText()+"', '"+backUser+"', '"+facultyLabel10.getText()+"', '"+shoutField4.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            else
            {
                query = "insert into comment values ('"+courseLabel9.getText()+"', '"+secLabel9.getText()+"', 'admin', '"+facultyLabel10.getText()+"', '"+shoutField4.getText()+"', '"+java.time.LocalDateTime.now()+"');";
            }
            st.executeUpdate(query);
            this.close();
            course q = new course(backUser,backUser);
            q.setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_postButton5ActionPerformed
    public void switchPanels(JPanel panel)
    {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }
    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new course().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel5;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton backButton2;
    private javax.swing.JButton backButton3;
    private javax.swing.JButton backButton4;
    private javax.swing.JButton backButton6;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JLabel commentLabel1;
    private javax.swing.JLabel commentLabel2;
    private javax.swing.JLabel commentLabel3;
    private javax.swing.JLabel commentLabel4;
    private javax.swing.JButton courseButton1;
    private javax.swing.JButton courseButton2;
    private javax.swing.JButton courseButton3;
    private javax.swing.JButton courseButton4;
    private javax.swing.JButton courseButton5;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JLabel courseLabel1;
    private javax.swing.JLabel courseLabel2;
    private javax.swing.JLabel courseLabel3;
    private javax.swing.JLabel courseLabel4;
    private javax.swing.JLabel courseLabel5;
    private javax.swing.JLabel courseLabel6;
    private javax.swing.JLabel courseLabel7;
    private javax.swing.JLabel courseLabel8;
    private javax.swing.JLabel courseLabel9;
    private javax.swing.JLabel courseNameLabel;
    private javax.swing.JLabel courseNameLabel1;
    private javax.swing.JLabel courseNameLabel2;
    private javax.swing.JLabel courseNameLabel3;
    private javax.swing.JLabel courseNameLabel4;
    private javax.swing.JLabel courseNameLabel5;
    private javax.swing.JLabel courseNameLabel6;
    private javax.swing.JLabel courseNameLabel7;
    private javax.swing.JLabel courseNameLabel8;
    private javax.swing.JLabel courseNameLabel9;
    private javax.swing.JLabel courseTitleLabel;
    private javax.swing.JLabel courseTitleLabel1;
    private javax.swing.JLabel courseTitleLabel2;
    private javax.swing.JLabel courseTitleLabel3;
    private javax.swing.JLabel courseTitleLabel4;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JLabel facultyLabel10;
    private javax.swing.JLabel facultyLabel2;
    private javax.swing.JLabel facultyLabel3;
    private javax.swing.JLabel facultyLabel4;
    private javax.swing.JLabel facultyLabel5;
    private javax.swing.JLabel facultyLabel6;
    private javax.swing.JLabel facultyLabel7;
    private javax.swing.JLabel facultyLabel8;
    private javax.swing.JLabel facultyLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLayeredPane layeredPane;
    private javax.swing.JLabel minLabel;
    private javax.swing.JButton postButton1;
    private javax.swing.JButton postButton2;
    private javax.swing.JButton postButton3;
    private javax.swing.JButton postButton4;
    private javax.swing.JButton postButton5;
    private javax.swing.JLabel postLabel;
    private javax.swing.JLabel postLabel1;
    private javax.swing.JLabel postLabel2;
    private javax.swing.JLabel postLabel3;
    private javax.swing.JLabel postLabel4;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JLabel secLabel;
    private javax.swing.JLabel secLabel1;
    private javax.swing.JLabel secLabel2;
    private javax.swing.JLabel secLabel3;
    private javax.swing.JLabel secLabel4;
    private javax.swing.JLabel secLabel5;
    private javax.swing.JLabel secLabel6;
    private javax.swing.JLabel secLabel7;
    private javax.swing.JLabel secLabel8;
    private javax.swing.JLabel secLabel9;
    private javax.swing.JTextArea shoutArea;
    private javax.swing.JTextArea shoutArea1;
    private javax.swing.JTextArea shoutArea2;
    private javax.swing.JTextArea shoutArea3;
    private javax.swing.JTextArea shoutArea4;
    private javax.swing.JTextField shoutField;
    private javax.swing.JTextField shoutField1;
    private javax.swing.JTextField shoutField2;
    private javax.swing.JTextField shoutField3;
    private javax.swing.JTextField shoutField4;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeLabel1;
    private javax.swing.JLabel timeLabel2;
    private javax.swing.JLabel timeLabel3;
    private javax.swing.JLabel timeLabel4;
    private javax.swing.JLabel timeLabel5;
    private javax.swing.JLabel timeLabel6;
    private javax.swing.JLabel timeLabel7;
    private javax.swing.JLabel timeLabel8;
    private javax.swing.JLabel timeLabel9;
    // End of variables declaration//GEN-END:variables
}
