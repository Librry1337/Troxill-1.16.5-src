/*
 * Decompiled with CFR 0.152.
 */
package ru.zvcoder.antihohol.troxill.clickgui.settings;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class Setting {
    public AbstractModule zaK;
    private int KxZ;
    private int IvL;
    public Color nAX;
    public Color njf;
    public String[] aIm;
    public List WJb;
    public String Rvn;
    public ArrayList onG;
    public int cgx;
    public int hCJ = 0;
    public boolean Xbo;
    public int bYH;
    public static final int obR = 0;
    public static final int KxJ = 1;
    public static final int ZbF = 2;
    public double nUP;
    public double bmb;
    public double Irt;
    public boolean pdN = false;

    public Setting(AbstractModule var1, boolean var2, String[] var3, int var4, int var5) {
        this.zaK = var1;
        this.Xbo = var2;
        this.aIm = var3;
        this.KxZ = 1;
        this.bYH = var4;
        this.cgx = var5;
    }

    public Setting(AbstractModule var1, int var2, int var3) {
        this.zaK = var1;
        this.KxZ = 3;
        this.IvL = var2;
        this.cgx = var3;
    }

    public Setting(AbstractModule var1, String[] var2, List var3, int var4) {
        this.zaK = var1;
        this.WJb = var3;
        this.KxZ = 4;
        this.aIm = var2;
        this.cgx = var4;
    }

    public Setting(AbstractModule var1, String[] var2, int var3, Color var4) {
        this.zaK = var1;
        this.KxZ = 5;
        this.aIm = var2;

        this.nAX = var4;
        this.njf = var4;
        this.cgx = var3;
    }

    public Setting(AbstractModule var1, String[] var2, double var3, double var5, double var7, boolean var9, int var10) {
        this.zaK = var1;
        this.nUP = var3;
        this.bmb = var5;
        this.Irt = var7;
        this.pdN = var9;
        this.KxZ = 2;
        this.aIm = var2;
        this.cgx = var10;
    }

    public AbstractModule ZsE() {
        return this.zaK;
    }

    public String qeX() {
        return this.Rvn;
    }

    public void NIt(String var1) {
        this.Rvn = var1;
    }

    public ArrayList wfI() {
        return this.onG;
    }

    public boolean aCO() {
        return this.Xbo;
    }

    public void QTb(boolean var1) {
        this.Xbo = var1;
    }

    public double iUj() {
        if (this.pdN) {
            this.nUP = (int)this.nUP;
        }
        return this.nUP;
    }

    public void Dxf(double var1) {
        this.nUP = var1;
    }

    public double THn() {
        return this.bmb;
    }

    public double ubj() {
        return this.Irt;
    }

    public boolean BRc() {
        return this.KxZ == 1;
    }

    public boolean Njk() {
        return this.bYH == 0;
    }

    public boolean EJg() {
        return this.bYH == 1;
    }

    public boolean uvD() {
        return this.bYH == 2;
    }

    public boolean jjc() {
        return this.KxZ == 2;
    }

    public boolean PlK() {
        return this.KxZ == 3;
    }

    public boolean xhi() {
        return this.KxZ == 4;
    }

    public boolean STF() {
        return this.KxZ == 5;
    }

    public boolean WbV() {
        return this.pdN;
    }
}

