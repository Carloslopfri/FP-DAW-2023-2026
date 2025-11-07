/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

public abstract class CuentaBancaria {

    private String titular;

    private double saldo;

    private int CCC;

    protected CuentaBancaria (String titular, double saldo, int CCC) {

        this.titular=titular;

        this.saldo=saldo;

        this.CCC=CCC;

    }

    protected String getTitular() {

        return titular;

    }

    protected void setTitular(String titular) {

        this.titular = titular;

    }

    protected double getSaldo() {

        return saldo;

    }

    protected void setSaldo(double saldo) {

        this.saldo = saldo;

    }

    protected int getCCC() {

        return CCC;

    }

    public void setCCC(int CCC) {

        this.CCC = CCC;

    }

    public void ingresar(double cantidad) {

        if (cantidad > 0) {

            saldo += cantidad;

        }

    }

}

