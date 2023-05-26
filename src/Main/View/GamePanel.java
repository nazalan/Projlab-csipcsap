package Main.View;

import Main.Model.Cso;
import Main.Model.Csucs;
import Main.Model.Jatekos;
import Main.Model.Pumpa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Displays the game in a panel.
 */
public class GamePanel extends JPanel {

    List<JatekosView> jatekosok;
    List<CsoView> csovek;
    List<CsucsView> csucsok;

    /**
     * Default ctor.
     */
    public GamePanel(){
        super();
        jatekosok = new ArrayList<>();
        csovek = new ArrayList<>();
        csucsok = new ArrayList<>();
        Pumpa p = new Pumpa();
        p.setVanViz(false);
        p.setRossz(false);
        PumpaView pm = new PumpaView(p);
        pm.setX(400);
        pm.setY(200);
        csucsok.add(pm);
    }
    /**
     * Paints the components.
     * @param g Erre lehet majd rajzolgatni. Ezt kene a Draw() metodusokban atadni( Draw(Graphics g) )
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (CsoView cs : csovek){
            cs.draw(g);
        }
        for (CsucsView cs : csucsok){
            cs.draw(g);
        }
        for (JatekosView j : jatekosok){
            j.draw(g);
        }
    }

    public void drawAll(){
        calculateAll();
        showAll();
    }

    public void showAll(){
        this.repaint();
    }

    public void calculateAll(){
        for (CsucsView cs : csucsok){
            cs.calculate();
        }
        for (CsoView cs : csovek){
            cs.calculate();
        }
        for (CsoView cs : csovek){
            cs.calculate();
        }
    }

    public JatekosView getPlayerViewFromPlayer(Jatekos j){
        for (JatekosView jv : jatekosok){
            if (jv.getJatekos() == j){
                return jv;
            }
        }
        return null;
    }

    public CsucsView getCsucsViewFromCsucs(Csucs c){
        for (CsucsView cv : csucsok){
            if (cv.getCsucs() == c){
                return cv;
            }
        }
        return null;
    }

    public List<JatekosView> getPlayerViewFromCso(Cso c){
        List<JatekosView> jatekosok = new ArrayList<>();
        for (JatekosView jv : this.jatekosok){
            if (jv.getJatekos().getCso() == c){
                jatekosok.add(jv);
            }
        }
        return jatekosok;
    }

    public CsoView getCsoViewFromCso(Cso c){
        for (CsoView cv : csovek){
            if (cv.getCso() == c){
                return cv;
            }
        }
        return null;
    }
}

