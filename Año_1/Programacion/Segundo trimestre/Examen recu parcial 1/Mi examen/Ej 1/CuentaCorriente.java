/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

public abstract class CuentaCorriente extends CuentaBancaria{

    private double comisionMantenimiento;

    protected CuentaCorriente(String titular, double saldo, int CCC, double comisionMantenimiento) {

        super(titular, saldo, CCC);

        this.comisionMantenimiento = comisionMantenimiento;

    }

    protected double getComisionMantenimiento() {

        return comisionMantenimiento;

    }

    protected void setComisionMantenimiento(double comisionMantenimiento) {

        this.comisionMantenimiento = comisionMantenimiento;

    }

    protected void cobrarComision() {

        setSaldo(getSaldo() - comisionMantenimiento);

    }

}

