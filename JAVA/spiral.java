/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Point;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JSlider;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ public class spiral {
/*     */   private JFrame frmSquareSpiral;
/*     */   
/*  33 */   public static String shape = "";
/*     */   
/*     */   public static Point p;
/*     */   
/*     */   public static Point p1;
/*     */   
/*  36 */   public static int num = 50;
/*     */   
/*  37 */   public static double u = 0.5D;
/*     */   
/*     */   public static void main(String[] args) {
/*  43 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/*     */             try {
/*  46 */               spiral window = new spiral();
/*  47 */               window.frmSquareSpiral.setVisible(true);
/*  48 */             } catch (Exception e) {
/*  49 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public spiral() {
/*  59 */     initialize();
/*     */   }
/*     */   
/*     */   private void initialize() {
/*  66 */     this.frmSquareSpiral = new JFrame();
/*  67 */     this.frmSquareSpiral.getContentPane().setBackground(Color.BLACK);
/*  68 */     this.frmSquareSpiral.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\a.png"));
/*  69 */     this.frmSquareSpiral.setTitle("SQUARE SPIRAL");
/*  70 */     this.frmSquareSpiral.setResizable(false);
/*  71 */     this.frmSquareSpiral.setBounds(100, 100, 750, 750);
/*  72 */     this.frmSquareSpiral.setDefaultCloseOperation(3);
/*  73 */     this.frmSquareSpiral.getContentPane().setLayout((LayoutManager)null);
/*     */     try {
/*  76 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*  77 */       SwingUtilities.updateComponentTreeUI(this.frmSquareSpiral);
/*  78 */     } catch (ClassNotFoundException e) {
/*  80 */       e.printStackTrace();
/*  81 */     } catch (InstantiationException e) {
/*  83 */       e.printStackTrace();
/*  84 */     } catch (IllegalAccessException e) {
/*  86 */       e.printStackTrace();
/*  87 */     } catch (UnsupportedLookAndFeelException e) {
/*  89 */       e.printStackTrace();
/*     */     } 
/*  92 */     final MPanel panel = new MPanel();
/*  93 */     panel.addMouseListener(new MouseAdapter() {
/*     */           public void mousePressed(MouseEvent arg0) {
/*  96 */             spiral.p = arg0.getPoint();
/*  97 */             spiral.p1 = arg0.getPoint();
/*  98 */             panel.repaint();
/*     */           }
/*     */           
/*     */           public void mouseReleased(MouseEvent arg0) {
/* 102 */             panel.repaint();
/*     */           }
/*     */         });
/* 105 */     panel.addMouseMotionListener(new MouseMotionAdapter() {
/*     */           public void mouseDragged(MouseEvent arg0) {
/* 108 */             spiral.p1 = arg0.getPoint();
/* 109 */             panel.repaint();
/*     */           }
/*     */         });
/* 112 */     panel.setForeground(Color.BLACK);
/* 113 */     panel.setBackground(Color.WHITE);
/* 114 */     panel.setBounds(0, 0, 744, 638);
/* 115 */     this.frmSquareSpiral.getContentPane().add(panel);
/* 117 */     JButton btnSquare = new JButton("");
/* 118 */     btnSquare.setPressedIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\MetaData\\SQUARE_G.png"));
/* 119 */     btnSquare.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\MetaData\\SQUARE.png"));
/* 120 */     btnSquare.setRequestFocusEnabled(false);
/* 121 */     btnSquare.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent arg0) {
/* 123 */             spiral.shape = "square";
/*     */           }
/*     */         });
/* 126 */     btnSquare.setBounds(0, 639, 75, 76);
/* 127 */     this.frmSquareSpiral.getContentPane().add(btnSquare);
/* 129 */     JButton btnCircle = new JButton("");
/* 130 */     btnCircle.setPressedIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\MetaData\\CIRCLE _G.png"));
/* 131 */     btnCircle.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent arg0) {
/* 133 */             spiral.shape = "circle";
/*     */           }
/*     */         });
/* 136 */     btnCircle.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\MetaData\\CIRCLE.png"));
/* 137 */     btnCircle.setBounds(76, 639, 75, 76);
/* 138 */     this.frmSquareSpiral.getContentPane().add(btnCircle);
/* 140 */     JButton btnTriangle = new JButton("");
/* 141 */     btnTriangle.setPressedIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\MetaData\\TRIANGLE_G.png"));
/* 142 */     btnTriangle.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent arg0) {
/* 144 */             spiral.shape = "triangle";
/*     */           }
/*     */         });
/* 147 */     btnTriangle.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\MetaData\\TRIANGLE.png"));
/* 148 */     btnTriangle.setBounds(152, 639, 75, 76);
/* 149 */     this.frmSquareSpiral.getContentPane().add(btnTriangle);
/* 151 */     final JSlider slider = new JSlider();
/* 152 */     slider.setValue(25);
/* 153 */     slider.addChangeListener(new ChangeListener() {
/*     */           public void stateChanged(ChangeEvent arg0) {
/* 155 */             spiral.num = slider.getValue();
/* 156 */             panel.repaint();
/*     */           }
/*     */         });
/* 159 */     slider.setLocation(new Point(10, 10));
/* 160 */     slider.setSize(new Dimension(20, 20));
/* 161 */     slider.setAlignmentX(1.0F);
/* 162 */     slider.setBackground(Color.WHITE);
/* 163 */     slider.setForeground(Color.WHITE);
/* 164 */     slider.setBounds(228, 639, 415, 37);
/* 165 */     this.frmSquareSpiral.getContentPane().add(slider);
/* 167 */     final JSlider slider_1 = new JSlider();
/* 168 */     slider_1.setValue(25);
/* 169 */     slider_1.addChangeListener(new ChangeListener() {
/*     */           public void stateChanged(ChangeEvent arg0) {
/* 171 */             spiral.u = slider_1.getValue() / 100.0D;
/* 172 */             panel.repaint();
/*     */           }
/*     */         });
/* 175 */     slider_1.setBackground(Color.WHITE);
/* 176 */     slider_1.setBounds(228, 677, 415, 38);
/* 177 */     this.frmSquareSpiral.getContentPane().add(slider_1);
/* 179 */     JLabel lblNewLabel = new JLabel("NUMBER");
/* 180 */     lblNewLabel.setFont(new Font("Microsoft YaHei", 0, 16));
/* 181 */     lblNewLabel.setHorizontalAlignment(0);
/* 182 */     lblNewLabel.setOpaque(true);
/* 183 */     lblNewLabel.setBackground(Color.WHITE);
/* 184 */     lblNewLabel.setForeground(Color.BLACK);
/* 185 */     lblNewLabel.setBounds(644, 639, 100, 37);
/* 186 */     this.frmSquareSpiral.getContentPane().add(lblNewLabel);
/* 188 */     JLabel lblNewLabel_1 = new JLabel("DENSITY");
/* 189 */     lblNewLabel_1.setFont(new Font("Microsoft YaHei", 0, 16));
/* 190 */     lblNewLabel_1.setHorizontalAlignment(0);
/* 191 */     lblNewLabel_1.setBackground(Color.WHITE);
/* 192 */     lblNewLabel_1.setOpaque(true);
/* 193 */     lblNewLabel_1.setBounds(644, 677, 100, 38);
/* 194 */     this.frmSquareSpiral.getContentPane().add(lblNewLabel_1);
/*     */   }
/*     */ }


/* Location:              C:\Users\DELL\Desktop\projects\JAVA_SPIRAL\JAVA_SPIRAL.jar!\spiral.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */