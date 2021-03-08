/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ class MPanel extends JPanel {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static Point getSection(Point arg0, Point arg1, double u) {
/* 207 */     Point p = new Point();
/* 208 */     p.x = (int)((arg0.x * u + arg1.x) / (u + 1.0D));
/* 209 */     p.y = (int)((arg0.y * u + arg1.y) / (u + 1.0D));
/* 211 */     return p;
/*     */   }
/*     */   
/*     */   public void update(Graphics g) {
/* 215 */     paint(g);
/*     */   }
/*     */   
/*     */   public void paintComponent(Graphics g) {
/* 220 */     super.paintComponent(g);
/* 222 */     if (spiral.shape == "circle") {
/* 224 */       int x = spiral.p.x - spiral.p1.x;
/* 225 */       int y = spiral.p.y - spiral.p1.y;
/* 226 */       int h = (int)Math.round(Math.sqrt((x * x + y * y)));
/* 228 */       int h0 = h;
/* 230 */       for (int i = 0; i < spiral.num; i++) {
/* 232 */         g.drawOval(spiral.p.x - h0, spiral.p.y - h0, 2 * h0, 2 * h0);
/* 233 */         h0 = (int)Math.round((1.0D - spiral.u) * h0);
/*     */       } 
/* 239 */     } else if (spiral.shape == "triangle" && !spiral.p.equals(spiral.p1)) {
/*     */       double th;
/* 241 */       float x = (spiral.p1.x - spiral.p.x);
/* 242 */       float y = (spiral.p1.y - spiral.p.y);
/* 243 */       int d = (int)Math.round(Math.sqrt((x * x + y * y)));
/*     */       try {
/* 247 */         if (spiral.p.x > spiral.p1.x) {
/* 248 */           th = Math.PI + Math.atan((y / x));
/* 249 */         } else if (spiral.p.y > spiral.p1.y) {
/* 250 */           th = 6.283185307179586D + Math.atan((y / x));
/*     */         } else {
/* 252 */           th = Math.atan((y / x));
/*     */         } 
/* 255 */       } catch (Exception e) {
/* 256 */         if (y > 0.0F) {
/* 257 */           th = Math.PI;
/*     */         } else {
/* 259 */           th = 4.71238898038469D;
/*     */         } 
/*     */       } 
/* 263 */       Point p1 = new Point(spiral.p1.x, spiral.p1.y);
/* 264 */       Point p2 = new Point((int)(spiral.p.x - d * Math.cos(th - 1.0471975511965976D)), (int)(spiral.p.y - d * Math.sin(th - 1.0471975511965976D)));
/* 265 */       Point p3 = new Point((int)(spiral.p.x + d * Math.cos(2.0943951023931953D - th)), (int)(spiral.p.y - d * Math.sin(2.0943951023931953D - th)));
/* 267 */       Point r1 = new Point(p1.x, p1.y);
/* 268 */       Point r2 = new Point(p2.x, p2.y);
/* 269 */       Point r3 = new Point(p3.x, p3.y);
/* 271 */       for (int i = 0; i < spiral.num; i++) {
/* 273 */         g.drawLine(p1.x, p1.y, p2.x, p2.y);
/* 274 */         g.drawLine(p2.x, p2.y, p3.x, p3.y);
/* 275 */         g.drawLine(p3.x, p3.y, p1.x, p1.y);
/* 277 */         p1 = getSection(r1, r2, spiral.u);
/* 278 */         p2 = getSection(r2, r3, spiral.u);
/* 279 */         p3 = getSection(r3, r1, spiral.u);
/* 281 */         r1 = p1;
/* 282 */         r2 = p2;
/* 283 */         r3 = p3;
/*     */       } 
/* 286 */     } else if (spiral.shape == "square" && !spiral.p.equals(spiral.p1)) {
/*     */       double th;
/* 288 */       float x = (spiral.p1.x - spiral.p.x);
/* 289 */       float y = (spiral.p1.y - spiral.p.y);
/* 290 */       int d = (int)Math.round(Math.sqrt((x * x + y * y)));
/*     */       try {
/* 294 */         if (spiral.p.x > spiral.p1.x) {
/* 295 */           th = Math.PI + Math.atan((y / x));
/* 296 */         } else if (spiral.p.y > spiral.p1.y) {
/* 297 */           th = 6.283185307179586D + Math.atan((y / x));
/*     */         } else {
/* 299 */           th = Math.atan((y / x));
/*     */         } 
/* 302 */       } catch (Exception e) {
/* 303 */         if (y > 0.0F) {
/* 304 */           th = Math.PI;
/*     */         } else {
/* 306 */           th = 4.71238898038469D;
/*     */         } 
/*     */       } 
/* 310 */       Point p1 = new Point(spiral.p1.x, spiral.p1.y);
/* 311 */       Point p2 = new Point((int)(spiral.p.x - d * Math.sin(th)), (int)(spiral.p.y + d * Math.cos(th)));
/* 312 */       Point p3 = new Point(2 * spiral.p.x - spiral.p1.x, 2 * spiral.p.y - spiral.p1.y);
/* 313 */       Point p4 = new Point(2 * spiral.p.x - p2.x, 2 * spiral.p.y - p2.y);
/* 315 */       Point r1 = p1;
/* 316 */       Point r2 = p2;
/* 317 */       Point r3 = p3;
/* 318 */       Point r4 = p4;
/* 320 */       for (int i = 0; i < spiral.num; i++) {
/* 322 */         g.drawLine(p1.x, p1.y, p2.x, p2.y);
/* 323 */         g.drawLine(p2.x, p2.y, p3.x, p3.y);
/* 324 */         g.drawLine(p3.x, p3.y, p4.x, p4.y);
/* 325 */         g.drawLine(p4.x, p4.y, p1.x, p1.y);
/* 327 */         p1 = getSection(r1, r2, spiral.u);
/* 328 */         p2 = getSection(r2, r3, spiral.u);
/* 329 */         p3 = getSection(r3, r4, spiral.u);
/* 330 */         p4 = getSection(r4, r1, spiral.u);
/* 332 */         r1 = p1;
/* 333 */         r2 = p2;
/* 334 */         r3 = p3;
/* 335 */         r4 = p4;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\DELL\Desktop\projects\JAVA_SPIRAL\JAVA_SPIRAL.jar!\MPanel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */