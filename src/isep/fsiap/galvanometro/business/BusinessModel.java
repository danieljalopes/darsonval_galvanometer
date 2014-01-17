/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.fsiap.galvanometro.business;

import java.io.Serializable;

/**
 * Classe Responsável por realizar todos os cálculos. Os itens modelados são
 * considerados ideais.
 *
 * @author Daniel lopes
 */
public class BusinessModel implements Serializable{
    
    public final double RESISTENCIA_S_DEFAULT = 0.076142132;
    /**
     * Valor por defeito da Resistencia R_g
     */
    public final double RESISTENCIA_G_DEFAULT = 5.0;

    /**
     * Valor por defeito do numero de espiras da bobine
     */
    public final int NUM_ESPIRAS_DEFAULT = 100;

    /**
     * Valores de referencia para construir a escala (A)
     */
    private final double i_fe[] = {1E-5, 1E-4, 1E-3, 1E-2, 1E-1, 1, 5};
    /**
     * Valor por defeito do campo Magnético (T)
     */
    public final double CAMPOMAGNETICO_DEFAULT = 5E-3;
    /**
     * Valor por defeito da área da secção circular da bobine (m²)
     */
    public final double AREA_ESPIRAS_DEFAULT = 0.25;
    /**
     * Valor por defeito da constante angular elástica de uma mola em espiral
     * plana (N/rad)
     */
    public final double CONSTANTE_ELASTICA_ANGULAR_DEFAULT = 0.0023695525;
    /**
     * Valor por defeito da Tensão da Fonte de Alimentação
     */
    public final double FONTE_ALIMENTACAO_DEFAULT = 10;
    /**
     * Valor por defeito da Resistencia em série com a fonte
     */
    public final double RESISTENCIA_PROVA_DEFAULT = 10;
    /**
     * tensão da fonte (V)
     */
    private double tensaoFonte;

    /**
     * resistencia de prova (Ohm)
     */
    private double r_p;

    /**
     * **************************************************
     *
     * GALVANOMETRO
     *
     ******************************************************
     */
    /**
     * corrente maxima que o amperimetro pode suportar em Ampere
     */
    public double i_g = 15E-3;

    /**
     * resistencia do galvanómetro (Ohm)
     */
    public  double r_g ;

    /**
     * vector campo magnético em Tesla
     */
    private double b;

    /**
     * numero de espiras da bobine
     */
    private int numEspiras;

    /**
     * area da secção circular da espira da bobina m²
     */
    private double area;

    /**
     * constante elasticidade angular
     */
    private double k;

    /**
     * resistencia responsável pela escala em Ohm
     */
    private double r_s;

    public BusinessModel() {
        numEspiras = NUM_ESPIRAS_DEFAULT;
        b = CAMPOMAGNETICO_DEFAULT;
        area = AREA_ESPIRAS_DEFAULT;
        k = CONSTANTE_ELASTICA_ANGULAR_DEFAULT;
        tensaoFonte = FONTE_ALIMENTACAO_DEFAULT;
        r_p = RESISTENCIA_PROVA_DEFAULT;
        r_g = RESISTENCIA_G_DEFAULT;
        r_s = RESISTENCIA_S_DEFAULT;

        // r_s para uma escala de -10E-6 a 10E6
        mudarEscala(i_fe[5]);

    }

    /**
     * Corrente em R_g
     *
     * @return the i_g
     */
    public double getI_g() {
        return i_g;
    }

    /**
     * Resistencia do Galvanómetro
     *
     * @return the r_g
     */
    public double getR_g() {
        return r_g;
    }

    /**
     * Numero de Espiras
     *
     * @return the numEspiras
     */
    public int getNumEspiras() {
        return numEspiras;
    }

    /**
     * Numero de Espiras
     *
     * @param numEspiras the numEspiras to set
     */
    public void setNumEspiras(int numEspiras) {
        this.numEspiras = numEspiras;
    }

    /**
     * Área da Espira
     *
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * Área da Espira
     *
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Constante Elástica Angular
     *
     * @return the k
     */
    public double getK() {
        return k;
    }

    /**
     * Resistencia de Shunt
     *
     * @param k the k to set
     */
    public void setK(double k) {
        this.k = k;
    }

    /**
     * @return the r_s
     */
    public double getR_s() {
        return r_s;
    }

    /**
     * Resistencia de Shunt
     *
     * @param r_s the r_s to set
     */
    public void setR_s(double r_s) {
        this.r_s = r_s;
    }

    /**
     * Tensão da Fonte
     *
     * @return the tensao
     */
    public double getTensao() {
        return tensaoFonte;
    }

    /**
     * Tensão da Fonte
     *
     * @param tensao the tensao to set
     */
    public void setTensao(double tensao) {
        this.tensaoFonte = tensao;
    }

    /**
     * Resistencia de prova
     *
     * @return the r_p
     */
    public double getR_p() {
        return r_p;
    }

    /**
     * Resistencia de prova
     *
     * @param r_p the r_p to set
     */
    public void setR_p(double r_p) {
        this.r_p = r_p;
    }

    /**
     * Campo Magnético
     *
     * @return the
     */
    public double getB() {
        return b;
    }

    /**
     * Campo Magnético
     *
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        s.append("Tensao na fonte: ").append(getTensao()).append(" Volt\n");
        s.append("Resistencia de prova do circuito: ").append(getR_p()).append(" Ohm\n");
        s.append("Campo Magnético: ").append(getB()).append(" Tesla\n");
        s.append("Área secção circular da bobine: ").append(getArea()).append(" Tesla\n");
        s.append("Numero de espiras da bobine: ").append(getNumEspiras()).append("\n");
        s.append("Constante elasticidade angular: ").append(getK()).append(" N.rad^-1\n");
        s.append("Corrente em Rg: ").append(getI_g()).append(" Ampere\n");
        s.append("Resistencia Rg: ").append(getR_g()).append(" Ohm\n");
        s.append("Resistencia Rs: ").append(getR_s()).append(" Ohm\n");
        s.append("Angulo da agulha: ").append(movement()).append(" rad\n");

        return s.toString();
    }

    /**
     *
     * @param i_escala valor maximo da escala a ler, ou seja, valor de fim de
     * escala Recebe como parâmetro
     *
     */
    public void mudarEscala(double i_escala) {

        setR_s(getR_g() * getI_g() / (i_escala - getI_g()));
    }

    /**
     *
     * @return o angulo de deflecção causado pela corrente medida pelo
     * Amperímetro
     */
    public double movement() throws ArithmeticException {
        double resultado = 0.0;

        try {
            resultado = getNumEspiras() * getTensao()
                    * Math.pow((getR_g() * getR_s()) / (getR_g() + getR_s()) + getR_p(), -1) * Math.pow(1 + getR_g() / getR_s(), -1) * Math.pow(getK(), -1) * getArea() * getB();

        } catch (ArithmeticException ex_div_por_zero) {
            throw ex_div_por_zero;
        }

        return resultado;
    }

    /**
     * @return the i_fe
     */
    public double[] getI_fe() {
        return i_fe;
    }

}
