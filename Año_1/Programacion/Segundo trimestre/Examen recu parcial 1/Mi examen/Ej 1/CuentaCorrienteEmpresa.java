/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

public class CuentaCorrienteEmpresa extends CuentaCorriente implements Imprimible {

    private double descubierto;

    public CuentaCorrienteEmpresa(Persona titular, double saldo, int CCC, double maximoDescubiertoPermitido, double interesDescubierto, double comisionFijaDescubierto) {

        super(titular.getNombre() + " " + titular.getApellidos(), saldo, CCC, comisionFijaDescubierto);

        this.descubierto = descubierto;

    }
    public double getDescubierto() {

        return descubierto;

    }

    public void setDescubierto(double descubierto) {

        this.descubierto = descubierto;

    }

    public void sacarDinero(double cantidad) {

        if (cantidad <= getSaldo() + descubierto) {

            setSaldo(getSaldo() - cantidad);

        } else {

            System.out.println("No se puede sacar dinero. Descubierto máximo superado.");

        }

    }

    public void ingresarDinero(double cantidad) {

        setSaldo(getSaldo() + cantidad);

    }

    public void imprimir() {

        System.out.println("Titular: " + getTitular());

        System.out.println("Saldo: " + getSaldo());

        System.out.println("CCC: " + getCCC());

        System.out.println("Comisión de mantenimiento: " + getComisionMantenimiento());

        System.out.println("Descubierto: " + descubierto);

    }

}
